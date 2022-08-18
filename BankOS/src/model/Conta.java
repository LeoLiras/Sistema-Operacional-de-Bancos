package model;

import helper.Utils;

public class Conta {
	private static int codigo = 1001;
	
	private int numero;
	private Cliente cliente;
	private Double saldo = 0.0;
	private Double limite = 0.0;
	private Double saldo_total = 0.0;
	
	public Conta(Cliente cliente) {
		this.numero = Conta.codigo;
		Conta.codigo++;
		
		this.cliente = cliente;
		
		this.atualizaSaldoTotal();
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getLimite() {
		return limite;
	}
	public void setLimite(Double limite) {
		this.limite = limite;
		this.atualizaSaldoTotal();
	}
	public int getNumero() {
		return numero;
	}
	public Double getSaldo_total() {
		return saldo_total;
	}
	
	public void atualizaSaldoTotal() {
		this.saldo_total = this.getSaldo() + this.getLimite();
	}
	
	public String toString() {
		return "Numero da Conta: " + this.getNumero() + "\nCliente: " + this.cliente.getNome() + "\nSaldo Total: " + Utils.numberToString(this.getSaldo_total());
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			this.saldo = this.getSaldo() + valor;
			this.atualizaSaldoTotal();
			System.out.println("Depósito efetuado com sucesso.\n");
		}else {
			System.out.println("Valor deve ser maior que zero.\n");
		}	
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo_total() >= valor) {
			if(this.getSaldo() >= valor) {
				this.saldo = this.getSaldo() - valor;
				this.atualizaSaldoTotal();
				
				System.out.println("Saque efetuado com sucesso.\n");
				
			}else {
				Double restante = valor - this.getSaldo();
				this.limite = this.getLimite() - restante;
				this.saldo = 0.0;
				
				this.atualizaSaldoTotal();
				
				System.out.println("Saque efetuado com sucesso. O limite de crédito foi utilizado.\n");
			}
		}else {
			System.out.println("Não foi possível realizar o saque.\n");
		}
	}
	
	public void transferir(Conta conta_destino, Double valor) {
		if(valor > 0 && this.getSaldo_total() >= valor) {
			if(this.getSaldo() >= valor) {
				this.saldo = this.getSaldo() - valor;
				this.atualizaSaldoTotal();
				
				conta_destino.saldo = conta_destino.getSaldo() + valor;
				conta_destino.atualizaSaldoTotal();
				
				System.out.println("Transferência realizada com sucesso.");
			}else {
				Double restante = valor - this.getSaldo();
				this.limite = this.getLimite() - restante;
				this.saldo = 0.0;
				this.atualizaSaldoTotal();
				
				conta_destino.saldo = conta_destino.getSaldo() + valor;
				conta_destino.atualizaSaldoTotal();
				
				System.out.println("Transferência realizada com sucesso.");
			}
		}else {
			System.out.println("Não foi possível realizar a transferência.\n");
		}
	}
	
}
