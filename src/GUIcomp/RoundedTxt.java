package GUIcomp;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundedTxt extends JTextField
{
	private Shape shape;
	private int radius = 15;

	public RoundedTxt(int size, int radius)
	{
		this.radius = radius;
		setOpaque(false); // As suggested by @AVD in comment.
	}

	protected void paintComponent(Graphics g)
	{
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g)
	{
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
	}

	public boolean contains(int x, int y)
	{
		if (shape == null || !shape.getBounds().equals(getBounds()))
		{
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
		}
		return shape.contains(x, y);
	}
}
