package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestMejoradoJUnit {
	@Test
	public void testNegocioMejorado() {
	   NegocioMejorado colorado = new NegocioMejorado();
	   String codigo = colorado.generarCodigo();
	   assertTrue(codigo.startsWith("M-"));
	   int numero = Integer.parseInt(codigo.substring(2));
	   assertTrue(numero >= 1 && numero <= 100);
	}
}
