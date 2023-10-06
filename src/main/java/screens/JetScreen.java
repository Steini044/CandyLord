package screens;

import state.Location;

import java.util.ArrayList;

public class JetScreen {
    protected void printJetDialogueStart(ArrayList<Location> locations, int[] prices) {
        System.out.printf(
                """
                                                      Locations:\s
                                                                                              \s
                        1. %17s     ($%3d)       5. %17s     ($%3d)   \s
                        2. %17s     ($%3d)       6. %17s     ($%3d)   \s
                        3. %17s     ($%3d)       7. %17s     ($%3d)   \s
                        4. %17s     ($%3d)       8. %17s     ($%3d)   \s
                                                                                         \s
                 Where do you wanna go?      \s
                                                            """,
                locations.get(0).getName(), prices[0], locations.get(4).getName(), prices[4], locations.get(1).getName(), prices[1],
                locations.get(5).getName(), prices[5], locations.get(2).getName(), prices[2], locations.get(6).getName(), prices[6],
                locations.get(3).getName(), prices[3], locations.get(7).getName(), prices[7]);
    }

    protected void printJetDialogueYourLocation(ArrayList<Location> locations, int[] prices) {
        System.out.printf(
                """
                                                      Locations:\s
                                                                                              \s
                        1. %17s     ($%3d)       5. %17s     ($%3d)   \s
                        2. %17s     ($%3d)       6. %17s     ($%3d)   \s
                        3. %17s     ($%3d)       7. %17s     ($%3d)   \s
                        4. %17s     ($%3d)       8. %17s     ($%3d)   \s
                                                                                         \s
                 Where do you wanna go?  Are ya having flashbacks? That's where you are now!   \s
                                                            """,
                locations.get(0).getName(), prices[0], locations.get(4).getName(), prices[4], locations.get(1).getName(), prices[1],
                locations.get(5).getName(), prices[5], locations.get(2).getName(), prices[2], locations.get(6).getName(), prices[6],
                locations.get(3).getName(), prices[3], locations.get(7).getName(), prices[7]);
    }

    protected void printJetDialogueNotEnoughCash(ArrayList<Location> locations, int[] prices) {
        System.out.printf(
                """
                                                      Locations:\s
                                                                                              \s
                        1. %17s     ($%3d)       5. %17s     ($%3d)   \s
                        2. %17s     ($%3d)       6. %17s     ($%3d)   \s
                        3. %17s     ($%3d)       7. %17s     ($%3d)   \s
                        4. %17s     ($%3d)       8. %17s     ($%3d)   \s
                                                                                         \s
                 Where do you wanna go?  Start flappin' yer arms, cause you ain't got de dough!   \s
                                                            """,
                locations.get(0).getName(), prices[0], locations.get(4).getName(), prices[4], locations.get(1).getName(), prices[1],
                locations.get(5).getName(), prices[5], locations.get(2).getName(), prices[2], locations.get(6).getName(), prices[6],
                locations.get(3).getName(), prices[3], locations.get(7).getName(), prices[7]);
    }
}
