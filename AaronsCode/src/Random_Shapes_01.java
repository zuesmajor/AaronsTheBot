import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Random_Shapes_01
{
	JFrame myWindow;
	JButton btnStart;
	RandomShapes rs;
	
	boolean draw = false;
	Thread drawThread = null;
	
	public static void main(String[] args)
	{
		Random_Shapes_01 p = new Random_Shapes_01();
		p.gui();
	}
	
	public void gui()
	{
		myWindow = new JFrame("Random Four-Legged Animal");
		myWindow.setSize(1200, 600);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		rs = new RandomShapes();
		myWindow.add(rs, BorderLayout.CENTER);
		 
		 JPanel pnlSouth = new JPanel();
		 btnStart = new JButton("Start");
		 pnlSouth.add(btnStart);
		 myWindow.add(pnlSouth, BorderLayout.SOUTH);
		 
		 btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
//				draw = !draw;
//				if( draw )
//				{
//					btnStart.setText("Stop");
					drawThread = new Thread(rs);
					drawThread.start();
//				}
//				else
//				{
//					btnStart.setText("Start");
//					drawThread.interrupt();
//					rs.save("Random_Shapes_01_Output.png");
//				}
			}
		 });
		 
		myWindow.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	class RandomShapes extends JComponent implements Runnable
	{
		private BufferedImage outputImage;

		public RandomShapes()
		{
			outputImage = null;
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			/*
			Graphics2D g2d = (Graphics2D)g;
			if( sourceImage != null )
				g2d.drawImage(sourceImage, 0, 0, (int)this.getWidth(), (int)this.getHeight(), null);
			else
			{
				g2d.setColor(Color.gray);
				g2d.fillRect(0, 0, (int)this.getWidth(), (int)this.getHeight());
			}
			*/
		}
		


		public void run()
		{
			// get the graphics for drawing to the screen
			Graphics2D g2d = (Graphics2D)this.getGraphics();
				
			// get the graphics for drawing to a buffer
			outputImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2dOutput = (Graphics2D)outputImage.getGraphics();
				
			int width = this.getWidth();
			int height = this.getHeight();
				


			
			
//			while(draw)
//			{

				// fill the background to start
				g2d.setColor(Color.white);
				g2d.fillRect(0, 0, width, height);
				g2dOutput.setColor(Color.white);
				g2dOutput.fillRect(0, 0, width, height);
					
				g2d.setColor(Color.black);
				g2dOutput.setColor(Color.black);

				Torso torso = new Torso();
				torso.setPosition(new Point(width/2, height/2));
				torso.draw(g2d);
		
				
//				int x1 = (int) Math.floor(Math.random() * width);
//				int y1 = (int) Math.floor(Math.random() * height);
//				
//				int x2 = (int) Math.floor(Math.random() * width);
//				int y2 = (int) Math.floor(Math.random() * height);
//				
//				if( Math.random() < 0.3 )
//				{
//					g2d.drawOval(x1, y1, x2, y2);
//					g2dOutput.drawOval(x1, y1, x2, y2);
//				}
//				else if( Math.random() < 0.3 )
//				{
//					g2d.drawRect(x1, y1, x2, y2);
//					g2dOutput.drawRect(x1, y1, x2, y2);
//				}
//				else
//				{
//					g2d.drawLine(x1, y1, x2, y2);
//					g2dOutput.drawLine(x1, y1, x2, y2);
//				}
//				
//				try
//				{
//					Thread.sleep(250);
//				}
//				catch (InterruptedException e)
//				{
//					//e.printStackTrace();
//					System.out.println("InterruptedException: Sleep interrupted...");
//				}
//			}
		}
		
		public void save(String filename)
		{
			if(outputImage != null)
			{
				try
				{
					ImageIO.write(outputImage, "png", new File(filename));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
		}
	}

}
