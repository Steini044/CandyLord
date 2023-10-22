package inputHandler;

import screens.Screen;
import state.State;
import events.*;

import java.util.ArrayList;

public class GameEventHandler {

    private final State state;
    private final Screen screen;
    private final ArrayList<Event> normalEvents;
    public GameEventHandler(State state, Screen screen) {
        this.state = state;
        this.screen = screen;
        normalEvents = new ArrayList<>();
        normalEvents.add(new LowerPricesEvent(state, screen));
        normalEvents.add(new HigherPricesEvent(state, screen));
        normalEvents.add(new CoatEvent(state, screen));
        normalEvents.add(new WandEvent(state, screen));
        normalEvents.add(new FightEvent(state, screen));
    }


    public void startRandomEvent() {
        Event event = getRandomEvent();
        event.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Event getRandomNormalEvent(){
        int randomIndex = (int) (Math.random() * normalEvents.size());
        return normalEvents.get(randomIndex);
    }

    private Event getRandomEvent(){
        double random = Math.random();
        if(random < 0.05){
            return new RobbedEvent(state, screen);
        } else if (random < 0.4 && state.getBean(4) > 0) {
            return new LostAllGrasEvent(state, screen);
        } else return getRandomNormalEvent();
    }

    public void startDebtEvent() {
        if(state.getHealth() > 75){
            state.subtractHealth(25);
        } else {
            state.subtractHealth(50);
        }
        screen.printDebtEvent();
    }

}
