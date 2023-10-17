package inputHandler;

import screens.Screen;
import state.State;

import java.util.Scanner;

public class HospitalHandler {
    private final State state;
    private final Screen screen;

    public HospitalHandler(State state, Screen screen) {
        this.state = state;
        this.screen = screen;
    }

    public void handleHospital() {

        Scanner input = new Scanner(System.in);
        String cmd;

        if(state.getHealth() == state.getMaxHealth()){
            screen.printHospitalMaxHealth();
            cmd = input.next();
        } else {
            int cost = calculateCost(state.getHealth());
            screen.printHospitalCosts(cost);
            boolean continueInput = true;
            do{
                cmd = input.next();
                if(cmd.equalsIgnoreCase("y")){
                    continueInput = false;
                    if(cost <= state.getCash()){
                        state.fullHealth();
                        state.subtractCash(cost);
                    }
                } else if(cmd.equalsIgnoreCase("n")){
                    continueInput = false;
                }
            }while(continueInput);
        }
    }

    private int calculateCost(int health) {
        if(health < 0 || health > state.getMaxHealth()){
            throw new IllegalArgumentException("argument health: " + health + " was negative or bigger than maxHealth");
        }
        return ((state.getMaxHealth() - health) * 10);
    }
}
