package state;

public class Location {
    //HOGWARTS, OLLIVANDERS, THE_BURROW, HOGSMAEDE_VILLAGE, AZKABAN, MINISTRY_OF_MAGIC, MALFOY_MANOR, LITTLE_HANGLETON, GODRICS_HOLLOW
    String name;
    int[] prices = new int[8];

    public Location(String name){
        this.name = name;
        updatePrices();
    }

    public void updatePrices() {
        prices[7] = randomNumber(7, 21);
        prices[6] = randomNumber(70, 120);
        prices[5] = randomNumber(210, 399);
        prices[4] = randomNumber(500, 1500);
        prices[3] = randomNumber(1999, 4000);
        prices[2] = randomNumber(6000, 15000);
        prices[1] = randomNumber(17000, 27000);
        prices[0] = randomNumber(29999, 60000);
    }

    private int randomNumber(int min, int max){
        return (int) (Math.random() * (max - min) ) + min;
    }

    public int getPriceOf(int number){
        if(number < 0 || number > 7){
            //Exception
            return 0;
        }
        return prices[number];
    }
}
