package GUI_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUIcomp.MinimalistDesigns;

public class SimSettings
{
	private JFrame frame;
	
	private JPanel panel2 = new JPanel();
	
	private JTextField txtCells;
	private JTextField txtGenQ;
	private JTextField txtDist;
	
	private JCheckBox boxAsynch;
	private JCheckBox boxTaurus;
	
	//Instanced
	private MinimalistDesigns md = new MinimalistDesigns();

	public SimSettings()
	{
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Simulation Settings");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLayout(null);

		makeLabel("Cell Quantity", 10);
		makeLabel("Generations", 50);
		makeLabel("Distance", 90);
		makeLabel("Asynch", 130);
		makeLabel("Taurus", 170);
		
		txtCells = new JTextField();
		md.txtField("hopijf", panel2, txtCells);
		
		panel2.setBounds(0, 0, 400, 200);
	}
	
	private void makeLabel(String text, int y)
	{
		JLabel lbl = new JLabel(text);
		lbl.setBounds(10, y, 150, 40);
		lbl.setBackground(null);
		lbl.setFont(new Font("sansserif", Font.BOLD, 20));
		lbl.setForeground(Color.black);
		frame.getContentPane().add(lbl);
	}
	
	public void setVisible(Point p)
	{
		frame.setVisible(true);
		frame.setLocation(p.x, p.y);
	}
	
	public void Move(Point p)
	{
		
	}
}
