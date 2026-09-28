package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private int ultimoCodigo = 0;
	
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();
		
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
	}
	
	public String generarCodigo() {
		int codigo;
		codigo = (int)(Math.random() * 100) + 1;
		return "M-" + codigo;
	}
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		
		Maquina maquinaRecuperada = recuperarMaquina(codigo);
		   
		if(maquinaRecuperada == null) {
		
	        Maquina maquina = new Maquina(
	            codigo,
	            nombreCerveza,
	            precioPorMl,
	            descripcion
	        );
	        maquinas.add(maquina);
	        
	        return true;
		}
		
		return false;
	}
	public void cargarMaquinas() {
		for(int i = 0; i < maquinas.size(); i++ ) {
	        Maquina maquina = maquinas.get(i);
	        maquina.llenarMaquina();
		}
	}
	
	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			
		  Maquina maquina = maquinas.get(i);
		
          if (maquina.getCodigo().equals(codigo)) {
              return maquina;
          }
		}
         return null;
	}
	
	public void registrarCliente(String nombre, String cedula) {

	    Cliente cliente = new Cliente(nombre, cedula);

	    cliente.setCodigo(ultimoCodigo);
	    ultimoCodigo++;

	    clientes.add(cliente);
	}
}