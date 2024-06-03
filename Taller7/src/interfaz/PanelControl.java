package uniandes.dpoo.taller7.interfaz4;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import javax.swing.*;

public class PanelControl extends JPanel {
    private JComboBox<String> comboTamano;

    public PanelControl() {
       
        JLabel labelTamano = new JLabel("Tamaño");
        comboTamano = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        JLabel labelDificultad = new JLabel("Dificultad");
        JRadioButton rbFacil = new JRadioButton("Fácil");
        JRadioButton rbMedio = new JRadioButton("Medio");
        JRadioButton rbDificil = new JRadioButton("Difícil");

       
        ButtonGroup bgDificultad = new ButtonGroup();
        bgDificultad.add(rbFacil);
        bgDificultad.add(rbMedio);
        bgDificultad.add(rbDificil);

        add(labelTamano);
        add(comboTamano);
        add(labelDificultad);
        add(rbFacil);
        add(rbMedio);
        add(rbDificil);
    }

    public JComboBox<String> getComboTamano() {
        return comboTamano;
    }
}
