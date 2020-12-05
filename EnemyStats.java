/********************************************************************************************************
 * Written by     : Reese Spaulding                                                                      *
 * Modified by    : David Monsen & Paulina Cruz                                                          *
 * Date created   : 11/21/2020                                                                           *
 * Dates modified : 11/21/2020 & 12/04/2020                                                              *
 * 12/04/2020     : Modifications by David Monsen                                                        *
                    - to take the parameter of UserStats stats so that one variable is used in Main      *
                    - also modified class to call methods from UserStats instead of duplicating code     *
                    - added in random_roll variable to the method enemyAttack so that random is called   *
                      each time that the method is called                                                *
 * 12/04/2020     : Modifications by Paulina Cruz                                                        *
                    - changed .Random to call a new method added in Main to avoid duplicate code         *
                    - took out the need to pass in UserStats since UserStats now uses all static methods *
                      it is no longer necessary to pass it in the methods                                *
 ********************************************************************************************************/

public class EnemyStats {

    public static void enemyAttack() {
        //methods
        int random_roll = Main.rollRandomTo100();
        if (random_roll > 30) {
            if (UserStats.Members > 0) { //loses one member
                UserStats.decreaseMembers();
                System.out.println("One of your group members has died of dysentery");
            } else {
                System.out.println("Oh no! all have your group memembers have died of dysentery!");
            }
        }
        if (random_roll < 30) {
            if (UserStats.Members > 0) { // increase number of members lost
                UserStats.decreaseMembers();
                UserStats.decreaseMembers();
                System.out.println("Two of your group members wandered off a cliff and were lost");
            } else {
                System.out.println("Oh no! all have your group memembers have wandered off a cliff and were lost!");
            }
        }
    }
}