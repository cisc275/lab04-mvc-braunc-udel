/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {
	private int xloc = 0;
	private int yloc = 0;
	private int xIncr = 8;
	private int yIncr = 2;
    private int frameWidth;
    private int frameHeight;
    private int imgWidth;
    private int imgHeight;
    
    public Model (int fWidth,int fHeight,int iWidth,int iHeight) {
    		frameWidth = fWidth;
    		frameHeight = fHeight;
    		imgWidth = iWidth;
    		imgHeight = iHeight;
    }
    
    public void updateLocationAndDirection() {
    	// COLLISION DETECTION
    	if (xloc < 0 || xloc >= frameWidth - imgWidth) {
    		xIncr*=-1;
    	} // out of bounds horizontally
    	
    	if (yloc < 0 || yloc >= frameHeight - imgHeight) {
    		yIncr*=-1;
    	} // out of bounds vertically
    	
    	// UPDATE POSITION
    		xloc += xIncr;
    		yloc += yIncr;
    		
    	// DETERMINE DIRECTION
    		
    }
}