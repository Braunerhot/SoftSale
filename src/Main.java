import softsale.model.PessoaFisica;
import softsale.model.service.PessoaFisicaService;

public class Main {
	public static void main(String[] args) {
		PessoaFisicaService service = new PessoaFisicaService();
		
		for(PessoaFisica pessoaFisica: service.getAll()) {
			System.out.println(pessoaFisica);
		}
	}
}
