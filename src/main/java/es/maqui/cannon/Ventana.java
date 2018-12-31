package es.maqui.cannon;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    /**
     * 
     */
    // TODO Generar UUID
    private static final long serialVersionUID = 1L;

    public static final int X = 400;
    public static final int Y = 200;
    private final static Dimension DIMENSIONES_VENTANA = new Dimension(X, Y);

    public void iniciarVentana() {

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("Simulacion De Bala De Cañon");
	setVisible(true);
	setSize(DIMENSIONES_VENTANA);

	Canvas canvas = new Canvas();
	canvas.setLocation(0, 0);
	canvas.setPreferredSize(DIMENSIONES_VENTANA);

	Container cp = getContentPane();
	cp.add(canvas);
    }
}
