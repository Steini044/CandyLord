package inputHandler;

import screens.Screen;
import state.State;

import java.util.Scanner;

public class HospitalHandler {
    private final State state;

    public HospitalHandler(State state) {
        this.state = state;
    }

    public void handleHospital() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);
        String cmd;

        if(state.getHealth() == 100){
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

        //Anschauen was passiert wenn nicht healthy, irgendwie Geld ausgeben um Leben wieder anzuheben?
    }

    private int calculateCost(int health) {
        if(health < 0 || health > 100){
            //exception
            return 0;
        }
        return ((100 - health) * 10);
    }
}
