package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Flight;
import util.DBUtil;

public class FlightDao {

	DBUtil db = new DBUtil();

	public void criarVoo(Flight voo) {
		String create = "insert into voo (dt_hr_decolagem, preco_passagem, aero_origem, aero_destino) values (?,?,?,?)";
		try {
			// abrindo conexão
			Connection conn = db.conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans

			pst.setString(1, voo.getData_hr_decolagem());
			pst.setString(2, voo.getPrecoPassagem());
			pst.setString(3, voo.getAero_origem());
			pst.setString(4, voo.getAero_destino());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco de dados
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Flight> buscaUsVoo(String origem, String destino, String data) {
		ArrayList<Flight> voos = new ArrayList<>();
		String query = "SELECT * FROM voo WHERE aero_origem = ? AND aero_destino = ? AND dt_hr_decolagem LIKE ? ";
		try (Connection conn = db.conectar(); PreparedStatement pst = conn.prepareStatement(query)) {
			System.out.println(data);
			pst.setString(1, origem);
			pst.setString(2, destino);
			pst.setString(3, data + "T%");
			System.out.println(data + "T%");
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int idVoo = rs.getInt("id_voo");
					String data_hr_decolagem = rs.getString("dt_hr_decolagem");
					String precoPassagem = rs.getString("preco_passagem");
					String aero_origem = rs.getString("aero_origem");
					String aero_destino = rs.getString("aero_destino");

					voos.add(new Flight(idVoo, data_hr_decolagem, precoPassagem, aero_origem, aero_destino));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voos;
	}

	public ArrayList<Flight> listarVoo() {
		ArrayList<Flight> voo = new ArrayList<Flight>();

		String read = "select * from voo";
		try {
			Connection conn = db.conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			// Percorrer todos os aeroportos
			while (rs.next()) {
				int idVoo = rs.getInt(1);
				String data_hr_decolagem = rs.getString(2);
				String precoPassagem = rs.getString(3);
				String aero_origem = rs.getString(4);
				String aero_destino = rs.getString(5);

				voo.add(new Flight(idVoo, data_hr_decolagem, precoPassagem, aero_origem, aero_destino));
			}
			conn.close();
			return voo;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void alterarVoo(Flight voo) {
		String create = "update voo set dt_hr_decolagem=? where id_voo = ?";
		try {
			Connection conn = db.conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, voo.getData_hr_decolagem());
			pst.setInt(2, voo.getIdVoo());

			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deletarVoo(Flight voo) {
		String delete = "delete from voo where id_voo=? ";
		try {
			Connection conn = db.conectar();
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setInt(1, voo.getIdVoo());

			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
