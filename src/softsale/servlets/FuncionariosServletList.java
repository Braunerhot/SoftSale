package softsale.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.Funcionario;
import softsale.model.service.FuncionarioService;

@WebServlet("/funcionarios-list")
public class FuncionariosServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioService service = new FuncionarioService();
		
		List<Funcionario> funcionarios = service.getAll();
		request.setAttribute("funcionarios", funcionarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("funcionarios-list.jsp");
		dispatcher.forward(request, response);
	}
}
