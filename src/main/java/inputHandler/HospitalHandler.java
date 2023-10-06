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

        if(state.getHealth() == 100){
            screen.printHospitalMaxHealth();
            Scanner input = new Scanner(System.in);
            String cmd = input.next();
        } else {


        }




        //Anschauen was passiert wenn nicht healthy, irgendwie Geld ausgeben um Leben wieder anzuheben?
    }
}
