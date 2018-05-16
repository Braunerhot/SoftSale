package softsale.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.Funcionario;
import softsale.model.Endereco;
import softsale.model.service.FuncionarioService;

@WebServlet("/funcionarios-update")
public class FuncionariosServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado);
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		
		Funcionario funcionario = new Funcionario(id, nome, cpf, senha, telefone, email, endereco);
		FuncionarioService service = new FuncionarioService();
		service.saveUpdate(funcionario);
		
		response.sendRedirect("/SoftSale/funcionarios-list");
	}
}
