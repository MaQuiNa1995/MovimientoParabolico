package es.maqui.cannon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Canvas extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<Linea> listaLineas = new ArrayList<>();

    public Canvas() {
	super();

	addMouseMotionListener(new MouseMotionListener() {

	    @Override
	    public void mouseMoved(MouseEvent e) {
//		listaLineas.clear();
//		listaLineas.add(new Linea(200, Ventana.Y - 140, e.getX(), e.getY()));

		double distanciaMouse = calcularDistanciaMaxY(e.getX(), e.getY());
		double anguloLanzamiento = calcularAnguloLanzamiento(e.getX(), e.getY(), distanciaMouse);

		repaint();
	    }

	    @Override
	    public void mouseDragged(MouseEvent e) {
		// TODO nueva funcionalidad de elegir arco
	    }
	});
    }

    @Override
    public void paintComponent(Graphics g) {

	/**
	 * Hacemos una pausa de 50 milisegundos para no sobrecargar la CPU de 30% a 4%
	 * de uso con el cambio
	 */
	try {
	    Thread.sleep(50);
	} catch (InterruptedException excepcion) {
	    // TODO manejar excepcion
	}

	super.paintComponent(g);
	setBackground(Color.BLACK);
	g.setColor(Color.YELLOW);

	g.setColor(Color.YELLOW);
	g.fillRect(0, Ventana.Y - 140, 200, 100);

	for (Linea lineaPintar : listaLineas) {
	    pintar(lineaPintar, g);
	}
    }

    private void pintar(Linea lineaPintar, Graphics g) {
	g.drawLine(lineaPintar.getX(), lineaPintar.getY(), lineaPintar.getxFin(), lineaPintar.getyFin());
    }

    private double calcularDistanciaMaxY(double x, double y) {

	double raizCuadrada = StrictMath.pow(x, 2d) + StrictMath.pow(y, 2d);
	return StrictMath.sqrt(raizCuadrada);
    }

    private double calcularAnguloLanzamiento(int x, int y, double distanciaMaxY) {

	double divisor = StrictMath.pow(x, 2d) + StrictMath.pow(distanciaMaxY, 2d) - StrictMath.pow(y, 2d);
	double dividendo = 2 * x * distanciaMaxY;
	double cociente = divisor / dividendo;

	return StrictMath.acos(cociente);
    }

}
