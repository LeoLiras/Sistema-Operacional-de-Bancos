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
		System.out.println("Efetuar saque: \n");
		
		System.out.println("Informe o número da conta: ");
		int numero = Integer.parseInt(Bank.teclado.nextLine());
		
		Conta conta = Bank.buscarConta(numero);
		
		if(conta != null) {
			System.out.println("Insira o valor do saque: ");
			Double valor_saque = Bank.teclado.nextDouble();
			
			conta.sacar(valor_saque);
		}else {
			System.out.println("Conta não encontrada.");
		}
		
		Utils.stop(2);
		Bank.menu();
	}
	
	public static void deposito() {
		System.out.println("Efetuar depósito: \n");
		
		System.out.println("Insira o número da conta: ");
		int numero = Integer.parseInt(Bank.teclado.nextLine());
		
		Conta conta = Bank.buscarConta(numero);
		
		if(conta != null) {
			System.out.println("Insira o valor do depósito: ");
			Double valor_deposito = Bank.teclado.nextDouble();
			
			conta.depositar(valor_deposito);
		}else {
			System.out.println("Conta não encontrada.");
		}
		
		Utils.stop(2);
		Bank.menu();
	}
	
	public static void transferencia() {
		System.out.println("Efetuar transferência: ");
		
		System.out.println("Informe o número da conta de origem: ");
		int numero_origem = Integer.parseInt(Bank.teclado.nextLine());
		
		Conta conta_origem = Bank.buscarConta(numero_origem);
		
		if(conta_origem != null) {
			System.out.println("Insira o número da conta de destino: ");
			int numero_destino = Integer.parseInt(Bank.teclado.nextLine());
			
			Conta conta_destino = Bank.buscarConta(numero_destino);
			
			if(conta_destino != null) {
				System.out.println("Insira o valor da transferência: ");
				Double valor_transferencia = Bank.teclado.nextDouble();
				
				conta_origem.transferir(conta_destino, valor_transferencia);
			}else {
				System.out.println("Conta destino não encontrada.");
			}
		}else {
			System.out.println("Conta origem não encontrada.");
		}
		
		Utils.stop(2);
		Bank.menu();
	}
	
	public static void listarContas() {
		if(Bank.contas.size() > 0) {
			System.out.println("Contas cadastradas: ");
			
			for(Conta conta : Bank.contas) {
				System.out.println(conta);
				System.out.println("====================================\n");
			}
		}else {
			System.out.println("Não há contas cadastradas.");
		}
		
		Utils.stop(1);
		Bank.menu();
	}
	
	private static Conta buscarConta(int numero_conta) {

		if(Bank.contas.size() > 0) {
			for(Conta conta : Bank.contas) {
				if(conta.getNumero() == numero_conta) {
					return conta;
				}
			}
		}else {
			System.out.println("Não há contas cadastradas.");
		}
		
		return null;
	}
}
