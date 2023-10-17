package inputHandler;

import screens.Screen;
import state.Location;
import state.State;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JetHandler {
    private final State state;
    private final ArrayList<Location> locations;
    private final Screen screen;
    public JetHandler(State state, ArrayList<Location> locations, Screen screen) {
        this.state = state;
        this.locations = locations;
        this.screen = screen;
    }

    public void handleJet() {
        Scanner input = new Scanner(System.in);

        int pickedLocation;
        int[] prices = new int[locations.size()];

        prices = getAllPrices(locations, state.getCurrentLocation());
        screen.printJetDialogueStart(locations, prices);

        boolean continueInput = true;
        do{
            try{
                pickedLocation = input.nextInt();
                switch (pickedLocation) {
                    case 1, 2, 3, 4, 5, 6, 7, 8 -> {
                        pickedLocation--;
                        int priceToJet = prices[pickedLocation];
                        if(priceToJet == 0){
                            screen.printJetDialogueYourLocation(locations, prices);
                        } else if (priceToJet > state.getCash()) {
                            screen.printJetDialogueNotEnoughCash(locations, prices);
                        } else {
                            state.subtractCash(priceToJet);
                            state.setCurrentLocation(locations.get(pickedLocation));
                            state.updatePrices();
                            state.nextDay();
                        }
                        continueInput = false;
                    }
                    default -> {
                    }
                }
            } catch(InputMismatchException ex){
                input.nextLine();
            }
        }while(continueInput);
    }

    private int getPrice(Location startLocation, Location endLocation){
        if(startLocation.getName().equals(endLocation.getName())){
            return 0;
        }
        double price = startLocation.getPosition().distance(endLocation.getPosition()) + 1;
        return (int) (price * 10);
    }

    private int[] getAllPrices(ArrayList<Location> locations, Location startLocation) {
        int[] result = new int[locations.size()];
        for (int i = 0; i < locations.size(); i++) {
            result[i] = getPrice(startLocation, locations.get(i));
        }
        return result;
    }
}
