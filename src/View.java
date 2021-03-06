/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JPanel {
	private final int imageWidth = 165;
	private final int imageHeight = 165;
    private final int frameWidth = 500;
    private final int frameHeight = 300;
	private final int numOfDirections = 8;
	private final int frameCount = 10;
	int picNum = 0;
	BufferedImage[] sourcePics;
	BufferedImage[][] animationFrames;
	private int orcX = 0;
	private int orcY = 0;
	private Direction orcDirect = Direction.NORTH;
	
	public int getImageHeight() {
		return imageHeight;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	
	public View() {
    		//adding pics for animation frames to array
    		sourcePics = new BufferedImage[numOfDirections];
    		for (int i = 0; i < numOfDirections; i++) {
    			sourcePics[i] = createImage(Direction.values()[i].getName());
    		}
    		
    		// all animations loaded into 2d array
    		animationFrames = new BufferedImage[numOfDirections][frameCount];
    		for (int i = 0; i < numOfDirections; i++) {
    			for (int x = 0; x < frameCount; x++) {
    				animationFrames[i][x] = sourcePics[i].getSubimage(imageWidth*x, 0, imageWidth, imageHeight);
    			}
    		}
    		
    		//Jframe setup
    		JFrame frame = new JFrame();
    		frame.getContentPane().add(this);
    		frame.setBackground(Color.gray);
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(frameWidth, frameHeight);
        		frame.setResizable(false);
        		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		picNum = (picNum + 1) % frameCount;
		g.drawImage(animationFrames[orcDirect.ordinal()][picNum], orcX, orcY, Color.gray, this);
	}
	
	public void update(int x, int y, Direction d) {
			orcX = x;
			orcY = y;
			orcDirect = d;
			setBackground(Color.gray);
			repaint();
		try {
			Thread.sleep(100);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
    private BufferedImage createImage(String fileName){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_" + fileName + ".png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
	
}