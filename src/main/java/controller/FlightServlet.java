package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightDao;
import model.Flight;

@WebServlet(urlPatterns = { "/FlightServlet", "/listarVoo", "/inserirVoo" })
public class FlightServlet extends HttpServlet {
	FlightDao vooDao = new FlightDao();
	Flight voo = new Flight();
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/listarVoo")) {
			/*listar(request, response);*/
		} else if (action.equals("/inserirVoo")) {
			inserirVoo(request, response);
		}
	}

	protected void inserirVoo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			voo.setData_hr_decolagem(request.getParameter("dt-hr"));
			voo.setPrecoPassagem(request.getParameter("preco"));
			voo.setAero_origem(request.getParameter("aero-origem"));
			voo.setAero_destino(request.getParameter("aero-destino"));
			vooDao.criarVoo(voo);
			
			response.sendRedirect("pagAdmin");

	}
	
	/*protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Flight> voo = vooDao.listarVoo();

		request.setAttribute("voo", voo);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);

	}*/
}
