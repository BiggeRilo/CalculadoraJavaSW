package br.com.atomjuice.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.atomjuice.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

	private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
	private final Color COR_CINZA_CLARO = new Color(96, 100, 99);
	private final Color COR_LARANJA = new Color(242, 163, 60);

	public Teclado() {

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constrain = new GridBagConstraints();

		setLayout(layout);

		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.fill = GridBagConstraints.BOTH;

		// Linha 1
		constrain.gridwidth = 1;
		adicionarBotao("AC", COR_CINZA_ESCURO, constrain, 0, 0);
		adicionarBotao("±", COR_CINZA_ESCURO, constrain, 2, 0);
		adicionarBotao("%", COR_CINZA_ESCURO, constrain, 1, 0);
		adicionarBotao("/", COR_LARANJA, constrain, 3, 0);

		// Linha 2
		adicionarBotao("7", COR_CINZA_CLARO, constrain, 0, 1);
		adicionarBotao("8", COR_CINZA_CLARO, constrain, 1, 1);
		adicionarBotao("9", COR_CINZA_CLARO, constrain, 2, 1);
		adicionarBotao("*", COR_LARANJA, constrain, 3, 1);

		// Linha 3

		adicionarBotao("4", COR_CINZA_CLARO, constrain, 0, 2);
		adicionarBotao("5", COR_CINZA_CLARO, constrain, 1, 2);
		adicionarBotao("6", COR_CINZA_CLARO, constrain, 2, 2);
		adicionarBotao("-", COR_LARANJA, constrain, 3, 2);

		// Linha 4
		adicionarBotao("1", COR_CINZA_CLARO, constrain, 0, 3);
		adicionarBotao("2", COR_CINZA_CLARO, constrain, 1, 3);
		adicionarBotao("3", COR_CINZA_CLARO, constrain, 2, 3);
		adicionarBotao("+", COR_LARANJA, constrain, 3, 3);

		// Linha 5

		// Zero Ocupa 2 espaços
		constrain.gridwidth = 2;
		adicionarBotao("0", COR_CINZA_CLARO, constrain, 0, 4);

		constrain.gridwidth = 1;
		adicionarBotao(",", COR_CINZA_CLARO, constrain, 2, 4);
		adicionarBotao("=", COR_LARANJA, constrain, 3, 4);
	}

	// Funcao para criar o botão e adicionar na linha/coluna especificada
	private void adicionarBotao(String texto, Color cor, GridBagConstraints constrain, int x, int y) {
		constrain.gridx = x;
		constrain.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, constrain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
			;
		}
	}

}
