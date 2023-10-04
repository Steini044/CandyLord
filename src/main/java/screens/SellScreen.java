package screens;

public class SellScreen {
    public void printSellDialogueStart() {
        System.out.print(
                """
                                                                    *** BEANS ***\s
                        What kinda beans do              ----------------------------------\s
                        ya want to unload?                                                  \s
                                                            1. Cherry          5. Gras\s
                                                            2. Banana          6. Earthworm\s
                                                            3. Tutti-Frutti    7. Dirt\s
                                                            4. Cinnamon        8. Vomit\s
                                                            """
        );
    }

    public void printSellDialogueZeroBeansHold(int pickedBeanNumber) {
        System.out.printf(
                """
                                                                    *** BEANS ***\s
                        What kinda beans do              ----------------------------------\s
                        ya want to unload? %2d                                               \s
                                                            1. Cherry          5. Gras\s
                        Give me a break, man, you           2. Banana          6. Earthworm\s
                        ain't got any of that!              3. Tutti-Frutti    7. Dirt\s
                                                            4. Cinnamon        8. Vomit\s
                                                            """,
                pickedBeanNumber);
    }

    public void printSellDialogueSecondQuestion(int pickedBeanNumber) {
        System.out.printf(
                """
                                                                    *** BEANS ***\s
                        What kinda beans do              ----------------------------------\s
                        ya want to unload? %2d                                                 \s
                                                            1. Cherry          5. Gras\s
                        How many do ya wanna sell?          2. Banana          6. Earthworm\s
                                                            3. Tutti-Frutti    7. Dirt\s
                                                            4. Cinnamon        8. Vomit\s
                                                            """,
                pickedBeanNumber);
    }

    public void printSellDialogueNotEnoughBeansHold(int pickedBeanNumber) {
        System.out.printf(
                """
                                                                    *** BEANS ***\s
                        What kinda beans do              ----------------------------------\s
                        ya want to unload? %2d                                                 \s
                                                            1. Cherry          5. Gras\s
                        I happen to know that you ain't     2. Banana          6. Earthworm\s
                        that much on ya, so quit trying     3. Tutti-Frutti    7. Dirt\s
                        to burn me!                         4. Cinnamon        8. Vomit\s
                                                            """,
                pickedBeanNumber);
    }
}
