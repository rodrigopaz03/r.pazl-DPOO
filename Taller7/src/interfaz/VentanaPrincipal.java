package uniandes.dpoo.taller7.interfaz4;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboTamano;
    private Tablero1 tablero;
    private Tablero tablero1;
    private int contadorJugadas = 0;
    private PanelTexto panelTexto;
    private PanelBotones panelBotones;
    private Top10 top10 = new Top10();
    
    public VentanaPrincipal() {
        setTitle("LightsOut");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        tablero1 = new Tablero(5);
        JPanel panelControl = new PanelControl();
        panelBotones = new PanelBotones(this, top10);
        panelTexto = new PanelTexto();
        ((PanelTexto) panelTexto).setJugadas(contadorJugadas);
        tablero = new Tablero1(tablero1, this);
      
  

        comboTamano = ((PanelControl) panelControl).getComboTamano();
        comboTamano.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newSize = Integer.parseInt(comboTamano.getSelectedItem().toString().split("x")[0]);
                tablero.setBoardSize(newSize);
            }
        });

        add(panelControl, BorderLayout.NORTH);
        add(tablero, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.EAST);
        add(panelTexto, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    public void generarNuevoTablero() {
       
        int newSize = Integer.parseInt(comboTamano.getSelectedItem().toString().split("x")[0]);
        tablero = new Tablero1(tablero1, this);
        getContentPane().remove(tablero); 
        add(tablero, BorderLayout.CENTER); 
        revalidate();
        tablero1.reiniciar();
    }
    
    public void incrementarJugadas() {
        contadorJugadas++;
        ((PanelTexto) panelTexto).setJugadas(contadorJugadas);
    }
    
    public String obtenerDificultadSeleccionada() {
        Container contentPane = getContentPane();
        if (contentPane.getComponentCount() > 0) {
            Component[] components = ((PanelControl) contentPane.getComponent(0)).getComponents();
            for (Component component : components) {
                if (component instanceof JRadioButton) {
                    JRadioButton radioButton = (JRadioButton) component;
                    if (radioButton.isSelected()) {
                        return radioButton.getText();
                    }
                }
            }
        }
        return "Facil";
    }
    
    public void reinciarJugadas() {
        contadorJugadas = 0;
        ((PanelTexto) panelTexto).setJugadas(contadorJugadas);
    }
    
   public void nuevotablero(String dificultad) {
	   int dificul = 10;
	   int tamano = 5;
	   
	   if (dificultad.equals("Fácil")) {
	       dificul = 10;
	    } else if (dificultad.equals("Intermedio")) {
	       dificul = 15;
	    } else {
	       dificul = 20;
	    }
	   String tamanoSeleccionado = (String) comboTamano.getSelectedItem();
	   
	   if (tamanoSeleccionado.equals("5x5")) {
           tamano = 5; 
       } else if (tamanoSeleccionado.equals("6x6")) {
          tamano = 6; 
       } else {tamano = 7;}
	   
	 tablero.nuevoTablero(tamano, dificul);
   }
    
   public PanelTexto getPanelTexto() {
	   return panelTexto;
   }
   
   public String getNombre() {
	   return panelTexto.getNombreJugador();
   }
   
   public void agregarPuntaje(String nombre, int puntaje) {
	 panelBotones.agregarPuntaje(nombre, puntaje);
   }
   
   
    public static void main(String[] args) {
        new VentanaPrincipal();
        
    }
}