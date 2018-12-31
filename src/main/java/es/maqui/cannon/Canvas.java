package es.maqui.cannon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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

    @Override
    public void paintComponent(Graphics g) {

	super.paintComponent(g);
	setBackground(Color.BLACK);

	g.setColor(Color.YELLOW);
	g.fillRect(0, Ventana.Y - 140, 200, 100);

	Graphics2D graphicSpace = (Graphics2D) g;
	graphicSpace.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	synchronized (listaLineas) {
	    Iterator<Linea> iterator = listaLineas.iterator();
	    while (iterator.hasNext()) {
		pintar(iterator.next(), g);
	    }
	}

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

    private void pintar(Linea lineaActual, Graphics g) {

	g.drawLine(lineaActual.getX(), lineaActual.getY(), lineaActual.getxFin(), lineaActual.getyFin());
	repaint();
    }

}
