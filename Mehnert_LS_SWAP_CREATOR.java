import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* Collin Mehnert
 * PROJECT - "LS SWAP CREATOR"
 * Ever since its debut in the 1997 Chevrolet Corvette,
 * the LS engine family has proven to be a powerful yet simple
 * and affordable design, and is very popular for custom car drivetrains.
 * Since the demand for swapping these engines into pretty much any vehicle has grown so popular
 * I have designed a program that will allow a user to create their own dream swap all put together.
 * It allows the user to customize a design to their liking and figure out which components they want for their 
 * particular build.
 * The enginePart class serves as the model class, where each of the different engine components is a part with a shape and color associated
 * The engineFrame class is the view class, it displays the engine being designed and allows the user to see what the product will look like assembled
 * The enginePanel class is the Controller, when it sees certain inputs and changes it will change the engine build accordingly
 * For future improvements I would like to add more parts to each menu catalog, and instead of just drawing generic shapes,
 * display actual photos of the parts and assemble the engine when complete.
 * 
 * 
 */

class enginePart {
	private int x;
	private int y;
	private int partShape;
	private int partColor;
	public int getpartShape() {
		return partShape;
	}												
	public void setpartShape(int partShape) {				
		this.partShape = partShape;
	}
	public int getpartColor() {
		return partColor;
	}
	public void setpartColor(int partColor) {
		this.partColor = partColor;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {				
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public enginePart(){
		setX(x);
		setY(y);
		setpartShape(partShape);
		setpartColor(partColor);
	}
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s",x ,y ,partShape ,partColor );
	}
	
}
class engineFrame extends JFrame implements ActionListener {
	private ArrayList<enginePart> parts;
	private enginePanel epan;
	enginePart Block = new enginePart();
	enginePart Heads = new enginePart();
	enginePart Aspiration = new enginePart();
	public void configureMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);												
			}
		});
		mnuFile.add(miExit);
		bar.add(mnuFile);
		JMenu mnuEdit = new JMenu("Edit");
		JMenuItem miUndo = new JMenuItem("Undo");
		miUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parts.remove(parts.size()-1);
			}
		});
		JMenuItem miClear = new JMenuItem("Clear");
		miClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parts.clear();
				repaint();
			}
		});
		JMenu mnuBlock = new JMenu("Block");
		Block.setX(300);
		Block.setY(300);
		JMenuItem miLS1 = new JMenuItem("LS1");
		miLS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parts.add(Block);
				Block.setpartColor(1);
				Block.setpartShape(0);
				
			}
		});
		JMenuItem miLS2 = new JMenuItem("LS2");
		miLS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parts.add(Block);
				Block.setpartColor(2);
				Block.setpartShape(0);
			}
		});
		JMenuItem miLS3 = new JMenuItem("LS3");
		miLS3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parts.add(Block);
				Block.setpartColor(3);
				Block.setpartShape(0);
			}
		});
		JMenu mnuHeads = new JMenu("Heads");
		JMenuItem mi799 = new JMenuItem("799");
		mi799.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parts.setColor(Color.RED);
				repaint();
			}
		});
		JMenuItem mi243 = new JMenuItem("243");
		mi243.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parts.setColor(Color.RED);
				repaint();
			}
		});
		JMenuItem mi862 = new JMenuItem("862");
		mi862.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parts.setColor(Color.RED);
				repaint();
			}
		});
		JMenu mnuAspiration = new JMenu("Aspiration");
		JMenuItem miNaTruck = new JMenuItem("N/A-Truck");
		miNaTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parts.setColor(Color.RED);
				repaint();
			}
		});
		JMenuItem miNaLS = new JMenuItem("N/A-LS");
		miNaLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parts.setColor(Color.RED);
				repaint();
			}
		});
		JMenuItem misuperCharged = new JMenuItem("Supercharged");
		misuperCharged.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parts.setColor(Color.RED);
				repaint();
			}
		});
		JMenuItem miTurbo = new JMenuItem("Turbocharged");
		miTurbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parts.setColor(Color.RED);
				repaint();
			}
		});
		mnuBlock.add(miLS1);
		mnuBlock.add(miLS2);
		mnuBlock.add(miLS3);
		mnuHeads.add(mi862);
		mnuHeads.add(mi243);
		mnuHeads.add(mi799);
		mnuAspiration.add(miNaTruck);
		mnuAspiration.add(miNaLS);
		mnuAspiration.add(misuperCharged);
		mnuAspiration.add(miTurbo);
		mnuEdit.add(miUndo);
		mnuEdit.add(miClear);
		bar.add(mnuEdit);
		bar.add(mnuBlock);
		bar.add(mnuHeads);
		bar.add(mnuAspiration);
		setJMenuBar(bar);
	}
	public void configureUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600,600,500,500);
		setTitle("LS SWAP CREATOR V1.0");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel partPanel = new JPanel();
		c.add(partPanel,BorderLayout.CENTER);
		configureMenu();
		
	}
	public engineFrame(ArrayList<enginePart> parts) { 						//Constructor for the frame
		this.parts = parts;
		configureUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
class enginePanel extends JPanel {
	private ArrayList<enginePart> parts;
	private Color color;
	public enginePanel(ArrayList<enginePart> parts) {
		this.parts = parts;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color col) {
		color = col;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int shape;
		int color;
		for (enginePart p : parts) {
			if (p.getpartColor() == 1 && p.getpartShape() == 0) {
				g.setColor(Color.RED);
				g.fillRect(300,300,200,200);
			} else if (p.getpartColor() == 2 && p.getpartShape() == 0) {
				g.setColor(Color.BLUE);
				g.fillRect(300,300,400,400);
			} else if (p.getpartColor() == 3 && p.getpartShape() == 0) {
				g.setColor(Color.GREEN);
				g.fillRect(300,300,400,400);
			} else if (p.getpartColor() == 4 && p.getpartShape() == 1) {
				g.setColor(Color.BLACK);
				g.fillOval(300,200,200,200);
			}
		}
		
		
	}
}
class buildPanel extends JPanel{
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawString("Here's your current build: ", 10, 500);					// 																				 
	g.drawString("Current Total = ", 10,400);								// 																			 
	}
	public buildPanel() {
		setPreferredSize(new Dimension(300,100));
	}
}

public class Mehnert_LS_SWAP_CREATOR {
	public static void main(String[] args) {
		ArrayList<enginePart> parts = new ArrayList<enginePart>();
		engineFrame myengineFrame = new engineFrame(parts);
		enginePart Block = new enginePart();
		enginePart Heads = new enginePart();
		enginePart Aspiration = new enginePart();
		parts.add(Block);
		parts.add(Heads);
		parts.add(Aspiration);
		myengineFrame.setVisible(true);
		
	}

}
