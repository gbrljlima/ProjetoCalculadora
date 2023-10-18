package application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import aula.entities.Calculo;
import aula.entities.Valores;
import aula.operation.Divisao;
import aula.operation.Multiplicacao;
import aula.operation.Soma;
import aula.operation.Subtracao;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class JCalc extends JFrame {

	private JPanel contentPane;
	private String valor1 = "";
	private String valor2 = "";
	private JLabel lblCalc;
	private String expressao = "";
	private String result = "";
	private JButton ultimoBotao;
	private boolean opCheck;
	private int count = 0;
	private Valores valores = new Calculo(new ArrayList<>(), new ArrayList<>());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalc frame = new JCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCalc() {
		ultimoBotao = new JButton("");
		setFont(new Font("Arial", Font.PLAIN, 9));
		setTitle("Calculadora Simple");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 252, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("");
		lblResult.setForeground(new Color(0, 0, 0));
		lblResult.setBackground(SystemColor.text);
		lblResult.setFont(new Font("Arial", Font.BOLD, 20));
		lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResult.setBounds(10, 43, 210, 33);
		contentPane.add(lblResult);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn0.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn0.setBounds(10, 247, 50, 50);
		contentPane.add(btn0);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn3.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn3.setBounds(10, 197, 50, 50);
		contentPane.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn2.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn2.setBounds(60, 197, 50, 50);
		contentPane.add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn1.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn1.setBounds(110, 197, 50, 50);
		contentPane.add(btn1);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn4.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn4.setBounds(110, 147, 50, 50);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn5.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn5.setBounds(60, 147, 50, 50);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn6.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn6.setBounds(10, 147, 50, 50);
		contentPane.add(btn6);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn9.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn9.setBounds(10, 97, 50, 50);
		contentPane.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn8.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn8.setBounds(60, 97, 50, 50);
		contentPane.add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumero(btn7.getText());
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btn7.setBounds(110, 97, 50, 50);
		contentPane.add(btn7);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valor1.contains(".") && valores.listaOperadores.isEmpty() || valor2.contains(".")) {
					return;
				}
				String numero = btnDot.getText();
				if (valor1.equals("")) {
					numero = "0.";
				}
				else if(opCheck && valor2.equals("")) {
					numero = "0.";
				}
				
				setNumero(numero);
				Valores calc = getResult();
				setTextResult(lblResult, calc);
			}
		});
		btnDot.setBounds(60, 247, 50, 50);
		contentPane.add(btnDot);
		
		JButton btnSum = new JButton("+");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation(lblResult, btnSum.getText());
			}
		});
		btnSum.setBounds(170, 97, 50, 33);
		contentPane.add(btnSum);
		
		JButton btnSubtract = new JButton("-");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation(lblResult, btnSubtract.getText());
			}
		});
		btnSubtract.setBounds(170, 130, 50, 33);
		contentPane.add(btnSubtract);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation(lblResult, btnMultiply.getText());
			}
		});
		btnMultiply.setBounds(170, 163, 50, 33);
		contentPane.add(btnMultiply);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation(lblResult, btnDivide.getText());
			}
		});
		btnDivide.setBounds(170, 196, 50, 33);
		contentPane.add(btnDivide);
		
		JButton btnResult = new JButton("=");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valor1.equals("")) {
					return;
				}
				try	{
					ultimoBotao = btnResult;
					Valores calc = getResult();
					if (calc.getResultado() == Double.POSITIVE_INFINITY) {
						JOptionPane.showMessageDialog(null, "Não é possível dividir por 0!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					setTextResult(lblResult, calc);
					lblCalc.setText(result);
					lblResult.setText("");
					valor1 = result;
				}
				catch (NumberFormatException e1) {
					lblCalc.setText(valor1);
				}
				catch (NullPointerException e1) {
					lblCalc.setText(valor1);
				}
				expressao = valor1;
				opCheck = false;
			}
		});
		btnResult.setBounds(170, 229, 50, 33);
		contentPane.add(btnResult);
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				lblResult.setText("");
				lblCalc.setText("0");
			}
		});
		btnCE.setBounds(170, 262, 50, 33);
		contentPane.add(btnCE);
		
		lblCalc = new JLabel("0");
		lblCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalc.setForeground(Color.BLACK);
		lblCalc.setFont(new Font("Arial", Font.BOLD, 20));
		lblCalc.setBackground(SystemColor.text);
		lblCalc.setBounds(10, 11, 210, 33);
		contentPane.add(lblCalc);
		
		JPanel panel = new JPanel();
		panel.setBounds(216, 78, -212, -34);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 216, 65);
		contentPane.add(panel_1);
	}
	
	private void limpar() {
		valor2 = "";
		expressao = "";
		valor1 = "";
		result = "";
		valores = new Calculo(new ArrayList<>(), new ArrayList<>());
		count = 0;
		opCheck = false;
	}
	
	private void setNumero(String numero) {
		if (ultimoBotao.getText().equals("=") && !opCheck) {
			limpar();
		}
		if (valores.listaOperadores.isEmpty()){
			valor1 = valor1.concat(numero);									
		}
		else {
			valor2 = valor2.concat(numero);
			if (valores.listaValores.size() == count) {
				valores.listaValores.add(Double.parseDouble(valor2));
			}
			else {
				valores.listaValores.set(count, Double.parseDouble(valor2));
			}		
		}
		if (valor1.length() > 0 && valor1.startsWith("0") && !valor1.contains(".") && !opCheck) {
			valor1 = valor1.substring(1);
			return;
		}
		if (valor2.length() > 1 && valor2.startsWith("0") && !valor2.contains(".")) {
			valor2 = valor2.substring(1);
			return;
		}
		ultimoBotao = new JButton("'");
		expressao = expressao.concat(numero);
		lblCalc.setText(expressao);
		opCheck = false;
	}
	
	private void setTextResult(JLabel txtResult, Valores calc) {
		result = valor1;
		txtResult.setText(result);
		if (calc == null) {
			return;
		}
		result = Double.toString(calc.getResultado());
		if (calc.getResultado() == Double.POSITIVE_INFINITY) {
			result = "";
		}	
		else if (calc.getResultado() % 1 == 0) {
			result = Integer.toString((int) calc.getResultado());
		}
			txtResult.setText(result);		
	}
	
	private void setOperation(JLabel txtResult, String operacao) {
		double numero = 0;
		if (ultimoBotao.getText().equals("=")) {
			valores = new Calculo(new ArrayList<>(), new ArrayList<>());
			valor2 = "";
			count = 0;
		}
		try {
			if (!operacao.equals("-") && valor1.equals("")) {
				return;
			}		
			else if (opCheck && "/*+".contains(valores.listaOperadores.get(count - 1)) && operacao.equals("-") && valor2.equals("")) {
				valor2 = "-";
				expressao = expressao.concat(valor2);
				lblCalc.setText(expressao); 
				return;
			}	
			else if ("/*+-".contains(ultimoBotao.getText())) {
				if (valor2.contains("-")) {
					return;
				}
				valores.listaOperadores.set(count - 1, operacao);
				expressao = expressao.substring(0, expressao.length() - 1).concat(operacao);
				lblCalc.setText(expressao);
				return;
			}
			else if (opCheck) {
				return;
			}
		}
		catch (IndexOutOfBoundsException e2) {
			return;
		}	
		if (operacao.equals("-") && valor1.equals("")) {
			valor1 = "-";
			expressao = expressao.concat(valor1);
		}
		else {
			if (valor2.equals("")) {
				numero = Double.parseDouble(valor1);
				valores.listaValores.add(numero);
			}
			else {
				numero = Double.parseDouble(valor2);
				valores.listaValores.set(count, numero);
			}
			valores.listaOperadores.add(operacao);
			count++;
			valor1 = result;
			expressao = expressao.concat(operacao);	
		}		
		ultimoBotao = new JButton(operacao);
		valor2 = "";
		lblCalc.setText(expressao);
		txtResult.setText(result);
		opCheck = true;
	}
	
	private Valores getResult() {
		Valores calc = null;
		String ultimaOperacao;
		List <Double> valorCalc = new ArrayList<>(valores.listaValores);
		List <String> opCalc = new ArrayList<>(valores.listaOperadores);
		try {
			ultimaOperacao = opCalc.get(opCalc.size() - 1);
		}
		catch (IndexOutOfBoundsException e4) {
			return null;
		}

		while (opCalc.size() > 0) {
			int index = 0;
			String operacao = "";
			for (int i = 0; i < opCalc.size(); i++) {
				if (opCalc.get(i).equals("*") || opCalc.get(i).equals("/")) {
					operacao = opCalc.get(i);
					index = i;
					break;
				}			
			}
			if (operacao.equals("")) {
				for (int i = 0; i < opCalc.size(); i++) {
					if (opCalc.get(i).equals("+") || opCalc.get(i).equals("-")) {
						operacao = opCalc.get(i);
						index = i;
						break;
					}
				}
			}
			try {
				if (operacao.contains("+")) {
					calc = new Calculo(valorCalc.get(index), valorCalc.get(index+1), new Soma());
				}
				else if (operacao.contains("-")) {
					calc = new Calculo(valorCalc.get(index), valorCalc.get(index+1), new Subtracao());
				}
				else if (operacao.contains("*")) {
					calc = new Calculo(valorCalc.get(index), valorCalc.get(index+1), new Multiplicacao());
				}
				else if (operacao.contains("/")) {
					calc = new Calculo(valorCalc.get(index), valorCalc.get(index+1), new Divisao());
				}
			}
			catch (IndexOutOfBoundsException e4) {
				return null;
			}
			calc.resultado();
			opCalc.remove(index);
			valorCalc.remove(index);
			valorCalc.set(index, calc.getResultado());
		}
		if (ultimoBotao.getText().equals("=")) {
			valores.listaValores = new ArrayList<>();
			valores.listaValores.add(calc.getResultado());
			valores.listaValores.add(Double.parseDouble(valor2));
			valores.listaOperadores = new ArrayList<>();
			valores.listaOperadores.add(ultimaOperacao);
		}
		return calc;
	}
}

