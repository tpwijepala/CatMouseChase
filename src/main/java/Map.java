import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

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
public class Map {

    ArrayList<StaticEntity> items = new ArrayList<StaticEntity>();
    ArrayList<MovingEntity> characters = new ArrayList<MovingEntity>();
    ArrayList<Entity> objects = new ArrayList<Entity>();
    private final int[][] walls; 

    int startX, startY;
    int endX, endY;
    int endHeight;
    int crumbsCollect;

    static int CELLWIDTH;

    boolean cheeseExists;
    Cheese c;
    long startTime;
    long timer;
    long tickTime;
    long catTickTime;
    Mouse player;

    private BufferedImage map;
    GameTimer gameTime = new GameTimer();

    Position start = new Position(startX, startY);
    ArrayList<Position> end;

    /**
     * Constructer of Map object
     * Loads map png to draw later
     * creates player & generates intial objects
     */

    public Map(){
        try{
            map = ImageIO.read(new File("src/main/resources/newMap.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        walls = generateWalls();

        tickTime = System.currentTimeMillis();
        startTime = System.currentTimeMillis();

        startX = 4; startY = 4;
        endX = 56; endY = 35; endHeight = 5;
        crumbsCollect = 0;
        CELLWIDTH = 25;

        cheeseExists = false;

        player = new Mouse(startX, startY, this);
        addCharacter(player);
        generateCrumbs();
        generateCats();
        generateMouseTraps();
        startTime = System.currentTimeMillis();
        tickTime = System.currentTimeMillis();
        catTickTime = System.currentTimeMillis();

        end = new ArrayList<Position>();
        for (int i = 0; i < endHeight; i++) {
            end.add(new Position(endX, endY + i));
        }
    }

    private int[][] generateWalls(){
        int[][] walls = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 },
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 },
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1 },
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1 },
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1 },
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1 },
            {1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,1,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1 },
            {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,1,0,1,1,1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,1,1,1,1 },
            {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0 },
            {1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0 },
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0 },
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0 },
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0 },
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 } };
        return walls;
    }

    private void generateCrumbs() {
        addItem(new Crumb(10,12));
        addItem(new Crumb(25, 12));
        addItem(new Crumb(10, 20));
        addItem(new Crumb(22, 18));
    }

    private void generateCats() {
        addCharacter(new Cat(12, 34, this));
        addCharacter(new Cat(36, 24, this));
        addCharacter(new Cat(43, 13, this));
    }

    private void generateMouseTraps() {
        addItem(new MouseTrap(23, 20));
        addItem(new MouseTrap(38, 34));
        addItem(new MouseTrap(55,5));
    }

    public int isWall(int x, int y) {
        return walls[y][x];
    }

     /**
      * This method is used to spawn/despawn cheese after a given time
      *
      * @param cheeseCollected - used to restart timer if item is collected
      */

    public void cheeseExist(boolean cheeseCollected) {
        if (cheeseCollected) { // if cheese is collected
            startTime = System.currentTimeMillis();
            cheeseExists = false;
        }
        timer = System.currentTimeMillis() - startTime;

        if (!cheeseExists && timer >= 5000) {
            // spawn after its been despawned for 5s
            c = new Cheese(this);
            addItem(c);
            cheeseExists = true;
            startTime = System.currentTimeMillis();
        }

        else if (cheeseExists && timer >= 12000){
            // if cheese uncollected for 12s
            this.removeItem(c);
            cheeseExists = false;
            startTime = System.currentTimeMillis();
        }
    }


    /**
     * Method is used to determine whether a tick or '1000ms' has passed
     * @return true or false depending whether 1000ms has passed
     */
    public boolean tick() {
        long time = System.currentTimeMillis();
        if (time >= tickTime + 250){
            tickTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public boolean catTick() {
        long time = System.currentTimeMillis();
        if (time >= catTickTime + 750){
            catTickTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    

    // Note: not on UML Diagram
    public ArrayList<Position> getEnd() {
        return end;
    }


    public Mouse getPlayer() {
        return player;
    }


    public ArrayList<Entity> getObjectsArray() {
        return objects;
    }


    // Note: not on UML Diagram
    public StaticEntity getItem(Position pos) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).pos.x == pos.x && items.get(i).pos.y == pos.y) {
                return items.get(i);
            }
        }
        return null;
    }


    public MovingEntity getCharacter(Position pos) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).pos.x == pos.x && characters.get(i).pos.y == pos.y) {
                return characters.get(i);
            }
        }
        return null;
    }


    public void addItem(StaticEntity item) {
        items.add(item);
        objects.add(item);
    }

    public void addCharacter(MovingEntity character) {
        characters.add(character);
        objects.add(character);
    }

    
    public void removeItem(StaticEntity item) {
        // Remove from objects ArrayList:
        Position pos = item.getPos();

        for (int i = 1; i < objects.size(); i++) {
            if (objects.get(i).pos.x == pos.x && objects.get(i).pos.y == pos.y) {
                objects.remove(i);
            }
        }
        // Remove from items array:
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).pos.x == pos.x && items.get(i).pos.y == pos.y) {
                items.remove(i);
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

        g.drawImage(map, 0,0, null);
        
        gameTime.displayTime(g);
        player.getMouseScore().displayScore(g);

        cheeseExist(false);

        if (tick()) {player.move();}
        
        if (catTick()) {
            
            for (int i = 1; i < characters.size(); i++) {
                Cat cat = (Cat) characters.get(i);
                cat.catchMouse(player.getPos());
            }
        }

        for (int i = 0; i < objects.size(); i++){
            objects.get(i).draw(g);
        }

       

    }
   
}
