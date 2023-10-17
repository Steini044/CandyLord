package events;

import items.Wand;
import screens.Screen;
import state.State;

import java.util.ArrayList;
import java.util.Scanner;

public class WandEvent extends Event {
    ArrayList<Wand> wands = new ArrayList<>();
    public WandEvent(State state, Screen screen) {
        super(state, screen);
        wands.add(new Wand("Elder Wand", 1,100, 10000));
        wands.add(new Wand("Ash Wand",2,50, 500));
        wands.add(new Wand("Birch Wand", 3, 30, 300));
        wands.add(new Wand("Hazel Wand", 4, 20, 150));
    }

    @Override
    public void start() {
        Scanner input = new Scanner(System.in);
        String cmd;

        Wand randomWand = getRandomWand();
        int price = randomWand.getPrice();
        boolean continueInput = true;

        screen.printWandEvent(randomWand.getName(), randomWand.getNumberOfWands(), randomWand.getDamage(), price);
        do{
            cmd = input.next();
            if(cmd.equalsIgnoreCase("y")){
                if(state.getCash() >= price){
                    state.subtractCash(price);
                    state.setWand(randomWand);
                    screen.printWandEventSold();
                } else {
                    screen.printWandEventNotEnoughCash();
                }
                continueInput = false;
            } else if(cmd.equalsIgnoreCase("n")){
                continueInput = false;
            }
        }while(continueInput);
    }

    private Wand getRandomWand() {
        int randomIndex = (int) (Math.random() * (wands.size() + 1) - 1);
        return wands.get(randomIndex);
    }
}
