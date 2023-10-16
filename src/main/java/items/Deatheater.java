package items;

public class Deatheater extends Fighter{
    public Deatheater(Wand wand, int health) {
        super(wand, health);
    }

    public void setWand(Wand newWand){
        this.wand = newWand;
    }


}
