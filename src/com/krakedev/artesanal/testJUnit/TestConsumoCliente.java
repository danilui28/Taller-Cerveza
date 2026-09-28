package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumoCliente {
	

	@Test
	public void probarConsumo() {
		Maquina maquinaA= new Maquina("Pilsener", "rubia", 0.02, 8000, null);
		Negocio barTar = new Negocio("Bar Tar", maquinaA);
		Cliente cliente = new Cliente("Andrew","987994381");
		
		barTar.cargarMaquinaA();
		barTar.consumirCervezaMaquinaA(cliente, 100);
		assertEquals(7700,maquinaA.getCantidadActual(),0.0001);
		assertEquals(2.0, cliente.getTotalConsumido(),0.0001);
		
		barTar.consumirCervezaMaquinaA(cliente, 200);
		assertEquals(7500,maquinaA.getCantidadActual(),0.0001);
		assertEquals(6.0, cliente.getTotalConsumido(),0.0001);
	}

}