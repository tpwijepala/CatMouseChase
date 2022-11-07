
/**
 *  This class is used to help maintain and
 *  create static Items that the Mouse collects
 */
public class StaticEntity extends Entity {

    protected int points = 0;
    
    public StaticEntity(int x, int y) {
        super (x, y);
    }

    /**
     * Returns the the points to increase/decrease Mouse Score by
     * <p>
     * This method is to be called after Mouse has collected the objected
     * 
     * @return points - how much to increase the Mouse's score by
     */
    public int getPoints() { return points; }
}


