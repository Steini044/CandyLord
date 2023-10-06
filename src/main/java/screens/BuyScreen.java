package screens;

public class BuyScreen {
    protected void printBuyDialogueStart(){
        System.out.print(
                """
                                                                    *** BEANS ***\s
                        What kinda beans are              ----------------------------------\s
                        ya interested in?                                                     \s
                                                            1. Cherry          5. Gras\s
                                                            2. Banana          6. Earthworm\s
                                                            3. Tutti-Frutti    7. Dirt\s
                                                            4. Cinnamon        8. Vomit\s
                                                            """);
    }

    protected void printBuyDialogueSecondQuestion(int pickedNumber, int maxAffordableBeans){
        System.out.printf(
                """
                                                                    *** BEANS ***\s
                        What kinda beans are              ----------------------------------\s
                        ya interested in? %2d                                                  \s
                                                            1. Cherry          5. Gras\s
                        How many do ya wanna buy?           2. Banana          6. Earthworm\s
                        (%3d max.)                          3. Tutti-Frutti    7. Dirt\s
                                                            4. Cinnamon        8. Vomit\s
                                                            """,
                pickedNumber, maxAffordableBeans);
    }

    protected void printBuyDialogueNotEnoughHold(int pickedNumber, int maxAffordableBeans) {
        System.out.printf(
                """
                                                                    *** BEANS ***\s
                        What kinda beans are              ----------------------------------\s
                        ya interested in? %2d                                                  \s
                                                            1. Cherry          5. Gras\s
                        How many do ya wanna buy?           2. Banana          6. Earthworm\s
                        (%3d max.)                          3. Tutti-Frutti    7. Dirt\s
                        Dude, you can't hold that much!     4. Cinnamon        8. Vomit\s
                        Everyone´s got a limit, right?                                    
                         """,
                pickedNumber, maxAffordableBeans);
    }

    protected void printBuyDialogueNotEnoughCash(int pickedNumber, int maxAffordableBeans) {
        System.out.printf(
                """
                                                                    *** BEANS ***\s
                        What kinda beans are              ----------------------------------\s
                        ya interested in? %2d                                                  \s
                                                            1. Cherry          5. Gras\s
                        How many do ya wanna buy?           2. Banana          6. Earthworm\s
                        (%3d max.)                          3. Tutti-Frutti    7. Dirt\s
                        Hey man, if ya don't have enough    4. Cinnamon        8. Vomit\s
                        cash, don't come 'round here!              
                         """,
                pickedNumber, maxAffordableBeans);
    }
}
