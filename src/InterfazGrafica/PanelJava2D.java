package InterfazGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelJava2D extends JPanel implements MouseListener
{
	
	private boolean [][] tablero;
	
	
	public void paint(Graphics g)
	{
		g.drawRect(0,10,50,50);
		g.fillRect(60, 5, 50, 100);
		g.setColor(Color.GREEN);
		
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D.Double rect = new Rectangle2D.Double(10,50,100,160);
		g2d.fill(rect);
		g.setColor(Color.CYAN);
		g2d.draw(rect);
		
		g.setColor(Color.WHITE);
		Ellipse2D.Double circ = new Ellipse2D.Double(10,50,50,50);
		g2d.fill(circ);
		
		int[] xs = {0,10,20,30,0};
		int[] ys = {50,10,40,40,50};
		Polygon pol = new Polygon (xs, ys, 5);
		g2d.fill(pol);
		
		int ancho = getWidth();
		int alto = getHeight();
		
		
		
	}
	
	
	
	public PanelJava2D()
	{
		add(new JLabel("                   "));
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) 
	{
		
		int click_x = e.getX();
		int click_y = e.getY();
		//int[] casilla = convertirCoordenadaACasilla(click_x, click_y);
		//cantidades[casilla[0]]
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
		
}
