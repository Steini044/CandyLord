package events;

import screens.Screen;
import state.State;

public class LowerPricesEvent extends Event {

    public LowerPricesEvent(State state) {
        super(state);
    }

    @Override
    public void start() {
        int numberOfBeansToReduceThePriceOf = getRandomNumber(3,1);
        int numberOfMaxBeans = state.getBeansSize();
        Screen screen = new Screen(state);
        double factor = 0.3;

        switch(numberOfBeansToReduceThePriceOf){
            case 1 -> {
                int beanNumber = getRandomNumber(numberOfMaxBeans, 0);
                screen.printLowerPricesEvent(state.getBeanName(beanNumber));
                state.reduceOnePrice(beanNumber, factor);
            }
            case 2 -> {
                int beanNumber = getRandomNumber(numberOfMaxBeans, 0);
                int beanNumber2 = getRandomNumber(numberOfMaxBeans, 0);
                while(beanNumber2 == beanNumber){
                    beanNumber2 = getRandomNumber(numberOfMaxBeans, 0);
                };
                screen.printLowerPricesEvent(state.getBeanName(beanNumber), state.getBeanName(beanNumber2));
                state.reduceOnePrice(beanNumber, factor);
                state.reduceOnePrice(beanNumber2, factor);
            }
            case 3 -> {
                int beanNumber = getRandomNumber(numberOfMaxBeans, 0);
                int beanNumber2 = getRandomNumber(numberOfMaxBeans, 0);
                int beanNumber3 = getRandomNumber(numberOfMaxBeans, 0);
                while(beanNumber2 == beanNumber){
                    beanNumber2 = getRandomNumber(numberOfMaxBeans, 0);
                };
                while(beanNumber3 == beanNumber || beanNumber3 == beanNumber2){
                    beanNumber3 = getRandomNumber(numberOfMaxBeans, 0);
                }
                screen.printLowerPricesEvent(state.getBeanName(beanNumber), state.getBeanName(beanNumber2), state.getBeanName(beanNumber3));
                state.reduceOnePrice(beanNumber, factor);
                state.reduceOnePrice(beanNumber2, factor);
                state.reduceOnePrice(beanNumber3, factor);
            }
            default -> {}
        }
    }


    private int getRandomNumber(int max, int min){
        return (int) (Math.random() * max + min);
    }
}
