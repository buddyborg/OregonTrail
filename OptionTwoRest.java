//Made by Shiana Venegas 

import java.util.Random; 
class OptionTwoRest {
 
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
 
// //Made by Shiana Venegas 
// // Modified by David Monsen to include EnemyStats class and methods
// 
// import java.util.Random; 
// public class OptionTwoRest {
//  
//      //methods
//      public static void optionTwo(UserStats stats){
//     //Rest one
//      int min = 0; 
//      int max = 100; 
//      int random_roll = (int)(Math.random() * (max - min + 1) + min); 
//     
//     
//     
//      if (random_roll > 50) {
//         System.out.println("You have found a stray traveller who is eager to join your group");
//         stats.increaseMembers();
//         stats.decreaseMembers();
//         System.out.println("Unfortunately, that traveller was being hunted by a group of bandits and have killed him");
//         EnemyStats.enemyAttack(stats); 
//     } 
//     //Rest two 
//        else if (random_roll < 50) {
//     
//          System.out.println("You've chosen to rest for the day! You gain one person and you were not attacked by bandits." + 
//                               " No one died of any diseases either, so that is another bonus.");
//          stats.increaseMembers();
//  }
// }
// }
//     
//  
