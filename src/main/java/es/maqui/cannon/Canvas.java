package es.maqui.cannon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseMotionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics g) {

	super.paintComponent(g);
	setBackground(Color.BLACK);

	g.setColor(Color.YELLOW);
	g.fillRect(0, Ventana.Y - 140, 200, 100);

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
