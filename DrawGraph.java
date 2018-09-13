import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawGraph extends JPanel {
	
	public static LinkedList<Integer> coords = new LinkedList<Integer>();
	public static LinkedList<Integer> path = new LinkedList<Integer>();
	Timer timer;
	public static GFG g1;
	public static Scanner input;
	DrawGraph() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
	    refreshScreen();
	      
	  }
	
  public void paintComponent(Graphics g) {
	  
	//path = MLP.findBest(g1, path);
	
    super.paintComponent(g);
    int scaleX = 10;
    int scaleY = 3;
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(Color.red);
	g2d.setStroke(new BasicStroke(5));
	
	for (int i = 0; i <= coords.size()-2; i+=2) {
		g2d.drawLine(coords.get(i)*scaleX, coords.get(i+1)*scaleY, coords.get(i)*scaleX, coords.get(i+1)*scaleY);
		String name = Character.toString((char) ('A' + i));
		g2d.drawString(String.format("%d",i/2), coords.get(i)*scaleX + 5, coords.get(i+1)*scaleY);
	}
	//set fisrt as color green
	g2d.setColor(Color.green);
	g2d.drawLine(coords.get(0)*scaleX, coords.get(1)*scaleY, coords.get(0)*scaleX, coords.get(1)*scaleY);
	
	g2d.setColor(Color.blue);
	g2d.setStroke(new BasicStroke(2));
	for (int i = 0; i <= path.size()-2; i++) {
		Dimension size = getSize();
		int w = size.width ;
		int h = size.height;
		     
		g2d.drawLine(coords.get(path.get(i)*2)*scaleX, coords.get((path.get(i)*2) +1)*scaleY, coords.get(path.get(i+1)*2)*scaleX, coords.get((path.get(i+1)*2)+1)*scaleY);
	}

	g2d.drawLine(coords.get(path.getLast()*2)*scaleX, coords.get((path.getLast()*2) +1)*scaleY, coords.get(path.getFirst()*2)*scaleX, coords.get((path.getFirst()*2)+1)*scaleY);
	
  }
  
  
  public void refreshScreen() {
	    timer = new Timer(0, new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        repaint();
	      }
	    });
	    timer.setRepeats(true);
	    // Aprox. 60 FPS
	    timer.setDelay(17);
	    timer.start();
	  }
 
}