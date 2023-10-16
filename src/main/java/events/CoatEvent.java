package events;

import screens.Screen;
import state.State;

import java.util.Scanner;

public class CoatEvent extends Event{

    public CoatEvent(State state) {
        super(state);
    }

    @Override
    public void start() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);
        String cmd;
        int price;

        int newHold = getNewHold();
        if(newHold < 50){
            price = 500;
        } else {
            price = 1500;
        }
        boolean continueInput = true;

        screen.printCoatEvent(newHold, price);
        do{
            cmd = input.next();
            if(cmd.equalsIgnoreCase("y")){
                if(state.getCash() >= price){
                    state.subtractCash(price);
                    state.setHoldMax(newHold);
                    screen.printCoatEventSold();
                } else {
                    screen.printCoatEventNotEnoughCash();
                }
                continueInput = false;
            } else if(cmd.equalsIgnoreCase("n")){
                continueInput = false;
            }
        }while(continueInput);
    }

    private int getNewHold() {
        if(Math.random() < 0.5){
            return 20;
        } else {
            return 50;
        }
    }
}


