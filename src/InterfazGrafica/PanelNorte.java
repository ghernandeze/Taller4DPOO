package InterfazGrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelNorte extends JPanel implements ActionListener {
    private JLabel lblRelleno;
    private JLabel lblTamanio;
    private JLabel lblDificultad;
    private VentanaPrincipal principal;
    private JRadioButton facilButton;
    private JRadioButton medioButton;
    private JRadioButton dificilButton;
    private JComboBox<String> lblComboBox;
    private int tamanioTablero;
    private String[] comboBoxOptions = {"5x5", "8x8", "11x11"};
    private int dificultad;
    private boolean eFacil;
    private boolean eMedia;
    private boolean eDificil;
    
    
    public PanelNorte(VentanaPrincipal pPrincipal, int val, boolean estadoFacil, boolean estadoMedio, boolean estadoDificil) 
    {
    	setTamanioTablero(val);
    	
        principal = pPrincipal;

        setLayout(new GridLayout(1, 3));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        lblRelleno = new JLabel(" ");
        add(lblRelleno);

        lblTamanio = new JLabel("Tamaño: ");
        Font font = new Font(lblTamanio.getFont().getName(), Font.BOLD, 18);
        lblTamanio.setFont(font);
        add(lblTamanio);

        lblComboBox = new JComboBox<>(comboBoxOptions);
        lblComboBox.addActionListener(this);
        add(lblComboBox);

        lblRelleno = new JLabel(" ");
        add(lblRelleno);

        lblDificultad = new JLabel("Dificultad: ");
        Font font1 = new Font(lblDificultad.getFont().getName(), Font.BOLD, 18);
        lblDificultad.setFont(font1);
        add(lblDificultad);

        ButtonGroup dificultadGroup = new ButtonGroup(); 

        facilButton = new JRadioButton("Fácil", estadoFacil);
        facilButton.setBackground(Color.CYAN);
        facilButton.addActionListener(this);
        dificultadGroup.add(facilButton); 
        add(facilButton);

        medioButton = new JRadioButton("Medio", estadoMedio);
        medioButton.setBackground(Color.CYAN);
        medioButton.addActionListener(this);
        dificultadGroup.add(medioButton); 
        add(medioButton);

        dificilButton = new JRadioButton("Difícil", estadoDificil);
        dificilButton.setBackground(Color.CYAN);
        dificilButton.addActionListener(this);
        dificultadGroup.add(dificilButton); 
        add(dificilButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == facilButton) 
        {
        	setBtn("difFacil");
        } 
        else if (e.getSource() == medioButton) 
        {
        	setBtn("difMedia");
        } 
        else if (e.getSource() == dificilButton) 
        {
        	setBtn("dificil");
        } 
        else if (e.getSource() == lblComboBox) 
        	{
            String selectedSize = (String) lblComboBox.getSelectedItem();
   
	            
            if (selectedSize.equals("5x5")) 
            {
            	setTamanioTablero(5);
            } 
            else if (selectedSize.equals("8x8")) 
            {
            	setTamanioTablero(8);
            	
            } 
            else if (selectedSize.equals("11x11")) 
            {
            	setTamanioTablero(11);
            	
            }
        }
    }
    
    private void setTamanioTablero(int nuevoValor) 
    {
        tamanioTablero = nuevoValor;
    }
    public int getTamanio() 
    {
        return tamanioTablero;
    }

	public int getDificultad() {
		// TODO Auto-generated method stub
		return dificultad;
	}
	
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
    
	public void setBtn(String btn) 
	{
	    if (btn.equals("difFacil"))
	    {
	        eFacil = true;
	        eMedia = false;
	        eDificil = false;
	        setDificultad(1);
	    }
	    else if (btn.equals("difMedia")) 
	    {
	    	eFacil = false;
	    	eMedia = true;
	    	eDificil = false;
	        setDificultad(3);
	    }
	    else 
	    {
	    	eFacil = false;
	        eMedia = false;
	        eDificil = true;
	        setDificultad(7);
	        
	    }
	}
	
	public boolean[] getBtnEstados() 
	{
	    boolean[] variable = {eFacil,eMedia,eDificil};
	    return variable;
	    }
}
