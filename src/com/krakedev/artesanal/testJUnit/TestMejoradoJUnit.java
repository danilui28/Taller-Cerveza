package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.krakedev.artesanal.Maquina;
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
	@Test
	public void testRecuperarMaquina() {

	    NegocioMejorado colorado = new NegocioMejorado();

	    colorado.agregarMaquina(
	        "Pilsener",
	        "Cerveza rubia",
	        0.05
	    );

	    Maquina maquinaAgregada = colorado.getMaquinas().get(0);

	    String codigo = maquinaAgregada.getCodigo();

	    Maquina maquinaRecuperada = colorado.recuperarMaquina(codigo);

	    assertEquals(codigo, maquinaRecuperada.getCodigo());
	}
	@Test
	public void testAgregarMaquina() {

	    NegocioMejorado colorado = new NegocioMejorado();

	    boolean resultado = colorado.agregarMaquina(
	            "Pilsener",
	            "Cerveza rubia",
	            0.05
	    );

	    assertTrue(resultado);
	}
}
