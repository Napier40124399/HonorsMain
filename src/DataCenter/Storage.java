package DataCenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;

import Cells.Cell;
import GUI.BottomPanel;
import GUI.DrawWindow;
import GUI.FrameBuilder;
import GUI.FrameBuilderAlt;
import GUI.MainWindow;
import GUI.MonitoringWindow;
import GUI.RightPanel;
import Logics.ActionHandlers;
import Logics.Draw;
import Logics.FourKHandler;
import Logics.Validation;
import Logics.VisualLogic;
import Scenarios.Scenario;

/**
 * <h1>Storage</h1> Serves as a centralized storage point for all classes
 * running on the main thread. They are essentially one class and are the result
 * of one class being seperated into more easily comprehensible sections. It
 * mainly handles GUI elements and instances of GUI related classes.
 * 
 * <br>
 * This is not the best way of implementing the wanted design but does the job.
 * Suggestions are more than welcome!
 * 
 * @param img
 *            the image displayed in the panel.
 * @param isDrawing
 *            **info comming soon**
 * @param placing
 *            **info comming soon**
 * @param extended
 *            **info comming soon**
 * @param running
 *            **info comming soon**
 * @param big
 *            **info comming soon**
 * @param cellQ
 *            **info comming soon**
 * @param area
 *            **info comming soon**
 * @param drawing
 *            **info comming soon**
 * @param CDVals
 *            **info comming soon**
 * @param color
 *            **info comming soon**
 * @param save
 *            **info comming soon**
 * @param path
 *            **info comming soon**
 * @param ok
 *            **info comming soon**
 * @param oldLocation
 *            **info comming soon**
 * @param oldDimensions
 *            **info comming soon**
 */
public class Storage
{
	// Colors
	public Color NeonGreen = new Color(0, 150, 60);
	public Color NeonBlue = new Color(0, 155, 255);
	public Color NeonRed = new Color(255, 102, 102);
	public Color Fade = new Color(200, 200, 200);
	public Color using;
	// Variables
	public Image img;
	public boolean isDrawing;
	public boolean placing = false;
	public boolean extended = false;
	public boolean running = false;
	public boolean big = false;
	public int cellQ = 100;
	public int area = 1;
	public boolean drawing = false;
	public int[][] CDvals;
	public int color = 0;
	public boolean save = false;
	public String path = "";
	public int ok = 0;
	public Point oldLocation;
	public Dimension oldDimension;
	public Float scale;
	// UI
	public Timer timer;
	public JFrame frame;
	// Panels
	public JPanel panel;
	public JPanel seperator;
	public JPanel seperator2;
	// Buttons
	public JButton btnRun;
	public JButton btnPlace;
	public JButton btnExtend;
	public JButton btnCD;
	public JButton btnClear;
	public JButton btnDelete;
	public JButton btnUpdate;
	public JButton btnPlace2;
	public JButton btnSettings;
	public JButton btn4K;
	public JButton btnMonitor;
	public JButton btnDisp;
	// Sliders
	public JSlider slider;
	public JSlider slider2;
	public JSlider slider3;
	public JSlider SliderArea;
	// Text Fields
	public JTextField txtCells;
	public JTextField txtSlider;
	public JTextField txtSlider2;
	public JTextField txtSlider3;
	public JTextField txtT;
	public JTextField txtR;
	public JTextField txtP;
	public JTextField txtS;
	public JTextField txtLoops;
	public JTextField txtDist;
	public JTextField txtItGen;
	public JTextField txtCores;
	// Combo Boxes
	public JComboBox comboScenario;
	public JComboBox comboColor;
	// Check Boxes
	public JCheckBox checkTaurus;
	// Arrays
	public ArrayList<JPanel> panels = new ArrayList<JPanel>();
	// New Arrays

	// Old Arrays
	public ArrayList<JLabel> RightOptionsLbl = new ArrayList<JLabel>();
	public ArrayList<JTextField> RightOptionsTxt = new ArrayList<JTextField>();
	public ArrayList<JSlider> RightOptionsSlider = new ArrayList<JSlider>();
	public ArrayList<JLabel> BottomOptionsLbl = new ArrayList<JLabel>();
	public ArrayList<JTextField> BottomOptionsTxt = new ArrayList<JTextField>();
	public Cell selectedCell = null;
	// Instances
	public Draw d;
	public Scenario s;
	public Bridge bridge;
	// Logic Instances
	public Validation validate;
	public Storage store;
	public VisualLogic vLog;
	public ActionHandlers actions;
	// GUI Instances
	public MainWindow window;
	public BottomPanel bPanel;
	public RightPanel rPanel;
	public FrameBuilder fBuild1;
	public FrameBuilderAlt fBuild2;
	public FourKHandler fKHandler;
	public MonitoringWindow mWindow;
	public DrawWindow dWindow;

	/**
	 * <h1>Instances</h1> Sets and starts instances. This is a convenient way of
	 * insuring all instances have the correct instance of each other. Its also
	 * a hassle free way of doing it.
	 *
	 * @param window
	 *            current instance of the {@link GUI.MainWindow MainWindow}
	 *            class.
	 * @param store
	 *            window's instance of this class.
	 */
	public void setInstances(MainWindow window, Storage store)
	{
		this.window = window;
		this.store = store;
		this.bridge = new Bridge();
		this.validate = new Validation();
		this.fBuild1 = new FrameBuilder(store);
		this.rPanel = new RightPanel(store);
		this.bPanel = new BottomPanel(store);
		this.actions = new ActionHandlers(store);
		vLog = new VisualLogic(store);
		fKHandler = new FourKHandler(store);
		mWindow = new MonitoringWindow(bridge);
	}
}
