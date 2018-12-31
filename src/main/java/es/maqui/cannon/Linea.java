package es.maqui.cannon;

public class Linea {

    private int x;
    private int y;
    private int xFin;
    private int yFin;

    public Linea(int x, int y, int xFin, int yFIn) {
	super();
	this.x = x;
	this.y = y;
	this.xFin = xFin;
	this.yFin = yFIn;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }

    public int getxFin() {
	return xFin;
    }

    public void setxFin(int xFin) {
	this.xFin = xFin;
    }

    public int getyFin() {
	return yFin;
    }

    public void setyFin(int yFin) {
	this.yFin = yFin;
    }

}
