package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelTexto extends JPanel {
    private JTextField movesField;
    private JTextField playerField;

    public PanelTexto() {
        JLabel movesLabel = new JLabel("Jugadas:");
        movesField = new JTextField("0", 5);
        JLabel playerLabel = new JLabel("Jugador:");
        playerField = new JTextField(10); 
        
        
        String nombreJugador = JOptionPane.showInputDialog("Por favor, ingrese su nombre:");
        if (nombreJugador != null && !nombreJugador.isEmpty()) { // Verificar si el nombre no es nulo ni vacío
            playerField.setText(nombreJugador);
        }

        add(movesLabel);
        add(movesField);
        add(playerLabel);
        add(playerField);
    }

    public void setJugadas(int jugadas) {
        movesField.setText(String.valueOf(jugadas));
    }

    public String getNombreJugador() {
        return playerField.getText();
    }

    public void setNombreJugador(String nombre) {
        playerField.setText(nombre);
    }
}