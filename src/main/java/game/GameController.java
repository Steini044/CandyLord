package game;

import inputHandler.*;
import items.Bean;
import screens.Screen;
import state.State;
import state.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    private State state;
    private BuyHandler buyHandler;
    private SellHandler sellHandler;
    private JetHandler jetHandler;
    private void initGame() {
        //getRandomStartLocation()
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Hogwarts"));
        locations.add(new Location("Ollivanders"));
        locations.add(new Location("Hogsmaede Village"));
        locations.add(new Location("Azkaban"));
        locations.add(new Location("Ministry of Magic"));
        locations.add( new Location("Malfoy Manor"));
        locations.add(new Location("Little Hangleton"));
        locations.add(new Location("Godrics Hollow"));

        state = new State(getRandomLocation(locations));
        state.addBeanToBeans(new Bean("Cherry"));
        state.addBeanToBeans(new Bean("Banana"));
        state.addBeanToBeans(new Bean("Tutti-Frutti"));
        state.addBeanToBeans(new Bean("Cinnamon"));
        state.addBeanToBeans(new Bean("Gras"));
        state.addBeanToBeans(new Bean("Earthworm"));
        state.addBeanToBeans(new Bean("Dirt"));
        state.addBeanToBeans(new Bean("Vomit"));

        buyHandler = new BuyHandler(state);
        sellHandler = new SellHandler(state);
        jetHandler = new JetHandler(state, locations);
    }

    private Location getRandomLocation(ArrayList<Location> locations){
        int randomIndex = (int) (Math.random() * locations.size());
        return locations.get(randomIndex);
    }
    public void startGame() {
        initGame();
        boolean done = false;
        Scanner input = new Scanner(System.in);
        String cmd;
        Screen screen = new Screen(state);

        do{
            //state.updatePrices();
            screen.printMainscreen();
            screen.printMainDialogue();
            cmd = input.next();
            if(cmd.equalsIgnoreCase("b")){
                buyHandler.handleBuy();
            } else if(cmd.equalsIgnoreCase("s")) {
                sellHandler.handleSell();
            } else if (cmd.equalsIgnoreCase("j")) {
                jetHandler.handleJet();
            } else if (cmd.equalsIgnoreCase("q")){
                done = true;
            }
        }while(!done);
    }
}
