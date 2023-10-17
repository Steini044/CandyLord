package inputHandler;

import java.util.InputMismatchException;
import java.util.Scanner;
import state.State;
import screens.Screen;

public class BankHandler {
    private final State state;
    private final Screen screen;


    public BankHandler(State state, Screen screen) {
        this.state = state;
        this.screen = screen;
    }

    public void handleBank() {
        Scanner input = new Scanner(System.in);
        String cmd;

        screen.printBankDialogueStart();

        boolean continueInput = true;
        do {
            cmd = input.next();
            if (cmd.equalsIgnoreCase("d")) {
                screen.printBankDialogueDeposit();
                deposit();
                continueInput = false;
            } else if (cmd.equalsIgnoreCase("w")) {
                screen.printBankDialogueWithdraw();
                withdraw();
                continueInput = false;
            }
        }while(continueInput);


    }

    private void deposit() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);

        int amount;
        boolean continueInput = true;

        do{
           try{
               amount = input.nextInt();
               if(amount > state.getCash() || amount < 0){
                   screen.printBankDialogueNotEnoughMoney();
               } else {
                   state.subtractCash(amount);
                   state.addDeposit(amount);
               }
               continueInput = false;
           }catch (InputMismatchException ex){
               input.nextLine();
           }
        }while(continueInput);
    }

    private void withdraw() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);

        int amount;
        boolean continueInput = true;

        do{
            try{
                amount = input.nextInt();
                if(amount > state.getCashInBank() || amount < 0){
                    screen.printBankDialogueNotEnoughMoneyInBank();
                } else {
                    state.addCash(amount);
                    state.withdrawDeposit(amount);
                }
                continueInput = false;
            }catch (InputMismatchException ex){
                input.nextLine();
            }
        }while(continueInput);
    }
}
