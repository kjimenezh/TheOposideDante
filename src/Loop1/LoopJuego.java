package Loop1;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import Personaje.Personaje;
import Enemigosimple.Enemigosimple;
import static java.lang.Math.*;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer {

    private Scene escena; //Para controlar los eventos del teclado y para el cambio de nivel.
    private GraphicsContext lapiz;

    private Personaje carro;
    private Image fondo;
    private Image esqueletoim;
    private Enemigosimple esqueleto;
    private Image mensito2;
    private Image mensito;
    private int secuencia = 0;
    private int numero;
    private int contador = 100;
    private String marca = "RIGHT";
    private ArrayList<String> pulsacionTeclado = null;

    public LoopJuego(Scene escena, GraphicsContext lapiz) {
        this.lapiz = lapiz;
        this.escena = escena;
        this.carro = new Personaje(0.0, 420.0, 40, 52, 0);//ubicación del mensito v;
        this.esqueleto = new Enemigosimple(750, 425, 40, 52);
        this.fondo = new Image("image/CITY_MEGA sin fondo.png");
        this.mensito2 = new Image("image/rogue spritesheet calciumtrice.png");
        this.mensito = new Image("image/rogue spritesheet calciumtrice IZ.png");
        this.esqueletoim = new Image("image/rpgcritter update formatted transparent.png");
        pulsacionTeclado = new ArrayList<>();

        escena.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                if (!pulsacionTeclado.contains(code)) {
                    pulsacionTeclado.add(code);
                }
            }
        });

        escena.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                pulsacionTeclado.remove(code);
            }
        });

    }

    @Override
    public void handle(long now) {

        //Carro
        lapiz.clearRect(0, 0, 1800, 520);
        
        if (this.numero % 10 == 0) {
            if (this.secuencia == 9) {
                this.secuencia = 0;
            } else {
                this.secuencia++;
            }
        }

        //Permite dibujar una imagen de fondo
        //permite hacer que el escenario vaya moviendose en la ubicación 
        if (carro.getxAbs() < 796) {
            if (carro.getxAbs() == 794) {
                carro.setrefX(760);
            }
            lapiz.drawImage(fondo, 43, 2400, 696, 320, 0, 0, 796, 520);
            lapiz.drawImage(fondo, 43, 2068, 696, 268, 0, 89, 796, 438);
            lapiz.drawImage(fondo, 43, 1621, 696, 235, 0, 204, 796, 330);
            
        } else if (carro.getxAbs() >= 796 && carro.getxAbs() < 1592) {
            if (carro.getxAbs() == 796) {//796
                carro.setrefX(0);//0
            }
            lapiz.drawImage(fondo, 736, 2400, 696, 320, 0, 0, 796, 520);
            lapiz.drawImage(fondo, 736, 2068, 696, 268, 0, 89, 796, 438);
            lapiz.drawImage(fondo, 736, 1621, 696, 235, 0, 204, 796, 330);
            try{
                esqueleto.start();
            }catch(Exception e){
                System.out.println("pailas prro");
            }
            for (int i = 0; i < 300; i++) {
                esqueleto.setXref(esqueleto.getXref()-1);
            }
            for (int i = 0; i < 300; i++) {
                esqueleto.setXref(esqueleto.getXref()+1);
            }
            lapiz.drawImage(esqueletoim, 16*this.secuencia, 111, 16, 17, esqueleto.getXref(), esqueleto.getYref(), 26, 27);
        } else if (carro.getxAbs() >= 1592 && carro.getxAbs() < 2388) {
            if (carro.getxAbs() == 1592) {
                carro.setrefX(0);
            }
            lapiz.drawImage(fondo, 43, 2400, 696, 320, 0, 0, 796, 520);
            lapiz.drawImage(fondo, 43, 1836, 696, 20, 0, 507, 796, 20);
        } else if (carro.getxAbs() >= 2388 && carro.getxAbs() < 3184) {
            if (carro.getxAbs() == 2388) {
                carro.setrefX(0);
            }
            lapiz.drawImage(fondo, 736, 2400, 696, 320, 0, 0, 796, 520);
            lapiz.drawImage(fondo, 736, 1836, 696, 20, 0, 507, 796, 20);
        }

        lapiz.strokeRect(carro.getXref() + 5, carro.getYref(), carro.getAncho(), carro.getAlto());

        //Obstaculos (imagen)
        lapiz.fillRect(100, 100, 20, 20);
        //lapiz.strokeRect(0, 507, 1800, 20);

        //movimiento de "gravedad"
        carro.moverAbajo();

        //Validando colision
        Shape sChasis = new Rectangle(carro.getXref() + 5, carro.getYref(), carro.getAncho(), carro.getAlto());
        //Obstaculos(programados)
        Shape sObstaculo = new Rectangle(100, 100, 20, 20);
        Shape bObstaculo = new Rectangle(0, 507, 1800, 20);
        //Calculando la Interseccion
        Shape interseccion = SVGPath.intersect(sChasis, bObstaculo);
        Shape intersection = SVGPath.intersect(sChasis, sObstaculo);

        if (intersection.getBoundsInLocal().getWidth() != -1) {
            contador = contador - 1;
            //stop();
        }

        if (interseccion.getBoundsInLocal().getWidth() != -1) {
            carro.setrefY(455);
        }

        //Acciones de teclado
        if (marca == "RIGHT") {
            lapiz.drawImage(mensito2, 32 * this.secuencia, 64, 32, 32, carro.getXref(), carro.getYref(), 52, 52);
        }
        if (marca == "LEFT") {
            lapiz.drawImage(mensito, 32 * this.secuencia, 64, 32, 32, carro.getXref(), carro.getYref(), 52, 52);
        }

        if (pulsacionTeclado.contains("LEFT")) {
            //
            marca = "LEFT";
            carro.setxAbs(carro.getxAbs() - 2);
            System.out.println(carro.getXref());
            carro.moverIzquierda();
            lapiz.drawImage(mensito, 32 * this.secuencia, 64, 32, 32, carro.getXref(), carro.getYref(), 52, 52);
        }
        if (pulsacionTeclado.contains("RIGHT")) {
            marca = "RIGHT";
            carro.setxAbs(carro.getxAbs() + 2);
            System.out.println("ABS: " + carro.getxAbs());
            carro.moverDerecha();
            lapiz.drawImage(mensito2, 32 * this.secuencia, 64, 32, 32, carro.getXref(), carro.getYref(), 52, 52);
        }
        if (pulsacionTeclado.contains("UP")) {
            if (pulsacionTeclado.contains("RIGHT") && carro.getYref() >= 450.0) {
                //carro.setrefY((200.0/30625.0)*(carro.getXref())+307.0);
                carro.saltarmoviendose();
            }
        }
        if (pulsacionTeclado.contains("DOWN")) {
            carro.moverAbajo();
        }

        //imagen de la puntuacion
        lapiz.strokeText("Puntaje: " + contador, 200, 10);

        this.numero++;
    }
}
