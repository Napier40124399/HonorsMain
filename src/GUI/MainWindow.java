package GUI;
import java.awt.EventQueue;

import DataCenter.Storage;
import Logics.FileReading;

/**
* <h1>Cooperative Behavior Simulation Software</h1>
* This is a toolkit / simulation engine. It is used to generate and assess a variety of 
* user definable simulations of behavioral evolution. It is usable by anyone with a
* minimal background in OO programming
* <p>
* Details on how to use this toolkit are placed throughout the code in a convenient
* manner. This should be a breeze!!
* 
*
* @author  James Taylor
* @version 1.0
* @since   05-01-2017
*/

public class MainWindow
{
	private static MainWindow window;
	private Storage store = new Storage();
	public static void main(String[] args){EventQueue.invokeLater(new Runnable(){public void run()
	{try{window = new MainWindow();}catch(Exception e){e.printStackTrace();}}});}

	/*
	* Description:
	* Launches everything.
	* If you change this make sure order is kept.
	*/
	
	public MainWindow()
	{
		store.setInstances(window, store);
		store.fBuild1.makeFrame();
		store.rPanel.makePanel();
		store.bPanel.makePanel();
		store.actions.BuildHandlers();
		store.panel.repaint();
		store.frame.setVisible(true);
		store.bridge.setCores(0);
		store.isDrawing = true;
		FileReading fr = new FileReading();
	}
	
	//OLD NEEDS MOVING
	public void setSave(boolean save)
	{
		store.save = save;
	}

	public void setPath(String path)
	{
		store.path = path;
	}
}
