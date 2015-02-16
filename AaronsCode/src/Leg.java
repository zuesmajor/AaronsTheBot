

import java.awt.Graphics2D;


public class Leg extends Drawable {
	int angle;
	int length;
	int footLength;

	public Leg() {
		angle = random.nextInt(30);
		length = random.nextInt(100)+50;
		footLength = random.nextInt(50)+20;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		System.out.println(position);
		
		double legEndX = position.getX() + Math.cos((double)(angle + 75)/180*Math.PI) * length;
		double legEndY = position.getY() + Math.sin((double)(angle + 75)/180*Math.PI) * length;

		g2d.drawLine(
				(int)(position.getX()),
				(int)(position.getY()),
				(int)(legEndX),
				(int)(legEndY)
		);
		
		g2d.drawLine(
				(int)(legEndX),
				(int)(legEndY),
				(int)(legEndX + Math.cos((double)(angle + 75 + 90)/180*Math.PI) * footLength),
				(int)(legEndY + Math.sin((double)(angle + 75 + 90)/180*Math.PI) * footLength)
		);
	}
}