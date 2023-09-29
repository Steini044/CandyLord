package items;

public class Wand {
    private String name;
    private int numberOfGuns;
    private int damage;

    public Wand(String name, int numberOfGuns, int damage){
        this.name = name;
        this.numberOfGuns = numberOfGuns;
        this.damage = damage;
    }
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getNumberOfGuns() {
        return numberOfGuns;
    }
}
