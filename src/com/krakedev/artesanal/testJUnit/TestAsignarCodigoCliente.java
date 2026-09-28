package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoCliente {
	
	@Test
	public void asignarCodigo() {
		Negocio barTan=new Negocio();
		Cliente marcos = new Cliente("Marcos", "123400789");
		Cliente andrew = new Cliente("Andrew", "987994381");
		
		barTan.asignarCodigoCliente(marcos);
		barTan.asignarCodigoCliente(andrew);
		
		assertEquals(100,marcos.getCodigo());
		assertEquals(101,andrew.getCodigo());
	}

}