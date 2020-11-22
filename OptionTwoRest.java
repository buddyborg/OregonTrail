import java.util.Random; 
class OptionTwoRest {
    //fields 
   
    
    //constructors 
 
     //methods
     public static void optionTwo(UserStats stats){
    //Rest one
     int min = 0; 
     int max = 100; 
     int random_roll = (int)(Math.random() * (max - min + 1) + min); 
    
    
    
    if (random_roll > 50) {
     
      stats.increaseMembers(); 
      System.out.println("You've chosen to rest for the day! You gain one member, but unfortunately you were attacked by bandits and one person was killed!"); 
      OptionTwoRest.enemyAttack(stats); 
    } 
    //Rest two 
    else if (random_roll < 50) {
    
     System.out.println("You've chosen to rest for the day! You gain one person and you were not attacked by bandits!"); 
     stats.increaseMembers();
     }
    }
    
    public static void enemyAttack(UserStats stats){
      stats.decreaseMembers(); 
    }
   
    
  }
 