package events;

import screens.Screen;
import state.State;

public class LostAllGrasEvent extends Event{
    public LostAllGrasEvent(State state) {
        super(state);
    }

    @Override
    public void start() {
        Screen screen = new Screen(state);
        screen.printLostAllGrasEvent();

        state.subtractBean(4, state.getBean(4));
    }
}
