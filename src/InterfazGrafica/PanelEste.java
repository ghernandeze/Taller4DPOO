package InterfazGrafica;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelEste extends JPanel implements ActionListener 
{
	private VentanaPrincipal principal;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarJugador;
	private JLabel lblRelleno;
	
    public PanelEste(VentanaPrincipal pPrincipal) 
    {
    	principal = pPrincipal;
    	
    	
    	setLayout(new GridLayout( 9, 10, 10, 10 ));
    	      
    	lblRelleno = new JLabel(" ");
        add(lblRelleno);
    	
    	btnNuevo= new JButton( "NUEVO JUEGO" );
        add(btnNuevo);
        btnNuevo.setBackground( Color.DARK_GRAY );
        btnNuevo.setForeground( Color.WHITE );
        btnNuevo.setSize(4,3);
         
        lblRelleno = new JLabel(" ");
        add(lblRelleno);
        
        btnReiniciar= new JButton( "REINICIAR JUEGO" );
        add(btnReiniciar);
        btnReiniciar.setBackground( Color.DARK_GRAY );
        btnReiniciar.setForeground( Color.WHITE );
         
        lblRelleno = new JLabel(" ");
        add(lblRelleno);
        
        btnTop10= new JButton( "TOP 10" );
        add(btnTop10);
        btnTop10.setBackground( Color.DARK_GRAY );
        btnTop10.setForeground( Color.WHITE );
        
        lblRelleno = new JLabel(" ");
        add(lblRelleno);
        
        btnCambiarJugador= new JButton( "CAMBIAR JUGADOR");
        add(btnCambiarJugador);
        btnCambiarJugador.setBackground( Color.DARK_GRAY );
        btnCambiarJugador.setForeground( Color.WHITE );
        
        lblRelleno = new JLabel(" ");
        add(lblRelleno);        
        
        btnNuevo.addActionListener( this );
        btnNuevo.setActionCommand( "Nuevo" );
        
        btnReiniciar.addActionListener( this );
        btnReiniciar.setActionCommand( "Reiniciar" );
        
        btnTop10.addActionListener( this );
        btnTop10.setActionCommand( "Top" );
        
        btnCambiarJugador.addActionListener( this );
        btnCambiarJugador.setActionCommand( "Cambiar" );
        
            	
    }

    
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
        if(e.getActionCommand( ).equals( "Top" ))
        {
            principal.mostrarTop( );
        }
        else if (e.getActionCommand( ).equals( "Nuevo" ))
        {
        	int val = principal.getTamanioTablero();
            int dificultad = principal.getDificultad();
            boolean[] estados = principal.getBtnEstados();
        	principal.cambiarTamanio(val, dificultad, estados[0],estados[1],estados[2]);
            
        }
        else if (e.getActionCommand( ).equals( "Reiniciar" ))
        {
        	System.out.println("a");
        }
		
		  else if (e.getActionCommand( ).equals( "Cambiar" ))
	      {
	          JOptionPane.showMessageDialog( principal, "Que jugador " );
	      }
		
	}
        
	
	
}