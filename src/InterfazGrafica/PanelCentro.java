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

    public PanelCentro(boolean[][] tableroP)
    {
        tablero = tableroP;
        add(new JLabel("                                   "));
        addMouseListener(this);
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
        cambiarColorYVecinos(casilla[0], casilla[1]);
        repaint();
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

    private void cambiarColorYVecinos(int fila, int columna)
    {
        tablero[fila][columna] = !tablero[fila][columna];
        int[] filasVecinas = {fila - 1, fila + 1};
        int[] columnasVecinas = {columna - 1, columna + 1};

        for (int i : filasVecinas)
        {
            if (i >= 0 && i < tablero.length)
            {
                tablero[i][columna] = !tablero[i][columna];
            }
        }

        for (int j : columnasVecinas)
        {
            if (j >= 0 && j < tablero.length)
            {
                tablero[fila][j] = !tablero[fila][j];
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // No necesario en este caso
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // No necesario en este caso
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // No necesario en este caso
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // No necesario en este caso
    }
}