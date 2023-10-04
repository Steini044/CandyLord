package inputHandler;

import screens.Screen;
import state.State;

import java.util.Scanner;

public class LoanSharkHandler {
    private State state;
    public LoanSharkHandler(State state) {
        this.state = state;
    }

    public void handleLoanShark() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);
        String cmd;

        screen.printLoanSharkDialogueStart();
        boolean continueInput = true;

        do{
            cmd = input.next();
            if(cmd.equalsIgnoreCase("b")){
                screen.printLoanSharkDialogueBorrow();
                borrow();
                continueInput = false;
            } else if (cmd.equalsIgnoreCase("w")) {
                screen.printLoanSharkDialoguePayBack();
                payBack();
                continueInput = false;
            }
        }while(continueInput);

    }

    private void borrow() {
        //TODO
        //Day countdown und Schuldenerhöhungen
    }

    private void payBack() {
        //TODO
    }
}
