package softsale.model.service;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import softsale.model.PessoaFisica;
 
public class Email implements PessoaFisicaListener {
	private String remetente = "softsaleweb@gmail.com";
	private String senha = "1f2c77ae";
	private boolean debug = false;
	
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void enviarEmail(String destinatario, String assunto, String mensagem) {
				Properties properties = new Properties();
				// Parâmetros servidor Gmail
				properties.put("mail.smtp.host", "smtp.gmail.com");
				properties.put("mail.smtp.socketFactory.port", "465");
				properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.port", "465");
				
				Session session = Session.getDefaultInstance(properties, 
						new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(remetente, senha);
					}
				});
				
				session.setDebug(debug);
				
				try {
				
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(remetente)); //set remetente
					
					Address toUser = new InternetAddress(destinatario); //set destinatario
					
					message.setRecipient(Message.RecipientType.TO, toUser);
					message.setSubject(assunto); //set assunto
					message.setText(mensagem); // set mensagem
					Transport.send(message); //metodo para enviar
					
				} catch (MessagingException e) {
				}
	}
	
	public void pessoaCadastrada(PessoaFisica pessoaFisica) {
		enviarEmail(pessoaFisica.getEmail(),
				"Cliente cadastrado com sucesso",
				String.format("Cliente\n"
						+ "Nome: %s\n"
						+ "CPF: %s\n"
						+ "Email: %s\n"
						+ "Idade: %d\n"
						+ "Telefone: %s\n", 
						pessoaFisica.getNome(),
						pessoaFisica.getCpf(),
						pessoaFisica.getEmail(),
						pessoaFisica.getIdade(),
						pessoaFisica.getTelefone()));
	}
}