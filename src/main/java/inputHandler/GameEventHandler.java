package inputHandler;

import screens.Screen;
import state.State;
import events.*;

import java.util.ArrayList;

public class GameEventHandler {

    private final State state;
    private final ArrayList<Event> normalEvents;
    public GameEventHandler(State state) {
        this.state = state;
        normalEvents = new ArrayList<>();
        normalEvents.add(new LowerPricesEvent(state));
        normalEvents.add(new HigherPricesEvent(state));
        normalEvents.add(new CoatEvent(state));
        normalEvents.add(new WandEvent(state));
        normalEvents.add(new FightEvent(state));
    }


    public void startRandomEvent() {
        Event event = getRandomEvent();
        event.start();
    }

    private Event getRandomNormalEvent(){
        int randomIndex = (int) (Math.random() * normalEvents.size());
        return normalEvents.get(randomIndex);
    }

    private Event getRandomEvent(){
        double random = Math.random();
        if(random < 0.002){
            return new RobbedEvent(state);
        } else if (random < 0.4 && state.getBean(4) > 0) {
            return new LostAllGrasEvent(state);
        } else return getRandomNormalEvent();
    }

    public void startDebtEvent() {
        Screen screen = new Screen(state);
        if(state.getHealth() > 75){
            state.subtractHealth(25);
        } else {
            state.subtractHealth(50);
        }
        screen.printDebtEvent();
    }

}
