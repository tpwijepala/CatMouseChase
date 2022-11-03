//package main.java;
import java.util.ArrayList;
// import java.util.Timer;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
//import javax.swing.*;


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

    StaticEntity[][] items = new StaticEntity[58][41];
    MovingEntity[][] characters = new MovingEntity[58][41];
    ArrayList<Entity> objects = new ArrayList<Entity>();

    int startX = 4, startY = 4;
    int endX = 0, endY = 0;
    int crumbsCollect = 0;

    final static int CELLWIDTH = 11;

    boolean cheeseExist = false;
    Entity c;
    long startTime;
    long timer;
    private Mouse player;

    Position start = new Position(startX, startY);
    Position end = new Position(endX, endY);

    /**
     * Sets up the characters on the map to their initial positions
     * 
     */
    public Map() {
        player = new Mouse(startX, startY, this);
        characters[startX][startY] = player;
        objects.add(player);
        generateCrumbs();
        generateCats();
        generateMouseTraps();

    }

    public Mouse getPlayer() {
        return player;
    }

    //Note: All crumb locations are placeholder
    private void generateCrumbs() {
        //41 down, 58 across
        Crumb c1 = new Crumb(10, 12);
        items[10][12] = c1;
        objects.add(c1);

        Crumb c2 = new Crumb(25, 12);
        items[25][12] = c2;
        objects.add(c2);

        Crumb c3 = new Crumb(10, 20);
        items[10][20] = c3;
        objects.add(c3);

        Crumb c4 = new Crumb(22, 18);
        items[22][18] = c4;
        objects.add(c4);
    }

    private void generateCats() {
        Cat cat1 = new Cat(12, 34);
        characters[49][17] = cat1;
        objects.add(cat1);

        Cat cat2 = new Cat(36, 24);
        characters[47][28] = cat2;
        objects.add(cat2);

        Cat cat3 = new Cat(43, 13);
        characters[29][33] = cat3;
        objects.add(cat3);
    }

    private void generateMouseTraps() {
        MouseTrap trap1 = new MouseTrap(23, 20);
        items[23][20] = trap1;
        objects.add(trap1);

        MouseTrap trap2 = new MouseTrap(38, 34);
        items[38][34] = trap2;
        objects.add(trap2);

        MouseTrap trap3 = new MouseTrap(55,5);
        items[55][5] = trap3;
        objects.add(trap3);
    }

    public static int isWall(int x, int y) {
        return walls[y][x];
    }

    public boolean cheeseExist(boolean cheeseDespawn) {
        if (cheeseDespawn) { // if cheese is collected or despawned
            startTime = System.currentTimeMillis();
            cheeseExist = false;
        }
        timer = System.currentTimeMillis() - startTime;

        if (!cheeseExist && timer >= 5000) {
            // spawn after its been despawned for 5s
            c = new Cheese(0,0);
            objects.add(c);
            cheeseExist = true;
        }

        else if (cheeseExist && timer >= 12000){
            // if cheese uncollected for 12s
            objects.remove(c);
            cheeseExist = false;
            startTime = System.currentTimeMillis();
        }
        return true;
    }

    private BufferedImage map;
    private Image cheesePic;
    Score score = new Score();
    GameTimer tt = new GameTimer();

    // Note: not on UML Diagram
    public void moveCharacter(Position oldPos, Position newPos) {
        MovingEntity temp = characters[oldPos.x][oldPos.y];
        characters[oldPos.x][oldPos.y] = null;
        characters[newPos.x][newPos.y] = temp;
    }

    // Note: not on UML Diagram
    public void removeItem(StaticEntity item) {
        // Remove from items array:
        items[item.pos.y][item.pos.x] = null;

        // Remove from objects ArrayList:
        for (int i = 1; i < objects.size(); i++) {
            if (objects.get(i).pos.x == item.pos.x && objects.get(i).pos.y == item.pos.y) {
                objects.remove(i);
            }
        }
    }

    // Note: not on UML Diagram
    public Position getEnd() {
        return end;
    }

    // Note: not on UML Diagram
    public StaticEntity getItem(Position pos) {
        return items[pos.getX()][pos.getY()];
    }

    public void drawEntities(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try{
            //map = ImageIO.read(new File("Documents/src/main/resources/map.png"));
            //cheesePic = ImageIO.read(new File("Documents/src/main/resources/cheese.png"));
            //File reads specific to my file system
            map = ImageIO.read(new File("src/main/resources/map.png"));
            cheesePic = ImageIO.read(new File("src/main/resources/cheese.png"));

        }catch(IOException e){
            e.printStackTrace();
        }

        g.drawImage(map, 0,0, null);
        
        tt.displayTime(g);
        score.displayScore(g);

        cheeseExist(false);
        if (cheeseExist){
            c.draw(g, cheesePic);
            System.out.println(c.getPos().x + " " + c.getPos().y);
        }

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).draw(g);
        }

    }
   
}

