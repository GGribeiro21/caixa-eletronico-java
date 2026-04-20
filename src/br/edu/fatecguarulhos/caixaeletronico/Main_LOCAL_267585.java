package br.edu.fatecguarulhos.caixaeletronico;

public class Main {

	public static void main(String[] args) {
		CaixaEletronico cx = new CaixaEletronico();
		
		System.out.println(cx.sacar(308));
		System.out.println(cx.sacar(311));
		System.out.println(cx.sacar(313));
	}

}
