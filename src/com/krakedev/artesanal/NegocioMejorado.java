package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	ArrayList<Maquina> maquina;
		
	public ArrayList<Maquina> getMaquina() {
		return maquina;
	}
	
	public NegocioMejorado() {
		maquina = new ArrayList<Maquina>();
	}
	
	public String generarCodigo() {
		int codigo;
		codigo = (int)(Math.random() * 100) + 1;
		return "M-" + codigo;
	}
}