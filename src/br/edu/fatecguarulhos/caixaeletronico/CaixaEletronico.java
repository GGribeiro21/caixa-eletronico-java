package br.edu.fatecguarulhos.caixaeletronico;

public class CaixaEletronico implements ICaixaEletronico{
    private int totalDisponivel;
    private int cotaMinima;

	private int[][] cedulas = {{100,100}, {50,200}, {20,300},{10,350},{5,450}, {2,500}};
	
	public CaixaEletronico() {
	}
	public String pegaRelatorioCedulas() {
	    String resposta = "Relatório de Cédulas:\n";

	    for (int i = 0; i < cedulas.length; i++) {
	        int valor = cedulas[i][0];
	        int quantidade = cedulas[i][1];

	        resposta += "Nota de R$" + valor + ": " + quantidade + " Cédulas disponíveis\n";
	    }

	    return resposta;
	}
		public String pegaValorTotalDisponivel() {
			atualizarTotalDisponivel();
			String resposta = ("Valor total disponivel : R$"+totalDisponivel+",00");
			//logica de pega o valor total disponivel no caixa eletronio
			return resposta;
		}
		
		public String reposicaoCedulas(Integer cedula, Integer quantidade) {
				
				if (cedula == 100) {
					cedulas[0][1] = cedulas[0][1] += quantidade; 
				}
				else if (cedula == 50) {
					cedulas[1][1] = cedulas[1][1] += quantidade; 
				}
				else if (cedula == 20) {
					cedulas[2][1] = cedulas[2][1] += quantidade;
				}
				else if (cedula == 10) {
					cedulas[3][1] = cedulas[3][1] += quantidade; 
				}
				else if (cedula == 5) {
					cedulas[4][1] = cedulas[4][1] += quantidade; 
				}
				else if (cedula == 2) {
					cedulas[5][1] = cedulas[5][1] += quantidade; 
				}
				else{
					 System.out.println("A cedula digitada não existe no sistema.");
				}
				
				String resposta = "Reposição realizada com sucesso";
				return resposta;
			}
		
		public String sacar(Integer valor){
			int valorRestante = valor;
			int[][] cedulasSacadas = {{100,0},{50,0},{20,0},{10,0}, {5,0},{2,0}};
			int numeroDeCedulasEmitidas = 0;
			String resposta = "";
			System.out.println("Valor a sacar: R$" + valor);
			for(int indiceCedula = 0; indiceCedula < cedulas.length; indiceCedula++) {
				//Recalcular notas se o valor não puder ser sacado com as maiores notas
				if(valorRestante == 1 || valorRestante == 3) {
					cedulasSacadas[indiceCedula-1][1]--; 
					valorRestante += cedulas[indiceCedula-1][0];
					cedulas[indiceCedula-1][1]++;
					numeroDeCedulasEmitidas--;
				}
				cedulasSacadas[indiceCedula][1] = calcularQuantidadeCedulas(valorRestante, cedulas[indiceCedula][0]);
				
				boolean naoHaCedulasSuficientes = cedulasSacadas[indiceCedula][1] > cedulas[indiceCedula][1];
				if(naoHaCedulasSuficientes) 
					cedulasSacadas[indiceCedula][1] = cedulas[indiceCedula][1];
				
				int valorSacado = cedulasSacadas[indiceCedula][0] * cedulasSacadas[indiceCedula][1];
				valorRestante -= valorSacado;
				
				numeroDeCedulasEmitidas +=  cedulasSacadas[indiceCedula][1];
				//Remover cédulas do caixa
				cedulas[indiceCedula][1] -= cedulasSacadas[indiceCedula][1];
			}
			if(valorRestante != 0) throw new RuntimeException("Valor excedente de R$" + valorRestante);
			//Implementar exceção por falta de cédulas.
			if(numeroDeCedulasEmitidas > 30) {
				throw new RuntimeException("Não é possível sacar mais de 30 cédulas");
			}
			
			for(int nota[] : cedulasSacadas) {
				if(nota[1] != 0)
				resposta = resposta.concat(nota[1] + " notas de "+ nota[0] + "\n");
			}
			return resposta;
		}
		private int calcularQuantidadeCedulas(int valorRestante, int valorCedula) {
			return (valorRestante - (valorRestante % valorCedula)) / valorCedula;
		}
		public String armazenaCotaMinima(Integer minimo) {
            cotaMinima = minimo;
		    String resposta = "Cota mínima atual de R$" + minimo;
		    //logica de armazenar a cota minima para saque e criar um //mensagem(resposta)ao usuario
		    return resposta;
		}

        public void verificarCotaMinima() {
            atualizarTotalDisponivel();
            if(cotaMinima > totalDisponivel)
                throw new RuntimeException("Caixa vazio: Chame o operador");
        }

        private void atualizarTotalDisponivel() {
            for(int[] cedula : cedulas) {
                // para cada cedula, adicionar o resultado do tipo(2, 5, 10 reais...) x quantidade
                totalDisponivel += cedula[0] *  cedula[1];
            }
        }

}
