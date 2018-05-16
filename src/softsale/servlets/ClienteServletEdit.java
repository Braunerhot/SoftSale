package softsale.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.Cliente;
import softsale.model.Endereco;
import softsale.model.service.ClienteService;

@WebServlet("/clientes-edit")
public class ClienteServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteService service = new ClienteService();
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Cliente cliente = service.getById(id);
		Endereco endereco = cliente.getEndereco();
		
		request.setAttribute("cliente", cliente);
		request.setAttribute("endereco", endereco);
		RequestDispatcher dispatcher = request.getRequestDispatcher("clientes-edit.jsp");
		dispatcher.forward(request, response);
	}
}
