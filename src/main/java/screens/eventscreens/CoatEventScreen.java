package screens.eventscreens;

public class CoatEventScreen {
    public void printCoatEvent(int newHold, int price) {
        System.out.printf(
                """
                        An ominous wizard, that you recognize from the Diagon Alley stands in front of you...\s
                        "Hey you! Do you wanna buy a new fresh robe? It can hold up to %d for only $%d!"\s
                                                                (Y/N) \s
                                                               """,newHold, price);
    }

    public void printCoatEventSold() {
        System.out.print(
                """
                        "Here ya go! Have fun with your new robe!"\s
                                                               """);
    }

    public void printCoatEventNotEnoughCash() {
        System.out.print(
                """
                        "You ain't got enough cash on ya bruv"\s
                                                               """);
    }
}
