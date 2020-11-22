//Written by Paulina Cruz

import java.util.Random;

class OptionOneContinue {
   public static boolean chance(int percentChance) {
      return new Random().nextInt(100) < percentChance;
      
   }
   
    public static void pick(UserStats stats) {
      stats.increaseMilesJourneyed();
      if (OptionOneContinue.chance(60))
         OptionOneContinue.runIntoBandits(stats);
      
    } 
    public static void runIntoBandits(UserStats stats){
      System.out.println("You ran into bandits and lost a member!");
      stats.decreaseMembers();
    }
} 