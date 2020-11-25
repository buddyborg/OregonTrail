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