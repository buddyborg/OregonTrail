//Written by Paulina Cruz

import java.util.Random; //import java.util.Random; 

class OptionOneContinue {
   public static boolean chance(int percentChance) {
      return new Random().nextInt(100) < percentChance; //returns random percent change
   }
   
    public static void pick(UserStats stats) {
      stats.increaseMilesJourneyed(); //calls increaseMilesJourneyed(); from UserStats.java
      if (OptionOneContinue.chance(60)) //if chance is greater than the 60% chance do this
         OptionOneContinue.runIntoBandits(stats); //calls runIntoBandits(stats);
    } 
    
    public static void runIntoBandits(UserStats stats){
      System.out.println("You ran into bandits and lost a member!"); //prints out message for user
      stats.decreaseMembers(); //calls decreaseMembers(); from UserStats.java
    }
} 

//   
// //Written by Paulina Cruz
// // Modified by David Monsen to include EnemyStats class and methods
// 
// import java.util.Random; //import java.util.Random; 
// 
// class OptionOneContinue {
//    public static boolean chance(int percentChance) {
//       return new Random().nextInt(100) < percentChance; //returns random percent change
//    }
//    
//     public static void pick(UserStats stats) {
//       stats.increaseMilesJourneyed(); //calls increaseMilesJourneyed(); from UserStats.java
//       System.out.println("Your group has travelled 10 miles");
//       if (OptionOneContinue.chance(30)){ //if chance is greater than the 60% chance do this
//          EnemyStats.enemyAttack(stats); //calls runIntoBandits(stats)
//       }
//       else if (OptionOneContinue.chance(60)){
//          stats.decreaseMembers();
//          System.out.println("One of your group members perished by spontaneous combustion. You don't know what that means.");
//          EnemyStats.enemyAttack(stats);
//       }
//       else if (OptionOneContinue.chance(90)){
//          stats.increaseMembers();
//          System.out.println("You saved a traveller from wandering off a cliff. You have gained one member");
//       }
//     } 
//     
//     public static void runIntoBandits(UserStats stats){
//       System.out.println("You ran into bandits and lost a member!"); //prints out message for user
//       stats.decreaseMembers(); //calls decreaseMembers(); from UserStats.java
//     }
// } 
