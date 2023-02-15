package application.Cliente;

public class Cliente {

	private static int counter = 1;
	
	private String nome;
	private String CPF;
	private String email;

	public Cliente(String nome, String cPF, String email) {
		this.nome = nome;
		CPF = cPF;
		this.email = email;
		counter +=1;
	}
	
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Cliente.counter = counter;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nNome= " + nome + ", \nCPF= " + CPF + ",\n Email= " + email ;
	}
	
	

}
