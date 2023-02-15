package application;

import java.util.ArrayList;
import java.util.Scanner;

import application.Cliente.Cliente;
import application.conta.Conta;

public class Main {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias; 
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("----------Bem vinda a nossa agencia");
		System.out.println("----------Selecione a opção desejada ");
		System.out.println("            1 - criar conta        ");
		System.out.println("            2 - depositar          ");
		System.out.println("            3 - sacar                ");
		System.out.println("            4 - transferir          ");
		System.out.println("            5 - listar               ");
		System.out.println("            6 - sair                 ");
		System.out.printf(">>");
		
		int operacao = input.nextInt();
		
		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			System.out.println("Obrigado! ");
			System.exit(operacao);
		default:
			System.out.println("opcao invalida");
			operacoes();
			break;
		}
	}

	public static void criarConta() {
		System.out.println("digite seu nome: ");
		System.out.printf(">>");
		String nome = input.next();
		System.out.println("digite seu cpf: ");
		System.out.printf(">>");
		String cpf = input.next();
		System.out.println("digite seu email :");
		System.out.printf(">>");
		String email = input.next();
		
		Cliente cliente = new Cliente(nome, cpf, email);
		Conta conta = new Conta(cliente);
		contasBancarias.add(conta);
		System.out.println("conta cadastrada com sucesso!");
		operacoes();
	}

	private static Conta acharConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size()>0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta()==numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("digite numero da conta:  ");
		System.out.println(">>");
		int numeroConta =  input.nextInt();
		
		Conta conta = acharConta(numeroConta);
		if(conta != null) {
			System.out.println("qual valor deseja depositar?");
			System.out.println(">>");
			double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("valor depositado com sucesso!!");
		}
		else {
			System.out.println("nao foi possivel realizar a operacao!");
			System.out.println("conta nao encontrada !");
			System.out.println("deseja criar? \n 1-sim \n 2-nao");
			int num  = input.nextInt();
			switch (num) {
			case 1:
				criarConta();
				break;
			case 2 :
				operacoes();
				break;
			default:
				break;
			}
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("digite numero da conta:  ");
		System.out.println(">>");
		int numeroConta =  input.nextInt();
		
		Conta conta = acharConta(numeroConta);
		if(conta != null) {
			System.out.println("qual valor deseja depositar?");
			System.out.println(">>");
			double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("valor de "+valorSaque+" retirado com sucesso!!");
		}
		else {
			System.out.println("conta nao encontrada !");
			System.out.println("deseja criar? \n 1-sim \n 2-nao");
			int num  = input.nextInt();
			switch (num) {
			case 1:
				criarConta();
				break;
			case 2 :
				operacoes();
				break;
			default:
				break;
			}
		}
	}

	public static void transferir() {
		System.out.println("numero da conta do remetente:");
		System.out.println(">>");
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemetente = acharConta(numeroContaRemetente);
		
		if(contaRemetente!=null) {
			System.out.println("numero do destinatario:");
			System.out.println(">>");
			int numeroDestinatario = input.nextInt();
			
			Conta contaDestinatario = acharConta(numeroDestinatario);
			
			if(contaDestinatario!=null) {
				System.out.println("digite o valor a ser transferido:");
				float valorTrans = input.nextFloat();
				contaRemetente.transferir(contaDestinatario, valorTrans);
				
			}else {
				System.out.println("conta nao encontrada !");
				System.out.println("deseja criar? \n 1-sim \n 2-nao");
				int num  = input.nextInt();
				switch (num) {
				case 1:
					criarConta();
					break;
				case 2 :
					operacoes();
					break;
				default:
					break;
				}
			}
		}
		operacoes();
	}
	
	public static void listar() {
		if(contasBancarias.size()>0) {
			for(Conta contas : contasBancarias){
				System.out.println(contas);
			}
		}
		else {
			System.out.println("Nao a contas cadastradas!");
			System.out.println("deseja criar? \n 1-sim \n 2-nao");
			int num  = input.nextInt();
			switch (num) {
			case 1:
				criarConta();
				break;
			case 2 :
				operacoes();
				break;
			default:
				break;
			}
		}
	}
}
