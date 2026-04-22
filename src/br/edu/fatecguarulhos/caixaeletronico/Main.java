package br.edu.fatecguarulhos.caixaeletronico;

public class Main {

	public static void main(String[] args) {
		System.out.println("Caixa eletrônico java");
		CaixaEletronico cx = new CaixaEletronico();
		

		System.out.println(cx.sacar(308));
		System.out.println(cx.sacar(311));
		System.out.println(cx.sacar(313));
		
		System.out.println(cx.sacar(3000));
        System.out.println(cx.armazenaCotaMinima(100000));
        cx.verificarCotaMinima();
        System.out.println(cx.pegaValorTotalDisponivel());
		
	}

}
