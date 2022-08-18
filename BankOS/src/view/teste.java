package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente c1 = new Cliente("Bruce Wayne", "bruce.wayne@hotmail.com", "123.456.789", Utils.stringDate("05/04/1990"));
		Cliente c2 = new Cliente("Selina Kyle", "selina@gmail.com", "345.6456.243", Utils.stringDate("10/02/1992"));
		
//		System.out.println(c1 + "\n");
//		System.out.println(c2);
//		
		Conta cont1 = new Conta(c1);
		Conta cont2 = new Conta(c2);
		
		System.out.println(cont1 + "\n");
		System.out.println(cont2);
		
		cont1.depositar(500.00);
		cont2.depositar(0.00);
		
		System.out.println(cont1 + "\n");
		System.out.println(cont2);
		
		cont1.sacar(600.0);
		System.out.println(cont1);
		
		cont1.setLimite(200.0);
		cont1.sacar(600.0);
		System.out.println(cont1);
		
		cont1.transferir(cont2, 50.0);
		System.out.println(cont1 + "\n");
		System.out.println(cont2);
	}

}
