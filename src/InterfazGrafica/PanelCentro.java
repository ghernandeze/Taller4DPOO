package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.awt.event.MouseListener;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.modelo.RegistroTop10;


public class PanelCentro extends JPanel implements MouseListener
{
    private VentanaPrincipal principal;
    private boolean[][] tablero;
    private int ultima_fila;
    private int ultima_columna;
    private Tablero modelo;

    public PanelCentro(boolean[][] tableroP, Tablero modelo, VentanaPrincipal principal )
    {
        tablero = tableroP;
        add(new JLabel("                                   "));
        addMouseListener(this);
        this.modelo = modelo;
        this.principal = principal;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int ancho = getWidth();
        int alto = getHeight();
        int anchoRect = ancho / tablero.length;
        int altoRect = alto / tablero.length;
        for (int i = 0; i < tablero.length; i++)
        {
            for (int j = 0; j < tablero.length; j++)
            {
                Rectangle2D.Double rect = new Rectangle2D.Double(i * anchoRect, j * altoRect, anchoRect, altoRect);
                if (tablero[j][i]== true)
                {
                    g.setColor(Color.YELLOW);
                }
                else
                {
                    g.setColor(Color.GRAY);
                }
                g2d.fill(rect);
                g.setColor(Color.BLACK);
                g2d.draw(rect);
            }
        }
    }

    public void mousePressed(MouseEvent e)
    {
        
    	int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        modelo.jugar(casilla[0], casilla[1]);
        int jugadas = modelo.darJugadas();
        principal.setJugadas(jugadas);
        repaint();
        boolean ganar = modelo.tableroIluminado();
        if (ganar == true)
        	{
        	principal.ganador();
        	};
    }

    private int[] convertirCoordenadasACasilla(int x, int y)
    {
        int ladoTablero = tablero.length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }
   
    public boolean[][] getTablero()
    {
    	return tablero;
    }
    
    public boolean[][] reiniciarCentro(boolean[][] pantalla)
    {
    	tablero = pantalla;
    	return tablero;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        
    }
}