package uniandes.dpoo.taller7.interfaz4;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller7.modelo.Top10;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PanelBotones extends JPanel{
	
	private VentanaPrincipal ventana;
	private Map<String, Integer> scoresMap = new HashMap<>();
	private Top10 top10;
	
	public PanelBotones(VentanaPrincipal nventana, Top10 nTop10) {
			this.ventana = nventana;
			this.top10 = nTop10;
		 	setLayout(new GridLayout(4, 1, 5, 5));
	        JButton nuevo = new JButton("NUEVO");
	        JButton reiniciar = new JButton("REINICIAR");
	        JButton top10 = new JButton("TOP-10");
	        JButton cambiarjugador = new JButton("CAMBIAR JUGADOR");
	        
	        Dimension buttonSize = new Dimension(100, 10);
	        nuevo.setSize(buttonSize);
	        reiniciar.setSize(buttonSize);
	        top10.setSize(buttonSize);
	        cambiarjugador.setSize(buttonSize);
	        
	        nuevo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String dificultad = ventana.obtenerDificultadSeleccionada();
					ventana.nuevotablero(dificultad);
					 
					
				}
	        });
	        
	        reiniciar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 
					 ventana.reinciarJugadas();
					
				}
	        });
	        
	        cambiarjugador.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {

	                String nuevoNombre = JOptionPane.showInputDialog("Por favor, ingrese su nombre:");
	                if (nuevoNombre != null && !nuevoNombre.isEmpty()) { 
	                    ventana.getPanelTexto().setNombreJugador(nuevoNombre);
	                    ventana.nuevotablero("Fácil");
	                }
	            }
	        });
	        
	        top10.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                mostrarTop10();
	            }
	        });

	        setLayout(new GridLayout(4, 1, 0, 10));
	        add(nuevo);
	        add(reiniciar);
	        add(top10);
	        add(cambiarjugador);
	    }
	    
	        
	private void mostrarTop10() {
	    List<String> topScores = new ArrayList<>();
	    for (Map.Entry<String, Integer> entry : scoresMap.entrySet()) {
	        String userScore = entry.getKey() + ": " + entry.getValue();
	        topScores.add(userScore);
	    }

	    JList<String> topScoresList = new JList<>(topScores.toArray(new String[0]));
	    topScoresList.setCellRenderer(new ScoreListCellRenderer(scoresMap));

	    JScrollPane scrollPane = new JScrollPane(topScoresList);

	    JDialog dialog = new JDialog(ventana, "Top 10 Puntajes", true);
	    dialog.add(scrollPane);
	    dialog.pack();
	    dialog.setLocationRelativeTo(ventana);
	    dialog.setVisible(true);
	}

	

public void agregarPuntaje(String nombre, int puntaje) {
	
	Integer valor = Integer.valueOf(puntaje);
	top10.agregarRegistro(nombre, puntaje);
	scoresMap.put(nombre, valor);
}

private class ScoreListCellRenderer extends DefaultListCellRenderer {
    private Map<String, Integer> scoresMap;
    
    public ScoreListCellRenderer(Map<String, Integer> scoresMap) {
        this.scoresMap = scoresMap;
    }
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String userScore = (String) value;
        int score = scoresMap.get(userScore);
        int greenIntensity = 255 - (index * 20); 
        Color color = new Color(0, greenIntensity, 0); 
        component.setForeground(color);
        return component;
    }
}
	}


