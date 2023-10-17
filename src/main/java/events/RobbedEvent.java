package events;

import screens.Screen;
import state.State;

public class RobbedEvent extends  Event{
    public RobbedEvent(State state, Screen screen) {
        super(state, screen);
    }

    @Override
    public void start() {
        screen.printRobbedEvent();
        state.subtractCash(state.getCash());
    }
}
