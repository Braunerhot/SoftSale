package softsale.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.service.FuncionarioService;

@WebServlet("/funcionarios-remove")
public class FuncionariosServletRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));

		FuncionarioService service = new FuncionarioService();
		
		service.remove(id);
		response.sendRedirect("/SoftSale/funcionarios-list");
	}
}
