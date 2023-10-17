package inputHandler;

import screens.Screen;
import state.State;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanSharkHandler {
    private final State state;
    private final Screen screen;
    public LoanSharkHandler(State state, Screen screen) {
        this.state = state;
        this.screen = screen;
    }

    public void handleLoanShark() {
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
            } else if (cmd.equalsIgnoreCase("p")) {
                if(!state.getDebt()){
                    screen.printLoanSharkDialogueNotInDebt();
                } else {
                    screen.printLoanSharkDialoguePayBack();
                    payBack();
                }
                continueInput = false;
            }
        }while(continueInput);
    }

    private void borrow() {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        int amount;

        do{
            try{
                amount = input.nextInt();
                if(amount < 1000){
                    screen.printLoanSharkDialogueTooLessMoney();
                } else if(amount > state.getStatusPoints() * 5000){
                    screen.printLoanSharkDialogueTooMuchMoney();
                } else if (state.getCashInDebt() > 5000 * state.getStatusPoints()) {
                    screen.printLoanSharkDialogueAlreadyInDebt(state.getCashInDebt());
                } else {
                    state.addCash(amount);
                    state.addCashInDebt(amount);
                    setDebtCounter(amount);
                    screen.printLoanSharkDialogueCountdownStarted(state.getDebtCounter());
                    state.nextDay();
                }
                continueInput = false;
            }catch(InputMismatchException ex){
                input.nextLine();
            }
        }while(continueInput);
    }

    private void setDebtCounter(int amount) {
        if(amount < 1500){
            state.setDebtCounter(15);
        } else if (amount < 1750) {
            state.setDebtCounter(13);
        } else if (amount < 2000) {
            state.setDebtCounter(12);
        } else if (amount < 2500) {
            state.setDebtCounter(11);
        } else if (amount < 3500) {
            state.setDebtCounter(10);
        } else if (amount < 4500) {
            state.setDebtCounter(8);
        } else if (amount < 5000) {
            state.setDebtCounter(7);
        } else if (amount < 8000) {
            state.setDebtCounter(6);
        } else if (amount < 10000) {
            state.setDebtCounter(4);
        } else {
            state.setDebtCounter(3);
        }
    }

    private void payBack() {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        int amount;

        do{
            try{
                amount = input.nextInt();
                if(amount < 0) {
                    input.nextLine();
                    continue;
                } else if(amount > state.getCash()){
                    screen.printLoanSharkDialogueNotEnoughMoney();
                } else if (amount < state.getCashInDebt() && amount != 0) {
                    state.subtractCash(amount);
                    state.subtractCashInDebt(amount);
                    screen.printLoanSharkDialogueStillDebtRemaining(state.getCashInDebt());
                    state.nextDay();
                } else {
                    state.subtractCashInDebt(state.getCashInDebt());
                    state.subtractCash(amount);
                    state.setDebt(false);
                    screen.printLoanSharkDialoguePaidInFull();
                    state.nextDay();
                }
                continueInput = false;
            }catch(InputMismatchException ex){
                input.nextLine();
            }

        }while(continueInput);
    }
}
