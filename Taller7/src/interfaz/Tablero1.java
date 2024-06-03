package uniandes.dpoo.taller7.interfaz4;


import javax.swing.*;

import uniandes.dpoo.taller7.modelo.Tablero;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;
import java.awt.*;

public class Tablero1 extends JPanel {

    private Tablero tablero;
    private VentanaPrincipal ventana;

    public Tablero1(Tablero tablero, VentanaPrincipal nventana) {
        this.tablero = tablero;
        setPreferredSize(new Dimension(400, 400)); 
        this.ventana = nventana;
        tablero.desordenar(10);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int tamanoCelda = getWidth() / tablero.obtenerTamano(); 
                int fila = e.getY() / tamanoCelda;
                int columna = e.getX() / tamanoCelda;

                
                if (fila >= 0 && fila < tablero.obtenerTamano() && columna >= 0 && columna < tablero.obtenerTamano()) {
                    tablero.jugar(fila, columna);
                    ventana.incrementarJugadas();
                    repaint();
                }

                if (tablero.tableroIluminado()) {
                	int puntaje = tablero.calcularPuntaje();
                	String nombre = ventana.getNombre();
                	ventana.agregarPuntaje(nombre, puntaje);
                    JOptionPane.showMessageDialog(ventana, "¡Felicidades! Has ganado el juego.");
                }
            }
        });
    
    
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        boolean[][] estadoTablero = tablero.darTablero();
        int tamanoCelda = getWidth() / tablero.obtenerTamano();

        
        for (int i = 0; i < estadoTablero.length; i++) {
            for (int j = 0; j < estadoTablero[i].length; j++) {
                if (estadoTablero[i][j]) {
                    g2d.setColor(Color.YELLOW);
                } else {
                    g2d.setColor(Color.BLACK);
                }
                int x = j * tamanoCelda;
                int y = i * tamanoCelda;
                g2d.fillRect(x, y, tamanoCelda, tamanoCelda);
                g2d.setColor(Color.GRAY);
                g2d.drawRect(x, y, tamanoCelda, tamanoCelda);
            }
        }
    }



    
    public void reiniciarTablero() {
        tablero.reiniciar();
        repaint();
    }

    
    public void nuevoTablero(int tamano, int dificultad) {
        tablero = new Tablero(tamano);
        ventana.reinciarJugadas();
        tablero.desordenar(dificultad);
        repaint();
        
        for(MouseListener listener : getMouseListeners()) {
            removeMouseListener(listener);}
            
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int tamanoCelda = getWidth() / tablero.obtenerTamano(); // Tamaño de la celda en píxeles
                int fila = e.getY() / tamanoCelda;
                int columna = e.getX() / tamanoCelda;

                
                if (fila >= 0 && fila < tablero.obtenerTamano() && columna >= 0 && columna < tablero.obtenerTamano()) {
                    tablero.jugar(fila, columna);
                    ventana.incrementarJugadas();
                    repaint();
                }

                if (tablero.tableroIluminado()) {
                	int puntaje = tablero.calcularPuntaje();
                	String nombre = ventana.getNombre();
                	ventana.agregarPuntaje(nombre, puntaje);
                    JOptionPane.showMessageDialog(ventana, "¡Felicidades! Has ganado el juego.");
                }
            }
        });
    }
    
    public void setBoardSize(int newSize) {
        tablero = new Tablero(newSize); 
        repaint(); 
    }
}