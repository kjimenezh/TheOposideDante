package Personaje;

import static java.lang.Math.*;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 *
 * @author Jhon
 */
public class Personaje {
    private Scene scene;
    private double xref;
    private double yref;
    private int ancho;
    private int alto;
    private int xAbs;

    public Personaje(double xref, double yref, int ancho, int alto, int sAbs) {
        this.xref = xref;
        this.yref = yref;
        this.ancho = ancho;
        this.alto = alto;
        this.xAbs = sAbs;
    }

    public double getXref() {
        return xref;
    }

    public double getYref() {
        return yref;
    }

    public int getxAbs() {
        return xAbs;
    }

    public void setrefX(double xref) {
        this.xref = xref;
    }

    public void setrefY(double yref) {
        this.yref = yref;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setxAbs(int xAbs) {
        this.xAbs = xAbs;
    }
    
    public void moverDerecha(){
        this.xref++;
    }
    
    public void moverIzquierda(){
        this.xref--;
    }
    
    public void moverArriba(){
        this.yref = yref-3;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    public void saltarquieto(){
        
    }
    
    /*public void saltarmoviendose(){
        this.yref = -((2*tan(toRadians(45))) - ((10*(2*2))/(2*(cos(toRadians(45))*cos(toRadians(45))))));
        /*xref = sin(toRadians(90))/10;
        yref = sin(toRadians(90))/20;
    }*/
    
    public void moverAbajo(){
        this.yref = this.yref + 2.5;
        System.out.println("Altura : " + yref);
    }
}