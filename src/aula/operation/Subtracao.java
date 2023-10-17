package aula.operation;

import aula.entities.IOperacao;

public class Subtracao implements IOperacao{
	@Override
	public double calculo(double valor1, double valor2) {
		return valor1 - valor2;
	}

	@Override
	public double calculo(int valor1, int valor2) {
		// TODO Auto-generated method stub
		return valor1 - valor2;
	}
}
