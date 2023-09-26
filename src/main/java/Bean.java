public class Bean {
    //CHERRY, CINNAMON, DIRT, VOMIT, TUTTI_FRUTTI, GRASS, EARTHWORM, BANANA
    String name;
    int number;

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
        if (number > this.number){
            //Exception
            return;
        }
        this.number -= number;
    }
}
