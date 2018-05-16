package softsale.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.Cliente;
import softsale.model.service.ClienteService;

@WebServlet("/clientes-list")
public class ClienteServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteService service = new ClienteService();
		
		List<Cliente> clientes = service.getAll();
		request.setAttribute("clientes", clientes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("clientes-list.jsp");
		dispatcher.forward(request, response);
	}
}
