package softsale.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.Funcionario;
import softsale.model.Endereco;
import softsale.model.service.FuncionarioService;

@WebServlet("/funcionarios-edit")
public class FuncionariosServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioService service = new FuncionarioService();
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Funcionario funcionario = service.getById(id);
		Endereco endereco = funcionario.getEndereco();
		
		request.setAttribute("funcionario", funcionario);
		request.setAttribute("endereco", endereco);
		RequestDispatcher dispatcher = request.getRequestDispatcher("funcionarios-edit.jsp");
		dispatcher.forward(request, response);
	}
}
