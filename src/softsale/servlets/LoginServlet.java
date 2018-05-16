package softsale.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.service.FuncionarioService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		FuncionarioService service = new FuncionarioService();
		
		if (service.autenticar(cpf, senha) != null) {
			response.sendRedirect("/SoftSale/clientes-list");
		} else {
			request.setAttribute("mensagem0", "Error ao fazer login");
			request.setAttribute("mensagem1", "Verifique os dados e tente novamente");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}	
	}
}
