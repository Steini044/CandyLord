package items;

public class Bean {
    //CHERRY, CINNAMON, DIRT, VOMIT, TUTTI_FRUTTI, GRASS, EARTHWORM, BANANA
    private final String name;
    private int number;

    public Bean(String name){
        this.name = name;
        this.number = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void add(int number) {
        this.number += number;
    }

    public void subtract(int number) {
        if (number > this.number || number < 0){
            throw new IllegalArgumentException("argument number: " + number + " was negative or bigger than the number of beans");
        }
        this.number -= number;
    }
}
