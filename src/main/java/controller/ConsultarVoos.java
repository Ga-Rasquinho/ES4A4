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
import model.Flight;

@WebServlet(urlPatterns = { "/ConsultarVoos", "/pagConsulta", "/index", "/buscarVoos" })
public class ConsultarVoos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDao vooDao = new FlightDao();
	Flight voo2 = new Flight();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/buscarVoos")) {
			buscaUsVoo(request, response);
		} else {
			response.sendRedirect("consulta.jsp");
		}
	}

	protected void buscaUsVoo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		voo2.setData_hr_decolagem(request.getParameter("dt-hr"));
		voo2.setAero_origem(request.getParameter("aero-origem"));
		voo2.setAero_destino(request.getParameter("aero-destino"));
		ArrayList<Flight> vooBusca = vooDao.buscaUsVoo(voo2.getAero_origem(), voo2.getAero_destino(), voo2.getData_hr_decolagem());

		request.setAttribute("listaVoo", vooBusca);
		RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
		rd.forward(request, response);
	}
	
}
