package events;

import state.State;
public abstract class Event {

    final State state;
    public Event(State state){
        this.state = state;
    }

    public abstract void start();

}
