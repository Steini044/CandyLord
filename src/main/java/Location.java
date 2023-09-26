public class Location {
    //HOGWARTS, OLLIVANDERS, THE_BURROW, HOGSMAEDE_VILLAGE, AZKABAN, MINISTRY_OF_MAGIC, MALFOY_MANOR, LITTLE_HANGLETON, GODRICS_HOLLOW
    String name;
    int[] prices;

    public Location(String name){
        this.name = name;
        prices = updatePrices();
    }

    private int[] updatePrices() {
        return new int[8];
    }
}
