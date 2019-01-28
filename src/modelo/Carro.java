package modelo;

/**
 *
 * @author Estudiante
 */
public class Carro {
    private int xref;
    private int yref;
    private int ancho;
    private int alto;
    private Chasis chasis;
    private Llanta[] llantas;

    public Carro(int xref, int yref, int ancho, int alto) {
        this.xref = xref;
        this.yref = yref;
        this.ancho = ancho;
        this.alto = alto;
        //Chasis chasis;
        this.chasis = new Chasis(xref, yref, ancho, alto-5);   
    }

    public int getXref() {
        return xref;
    }
    
    public void setrefY(int y){
        yref = y;
    }

    public int getYref() {
        return yref;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
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
    
    public void moverAbajo(){
      this.yref++;
    }

    public Chasis getChasis() {
        return chasis;
    }

    public Llanta[] getLlantas() {
        return llantas;
    }
}
