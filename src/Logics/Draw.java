package Logics;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Cells.Cell;
import DataCenter.Bridge;

public class Draw implements Runnable
{
	private BufferedImage img;
	private BufferedImage img2 = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
	private AffineTransform at;
	private Graphics g;
	private Bridge bridge;
	private ArrayList<Cell> cells;
	private double scale;
	public boolean drawing = true;
	private boolean save = false;
	private AffineTransformOp scaleOp;
	private int fileN = 0;
	private String path;
	private ArrayList<BufferedImage> pics = new ArrayList<BufferedImage>();

	public Draw(Bridge bridge, int Q)
	{
		this.bridge = bridge;
		img = new BufferedImage(Q, Q, BufferedImage.TYPE_INT_RGB);
		g = img.getGraphics();
		scale = 500 / ((double) Q);
		at = new AffineTransform();
		at.scale(scale, scale);
		scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	}

	public void Start()
	{
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run()
	{
		while (!bridge.ready())
		{
			try
			{
				Thread.sleep(50);
			} catch (InterruptedException e)
			{
			}
		}
		while (drawing)
		{
			cells = bridge.getCells();
			g.setColor(Color.black);
			g.fillRect(0, 0, 500, 500);
			for (Cell c : cells)
			{
				g.setColor(c.getColor());
				g.drawLine(c.getX(), c.getY(), c.getX(), c.getY());
			}

			img2 = scaleOp.filter(img, img2);
			bridge.setImg(this.img2);

			pics.add(img2);

			while (!bridge.ready())
			{
				try
				{
					Thread.sleep(50);
				} catch (InterruptedException e)
				{
				}
			}
			bridge.setNotReady();
		}
		System.out.println("Save: "+bridge.getSave()+" >> " + bridge.getPath() + "\\" + fileN + ".png");
		if (bridge.getSave())
		{
			fileN = 0;
			for (BufferedImage pic : pics)
			{
				try
				{
					File outputfile = new File(bridge.getPath() + "\\" + fileN + ".png");
					ImageIO.write(pic, "png", outputfile);
					fileN++;
				} catch (IOException e)
				{
				}
			}
			try
			{
				Desktop.getDesktop().open(new File(bridge.getPath() + "\\"));
			} catch (IOException e)
			{
			}
		}
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public void setSave(boolean save)
	{
		this.save = save;
	}

	public void setAffineTransform(AffineTransformOp at)
	{
		this.scaleOp = at;
	}

	public void setImg2(BufferedImage img)
	{
		this.img2 = img;
	}
}
