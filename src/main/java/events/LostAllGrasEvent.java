package events;

import screens.Screen;
import state.State;

public class LostAllGrasEvent extends Event{
    public LostAllGrasEvent(State state, Screen screen) {
        super(state, screen);
    }

    @Override
    public void start() {
        screen.printLostAllGrasEvent();
        state.subtractBean(4, state.getBean(4));
    }
}
