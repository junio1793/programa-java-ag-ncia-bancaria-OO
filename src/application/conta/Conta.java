package application.conta;

import application.Cliente.Cliente;
import application.utils.Utils;

public class Conta {

	private static int contadorDeContas = 1;

	private int numeroConta;
	private double saldo;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.numeroConta = contadorDeContas;
		this.cliente = cliente;
	}

	public static int getContadorDeContas() {
		return contadorDeContas;
	}

	public static void setContadorDeContas(int contadorDeContas) {
		Conta.contadorDeContas = contadorDeContas;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "\ncliente= " + this.cliente.getNome() + "\nCPF: " + this.cliente.getCPF() + "\nEmail: "
				+ this.cliente.getEmail() + "\nConta: " + this.getNumeroConta() + "\nsaldo= "
				+ Utils.doubleToString(this.getSaldo());
	}

	public void depositar(double valor) {
		if (saldo > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Valor depositado com sucesso!");
		}
	}

	public void sacar(double valor) {
		if (valor > 0 && this.saldo >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("saque realizado com sucesso!");
		} 
		else {
			System.out.println("ERRO!");
		}
	}

	public void transferir(Conta contaTransferir, double valor) {
		if (valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);

			contaTransferir.saldo = contaTransferir.getSaldo() + valor;
		} else {
			System.out.println("\nERRO!");
		}
	}
}