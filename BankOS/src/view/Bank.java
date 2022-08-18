package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Bank {
	
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contas;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank.contas = new ArrayList<Conta>();
		Bank.menu();
	}
	
	public static void menu() {
		System.out.println("========================================================");
		System.out.println("=============== Bank Operational System ================");
		System.out.println("========================================================");
		System.out.println("Insira uma opção: ");
		System.out.println("1 - Criar conta.");
		System.out.println("2 - Saque.");
		System.out.println("3 - Depósito.");
		System.out.println("4 - Transferência.");
		System.out.println("5 - Listar contas.");
		System.out.println("6 - Fechar programa.\n");
		
		int opt = 0;
		try {
			opt = Integer.parseInt(teclado.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Valor inválido. Por favor, tente novamente.");
			Utils.stop(1);
			Bank.menu();
		}
		
		switch(opt) {
		case 1: 
			Bank.criarConta();
			break;
		case 2:
			Bank.saque();
			break;
		case 3:
			Bank.deposito();
			break;
		case 4:
			Bank.transferencia();
			break;
		case 5:
			Bank.listarContas();
			break;
		case 6:
			System.out.println("Muito obrigado. Até a próxima!");
			Utils.stop(1);
			System.exit(0);
		default:
			System.out.println("Opção inválida, tente novamente.");
			Utils.stop(1);
			Bank.menu();		
		}
		
	}
	
	public static void criarConta() {
		System.out.println("Insira os dados do cliente: ");
		
		System.out.println("Nome: ");
		String nome = Bank.teclado.nextLine();
		
		System.out.println("E-mail: ");
		String email = Bank.teclado.nextLine();
		
		System.out.println("CPF: ");
		String cpf = Bank.teclado.nextLine();
		
		System.out.println("Data de Nascimento: ");
		String data_nascimento = Bank.teclado.nextLine();
		
		Cliente cliente = new Cliente(nome, email, cpf, Utils.stringDate(data_nascimento));
		Conta conta = new Conta(cliente);
		
		Bank.contas.add(conta);
		
		System.out.println("\nConta criada com sucesso!");
		System.out.println("Dados da conta: \n");
		System.out.println(conta + "\n");
		
		Utils.stop(2);
		Bank.menu();				
	}
	
	public static void saque() {
		
	}
	
	public static void deposito() {
		
	}
	
	public static void transferencia() {
		
	}
	
	public static void listarContas() {
		
	}

}
