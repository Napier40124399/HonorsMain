package Logics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Cells.Cell;
import DataCenter.Storage;
import GUI.SettingsWindow;
import Scenarios.Scenario1;
import Scenarios.Scenario2;
import Scenarios.Scenario3;
import Scenarios.Scenario4;
import Scenarios.Scenario5;

/**
 * <h1>Action Handlers</h1> Creates all action handlers. As a result, a large
 * part of GUI logic occurs here.
 *
 * @param store
 *            {@link DataCenter.Storage Storage}
 * @see {@link MouseListener} & {@link MouseAdapter}
 * @see {@link ActionEvent} & {@link ActionListener}
 */
public class ActionHandlers
{
	private Storage store;
	private boolean newFocus = true;

	public ActionHandlers(Storage store)
	{
		this.store = store;
	}

	public void BuildHandlers()
	{
		store.slider.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				store.txtSlider.setText(store.slider.getValue() + "%");
			}
		});
		store.slider2.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				store.txtSlider2.setText((store.slider2.getValue() * 10) + "ms");
			}
		});
		store.slider3.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				store.txtSlider3.setText(store.slider3.getValue() + "%");
			}
		});
		store.btnUpdate.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (store.running)
				{
					store.vLog.setBridge(store.bridge);
				} else
				{
					JOptionPane.showMessageDialog(store.frame, "Simulation not running.", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		store.btnSettings.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				SettingsWindow sd = new SettingsWindow(store.bridge);
			}
		});
		store.timer = new Timer(10, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				store.panel.repaint();
				if (store.running)
				{
					if (!store.s.isRunning())
					{
						store.running = false;
						store.timer.stop();
						store.btnRun.setText("Run");
						store.s.Stop();
						store.d.drawing = false;
					}
				}
			}
		});
		
		store.btnDisp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(!store.selectedCell.equals(null))
				{
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("====== NEW ======");
					store.selectedCell.manage(0);
				}
			}
		});

		store.panel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if (store.running && !store.big && arg0.getButton() == 1)
				{
					if (store.selectedCell != null)
					{
						System.out.println("Color: " + store.selectedCell.getColor().getBlue());
						for (Cell ce : store.selectedCell.getNeighboors())
						{
							ce.setColor(Color.black);
						}
					}
					if (true)
					{
						int size = (int) Math.sqrt(store.bridge.getCells().size());
						int ratio = store.panel.getWidth() / size;
						int pos = (arg0.getX() / 5) * size + (arg0.getY() / 5);
						store.selectedCell = store.bridge.getCells().get(pos);
						for (Cell ce : store.selectedCell.getNeighboors())
						{
							// ce.setColor(Color.white);
						}
					}
				} else if (arg0.getButton() == 2 && store.running)
				{
					Color oo = new Color(store.bridge.getImg().getRGB(arg0.getX(), arg0.getY()));
					System.out.println("rgb: " + oo);
					if (store.selectedCell != null)
					{
						for (Cell ce : store.selectedCell.getNeighboors())
						{
							ce.setColor(Color.black);
						}
					}
				} else if (arg0.getButton() == 3)
				{
					if (store.running)
					{
						if (store.big)
						{
							store.big = false;
							store.frame.setBounds(store.oldLocation.x, store.oldLocation.y, store.oldDimension.width,
									store.oldDimension.height);
							store.panel.setBounds(2, 3, 500, 500);

							int Q = Integer.parseInt(store.txtCells.getText().toString());

							double scale = 500 / ((double) Q);
							AffineTransform at = new AffineTransform();
							at.scale(scale, scale);
							store.d.setAffineTransform(
									new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR));
							store.d.setImg2(new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB));
						} else
						{
							// Transform to full screen
							store.oldLocation = store.frame.getLocation();
							store.oldDimension = store.frame.getSize();
							store.big = true;
							Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
							int size;
							if (screenSize.getHeight() > screenSize.getWidth())
							{
								size = (int) screenSize.getWidth() - 100;
							} else
							{
								size = (int) screenSize.getHeight() - 100;
							}
							store.frame.setSize(new Dimension(size + 7, size + 51));
							store.frame.setLocation(5, 5);
							store.panel.setBounds(0, 0, size, size);

							int Q = Integer.parseInt(store.txtCells.getText().toString());

							double scale = size / ((double) Q);
							AffineTransform at = new AffineTransform();
							at.scale(scale, scale);
							store.d.setAffineTransform(
									new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR));
							store.d.setImg2(new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB));
						}
					}
				}
			}
		});

		store.btnExtend.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (store.extended)
				{
					store.extended = false;
					store.frame.setBounds(store.frame.getBounds().x, store.frame.getBounds().y, 512,
							store.frame.getHeight());
					store.btnExtend.setText(">");
				} else
				{
					store.extended = true;
					store.frame.setBounds(store.frame.getBounds().x, store.frame.getBounds().y, 1000,
							store.frame.getHeight());
					store.btnExtend.setText("<");
				}
			}
		});

		store.btnPlace.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (store.running)
				{
					JOptionPane.showMessageDialog(store.frame,
							"You are already running a simulation.\n Please start a new one", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else
				{
					if (store.placing)// Back to normal
					{
						store.placing = false;
						store.btnPlace.setText("Place Cells");
						store.frame.setBounds(store.frame.getBounds().x, store.frame.getBounds().y,
								store.frame.getWidth(), 580);
						store.timer.stop();
					} else if (store.validate.checkString(store.txtCells.getText().toString()))
					{
						store.cellQ = Integer.parseInt(store.txtCells.getText().toString());
						store.CDvals = new int[store.cellQ][store.cellQ];
						for (int i = 0; i < store.cellQ; i++)
						{
							for (int j = 0; j < store.cellQ; j++)
							{
								store.CDvals[i][j] = 1;
							}
						}
						store.placing = true;
						store.btnPlace.setText("Done");

						store.frame.setBounds(store.frame.getBounds().x, store.frame.getBounds().y,
								store.frame.getWidth(), 735);
						store.timer.start();
					} else
					{
						JOptionPane.showMessageDialog(store.frame, "Must input correct cell count.", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		store.btnRun.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (store.running && store.isDrawing)
				{
					store.running = false;
					store.timer.stop();
					store.btnRun.setText("Run");
					store.s.Stop();
					store.d.drawing = false;
				} else
				{
					if (store.validate.checkString(store.txtCells.getText().toString()))
					{
						store.vLog.setBridge(store.bridge);
						store.running = true;
						store.btnRun.setText("Stop");
						if (store.isDrawing)
						{
							store.d = new Draw(store.bridge, Integer.parseInt(store.txtCells.getText().toString()));
							store.d.setSave(store.save);
							store.d.setPath(store.path);
							store.d.Start();
							store.timer.start();
						}
						// handling scenario
						if (store.comboScenario.getSelectedIndex() == 0)
						{
							store.s = new Scenario1(Integer.parseInt(store.txtCells.getText().toString()),
									store.slider.getValue(), store.CDvals,
									Integer.parseInt(store.txtLoops.getText().toString()), store.bridge);
						} else if (store.comboScenario.getSelectedIndex() == 1)
						{
							store.s = new Scenario2(Integer.parseInt(store.txtCells.getText().toString()),
									store.slider.getValue(), store.CDvals,
									Integer.parseInt(store.txtLoops.getText().toString()), store.bridge);
						} else if (store.comboScenario.getSelectedIndex() == 2)
						{
							store.s = new Scenario3(Integer.parseInt(store.txtCells.getText().toString()),
									store.slider.getValue(), store.CDvals,
									Integer.parseInt(store.txtLoops.getText().toString()), store.bridge);
						} else if (store.comboScenario.getSelectedIndex() == 3)
						{
							store.s = new Scenario4(Integer.parseInt(store.txtCells.getText().toString()),
									store.slider.getValue(), store.CDvals,
									Integer.parseInt(store.txtLoops.getText().toString()), store.bridge);
						} else if (store.comboScenario.getSelectedIndex() == 4)
						{
							store.s = new Scenario5(Integer.parseInt(store.txtCells.getText().toString()),
									store.slider.getValue(), store.CDvals,
									Integer.parseInt(store.txtLoops.getText().toString()), store.bridge);
						}
						store.bridge.setItPerGen(Integer.parseInt(store.txtItGen.getText()));
						store.s.Start();
						if (store.panel.getWidth() > 700)
						{
							Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
							int size;
							if (screenSize.getHeight() > screenSize.getWidth())
							{
								size = (int) screenSize.getWidth() - 100;
							} else
							{
								size = (int) screenSize.getHeight() - 100;
							}

							int Q = Integer.parseInt(store.txtCells.getText().toString());

							double scale = size / ((double) Q);
							AffineTransform at = new AffineTransform();
							at.scale(scale, scale);
							store.d.setAffineTransform(
									new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR));
							store.d.setImg2(new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB));
						}
					} else
					{
						JOptionPane.showMessageDialog(store.frame, "Incorrect input.", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		store.btn4K.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				store.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

				store.fKHandler.goToFourK();

				store.btnUpdate.setBounds(store.btnRun.getX() + 220, 900, 200, 80);
				store.btnSettings.setBounds(store.frame.getWidth() - 300, store.frame.getHeight() - 200, 200, 80);
			}
		});

		store.btnMonitor.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				store.mWindow.setVisible(true);
			}
		});
	}
}
