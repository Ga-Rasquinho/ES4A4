package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FlightDao;
import dao.UserDao;
import model.Flight;
import model.User;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao usuarioLogado = new UserDao();
	FlightDao vooDao = new FlightDao();
	Flight voo = new Flight();
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filePath = "/login.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(filePath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/login")) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			User user = usuarioLogado.login(email, senha);
			if (user != null) {
				System.out.println(user.getPermission());
				HttpSession session = request.getSession();
				session.setAttribute("usuarioAtual", user); // Armazenar o objeto User na sessão
				request.getSession().setAttribute("usuarioAtual", user);

				if (user.getPermission() == 1) {
					
					response.sendRedirect("index.html");
				} else if (user.getPermission() == 0) {
					UserDao userDao = new UserDao();

					ArrayList<Flight> voo = vooDao.listarVoo();

					request.setAttribute("voo", voo);

					RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("mensagem", "email ou senha inválidos");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}