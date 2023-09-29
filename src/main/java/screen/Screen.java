package screen;

import state.State;

public class Screen {
    State state;
    public Screen(State state) {
        this.state = state;
    }

    public void printMainscreen(){
        System.out.printf(
                """
                        ╔═════════════════════════════════════════════════════════════════════════════╗\s
                        ║                       * * * B E A N  L O R D * * *                          ║\s
                        ╠═══ State.Date: 09/28/90 ═════════════════════╦══════════════════════════════╣\s
                        ║                                              ║       Location: Los Angeles  ║\s
                        ╠═══ Beans on Hand ═══╦════ Street Prices ═════╣       Hold: %2d     (%2d max)  ║\s
                        ║                     ║                        ║                              ║\s
                        ║   Cherry         %2d ║   Cherry        %5d  ║       Cash:  $%5d          ║\s
                        ║   Banana         %2d ║   Banana        %5d  ║    In Bank:  $%5d          ║\s
                        ║   Tutti-Frutti   %2d ║   Tuttu-Frutti  %5d  ║    In Debt:  $%5d          ║\s
                        ║   Cinnamon       %2d ║   Cinnamon      %5d  ║                              ║\s
                        ║   Gras           %2d ║   Gras          %5d  ║  # of Guns: %2d               ║\s
                        ║   Earthworm      %2d ║   Earthworm     %5d  ║   Gun Type: None             ║\s
                        ║   Dirt           %2d ║   Dirt          %5d  ║                              ║\s
                        ║   Vomit          %2d ║   Vomit         %5d  ║  Status Pts: %2d              ║\s
                        ║                     ║                        ║      Health: %3d             ║\s
                        ╚═════════════════════╩════════════════════════╩══════════════════════════════╝\s
                        """
                ,state.getHold(), state.getHoldMax(), state.getBean(0), state.getPriceOf(0), state.getCash(), state.getBean(1), state.getPriceOf(1),
                state.getCashInBank(), state.getBean(2), state.getPriceOf(2), state.getCashInDebt(), state.getBean(3), state.getPriceOf(3),
                state.getBean(4), state.getPriceOf(4), state.getNumberOfWands(),state.getBean(5), state.getPriceOf(5),
                state.getBean(6), state.getPriceOf(6), state.getBean(7), state.getPriceOf(7),  state.getStatusPoints(), state.getHealth());
    }
    public void printMainDialogue(){
        System.out.print(
                """
                                                                                        (Q)uit the game\s
                                          Here's a list of possible plans dude\s
                                     (B)uy Drugs,                  (V)isit de Bank,\s
                                     (S)ell Drugs                  Go to the (H)ospital,\s
                                     (J)et to another city,        See the (L)oan Shark\s

                                                      Make up your mind ► \s
                        """);
    }

    public void printBuyDialogueStart(){
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

    public void printBuyDialogueSecondQuestion(int pickedNumber, int maxAffordableBeans){
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
                pickedNumber + 1, maxAffordableBeans);
    }

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

    public void printSellDialogueNotEnoughBeans() {
        System.out.print(
                """
                                                                    *** BEANS ***\s
                        What kinda beans do              ----------------------------------\s
                        ya want to unload?                                                  \s
                                                            1. Cherry          5. Gras\s
                        Give me a break, man, you           2. Banana          6. Earthworm\s
                        ain't got any of that!              3. Tutti-Frutti    7. Dirt\s
                                                            4. Cinnamon        8. Vomit\s
                                                            """
        );
    }

    public void printSellDialogueSecondQuestion() {
        System.out.print(
                """
                                                                    *** BEANS ***\s
                        What kinda beans do              ----------------------------------\s
                        ya want to unload?                                                  \s
                                                            1. Cherry          5. Gras\s
                        How many do ya wanna sell?          2. Banana          6. Earthworm\s
                                                            3. Tutti-Frutti    7. Dirt\s
                                                            4. Cinnamon        8. Vomit\s
                                                            """
        );
    }
}

