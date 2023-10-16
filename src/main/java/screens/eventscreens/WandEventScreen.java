package screens.eventscreens;

public class WandEventScreen {
    public void printWandEvent(String name,int numberOfWands, int damage, int price) {
        System.out.printf(
                """
                        An ominous wizard, that you recognize from the Diagon Alley stands in front of you...\s
                        "EY you! ya wanna have some fun with a new wand? I've got the %s for you. I can give you"\s
                        %d copies of it, they deal %d damage each and all of this for only $%d! Its a one time-offer!\s
                                                                (Y/N) \s
                                                               """,name,numberOfWands,damage, price);
    }

    public void printWandEventSold() {
        System.out.print(
                """
                        "Here ya go! Have fun with your new wand!"\s
                                                               """);
    }

    public void printWandEventNotEnoughCash() {
        System.out.print(
                """
                        "You ain't got enough cash on ya bruv"\s
                                                               """);
    }
}
