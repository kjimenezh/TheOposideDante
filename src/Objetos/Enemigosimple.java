package Objetos;

/**
 *
 * @author Jhon
 */
public class Enemigosimple extends Thread{
    private double xref;
    private double yref;
    private int alto;
    private int ancho;

    public Enemigosimple(double xref, double yref, int alto, int ancho) {
        this.xref = xref;
        this.yref = yref;
        this.alto = alto;
        this.ancho = ancho;
    }

    public void setXref(double xref) {
        this.xref = xref;
    }

    public void setYref(double yref) {
        this.yref = yref;
    }

    public double getXref() {
        return xref;
    }

    public double getYref() {
        return yref;
    }
    

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            xref--;
        }
        /*for (int i = 0; i < 300; i++) {
            xref++;
        }*/
    }
}