package GUIcomp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MinimalistDesigns
{	
	public JPanel txtField(String name, JPanel panel1, JTextField txt1)
	{
		panel1.setLayout(null);
		panel1.setOpaque(false);
		
		JLabel lbl1 = new JLabel();
		lbl1.setFont(new Font("sansserif", Font.PLAIN, 30));
		lbl1.setText(name);
		lbl1.setBounds(10, 5, 190, 40);
		
		
		
		Border rounded = new LineBorder(new Color(0,0,0), 2, true);
		Border empty = new EmptyBorder(0, 3, 0, 0);
		Border border = new CompoundBorder(rounded, empty);
		
		
		
		txt1.setFont(new Font("sansserif", Font.PLAIN, 25));
		//txt1.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 0, Color.black));
		txt1.setBounds(200, 5, 150, 40);
		txt1.setOpaque(false);
		txt1.setBorder(border);
		txt1.setMargin(new Insets(0, 10, 0, 0));
		
		panel1.add(lbl1);
		panel1.add(txt1);
		
		return panel1;
	}
	
	public JPanel comboField(String name, JPanel panel, JCheckBox box, boolean isSelected)
	{
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JLabel lbl1 = new JLabel();
		lbl1.setFont(new Font("sansserif", Font.PLAIN, 30));
		lbl1.setText(name);
		lbl1.setBounds(10, 5, 190, 40);
		
		box.setSelected(isSelected);
		box.setIcon(new ImageIcon("res\\unSelected.png"));
		box.setSelectedIcon(new ImageIcon("res\\selected.png"));
		box.setBounds(205,0,200,50);
		box.setOpaque(false);
		box.setText("");
		box.setFocusable(false);
		
		panel.add(lbl1);
		panel.add(box);
		
		return panel;
	}
}
