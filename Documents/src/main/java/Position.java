public class Position {
    protected int x;
    protected int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getters and setters are new to position class compared to UML
    public int getX() {
        return x;
    }
    public void setX(int newX) {
        x = newX;
    }

    public int getY() {
        return y;
    }
    public void setY(int newY) {
        y = newY;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}