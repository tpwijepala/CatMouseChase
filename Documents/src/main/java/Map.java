import java.util.ArrayList;
// import java.util.Timer;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
//import javax.swing.*;

/**
 * This class is used to create everything for the game
 * It creates & draws the Map
 * It is also used for moving, spawning in and drawing new objects
 * It also keeps track of elapsed time
 * Map also stores and maintains the objects in Arrays & ArrayLists so that they
 * can be accessed by other classes
 * 
 * @author Thimira Wijepala
 */
public class Map{

    private static final int[][] walls = 
        {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

    protected static StaticEntity[][] items = new StaticEntity[58][41];
    protected static MovingEntity[][] characters = new MovingEntity[58][41];
    ArrayList<Entity> objects = new ArrayList<Entity>();
    static ArrayList<Cat> mapCats = new ArrayList<Cat>();  //This might be redundant later on

    int startX = 4, startY = 4;
    int endX = 56; 
    int[] endY = {35, 36, 37, 38, 39};   //This marks the finish line rather than a finish cell
    int crumbsCollect = 0;

    final static int CELLWIDTH = 25;

    boolean cheeseExist = false;
    Cheese c;
    long startTime;
    long timer;
    long tickTime = System.currentTimeMillis();
    Mouse player;

    private BufferedImage map;
    GameTimer tt = new GameTimer();

    Position start = new Position(startX, startY);
    Position[] end = new Position[5];

    /**
     * Constructer of Map object
     * Loads map png to draw later
     * creates player & generates intial objects
     */

    public Map(){
        try{
            map = ImageIO.read(new File("src/main/resources/map.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < endY.length; i++) {
            end[i] = new Position(endX, endY[i]);
        }
        player = new Mouse(startX, startY, this);
        addCharacter(player);
        generateCrumbs();
        generateCats();
        generateMouseTraps();
    }

    private void generateCrumbs() {
        //41 down, 58 across
        Crumb c1 = new Crumb(10, 12);
        addItem(c1);

        Crumb c2 = new Crumb(25, 12);
        addItem(c2);

        Crumb c3 = new Crumb(10, 20);
        addItem(c3);

        Crumb c4 = new Crumb(22, 18);
        addItem(c4);
    }  

    private void generateCats() {
        Cat cat1 = new Cat(12, 34);
        mapCats.add(cat1);
        addCharacter(cat1);

        Cat cat2 = new Cat(36, 24);
        mapCats.add(cat2);
        addCharacter(cat2);

        Cat cat3 = new Cat(43, 13);
        mapCats.add(cat3);
        addCharacter(cat3);
    }

    private void generateMouseTraps() {
        MouseTrap trap1 = new MouseTrap(23, 20);
        addItem(trap1);

        MouseTrap trap2 = new MouseTrap(38, 34);
        addItem(trap2);

        MouseTrap trap3 = new MouseTrap(55,5);
        addItem(trap3);
    }


    public static int isWall(int x, int y) {
        return walls[y][x];
    }

     /**
      * This method is used to spawn/despawn cheese after a given time
      *
      * @param cheeseDespawn - used to restart timer if item is collected
      */

    public void cheeseExist(boolean cheeseCollected) {
        if (cheeseCollected) { // if cheese is collected
            startTime = System.currentTimeMillis();
            cheeseExist = false;
        }
        timer = System.currentTimeMillis() - startTime;

        if (!cheeseExist && timer >= 5000) {
            // spawn after its been despawned for 5s
            c = new Cheese(0,0);
            addItem(c);
            cheeseExist = true;
        }

        else if (cheeseExist && timer >= 12000){
            // if cheese uncollected for 12s
            this.removeItem(c);
            cheeseExist = false;
            startTime = System.currentTimeMillis();
        }
    }


    /**
     * Method is used to determine whether a tick or '1000ms' has passed
     * @return true or false depending whether 1000ms has passed
     */
    private boolean tick(){
        long time = System.currentTimeMillis();
        if (time >= tickTime + 1000){
            tickTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }
    
    // Note: not on UML Diagram
    public Position[] getEnd() {
        return end;
    }

    public Mouse getPlayer() {
        return player;
    }

    public static ArrayList<Cat> getCats() {
        return mapCats;
    }

    public ArrayList<Entity> getObjectsArray() {
        return objects;
    }

    // Note: not on UML Diagram
    public void moveCharacter(Position oldPos, Position newPos) {
        MovingEntity temp = characters[oldPos.x][oldPos.y];
        characters[oldPos.x][oldPos.y] = null;
        characters[newPos.x][newPos.y] = temp;
    }

    // Note: not on UML Diagram
    public static StaticEntity getItem(Position pos) {
        return items[pos.getX()][pos.getY()];
    }

    public static MovingEntity getCharacter(int x, int y){
        return characters[x][y];
    }

    public void addItem(StaticEntity item) {
        items[item.getPos().getX()][item.getPos().getY()] = item;
        objects.add(item);
    }

    public void addCharacter(MovingEntity charac) {
        characters[charac.pos.x][charac.pos.y] = charac;
        objects.add(charac);
    }

    public void removeItem(StaticEntity item) {
        //System.out.println("BEFORE REMOVE: " + items[item.getPos().getX()][item.getPos().getY()]);
        
        // Remove from items array:
        items[item.getPos().getX()][item.getPos().getY()] = null;
        
        //System.out.println("AFTER REMOVE: " + items[item.getPos().getX()][item.getPos().getY()]);
        // Remove from objects ArrayList:
        for (int i = 1; i < objects.size(); i++) {
            if (objects.get(i).getPos().getX() == item.getPos().getX() && objects.get(i).getPos().getY() == item.getPos().getY()) {
                objects.remove(i);
            }
        }
    }

    /**
     * This method is used to draw map and objects
     * also used to generate & move the objects
     * 
     * @param g - the canvas that gets drawn
     */
    public void drawEntities(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(map, 0,0, null);
        
        tt.displayTime(g);
        player.getMouseScore().displayScore(g);

        cheeseExist(false);

        player.move(player.newPos);
        //player.collectItem();

        if (tick()){
            for (int i = 0; i < 3; i++) {
                mapCats.get(i).catchMouse(player.getPos());
            }
        }

        for (int i = 0; i < objects.size(); i++){
            objects.get(i).draw(g);
        }

    }
   
}

