package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import uniandes.dpoo.taller4.modelo.Tablero; 

public class PanelSur extends JPanel 
{
	
	private JLabel lblJugadas;
	private JLabel lblRelleno;
	private JLabel lblJugador;
	private JLabel lblNombreJugador;
	private VentanaPrincipal principal;
	private JLabel labelContador;
	private int contadorClics = 0;
	private JLabel lblNomJug;
	
	public PanelSur(VentanaPrincipal pPrincipal)
	{
		
		principal = pPrincipal;
		
		setLayout (new GridLayout ( 1, 3 )); 
		setBorder (new EmptyBorder(20, 20, 20, 20) );
		
		lblJugadas= new JLabel("Jugadas:");
		Font font = new Font(lblJugadas.getFont().getName(), Font.BOLD, 18); 
		lblJugadas.setFont(font);
		add(lblJugadas);
			
		labelContador = new JLabel("" );
        Font font2 = new Font(labelContador.getFont().getName(), Font.BOLD, 18);
        labelContador.setFont(font2);
        add(labelContador);
		
		lblJugador= new JLabel("Jugador:");
		Font font1 = new Font(lblJugador.getFont().getName(), Font.BOLD, 18); 
		lblJugador.setFont(font1);
		add(lblJugador);
		
		lblNomJug= new JLabel(" ");
		Font font3 = new Font(lblNomJug.getFont().getName(), Font.BOLD, 18); 
		lblNomJug.setFont(font3);
		add(lblNomJug);
		       
		lblRelleno = new JLabel(" ");
		add(lblRelleno);
	}
	
	public void setJugadas(String jugadas)
	{
		labelContador.setText(jugadas);
		
	}
		
	public void setNombre(String nombre)
	{
		lblNomJug.setText(nombre);
		
	}
	
	public void cambiarJugadas(String valor)
	{
		labelContador.setText(valor);
	}
	
}