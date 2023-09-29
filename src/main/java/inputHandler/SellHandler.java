package inputHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

import state.State;
import screen.Screen;

public class SellHandler {
    State state;

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
                    screen.printSellDialogueNotEnoughBeans();
                    return;
                }
                continueInput = false;
            } catch (InputMismatchException ex) {
                input.nextLine();
            }
        }
        while (continueInput);

        screen.printSellDialogueSecondQuestion();

        int numberOfBeansToSell;

        try {
            numberOfBeansToSell = input.nextInt();
            if (numberOfBeansToSell <= state.getBean(pickedBeanNumber)) {
                sellBeans(pickedBeanNumber, numberOfBeansToSell);
            } else{
                //Print why we return
                System.out.println("Not enough Beans to sell!!!");
                return;
            }
        } catch (InputMismatchException ex) {
            input.nextLine();
        }
    }


    private void sellBeans(int pickedBeanNumber, int numberOfBeansToSell) {
        if (numberOfBeansToSell <= state.getBean(pickedBeanNumber)) {
            state.subtractBean(pickedBeanNumber,numberOfBeansToSell);
            int cashToAdd = state.getPriceOf(pickedBeanNumber) * numberOfBeansToSell;
            state.addCash(cashToAdd);
        }
    }
}
