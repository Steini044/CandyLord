import java.util.Scanner;

public class GameController {

    State state;
    private void initGame() {
        //getRandomStartLocation()
        Location randomLocation = new Location("Hogwarts");
        state = new State(randomLocation);
    }

    public void startGame() {
        initGame();
        Scanner input = new Scanner(System.in);
        String cmd;
        //DO WHILE (!Done)
    }
}
