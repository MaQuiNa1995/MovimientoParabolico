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

    private List<Parabola> listaParabolas = new ArrayList<>();

    public Canvas() {
	super();

	addMouseMotionListener(new MouseMotionListener() {

	    @Override
	    public void mouseMoved(MouseEvent e) {
		listaParabolas.clear();

		Double distanciaY = calcularDistanciaMaxY(e.getX(), e.getY());

		Parabola parabola = new Parabola();
		parabola.setxInicial(200D);
		parabola.setyInicial(Ventana.Y - 140D);
		parabola.setDistanciaMaxY(distanciaY);
		parabola.setAngulo(calcularAnguloLanzamiento(e.getX(), e.getY(), distanciaY));
		parabola.setVelocidad(10D);

		listaParabolas.add(parabola);
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

	// TODO mirar eficiencia con Timer en vez de un hilo
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

	g.setColor(Color.BLUE);
	g.fillRect(0, 140, 200, 100);

	g.setColor(Color.YELLOW);
	for (Parabola parabola : listaParabolas) {
	    pintarParabola(parabola, g);
	}
    }

    private void pintarParabola(Parabola parabola, Graphics g) {

	double tiempo = 1;

	// g.drawLine(parabola.getX(), parabola.getY(), parabola.getxFin(),
	// parabola.getyFin());

	double veloInicialX = parabola.getVelocidad() * StrictMath.acos(parabola.getAngulo());
	double veloinicialY = parabola.getVelocidad() * StrictMath.asin(parabola.getAngulo());

	// Asignacion inutil a efectos practicos pero si mentales para entender de donde
	// sale todo
	double veloX = veloInicialX;

	while (true) {

//	    double veloY = veloinicialY - Constantes.GRAVEDAD * tiempo;

	    Double x = veloX * tiempo;
	    Double y = parabola.getyInicial() + veloinicialY * tiempo
		    - 0.5 * Constantes.GRAVEDAD * StrictMath.pow(tiempo, 2);

	    try {
		Thread.sleep(1);
	    } catch (InterruptedException excepcion) {
		// TODO manejar excepcion
	    }

	    if (y < 0 || y > 800) {
		break;
	    }

	    tiempo++;
	    g.drawLine(parabola.getxInicial().intValue(), parabola.getyInicial().intValue(), x.intValue(),
		    y.intValue());

	    parabola.setxInicial(x);
	    parabola.setyInicial(y);

	}

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
