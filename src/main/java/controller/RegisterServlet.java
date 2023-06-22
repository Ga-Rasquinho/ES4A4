package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;


@WebServlet(urlPatterns = {"/RegisterServlet", "/RegistrarUsuario"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	 User user = new User();
  
    public RegisterServlet() {
        super();
        
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
    	  String nome = request.getParameter("nome");
    	  String senha = request.getParameter("senha");
    	  String email = request.getParameter("email");
    	  String cpf = request.getParameter("cpf");
    	
    	 
    	  user.setName(nome);
    	  user.setPassword(senha);
    	  user.setEmail(email);
    	  user.setCpf(cpf);
    
    	  System.out.println(cpf);
    	  UserDao userDao = new UserDao();
    	  userDao.inserir(user);
    	  
    	  response.sendRedirect("index.html");
		// Processar a lógica do CRUD
		// Recuperar dados do formulário usando request.getParameter()
		// Atualizar ou excluir o voo no banco de dados usando o FlightDao
		// correspondente

		
	
	}

}
