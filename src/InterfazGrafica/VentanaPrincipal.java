package InterfazGrafica;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.Collection;

import javax.swing.JPanel;
import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class VentanaPrincipal extends JFrame
{

	private PanelSur panelSur;
	private PanelNorte panelNorte;
	private PanelEste panelEste;
	private PanelCentro panelCentro;
	Top10 top10 = new Top10();
	Tablero tablero;
	
	
	public VentanaPrincipal(int tamanio, int dificultad, boolean estadoFacil, boolean estadoMedio, boolean estadoDificil) 
	{
		setSize(950, 750);
		setTitle("LightsOut");	
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setResizable(false);
		
		setLayout(new BorderLayout( ) );
		
		panelSur = new PanelSur(this);
		add(panelSur, BorderLayout.SOUTH);
		panelSur.setBackground(Color.WHITE);
		
		panelNorte = new PanelNorte(this, tamanio, estadoFacil, estadoMedio, estadoDificil);
		add(panelNorte, BorderLayout.NORTH);
		panelNorte.setBackground(Color.CYAN);
		
		if (estadoFacil) {
            panelNorte.setBtn("f");
        }
        else if(estadoMedio)
        {
            panelNorte.setBtn("m");
        }
        else 
        {
            panelNorte.setBtn("sdsfd");
        }
		
		panelEste = new PanelEste(this);
		add(panelEste, BorderLayout.EAST);
		panelEste.setBackground(Color.WHITE);
		
		tablero = new Tablero( tamanio );
		
		tablero.desordenar(dificultad);
		panelCentro = new PanelCentro(tablero.darTablero( ));
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setBackground(Color.WHITE);
		
	
	}
	
	
	public static void main(String[]args)
	{
		VentanaPrincipal ventana = new VentanaPrincipal(5,1, true, false, false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}
	
	public void mostrarTop()
    {
		
		try {
			Collection<RegistroTop10> lectura = top10.darRegistros();
	        JOptionPane.showMessageDialog(this, lectura, "Top 10", JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Ha ocurrido un error al cargar los registros.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void nuevoJuego()
	{
		try {
			
				        
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "No se pudo reiniciar", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void cambiarTamanio(int t, int dificultad, boolean estadoFacil, boolean estadoMedio, boolean estadoDificil)
	{
		this.setVisible(false);
		VentanaPrincipal ventana = new VentanaPrincipal(t, dificultad, estadoFacil, estadoMedio, estadoDificil);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
				
	}
	
	public int getTamanioTablero() 
	{
	    return panelNorte.getTamanio();
	}
	
	public int getDificultad() 
	{
	    return panelNorte.getDificultad();
	}
	
	public void cambiarDificultad(int dificultad)
	{
		System.out.println("dificultad cambiada");
		tablero.desordenar(dificultad);
	}
	
	public boolean[] getBtnEstados() 
	{
	return panelNorte.getBtnEstados();	
	}
	
}