import softsale.model.PessoaFisica;
import softsale.model.service.PessoaFisicaService;

public class Main {
	public static void main(String[] args) {
		PessoaFisicaService pessaoFisicaService = new PessoaFisicaService();
		PessoaFisica pessoaFisica = new PessoaFisica(null, "Paulo Guilherme", 20, "83998028519", "gui2072@hotmail.com", "09430206460");
		pessaoFisicaService.saveUpdate(pessoaFisica);	
	}
}
