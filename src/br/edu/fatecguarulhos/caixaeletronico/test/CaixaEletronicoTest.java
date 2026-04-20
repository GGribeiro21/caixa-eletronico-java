package br.edu.fatecguarulhos.caixaeletronico.test;

import br.edu.fatecguarulhos.caixaeletronico.CaixaEletronico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CaixaEletronicoTest {
	private CaixaEletronico caixaEletronico;
	@Test
	void saque() {
		caixaEletronico = new CaixaEletronico();
		assertEquals(caixaEletronico.sacar(300), "3 notas de 100\n");
		assertThrows(RuntimeException.class, () -> caixaEletronico.sacar(3005));
		assertEquals(caixaEletronico.sacar(308), "3 notas de 100\n"
				+ "4 notas de 2\n");
	}

}
