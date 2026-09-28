package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class testConsumirCervezaJUnit {
		@Test
		public void testConsumirCerveza() {

		    NegocioMejorado colorado = new NegocioMejorado();

		    colorado.agregarMaquina(
		        "Pilsener",
		        "Cerveza rubia",
		        0.05
		    );
		    
		    colorado.cargarMaquinas();

		    colorado.registrarCliente(
		        "David",
		        "1312345678"
		    );

		    Maquina maquina = colorado.getMaquinas().get(0);
		    Cliente cliente = colorado.getClientes().get(0);

		    double cantidadAntes = maquina.getCantidadActual();
		    double consumoAntes = cliente.getTotalConsumido();

		    double valor = colorado.consumirCerveza(
		        cliente.getCodigo(),
		        maquina.getCodigo(),
		        100
		    );

		    assertEquals(
		        cantidadAntes - 100,
		        maquina.getCantidadActual()
		    );

		    assertEquals(
		        consumoAntes + valor,
		        cliente.getTotalConsumido()
		    );
		}
		
		@Test
		public void testConsultarValorVendido() {

		    NegocioMejorado colorado = new NegocioMejorado();

		    colorado.agregarMaquina(
		        "Pilsener",
		        "Cerveza rubia",
		        0.05
		    );

		    colorado.cargarMaquinas();

		    colorado.registrarCliente("David", "1312345678");
		    colorado.registrarCliente("Pedro", "1398765432");

		    Maquina maquina = colorado.getMaquinas().get(0);

		    Cliente cliente1 = colorado.getClientes().get(0);
		    Cliente cliente2 = colorado.getClientes().get(1);

		    colorado.consumirCerveza(
		        cliente1.getCodigo(),
		        maquina.getCodigo(),
		        100
		    );

		    colorado.consumirCerveza(
		        cliente2.getCodigo(),
		        maquina.getCodigo(),
		        200
		    );

		    double total = colorado.consultarValorVendido();

		    assertEquals(15.0, total);
		}

	}

