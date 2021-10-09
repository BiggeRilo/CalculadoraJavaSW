package br.com.atomjuice.calc.visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton implements MouseListener {

	// Atributos para implementar cores quando o Mouse fica em cima do botão
	private Color corBotaoDefault;
	private final Color corOnHover = new Color(26, 22, 22);

	public Botao(String texto, Color cor) {
		setCorBotaoDefault(cor);
		setText(texto);
		setFont(new Font("courier", Font.PLAIN, 30));
		setOpaque(true);
		setBackground(cor);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addMouseListener(this);

	}

	public Color setCorBotaoDefault(Color cor) {
		this.corBotaoDefault = cor;
		return corBotaoDefault;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBackground(corOnHover);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(corBotaoDefault);
	}

}
