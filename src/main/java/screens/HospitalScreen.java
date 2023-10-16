package screens;

public class HospitalScreen {
    protected void printHospitalMaxHealth(){
        System.out.print(
                """
                               Ya have de doc check yous out, but aside from yer bunions\s
                               on yer feet, youse is fit as a fiddle!                   \s
                                                                                        \s
                                            Press any key to continue                   \s
                                                           """);
    }

    public void printHospitalCosts(int cost) {
        System.out.printf(
                """
                               Ya drag yer sorry butt into de loc'l Hospital. The docs check ye\s
                               out, and come to the conclusion that it'll cost %3d dollars to fix ya up.\s
                                                                                        \s
                                            Do ya sign the consent forms? (Y/N)                   \s
                                                           """,cost);
    }
}
