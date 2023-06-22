package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightDao;
import dao.UserDao;
import model.Flight;
import model.User;

@WebServlet(urlPatterns = { "/AdminFlightServlet", "/pagAdmin", "/selecaoUsu", "/updateVoo", "/deleteVoo" })
public class AdminFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao user = new UserDao();
	User usuario = new User();
	FlightDao vooDao = new FlightDao();
	Flight voo = new Flight();

	public AdminFlightServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/pagAdmin")) {
			listar(request, response);
		} else if (action.equals("/selecaoUsu")) {
			listarContato(request, response);
		} else if (action.equals("/updateVoo")) {
			editarVoo(request, response);
		} else if (action.equals("/deleteVoo")) {
			deletarVoo(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Flight> voo = vooDao.listarVoo();

		request.setAttribute("voo", voo);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do ID
		int userId = Integer.parseInt(request.getParameter("userId"));
		// Setar variável Usuario
		usuario.setUserId(userId);
		;
		// Executar o método selecionarContato (DAO)
		user.selecionarContato(usuario);
		// setar atributos do formulário
		request.setAttribute("userId", usuario.getUserId());
		request.setAttribute("nome", usuario.getName());
		request.setAttribute("cpf", usuario.getCpf());
		request.setAttribute("email", usuario.getEmail());
		// encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void editarVoo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		voo.setData_hr_decolagem(request.getParameter("dt_hr_decolagem"));
		voo.setIdVoo(Integer.parseInt(request.getParameter("idVoo")));
		// executar alterar contato
		vooDao.alterarVoo(voo);
		// redirecionar para o documento agenda.jsp (atualizando as alterações)
		response.sendRedirect("pagAdmin");
	}

	protected void deletarVoo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		voo.setIdVoo(Integer.parseInt(request.getParameter("idVoo")));
		// executar alterar contato
		vooDao.deletarVoo(voo);
		// redirecionar para o documento agenda.jsp (atualizando as alterações)
		response.sendRedirect("pagAdmin");
	}
}
