package es.maqui.cannon;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.JFrame;

public class Ventana {

    private static final int COMPONENTE_X = 800;
    private static final int COMPONENTE_Y = 600;

    public void iniciarVentana() {
	JFrame frame = new JFrame("Ventana Animacion parabolica");

	frame.setBounds(0, 0, COMPONENTE_X, COMPONENTE_Y);

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(new Label(), BorderLayout.CENTER);
	frame.setVisible(true);
    }
}
