package inputHandler;

import java.util.InputMismatchException;
import java.util.Scanner;
import state.State;
import screen.Screen;

public class BuyHandler {
    State state;
    public BuyHandler(State state){
        this.state = state;
    }

    public void handleBuy() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);
        int pickedBeanNumber = 0;
        int maxAffordableBeans = 0;

        screen.printBuyDialogueStart();

        boolean continueInput = true;
        do {
            try {
                pickedBeanNumber = input.nextInt();
                switch (pickedBeanNumber) {
                    case 1, 2, 3, 4, 5, 6, 7, 8 -> {
                        pickedBeanNumber--;
                        maxAffordableBeans = maxBeansAbleToBuy(pickedBeanNumber);
                        screen.printBuyDialogueSecondQuestion(pickedBeanNumber, maxAffordableBeans);
                        continueInput = false;
                    }
                    default -> {
                    }
                }
            } catch (InputMismatchException ex) {
                input.nextLine();
            }
        }
        while (continueInput);

        continueInput = true;
        int numberOfBeansToBuy;

        do {
            try {
                numberOfBeansToBuy = input.nextInt();
                if (numberOfBeansToBuy <= state.getHold() && numberOfBeansToBuy <= maxAffordableBeans) {
                    buyBeans(pickedBeanNumber, numberOfBeansToBuy);
                    continueInput = false;
                }
            } catch (InputMismatchException ex) {
                input.nextLine();
            }
        }
        while (continueInput);
    }

    private int maxBeansAbleToBuy(int pickedBeanNumber) {
        int result;
        result = (int) (state.getCash() / state.getPriceOf(pickedBeanNumber));
        return result;
    }

    private void buyBeans(int pickedBeanNumber, int numberOfBeansToBuy) {
        if (numberOfBeansToBuy <= state.getHold() && numberOfBeansToBuy <= maxBeansAbleToBuy(pickedBeanNumber)){
            state.subtractCash(numberOfBeansToBuy * state.getPriceOf(pickedBeanNumber));
            state.addBean(pickedBeanNumber,numberOfBeansToBuy);
        }
    }
}
