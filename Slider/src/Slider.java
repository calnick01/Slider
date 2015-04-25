import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JFrame implements ChangeListener
{
	JPanel sliderPanel = new JPanel(); //SLIDER PLANEL
	JPanel panelLabel = new JPanel(); //LABEL PANEL
	JLabel jlblRed = new JLabel(" Red "); //RED LABEL
	JLabel jlblGreen = new JLabel("Green"); //GREEN LABEL
	JLabel jlblBlue = new JLabel("Blue ");	 //BLUE LABEL
	JLabel labelChange = new JLabel("Show Colors"); //LABEL TO CHANGE COLOR
	JSlider jscbRed = new JSlider(JSlider.HORIZONTAL, 0, 255, 0); //RED SLIDER
	JSlider jscbGreen = new JSlider(JSlider.HORIZONTAL, 0, 255, 0); //GREEN SLIDER
	JSlider jscbBlue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0); //BLUE SLIDER
	int colorRed=0, colorGreen=0, colorBlue=0; //COLOR(INT,INT,INT)
	public Slider() 
	{		
		sliderPanel.setBorder(new CompoundBorder(new TitledBorder("Choose colors"),new EmptyBorder(2, 2, 2, 2))); //TITLED BORDER
		
		jscbRed.addChangeListener(this); //RED ACTION SLIDER
		jscbGreen.addChangeListener(this); //GREEN ACTION SLIDER
		jscbBlue.addChangeListener(this); //BLUE ACTION SLIDER
		
		sliderPanel.add(jlblRed); //RED LABEL ADDED
		sliderPanel.add(jscbRed); //RED SLIDER ADDED
		sliderPanel.add(jlblGreen); //GREEN LABEL ADDED
		sliderPanel.add(jscbGreen); //GREEN SLIDER ADDED
		sliderPanel.add(jlblBlue); //BLUE LABEL ADDED
		sliderPanel.add(jscbBlue); //BLUE SLIDER ADDED
		panelLabel.add(labelChange); //ADDS IT TO PANEL TO CENTER EASIER
		
		add(panelLabel,BorderLayout.NORTH); //PUTS LABEL PANEL TOP
		add(sliderPanel); //PUTS SLIDER PANEL BELOW
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //CLOSE ON EXIT
		setLocationRelativeTo(null); //CENTER
		setVisible(true); //VISIBLE
		setSize(new Dimension(300,200)); //SIZE
		setTitle("Slide Demo"); //TITLE		
	}
	
	public static void main(String[] args)
	{
		Slider scrollBarTest = new Slider();
	}
	
	public void stateChanged(ChangeEvent e) 
	{
		JSlider slider = (JSlider) e.getSource(); //CHANGES ACTION TO SLIDER	
		if (slider==jscbRed) //IF THE ACTION IS RED THEN CHANGES RED VALUE
		{colorRed = (int)slider.getValue();} //CHANGE THE RED VALUE
		if (slider==jscbGreen) //IF THE ACTION IS GREEN THEN CHANGES GREEN VALUE
		{colorGreen = (int)slider.getValue();} //CHANGE THE GREEN VALUE
		if (slider==jscbBlue) //IF THE ACTION IS BLUE THEN CHANGES BLUE VALUE
		{colorBlue = (int)slider.getValue();} //CHANGE THE BLUE VALUE
		Color colTest = new Color(colorRed,colorGreen,colorBlue); //MAKES A COLOR BASED ON ACTION
		labelChange.setForeground(colTest); //SETS THE LABEL AS THE COLOR
		//System.out.println(colorRed+","+colorGreen+","+colorBlue); //TRACING
	}	
}
