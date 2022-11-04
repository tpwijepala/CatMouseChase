public abstract class StaticEntity extends Entity {
    public StaticEntity(int x, int y){
        super(x,y);
    }

    protected abstract int getPoints();
}
