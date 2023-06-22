package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import util.DBUtil;

public class UserDao {
	DBUtil db = new DBUtil();
	User usuario = new User();
	
	public User obterResultado(String email) {

		User user = null;
		String sql = String.format("SELECT * FROM usuario WHERE email = %s", email);

		try (Connection connection = DBUtil.getInstance().conectar();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			if (resultSet.next()) {
				user = new User();
				user.setName(resultSet.getString("nome"));
				user.setEmail(resultSet.getString("email"));
				user.setCpf(resultSet.getString("cpf"));
				user.setPassword(resultSet.getString("senha"));
				user.setPermission(Integer.parseInt(resultSet.getString("permissao")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public void inserir(User user) {
		String sql = "INSERT INTO usuario (nome, cpf, email, senha, permissao) VALUES (?, ?, ?, ?, 1)";

		try (Connection connection = DBUtil.getInstance().conectar();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, user.getName());
			statement.setString(2, user.getCpf());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());


			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> listarUsuarios() {
		ArrayList<User> usuarios = new ArrayList<User>();

		String read = "select * from usuario order by nome";
		try {
			Connection conn = db.conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			// Percorrer todos os usuários
			while (rs.next()) {
				int userId = rs.getInt(1);
				String name = rs.getString(2);
				String cpf = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				int permission = rs.getInt(6);
				usuarios.add(new User(userId, name, cpf, email, password, permission));
			}
			conn.close();
			return usuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Login do usuário
	public User login(String email, String senha) {
	    String consultaUsuario = "SELECT * FROM usuario WHERE email=? AND senha=?";
	    User user = null;

	    try {
	        Connection conn = db.conectar();
	        PreparedStatement pst = conn.prepareStatement(consultaUsuario);
	        pst.setString(1, email);
	        pst.setString(2, senha);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            user = new User();
	            user.setUserId(rs.getInt("id_usuario"));
	            user.setCpf(rs.getString("cpf"));
	            user.setEmail(rs.getString("email"));
	            user.setName(rs.getString("nome"));
	            user.setPassword(rs.getString("senha"));
	            user.setPermission(rs.getInt("permissao"));
	        }

	        rs.close();
	        conn.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return user;
	}

	
	// Alterar informações do usuário
	public void selecionarContato(User user) {
		String read2 = "select * from usuario where id_usuario = ?";
		try {
			Connection conn = db.conectar();
			PreparedStatement pst = conn.prepareStatement(read2);
			pst.setInt(1, user.getUserId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {				
				user.setUserId(Integer.parseInt(rs.getString(1)));
				user.setName(rs.getString(2));
				user.setCpf(rs.getString(3));
				user.setEmail(rs.getString(4));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarContato(User user) {
		String create = "update usuario set nome=?, cpf=?, email=? where id_usuario = ?";
		try {
			Connection conn = db.conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, user.getName());
			pst.setString(2, user.getCpf());
			pst.setString(3, user.getEmail());
			pst.setInt(4, user.getUserId());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

