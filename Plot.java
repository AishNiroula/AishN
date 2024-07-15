
public class Plot {

    private int x;
	private int y;
	private int depth;
	private int width;
	
	public Plot(){
		this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    
	}
	
	public Plot(int x, int y, int depth, int width){
	this.x = x;
	this.y = y;
	this.depth = depth;
	this.width = width;
	
	}
	
	 public Plot(Plot plot) {
	 this.x = plot.x;
     this.y = plot.y;
	 this.width = plot.width;
     this.depth = plot.depth;
    
	 }

	  /**
	   * @return the x
	   */
	  public int getX() {
	    return x;
	  }

	  /**
	   * @param x the x to set
	   */
	  public void setX(int x) {
	    this.x = x;
	  }

	  /**
	   * @return the y
	   */
	  public int getY() {
	    return y;
	  }

	  /**
	   * @param y the y to set
	   */
	  public void setY(int y) {
	    this.y = y;
	  }

	  /**
	   * @return the width
	   */
	  public int getWidth() {
	    return width;
	  }

	  /**
	   * @param width the width to set
	   */
	  public void setWidth(int width) {
	    this.width = width;
	  }

	  /**
	   * @return the depth
	   */
	  public int getDepth() {
	    return depth;
	  }

	  /**
	   * @param depth the depth to set
	   */
	  public void setDepth(int depth) {
	    this.depth = depth;
	  }

	  

	  public boolean overlaps(Plot plot) {
		  boolean aOverlapsXY1 = (plot.x >= x && plot.x < (x + width)) &&  (plot.y >= y && plot.y < (y + depth));
		    boolean aOverlapsXY2 = (x >= plot.x && x < (plot.x + width)) &&  (y >= plot.y && y < (plot.y + plot.depth));
		    boolean bOverlapsXY1 = (plot.x + plot.width) > x && (plot.x + plot.width) < (x + width) && plot.y >= y && plot.y <= (y + depth); 
		    boolean bOverlapsXY2 = (x + width) > plot.x && (x + width) < (plot.x + plot.width) && y >= plot.y && y <= (plot.y + plot.depth); 
		    boolean cOverlapsXY1 = plot.x >= x && plot.x < (x +  width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) <= (y + depth);
		    boolean cOverlapsXY2 = x >= plot.x && x < (plot.x +  plot.width) && (y + depth) > plot.y && (y + depth) <= (plot.y + plot.depth);
		    boolean dOverlapsXY1 = (plot.x + plot.width) > x && (plot.x +plot.width) <= (x + width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) <= (y + depth);
		    boolean dOverlapsXY2 = (x + width) > plot.x && (x + width) <= (plot.x + plot.width) && (y + depth) > plot.y && (y + depth) <= (plot.y + plot.depth);
		    
		    return aOverlapsXY1 || aOverlapsXY2 || bOverlapsXY1 || bOverlapsXY2 || cOverlapsXY1 || cOverlapsXY2 || dOverlapsXY1 || dOverlapsXY2;
		  }

		  public boolean encompasses(Plot plot) {
		    boolean insideX = plot.x >= x;
		    boolean insideY = plot.y >= y;
		    boolean insideWidth = plot.x + plot.width <= x + width;
		    boolean insideDepth = plot.y + plot.depth <= y + depth;
		    
		    return insideX && insideY && insideWidth && insideDepth;
		  }

	  

	  @Override
	  public String toString() {
		  return x + "," + y + "," + depth + "," + width;
		    }
		    
	  }