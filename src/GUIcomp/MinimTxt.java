package GUIcomp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class MinimTxt
{
	public void txtBuilder(JTextField txt, String name)
	{
		txt.setFont(new Font("sansserif", Font.PLAIN, 30));
		txt.setText(name);
		txt.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 0, Color.black));
	}
}
