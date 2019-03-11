
package modelo;

/**
 *
 * @author kjime
 */
public class Usuario {
    private String nombre;
    private double score;

    public Usuario(String nombre, double score) {
        this.nombre = nombre;
        this.score = score;
    }

    public String getNombre() {
        return nombre;
    }

    public double getScore() {
        return score;
    }
    
}
