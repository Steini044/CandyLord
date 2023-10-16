package items;

public class Wand {
    private final String name;

    private int numberOfWands;

    private final int damage;
    private final int price;
    public Wand(String name, int numberOfWands, int damage, int price){
        this.name = name;
        this.numberOfWands = numberOfWands;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }

    public int getNumberOfWands() {
        return numberOfWands;
    }

    public int getPrice() {
        return price;
    }

    public void setNumberOfWands(int numberOfWands) {
        if(numberOfWands < this.numberOfWands && numberOfWands > 0){
            this.numberOfWands = numberOfWands;
        } else {
            //Exception
            return;
        }
    }
}
