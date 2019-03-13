package Main;

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
import Objetos.Personaje;
import Objetos.Enemigosimple;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Modelo;
import java.net.MalformedURLException;
import java.net.URL;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer {

    private Scene escena; //Para controlar los eventos del teclado y para el cambio de nivel.
    private GraphicsContext lapiz;

    private Modelo model;
    private Personaje ninja;
    private Image fondo;
    private Image fondo2;
    private Image fondo3;
    private Image esqueletoim;
    private Enemigosimple esqueleto;
    private Enemigosimple minotauro;
    private Enemigosimple hongo;
    private Enemigosimple minotauro2;
    private Image cepamala;
    private Image ninjaImD;
    private Image ninjaImDN;
    private Image ninjaImI;
    private Image ninjaImIN;
    private Image ghost1;
    private Image ghost2;
    private Image minota1;
    private Image minota2;
    private Image hongoim;
    private Image candyIm;
    private boolean comprobacion = false;
    private boolean comprobacion2 = false;
    private boolean comprobacion3 = false;
    private boolean comprobacion4 = false;
    private int secuencia = 0;
    private int secuencia2 = 0;
    private int secuencia3 = 0;
    private int numero;
    private int tiempovida = 0;
    private int vidas = 5;
    private int contador = 100;
    private String marca = "RIGHT";
    private ArrayList<String> pulsacionTeclado = null;
    private Image heart;
    private int salto = 0; //Indicador del salto
    private boolean pausa = false; //Indicador de pausa
    private int debounceP = 0; //Antirrebote para la pausa
    private int ghostX = 0;
    private int secuenciaGhost = 0;
    private int secuenciaGhost2 = 0;
    private boolean ghostP = false;
    private int puntaje = 0;
    private ArrayList<Enemigosimple> bombas;
    private ArrayList<Shape> sBombas;
    private ArrayList<Enemigosimple> Candy;
    private ArrayList<Shape> sCandy;
    public LoopJuego(Scene escena, GraphicsContext lapiz, Modelo modelo) {

        this.lapiz = lapiz;
        this.escena = escena;
        this.ninja = new Personaje(0.0, 420.0, 40, 52, 0);//ubicación del ninjaImI
        this.esqueleto = new Enemigosimple(720, 478, 45, 57);//ubicacion del esqueleto
        this.minotauro = new Enemigosimple(720, 450, 97, 46);//ubicacion del minotauro
        this.minotauro2 = new Enemigosimple(500, 450, 97, 46);//ubicacion del minotauro2
        this.hongo = new Enemigosimple(720, 478, 16, 16);//ubicacion del hongo
        this.heart = new Image("Images/heart.png");
        this.fondo = new Image("Images/CITY_MEGA sin fondo.png");
        this.fondo2 = new Image("Images/Nivel2.png");
        this.fondo3 = new Image("Images/Nivel3.png");
        this.ninjaImD = new Image("Images/rogue spritesheet calciumtrice.png");
        this.ninjaImDN = new Image("Images/rogue spritesheet calciumtrice negativo.png");
        this.ninjaImI = new Image("Images/rogue spritesheet calciumtrice IZ.png");
        this.ninjaImIN = new Image("Images/rogue spritesheet calciumtrice IZnegativo.png");
        this.esqueletoim = new Image("Images/rpgcritter update formatted transparent.png");
        this.cepamala = new Image("Images/rpgcritter update formatted transparent.png");
        this.hongoim = new Image("Images/rpgcritter update formatted transparent.png");
        this.minota1 = new Image("Images/minotaurus_spritesheet_lava.png");
        this.minota2 = new Image("Images/minotaurus_spritesheet_lava IZQUIERDA sinfondo.png");
        this.ghost1 = new Image("Images/ghostDer.png");
        this.ghost2 = new Image("Images/ghostIzq.png");
        this.candyIm = new Image("Images/candy.png");
        pulsacionTeclado = new ArrayList<>();
        this.bombas = new ArrayList<>();
        this.sBombas = new ArrayList<>();
        this.sCandy = new ArrayList<>();
        this.Candy = new ArrayList<>();

        escena.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                if (!pulsacionTeclado.contains(code)) {
                    pulsacionTeclado.add(code);
                }
            }
        });

        escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                pulsacionTeclado.remove(code);
            }
        });

    }

    @Override
    public void handle(long now) {
        
        if (pulsacionTeclado.contains("P") && debounceP == 0) { //oprimir P para pausar
            pausa = !pausa;
            debounceP = 15;
        }
        if (vidas < 0) {
            VentanafinalController controlador = new VentanafinalController(model);
            controlador.mostrarVista();
            String score = String.valueOf(puntaje);
            controlador.setScore(score);
            vidas = 5;
        } else if (!pausa) {
            lapiz.clearRect(0, 0, 1800, 520);

            if (this.numero % 10 == 0) {
                if (this.secuencia == 9) {
                    this.secuencia = 0;
                } else {
                    this.secuencia++;
                }
            }

            if (this.numero % 10 == 0) {
                if (this.secuencia2 == 2) {
                    this.secuencia2 = 0;
                } else {
                    this.secuencia2++;
                }
            }

            if (this.numero % 10 == 0) {
                if (this.secuencia3 == 3) {
                    this.secuencia3 = 0;
                } else {
                    this.secuencia3++;
                }
            }

            //shape del personaje
            Shape sNinja = new Rectangle(ninja.getXref() + 5, ninja.getYref(), ninja.getAncho() - 10, ninja.getAlto());
            Shape sEsqueleto = new Rectangle(esqueleto.getXref(), esqueleto.getYref(), 23, 38);
            Shape sMinotauro = new Rectangle(minotauro.getXref() + 25, minotauro.getYref() + 10, 28, 35);
            Shape sHongo = new Rectangle(hongo.getXref(), hongo.getYref(), 25, 25);
            Shape sMinotauro2 = new Rectangle(minotauro2.getXref() + 25, minotauro2.getYref() + 10, 28, 35);
            
            //permite hacer que el escenario vaya moviendose en la ubicación 
            //*********************************ESCENA 1************************
            if (ninja.getxAbs() < 796) {
                if (ninja.getxAbs() == 794) {
                    ninja.setrefX(760);
                }
                Shape h1 = new Rectangle(180, 491, 22, 22);
                Shape h2 = new Rectangle(480, 491, 22, 22);
                Shape pared = new Rectangle(-20, 0, 2, 500);
                Shape pared2 = new Rectangle(804, 0, 2, 500);
                Shape inter = SVGPath.intersect(sHongo, sNinja);
                Shape intert = SVGPath.intersect(sHongo, pared);
                Shape intert2 = SVGPath.intersect(sHongo, pared2);
                Shape interh1 = SVGPath.intersect(sNinja, h1);
                Shape interh2 = SVGPath.intersect(sNinja, h2);
                lapiz.drawImage(fondo, 43, 2400, 696, 320, 0, 0, 796, 520);
                lapiz.drawImage(fondo, 43, 2068, 696, 268, 0, 89, 796, 438);
                lapiz.drawImage(fondo, 43, 1621, 696, 235, 0, 204, 796, 330);

                Shape interseccion = SVGPath.intersect(sNinja, pared);
                Shape interseccion2 = SVGPath.intersect(sNinja, pared2);
                if (interseccion.getBoundsInLocal().getWidth() != -1) {
                    ninja.setrefX(-22);
                    ninja.setxAbs(-20);
                }
                
                ////////////hongos que no se mueven de posiscion/////////////
                lapiz.drawImage(cepamala, 128 + 16*secuencia2 ,130, 16, 16, 480, 491, 22 ,22);
                lapiz.drawImage(cepamala, 128 + 16*secuencia2 ,130, 16, 16, 180, 491, 22 ,22);
                
                //////////movimiento del hongo fantasma/////////////
                if (!comprobacion3) {
                    hongo.moverizquierda();
                    lapiz.drawImage(hongoim, 16 * this.secuencia2, 32, 16, 16, hongo.getXref(), hongo.getYref(), 25, 25);//animacion hongo
                    if (intert.getBoundsInLocal().getWidth() != -1) {
                        comprobacion3 = true;
                    }
                } else {
                    hongo.moverderecha();
                    lapiz.drawImage(hongoim, 16 * this.secuencia2, 48, 16, 16, hongo.getXref(), hongo.getYref(), 25, 25);
                    if (intert2.getBoundsInLocal().getWidth() != -1) {
                        comprobacion3 = false;
                    }
                }

                if (inter.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con el hongofantasma");
                    vidas--;
                    tiempovida = 50;
                }
                
                if (interh1.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con un minihongo");
                    vidas--;
                    tiempovida = 50;
                }
                
                if (interh2.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con un minihongo");
                    vidas--;
                    tiempovida = 50;
                }
                //Activar pared2 escenario 
                if (puntaje < 1000) {
                    if (interseccion2.getBoundsInLocal().getWidth() != -1) {
                        ninja.setrefX(764);
                        ninja.setxAbs(762);
                    }
                }
                //*******************Escena 2**************************
            } else if (ninja.getxAbs() >= 796 && ninja.getxAbs() < 1592) {
                if (ninja.getxAbs() == 796) {//796
                    ninja.setrefX(0);//0
                }
                Shape pared = new Rectangle(4, 0, 2, 500);
                Shape pared2 = new Rectangle(804, 0, 4, 500);
                Shape h1 = new Rectangle(180, 491, 22, 22);
                Shape h2 = new Rectangle(480, 491, 22, 22);
                Shape h3 = new Rectangle(720, 491, 22, 22);
                Shape interseccion = SVGPath.intersect(sNinja, pared);
                Shape interseccion2 = SVGPath.intersect(sNinja, pared2);
                Shape interseccionEsqueleto1 = SVGPath.intersect(sEsqueleto, pared);
                Shape interseccionEsqueleto2 = SVGPath.intersect(sEsqueleto, pared2);
                Shape interh1 = SVGPath.intersect(sNinja, h1);
                Shape interh2 = SVGPath.intersect(sNinja, h2);
                Shape interh3 = SVGPath.intersect(sNinja, h3);
                Shape inter = SVGPath.intersect(sNinja, sEsqueleto);

                lapiz.drawImage(fondo2, 0, 0, 769, 286, 0, 0, 796, 520);
                
                ////////////hongos que no se mueven de posiscion/////////////
                lapiz.drawImage(cepamala, 128 + 16*secuencia2 ,130, 16, 16, 480, 491, 22 ,22);
                lapiz.drawImage(cepamala, 128 + 16*secuencia2 ,130, 16, 16, 180, 491, 22 ,22);
                lapiz.drawImage(cepamala, 128 + 16*secuencia2 ,130, 16, 16, 720, 491, 22 ,22);

                //paredes escenario 2
                if (interseccion.getBoundsInLocal().getWidth() != -1) {
                    ninja.setrefX(2);
                    ninja.setxAbs(798);
                }
                if (puntaje >= 1000 && puntaje < 2000) {
                    if (interseccion2.getBoundsInLocal().getWidth() != -1) {
                        ninja.setrefX(764);
                        ninja.setxAbs(1562);
                        System.out.println(interseccion2.getBoundsInLocal().getWidth());

                    }
                }

                if (!comprobacion) {
                    esqueleto.moverizquierda();
                    lapiz.drawImage(esqueletoim, 96 + 16 * this.secuencia2, 111, 16, 17, esqueleto.getXref(), esqueleto.getYref(), 26, 27);//animacion esqueleto
                    if (interseccionEsqueleto1.getBoundsInLocal().getWidth() != -1) {
                        comprobacion = true;
                    }
                } else {
                    esqueleto.moverderecha();
                    lapiz.drawImage(esqueletoim, 96 + 16 * this.secuencia2, 79, 16, 17, esqueleto.getXref(), esqueleto.getYref(), 26, 27);
                    if (interseccionEsqueleto2.getBoundsInLocal().getWidth() != -1) {
                        comprobacion = false;
                    }
                }
                if (inter.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con el esqueleto");
                    vidas--;
                    tiempovida = 50;
                }
                
                if (interh1.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con un minihongo");
                    vidas--;
                    tiempovida = 50;
                }
                
                if (interh2.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con un minihongo");
                    vidas--;
                    tiempovida = 50;
                }
                
                if (interh3.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con un minihongo");
                    vidas--;
                    tiempovida = 50;
                }
                
                //*******************Escena 3******************
            } else if (ninja.getxAbs() >= 1592 && ninja.getxAbs() < 2388) {
                if (ninja.getxAbs() == 1592) {
                    ninja.setrefX(0);
                }

                Shape pared = new Rectangle(4, 0, 2, 500);
                Shape pared2 = new Rectangle(804, 0, 2, 500);

                Shape h1 = new Rectangle(180, 491, 22, 22);
                Shape h2 = new Rectangle(680, 491, 22, 22);
                Shape interseccion = SVGPath.intersect(sNinja, pared);
                Shape interseccion2 = SVGPath.intersect(sNinja, pared2);
                Shape interse = SVGPath.intersect(sMinotauro, pared);
                Shape interse2 = SVGPath.intersect(sMinotauro, pared2);
                Shape intersemin = SVGPath.intersect(sMinotauro2, pared);
                Shape intersemin2 = SVGPath.intersect(sMinotauro2, pared2);
                Shape interh1 = SVGPath.intersect(sNinja, h1);
                Shape interh2 = SVGPath.intersect(sNinja, h2);
                Shape intersecmin = SVGPath.intersect(sNinja, sMinotauro);
                Shape intersecmin2 = SVGPath.intersect(sNinja, sMinotauro2);

                lapiz.drawImage(fondo3, 0, 0, 492, 233, 0, 0, 796, 520);
                
                ////////////hongos que no se mueven de posiscion/////////////
                lapiz.drawImage(cepamala, 128 + 16*secuencia2 ,130, 16, 16, 680, 491, 22 ,22);
                lapiz.drawImage(cepamala, 128 + 16*secuencia2 ,130, 16, 16, 180, 491, 22 ,22);
                
                //////movimientos minotauro 1////////7
                if (!comprobacion2) {
                    minotauro.moverizquierda();
                    lapiz.drawImage(minota2, 92 + 97 * this.secuencia3, 124, 97, 46, minotauro.getXref(), minotauro.getYref(), 107, 52);//animacion esqueleto
                    if (interse.getBoundsInLocal().getWidth() != -1) {
                        comprobacion2 = true;
                    }
                } else {
                    minotauro.moverderecha();
                    lapiz.drawImage(minota1, 97 * this.secuencia3, 124, 97, 46, minotauro.getXref(), minotauro.getYref(), 107, 52);
                    if (interse2.getBoundsInLocal().getWidth() != -1) {
                        comprobacion2 = false;
                    }
                }
                
                /////////movimientos minotaruo 2////////////
                if (!comprobacion4) {
                    minotauro2.moverderecha();
                    lapiz.drawImage(minota1, 97 * this.secuencia3, 124, 97, 46, minotauro2.getXref(), minotauro2.getYref(), 107, 52);//animacion esqueleto
                    if (intersemin2.getBoundsInLocal().getWidth() != -1) {
                        comprobacion4 = true;
                    }
                } else {
                    minotauro2.moverizquierda();
                    lapiz.drawImage(minota2, 92+97 * this.secuencia3, 124, 97, 46, minotauro2.getXref(), minotauro2.getYref(), 107, 52);
                    if (intersemin.getBoundsInLocal().getWidth() != -1) {
                        comprobacion4 = false;
                    }
                }
                
                if (intersecmin.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con el minotauro");
                    vidas--;
                    tiempovida = 50;
                }

                if (intersecmin2.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con el minotauro2");
                    vidas--;
                    tiempovida = 50;
                }
                
                if (interh1.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con un minihongo");
                    vidas--;
                    tiempovida = 50;
                }
                
                if (interh2.getBoundsInLocal().getWidth() != -1 && tiempovida == 0) {
                    System.out.println("Se ha chocado con un minihongo");
                    vidas--;
                    tiempovida = 50;
                }
// paredes escenario 3
                if (interseccion.getBoundsInLocal().getWidth() != -1) {
                    ninja.setrefX(2);
                    ninja.setxAbs(1598);
                }
                
            }
            
            //movimiento de "gravedad"
            ninja.moverAbajo();
            
            //Obstaculos(programados)
            Shape sObstaculo = new Rectangle(100, 100, 20, 20);
            Shape bObstaculo = new Rectangle(0, 503, 1800, 20);
            //Calculando la Interseccion
            Shape interseccion = SVGPath.intersect(sNinja, bObstaculo);

            if (interseccion.getBoundsInLocal().getWidth() != -1) {
                ninja.setrefY(455);
            }

            //*************************Ghost******************************
            if (ghostX < ninja.getXref()) {
                lapiz.drawImage(ghost1, 32 * this.secuenciaGhost, 64, 32, 32, ghostX, 20, 52, 52);
                ghostX++;
                ghostP = false;
            }
            if (ghostX > ninja.getXref()) {
                lapiz.drawImage(ghost2, 32 * (this.secuenciaGhost + 5), 64, 32, 32, ghostX, 20, 52, 52);
                ghostX--;
                ghostP = true;
            }
            if (ghostX == ninja.getXref()) {
                if (ghostP) {
                    lapiz.drawImage(ghost2, 32 * (this.secuenciaGhost + 5), 64, 32, 32, ghostX, 20, 52, 52);
                }else{
                    lapiz.drawImage(ghost1, 32 * this.secuenciaGhost, 64, 32, 32, ghostX, 20, 52, 52);
                }
            }
            if (this.numero % 200 == 0) {
                Enemigosimple bomba = new Enemigosimple(ghostX, 20, 26, 27);
                this.bombas.add(bomba);
                Shape sBomba = new Rectangle(ghostX,20,26,27);
                this.sBombas.add(sBomba);
            }
            if (this.numero % 200 == 0) {
                Enemigosimple Candy = new Enemigosimple(ghostX+10, 20, 30, 27);
                this.Candy.add(Candy);
                Shape sCandy = new Rectangle(ghostX+10,20,26,27);
                this.sCandy.add(sCandy);
            }
            
               
            
            for (int i = 0; i < this.bombas.size(); i++) {
                this.bombas.get(i).setYref(this.bombas.get(i).getYref()+1);
                Shape sBomba = new Rectangle(this.bombas.get(i).getXref(),this.bombas.get(i).getYref(),26,27);
                this.sBombas.set(i, sBomba);
                Shape interEsquelet = SVGPath.intersect(sNinja, this.sBombas.get(i));
                lapiz.drawImage(esqueletoim, 191.5 + (16 * this.secuencia2), 3, 16.3, 23, this.bombas.get(i).getXref(), this.bombas.get(i).getYref(), 26.3, 33);
                if ((interEsquelet.getBoundsInLocal().getWidth() != -1)&&(tiempovida==0)) {
                    System.out.println("lo toco un esqueleto del cielo");
                    vidas--;
                    tiempovida = 50;
                    if (this.bombas.get(i).getYref()>600) {
                    this.bombas.remove(i);
                    this.sBombas.remove(i);
                }
                }
            }
                for (int i = 0; i < this.Candy.size(); i++) {
                this.Candy.get(i).setYref(this.Candy.get(i).getYref()+1);
                Shape sCandy = new Rectangle(this.Candy.get(i).getXref()+30,this.Candy.get(i).getYref(),30,27);
                this.sCandy.set(i, sCandy);
                Shape interCandy = SVGPath.intersect(sNinja, this.sCandy.get(i));
                lapiz.drawImage(candyIm, 32 +  175* this.secuencia2, 226, 130, 113, this.Candy.get(i).getXref()+30, this.Candy.get(i).getYref(), 30, 27);
                if ((interCandy.getBoundsInLocal().getWidth() != -1)) {
                    System.out.println("lo toco un dulce milagroso");
                    puntaje = puntaje +50;
                    this.Candy.remove(i);
                    this.sCandy.remove(i);
                }
                
                
            
            }
            //******************************Acciones de teclado***********************************
            if (marca == "RIGHT") {
                lapiz.drawImage(ninjaImD, 32 * this.secuencia, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
            } else if (marca == "LEFT") {
                lapiz.drawImage(ninjaImI, 32 * this.secuencia, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
            }

            if (pulsacionTeclado.contains("LEFT")) {
                //
                marca = "LEFT";
                ninja.setxAbs(ninja.getxAbs() - 2);
                ninja.moverIzquierda();
                lapiz.drawImage(ninjaImI, 32 * this.secuencia, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
            } else if (pulsacionTeclado.contains("RIGHT")) {
                marca = "RIGHT";
                ninja.setxAbs(ninja.getxAbs() + 2);
                ninja.moverDerecha();
                lapiz.drawImage(ninjaImD, 32 * this.secuencia, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
            } else if (pulsacionTeclado.contains("DOWN")) {
                ninja.moverAbajo();
            }

            if (salto > 0) {
                ninja.saltarmoviendose();
                if (marca == "RIGHT") {
                    lapiz.drawImage(ninjaImD, 32, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
                } else if (marca == "LEFT") {
                    lapiz.drawImage(ninjaImI, 32, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
                }
                this.salto--;
            }
            if ((pulsacionTeclado.contains("SPACE")) && (ninja.getYref() == 455.0)) {
                salto = 20;
            }

            if (tiempovida > 0) {
                tiempovida--;
                //************************Animaciones en negativo***********************************   
                if (marca == "RIGHT") {
                    lapiz.drawImage(ninjaImDN, 32 * this.secuencia, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
                } else if (marca == "LEFT") {
                    lapiz.drawImage(ninjaImIN, 32 * this.secuencia, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
                }
                if (salto > 0) {
                    ninja.saltarmoviendose();
                    if (marca == "RIGHT") {
                        lapiz.drawImage(ninjaImDN, 32, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
                    } else if (marca == "LEFT") {
                        lapiz.drawImage(ninjaImIN, 32, 64, 32, 32, ninja.getXref(), ninja.getYref(), 52, 52);
                    }
                    this.salto--;
                }
                if ((pulsacionTeclado.contains("SPACE")) && (ninja.getYref() == 455.0)) {
                    salto = 20;
                }
            }

            //imagen de la salud actual
            lapiz.drawImage(heart, 0, 0, 64, 64, 50, 5, 20, 20);
            lapiz.strokeText("= " + vidas, 72, 17);
            
            lapiz.strokeText("Puntaje actual : " + puntaje, 600, 17);

            this.numero++;
        } else {
            lapiz.strokeText("PAUSA, presiona P para continuar", 100, 50);
        }
        if (debounceP > 0) { //Antirrebote para la tecla P
            debounceP--;

        }

    }
}
