package aula.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Valores {
	private double valor1;
	private double valor2;
	protected double resultado;
	
	public List <Double> listaValores;
	public List <String> listaOperadores;
	
	public Valores(double valor1, double valor2) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	
	public Valores(List<Double> listaValores, List<String> listaOperadores) {
		super();
		this.listaValores = listaValores;
		this.listaOperadores = listaOperadores;
	}


	public Valores() {
		super();
	}
	
	public double getValor1() {
		return valor1;
	}
	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}
	public double getValor2() {
		return valor2;
	}
	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public void resultado() {
		return;
	}

}
