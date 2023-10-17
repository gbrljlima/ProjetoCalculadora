package aula.entities;

import java.util.List;

public class Calculo extends Valores {
	private IOperacao op;
	
	public Calculo(double valor1, double valor2, IOperacao op) {
		super(valor1, valor2);
		this.op = op;
	}
	
	
	public Calculo(List<Double> listaValores, List<String> listaOperadores) {
		super(listaValores, listaOperadores);
	}


	@Override
	public void resultado() {
		this.resultado = op.calculo(getValor1(), getValor2());
	}
}
