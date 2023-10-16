package events;

import screens.Screen;
import state.State;

public class RobbedEvent extends  Event{
    public RobbedEvent(State state) {
        super(state);
    }

    @Override
    public void start() {
        Screen screen = new Screen(state);

        screen.printRobbedEvent();
        state.subtractCash(state.getCash());
    }
}
