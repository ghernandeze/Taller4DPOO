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
	private Tablero tablero;
	
	
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
            panelNorte.setBtn("difFacil");
        }
        else if(estadoMedio)
        {
            panelNorte.setBtn("difMedia");
        }
        else 
        {
            panelNorte.setBtn("defDiff");
        }
		
		panelEste = new PanelEste(this);
		add(panelEste, BorderLayout.EAST);
		panelEste.setBackground(Color.WHITE);
		
		tablero = new Tablero( tamanio );
		
		tablero.desordenar(dificultad);
		panelCentro = new PanelCentro(tablero.darTablero( ), tablero, this);
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setBackground(Color.WHITE);
		
	}
	
	public static void main(String[]args)
	{
		VentanaPrincipal ventana = new VentanaPrincipal(5,3, true, false, false);
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
	
	public void reiniciar()
    {
		
		try 
		{
			tablero.reiniciar();
		    boolean[][] pantalla = panelCentro.reiniciarCentro(panelCentro.getTablero());
		    panelCentro.setVisible(false);
		    panelCentro = new PanelCentro(pantalla,tablero,this);
		    cambiarValor(0);
		    this.add(panelCentro,BorderLayout.CENTER);
			
	    } 
		catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Error reiniciando el programa.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void cambiarValor(int valor) 
	{
	    panelSur.cambiarJugadas(Integer.toString(valor));
	}
	
	public void cambiarTamanio(int t, int dificultad, boolean estadoFacil, boolean estadoMedio, boolean estadoDificil)
	{
		this.setVisible(false);
		VentanaPrincipal ventana = new VentanaPrincipal(t, dificultad, estadoFacil, estadoMedio, estadoDificil);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
				
	}
	
	public void ganador()
	{
		JOptionPane.showMessageDialog(this, "GANASTE SUUUUUUUUU", "LightsOut", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int getTamanioTablero() 
	{
	    return panelNorte.getTamanio();
	}
	
	public int getDificultad() 
	{
	    return panelNorte.getDificultad();
	}
		
	public boolean[] getBtnEstados() 
	{
	return panelNorte.getBtnEstados();	
	}
	
	public PanelCentro getPanelCentro()
    {
    	return panelCentro;
    }
	
	public int getJugadas()
	{
		return tablero.darJugadas();
	}
	
	public void setJugadas(int jugadas)
	{
		String stringRespuesta = Integer.toString(jugadas); 
		panelSur.setJugadas(stringRespuesta);
		
	}
		
	public void setNombre(String nombre)
	{
		panelSur.setNombre(nombre);
	}
}