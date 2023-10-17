package events;

import screens.Screen;
import state.State;

public class HigherPricesEvent extends Event {

    public HigherPricesEvent(State state, Screen screen) {
        super(state, screen);
    }

    @Override
    public void start() {
        int numberOfBeanToIncreaseThePriceOf = getRandomNumber(3,1);
        int numberOfMaxBeans = state.getBeansSize();
        double factor = 0.9;

        switch(numberOfBeanToIncreaseThePriceOf){
            case 1 -> {
                int beanNumber = getRandomNumber(numberOfMaxBeans, 0);
                screen.printHigherPricesEvent(state.getBeanName(beanNumber));
                state.increaseOnePrice(beanNumber, factor);
            }
            case 2 -> {
                int beanNumber = getRandomNumber(numberOfMaxBeans, 0);
                int beanNumber2 = getRandomNumber(numberOfMaxBeans, 0);
                while(beanNumber2 == beanNumber){
                    beanNumber2 = getRandomNumber(numberOfMaxBeans, 0);
                };
                screen.printHigherPricesEvent(state.getBeanName(beanNumber), state.getBeanName(beanNumber2));
                state.increaseOnePrice(beanNumber, factor);
                state.increaseOnePrice(beanNumber2, factor);
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
                screen.printHigherPricesEvent(state.getBeanName(beanNumber), state.getBeanName(beanNumber2), state.getBeanName(beanNumber3));
                state.increaseOnePrice(beanNumber, factor);
                state.increaseOnePrice(beanNumber2, factor);
                state.increaseOnePrice(beanNumber3, factor);
            }
            default -> {}
        }
    }


    private int getRandomNumber(int max, int min){
        return (int) (Math.random() * max + min);
    }
}

