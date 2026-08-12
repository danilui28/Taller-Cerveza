package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

	@Test
	public void testRecargaExitosa() {
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "0322");

		boolean resultado = rubia.RecargarCerveza(3000);

		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(), 0.0001);
	}

	@Test
	public void testRecargaFallidaPorDesborde() {
		Maquina negra = new Maquina("Club", "Cerveza Fria", 0.02, 8000, "5001");
		negra.RecargarCerveza(7000);
		boolean resultado = negra.RecargarCerveza(800);

		assertTrue(resultado);
		assertEquals(7800, negra.getCantidadActual(), 0.0001);
	}
}
