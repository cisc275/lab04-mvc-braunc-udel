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
    private Direction direction;
    
    public Model (int fWidth,int fHeight,int iWidth,int iHeight) {
    		frameWidth = fWidth;
    		frameHeight = fHeight;
    		imgWidth = iWidth;
    		imgHeight = iHeight;
    }
    
    // getters for frame and image
    public int getWidth() {
    		return frameWidth;
    }
    public int getHeight() {
    		return frameHeight;
    }
    public int getImageWidth() {
    		return imgWidth;
    }
    public int getImageHeight() {
    		return imgHeight;
    }
    
    //getters for orc
    public int getX() {
    		return xloc;
    }
    public int getY() {
    		return yloc;
    }
    public Direction getDirect() {
    		return direction;
    }
    
    
    public void updateLocationAndDirection() {
    	// COLLISION DETECTION
    	if (xloc < 0 || xloc > frameWidth - imgWidth) {
    		xIncr*=-1;
    	} // out of bounds horizontally
    	
    	if (yloc < 0 || yloc > frameHeight - imgHeight) {
    		yIncr*=-1;
    	} // out of bounds vertically
    	
    	
    	// UPDATE POSITION
    		xloc += xIncr;
    		yloc += yIncr;
    		
    		
    	// DETERMINE DIRECTION
    		boolean findingDirection = true;
    		while (findingDirection) {
    		// using a while loop so we can stop checking for directions
    		// after the correct one has been found
    			if (xIncr == 0 && yIncr < 0) {
        			direction = Direction.NORTH;
        			break;
        		}
        		if (xIncr > 0 && yIncr < 0) {
        			direction = Direction.NORTHEAST;
        			break;
        		}
        		if (xIncr > 0 && yIncr == 0) {
        			direction = Direction.EAST;
        			break;
        		}
        		if (xIncr > 0 && yIncr > 0) {
        			direction = Direction.SOUTHEAST;
        			break;
        		}
        		if (xIncr == 0 && yIncr > 0) {
        			direction = Direction.SOUTH;
        			break;
        		}
        		if (xIncr < 0 && yIncr > 0) {
        			direction = Direction.SOUTHWEST;
        			break;
        		}
        		if (xIncr < 0 && yIncr == 0) {
        			direction = Direction.WEST;
        			break;
        		}
        		if (xIncr < 0 && yIncr < 0) {
        			direction = Direction.NORTHWEST;
        			break;
        		}
        		else {
        			findingDirection = false;
        		}
    		}
    }
}