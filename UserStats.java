/*********************************************************
* Written by     : David Monsen                          *
* Modified by    : David Monsen & Paulina Cruz           *
* Date created   : 11/11/2020                            *
* Dates modified : 11/21/2020 & 11/25/2020               *
* 11/21/2020     : methods updated to return values      *
* 11/25/2020     : made methods/variables static         *
*********************************************************/

public class UserStats{
      
   //fields
  
   public static int MAX_MEMBERS = 10;
   private final static int MAX_MILES = 100;
   private static int[] userStats = {MAX_MEMBERS, MAX_MILES}; // userStats[0] is members, userStats[1] is miles left which starts at 100
   private static int milesJourneyed = 0; // total milesJourneyed at the start is 0
   
   //constructors
   
   public UserStats(int[] userStats){
      userStats[0] = MAX_MEMBERS;  // begins the UserStats array with 10 in userStats[0]
      userStats[1] = MAX_MILES;    // and 100 in userStats[1]
   }
   
   //methods
   
   public static void increaseMilesJourneyed(){  // increases miles journeyd AND decreases miles left
     if (milesJourneyed < MAX_MILES){ // increases the milesJourneyed by 10 each time it is called up to 100
        milesJourneyed += 10;   // will have to have a check in the code to verify if 100 has been reached
     }
     if (userStats[1] > 0){
        userStats[1] -= 10;  // subtracts 10 from the milesleft portion of the array
     }
   }
   
   public int getMilesLeft(){   // //prints out the remaining miles left
      int milesLeft = userStats[1]; 
      return milesLeft;
   }
   
   public int getMilesJourneyed(){ // prints out the miles journeyed so far
      return milesJourneyed;
   }
     
   public int getMembers(){  // prints out the remaining members
      int members = userStats[0];       
      return members;
   }
   
   public static void increaseMembers(){
      if (userStats[0] < MAX_MEMBERS){ // if member is less than 10, increase by 1
         userStats[0] += 1;
         System.out.println("You have gained a member in your travels.");
      }
      else{ // if tries to add a member beyond 10, it won't and will return this message
         System.out.println("You found a travller on your journey. Unfortunately, your group is maxed out, " +
                              "and is unable to survive with additional group members. You leave the traveller to his fate.");
      }
   }
   
   public static void decreaseMembers(){ // decreases total members by 1 when called
      if (userStats[0] > 0){   // if total members is greater than 0 which it always should be for the game to continue
         userStats[0] -= 1;
      }
   }
}
