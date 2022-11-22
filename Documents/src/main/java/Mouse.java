import javax.imageio.ImageIO;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Mouse extends MovingEntity{
    //private Image picture;  // mousePic can be declared const and given an initial value once a picture is found and included in files
    //private Position mousePosition;
    //Position pos;
    Map map;
    private Score playerScore = new Score();
    Position newPos;

    public Mouse(int x, int y, Map m) {
        super(x,y);
        map = m;
        newPos = pos;
        try{
            picture = ImageIO.read(new File("src/main/resources/mouse.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Position getMousePosition() {
        return pos;
    }

    public void checkFinish() {
        ArrayList<Position> end = map.getEnd();
        System.out.println(map.crumbsCollect);
        if (map.crumbsCollect >= 4) {
            for (int i = 0; i < end.size(); i++){
                if (getPos().getX() == end.get(i).getX() && getPos().getY() == end.get(i).getY()){
                    
                    Game.State = Game.STATE.WIN;
                }
            }
        }
    }

    public void collectItem() {
        StaticEntity item = Map.getItem(getPos());
        if (item != null) {
            playerScore.setScore(item.getPoints());
            
            if (item instanceof Cheese)
                map.cheeseExist(true);

            if (item instanceof Crumb)
                map.crumbsCollect++;
            
            if (playerScore.checkScoreBelowZero() == true) {
                Game.State = Game.STATE.LOSE;
            }

            else {
                map.removeItem(item);
            }
            
        }
    }

    public Score getMouseScore() {
        return playerScore;
    }

}
