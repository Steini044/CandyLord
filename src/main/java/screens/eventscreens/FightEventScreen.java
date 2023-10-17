package screens.eventscreens;

public class FightEventScreen {
    public void printFightEventStart() {
        System.out.print(
                """
                        You are getting stopped by the Department of Magical Law Enforcement\s
                        A fight is about to start do you wanna use your status Points to hire\s
                                        some deatheaters to fight alongside you?\s
                                                    (Y/N)
                                                               """);
    }

    public void printFightEventRecruiting() {
        System.out.print(
                """
                        How many deatheaters do you wanna recruit?\s
                              (1 Status Point = 1 deatheater)\s
                                                               """);
    }

    public void printFightEventNotEnoughStatus() {
        System.out.print(
                """
                        Come on now bruv, you not even close to be famous enough\s
                        to recrute that many deatheaters\s
                                                               """);
    }

    public void printFightEventMainScreen() {
        System.out.print(
                """
                        This is the following Situation:\s
                                                               """);
    }

    public void printFightEventYourself(int health, int wandDamage) {
        System.out.printf(
                """
                        You have %d health and can deal up to %d damage!\s
                                                               """, health, wandDamage);
    }

    public void printFightEventCompanion(int number, int health, int damage) {
        System.out.printf(
                """
                        Deatheater%d has %d health and can deal up to %d damage!\s
                                                               """,number, health, damage);
    }

    public void printFightEventPolicemen(int number, int health, int damage) {
        System.out.printf(
                """
                        Policeman%d has %d health and  can deal up to %d damage!\s
                                                               """,number, health, damage);
    }

    public void printFightEventOptions() {
        System.out.print(
                """
                        You have the following options:\s
                        (A)ttack a policeman\s
                        (F)lee\s
                                                               """);
    }

    public void printFightEventSuccessfulEscape() {
        System.out.print(
                """
                        You successfully fled like the coward you are!\s
                        At least you are safe for now ... \s
                                                               """);
    }

    public void printFightEventAttackWho() {
        System.out.print(
                """
                        Which cop do you want to attack?\s
                                                               """);
    }

    public void printFightEventAllCopsDefeated() {
        System.out.print(
                """
                        You defeated all the cops, you are safe ... for now ...\s
                                                               """);
    }

    public void printFightEventUnsuccessfulEscape() {
        System.out.print(
                """
                        You will never escape these cops you coward!\s
                                                               """);
    }
}
