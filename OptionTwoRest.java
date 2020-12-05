/********************************************************************************************************
 * Written by     : Shiana Venegas                                                                       *
 * Modified by    : Paulina Cruz & David Monsen                                                          *
 * Date created   : 11/09/2020                                                                           *
 * Dates modified : 12/04/2020                                                                           *
 * 12/04/2020     : Modifications by David Monsen                                                        *
                    - included EnemyStats class and methods                                              *
 * 12/04/2020     : Modifications by Paulina Cruz                                                        *
                    - changed .Random to call a new method added in Main to avoid duplicate code         *
                    - took out the need to pass in UserStats since UserStats now uses all static methods *
                      it is no longer necessary to pass it in the methods  
 ********************************************************************************************************/

public class OptionTwoRest {

    //methods
    public static void optionTwo() {
        //Rest one
        int random_roll = Main.rollRandomTo100();

        if (random_roll > 50) {
            System.out.println("You have found a stray traveller who is eager to join your group");
            UserStats.increaseMembers();
            UserStats.decreaseMembers();
            System.out.println("Unfortunately, that traveller was being hunted by a group of bandits and have killed him");
            EnemyStats.enemyAttack();
        }
        //Rest two
        else if (random_roll < 50) {
            System.out.println("You've chosen to rest for the day! You gain one person and you were not attacked by bandits." +
                    " No one died of any diseases either, so that is another bonus.");
            UserStats.increaseMembers();
        }
    }
}
