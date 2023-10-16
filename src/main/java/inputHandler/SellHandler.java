package inputHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

import state.State;
import screens.Screen;

public class SellHandler {
    private final State state;

    public SellHandler(State state) {
        this.state = state;
    }

    public void handleSell() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);
        int pickedBeanNumber = 0;

        screen.printSellDialogueStart();

        boolean continueInput = true;
        do {
            try {
                pickedBeanNumber = input.nextInt();
                pickedBeanNumber--;
                if (state.getBean(pickedBeanNumber) == 0) {
                    screen.printSellDialogueZeroBeansHold(pickedBeanNumber + 1);
                    return;
                }
                continueInput = false;
            } catch (InputMismatchException ex) {
                input.nextLine();
            }
        }
        while (continueInput);

        screen.printSellDialogueSecondQuestion(pickedBeanNumber + 1);

        int numberOfBeansToSell;
        continueInput = true;

        do {
            try {
                numberOfBeansToSell = input.nextInt();
                if(numberOfBeansToSell <= state.getBean(pickedBeanNumber)) {
                    sellBeans(pickedBeanNumber, numberOfBeansToSell);
                } else {
                    screen.printSellDialogueNotEnoughBeansHold(pickedBeanNumber + 1);
                }
                continueInput = false;
            } catch (InputMismatchException ex) {
                input.nextLine();
            }
        }while(continueInput);
    }


    private void sellBeans(int pickedBeanNumber, int numberOfBeansToSell) {
        if (numberOfBeansToSell <= state.getBean(pickedBeanNumber)) {
            state.subtractBean(pickedBeanNumber,numberOfBeansToSell);
            int cashToAdd = state.getPriceOf(pickedBeanNumber) * numberOfBeansToSell;
            state.addCash(cashToAdd);
            updateStatusPoints(cashToAdd);
            state.nextDay();
        }
    }

    private void updateStatusPoints(int cashToAdd) {
        if(cashToAdd > 10000){
            state.addStatusPoints(10);
        } else if (cashToAdd > 9000) {
            state.addStatusPoints(9);
        } else if (cashToAdd > 8000) {
            state.addStatusPoints(8);
        } else if (cashToAdd > 7000) {
            state.addStatusPoints(7);
        } else if (cashToAdd > 6000) {
            state.addStatusPoints(6);
        } else if (cashToAdd > 5000) {
            state.addStatusPoints(5);
        } else if (cashToAdd > 4000) {
            state.addStatusPoints(4);
        } else if (cashToAdd > 3000) {
            state.addStatusPoints(3);
        } else if (cashToAdd > 2000) {
            state.addStatusPoints(2);
        }
    }
}
