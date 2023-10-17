package events;

import screens.Screen;
import state.State;
public abstract class Event {

    final State state;
    final Screen screen;
    public Event(State state, Screen screen){
        this.state = state;
        this.screen = screen;
    }

    public abstract void start();

}
