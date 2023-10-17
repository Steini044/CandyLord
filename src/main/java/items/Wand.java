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

    public void subtractNumberOfWands(int number) {
        if(number < numberOfWands && number > 0){
            numberOfWands -= number;
        } else {
            throw new IllegalArgumentException("argument" + number + "was negative or bigger than the number of Wands");
        }
    }
}
