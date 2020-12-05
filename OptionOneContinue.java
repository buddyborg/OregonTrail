/********************************************************************************************************
 * Written by     : Paulina Cruz                                                                         *
 * Modified by    : Paulina Cruz & David Monsen                                                          *
 * Date created   : 11/09/2020                                                                           *
 * Dates modified : 12/04/2020                                                                           *
 * 12/04/2020     : Modifications by David Monsen                                                        *
                    - included EnemyStats class and methods                                              *
 * 12/04/2020     : Modifications by Paulina Cruz                                                        *
                    - fixed error that was killing too many members in certain chance                    *
                    - took out the need to pass in UserStats since UserStats now uses all static methods *
                      it is no longer necessary to pass it in the methods  
 ********************************************************************************************************/
 
 import java.util.Random; //import java.util.Random; 
 
 class OptionOneContinue {
    public static boolean chance(int percentChance) {
       return new Random().nextInt(100) < percentChance; //returns random percent change
    }
    
     public static void pick() {
       UserStats.increaseMilesJourneyed(); //calls increaseMilesJourneyed() from UserStats
       System.out.println("Your group has travelled 10 miles");
       if (OptionOneContinue.chance(40)){ //if OptionOneContinue.chance(30) is fufilled, do this
          EnemyStats.enemyAttack(); //calls EnemyStats.enemyAttack()
       }
       if (OptionOneContinue.chance(40)){ //if OptionOneContinue.chance(60) is fufilled, do this
          System.out.println("One of your group members perished by spontaneous combustion. You don't know what that means.");
          UserStats.decreaseMembers(); //calls UserStats.decreaseMembers()
       }
       if (OptionOneContinue.chance(60)){ //if OptionOneContinue.chance(90) is fufilled, do this
          UserStats.increaseMembers(); //calls UserStats.increaseMembers()
          System.out.println("You saved a traveller from wandering off a cliff. You have gained one member");
       }
       if (OptionOneContinue.chance(50)){ //if OptionOneContinue.chance(90) is fufilled, do this
            OptionOneContinue.runIntoBandits(); //calls runIntoBandits()
       }
     } 
     
     public static void runIntoBandits(){
       System.out.println("You ran into bandits and lost a member!"); //prints out message for user
       UserStats.decreaseMembers(); //calls decreaseMembers() from UserStats
     }
 } 
