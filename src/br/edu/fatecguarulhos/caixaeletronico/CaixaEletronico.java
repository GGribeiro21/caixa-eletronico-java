package br.edu.fatecguarulhos.caixaeletronico;

public class CaixaEletronico implements ICaixaEletronico{
	private int[][] cedulas = {{100,100}, {50,200}, {20,300},{10,350},{5,450}, {2,500}};
	public CaixaEletronico() {
	}
	public String pegaRelatorioCedulas() {
		String resposta = "";
		//logica de fazer o relatorio de cedulas
		return resposta;
		}
		public String pegaValorTotalDisponivel() {
		String resposta = "";
		//logica de pega o valor total disponivel no caixa eletronio
		return resposta;
		}
		public String reposicaoCedulas(Integer cedula, Integer quantidade) {
		String resposta = "";
		//logica de fazer a reposicao de cedulas e criar uma mensagem //(resposta)ao usuario
		return resposta;
		}
		public String sacar(Integer valor){
			int valorSacado = valor;
			int[][] notasParaSaque = {{100,0},{50,0},{20,0},{10,0}, {5,0},{2,0}};
			int cedulasEmitidas = 0;
			int valorEntregue = 0;
			String resposta = "";
			System.out.println("Valor a sacar: R$" + valor);
			for(int i = 0; i < 6; i++) {
				//Recalcular notas se o valor não puder ser sacado com as maiores notas
				if(valorSacado == 1 || valorSacado == 3) {
					notasParaSaque[i-1][1]--; 
					valorSacado += cedulas[i-1][0];
					cedulas[i-1][1]++;
					cedulasEmitidas--;
				}
				//Calcular quantidade de notas
				notasParaSaque[i][1] = (valorSacado- (valorSacado % cedulas[i][0])) / cedulas[i][0];
				//Se não houver notas suficientes disponíveis, utilizar as de menor valor
				if(notasParaSaque[i][1] > cedulas[i][1]) notasParaSaque[i][1] = cedulas[i][1];
				//Reduzir valor restante
				valorSacado -= notasParaSaque[i][0] * notasParaSaque[i][1];
				//Atualizar valor de cédulas emitidas
				cedulasEmitidas +=  notasParaSaque[i][1];
				//Remover cédulas do caixa
				cedulas[i][1] -= notasParaSaque[i][1];
			}
			if(valorSacado != 0) throw new RuntimeException("Valor excedente de R$" + valorSacado);
			//Implementar exceção por falta de cédulas.
			if(cedulasEmitidas > 30) {
				throw new RuntimeException("Não é possível sacar mais de 30 cédulas");
			}
			
			for(int nota[] : notasParaSaque) {
				if(nota[1] != 0)
				resposta = resposta.concat(nota[1] + " notas de "+ nota[0] + "\n");
			}
			return resposta;
		}
		public String armazenaCotaMinima(Integer minimo) {
		String resposta = "";
		//logica de armazenar a cota minima para saque e criar um //mensagem(resposta)ao usuario
		return resposta;
		}
}
