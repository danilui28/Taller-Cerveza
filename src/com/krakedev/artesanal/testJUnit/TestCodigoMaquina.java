package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestCodigoMaquina {
	@Test
	public void testCodigoMaquina() {

	    NegocioMejorado colorado = new NegocioMejorado();

	    colorado.agregarMaquina(
	            "Pilsener",
	            "Cerveza rubia",
	            0.05
	    );

	    Maquina maquina = colorado.getMaquinas().get(0);

	    assertEquals("Pilsener", maquina.getNombreCerveza());
	    assertEquals("Cerveza rubia", maquina.getDescripcion());
	    assertEquals(0.05, maquina.getPrecioPorMl());

	    assertTrue(maquina.getCodigo().startsWith("M-"));
	}
	
	@Test
	public void testCodigoDuplicado() {

	    NegocioMejorado colorado = new NegocioMejorado() {
	        @Override
	        public String generarCodigo() {
	            return "M-50";
	        }
	    };

	    boolean primero = colorado.agregarMaquina(
	            "Pilsener",
	            "Cerveza rubia",
	            0.05
	    );

	    boolean segundo = colorado.agregarMaquina(
	            "Club",
	            "Cerveza dorada",
	            0.06
	    );

	    assertTrue(primero);
	    assertFalse(segundo);
	}
}
