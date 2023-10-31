package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class PanelSur extends JPanel implements ActionListener
{
	
	private JLabel lblJugadas;
	private JLabel lblRelleno;
	private JLabel lblJugador;
	private JLabel lblNombreJugador;
	private VentanaPrincipal principal;
	private JLabel labelContador;
	private int contadorClics = 0;
	
	public PanelSur(VentanaPrincipal pPrincipal)
	{
		
		principal = pPrincipal;
		
		setLayout (new GridLayout ( 1, 3 )); 
		setBorder (new EmptyBorder(20, 20, 20, 20) );
		
		lblJugadas= new JLabel("Jugadas:");
		Font font = new Font(lblJugadas.getFont().getName(), Font.BOLD, 18); 
		lblJugadas.setFont(font);
		add(lblJugadas);
			
		labelContador = new JLabel("" + contadorClics);
        Font font2 = new Font(labelContador.getFont().getName(), Font.BOLD, 18);
        labelContador.setFont(font2);
        add(labelContador);

        addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                contadorClics++;
                labelContador.setText("" + contadorClics);
            }
        }
        );
		    
		
		lblJugador= new JLabel("Jugador: ");
		Font font1 = new Font(lblJugador.getFont().getName(), Font.BOLD, 18); 
		lblJugador.setFont(font1);
		add(lblJugador);
		
		lblRelleno= new JLabel(" ");
		add(lblRelleno);
        
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}