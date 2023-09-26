public class Game {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();
        Screen screen = new Screen();
        State state = controller.state;
        //screen.printScreen(state);
        state.addBean(1,2);
        state.addBean(1,2);
        System.out.println(state.beans.get(1).number);
    }
}
