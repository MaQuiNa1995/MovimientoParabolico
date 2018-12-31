package es.maqui.cannon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
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

	this.addMouseMotionListener(new MouseMotionListener() {

	    @Override
	    public void mouseMoved(MouseEvent e) {
		listaLineas.clear();
		listaLineas.add(new Linea(200, Ventana.Y - 140, e.getX(), e.getY()));
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

	Iterator<Linea> iterator = listaLineas.iterator();
	while (iterator.hasNext()) {
	    pintar(iterator.next(), g);
	}

    }

    private void pintar(Linea lineaActual, Graphics g) {

	g.drawLine(lineaActual.getX(), lineaActual.getY(), lineaActual.getxFin(), lineaActual.getyFin());
	repaint();
    }

}
