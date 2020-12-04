/***************************************************************************************************************
*  ;;Block comments;;                                                                                          *
*  ***Main was created by Paulina Cruz, David Monsen, Shiana Venegas, & Reese Spaulding on 11/09/2020***       *
*  11/14/2020, main was modified, all user methods were added into main                                        *
*  11/21/2020, main was modified, exit conditions added, functionality for playing game added                  *
*  11/28/2020, modified selection so that if option1 or option2 are chosen 3 times                             *
*  in a row forces the user to chose either option 3 or the option they haven't chosen                         *
*  Still need to modify some more to allow the user to continue playing the game after victory or defeat       *
*  Tried to add in while statement at the beginning of the game that is default Y and trying to have it        *
*  be modified at the end of the game to be able to input either Y or N                                        *
*  11/29/2020, modified continue1 so it will now prompt the user if they want to continue after completing     *
*  the game, put in a while statement to accomplish this task for line 23. modified indents so everything      *
*  is correctly indented.                                                                                      *
*  12/4/2020, modified code to include EnemyStats in OptionOneContinue, OptionTwoRest. also modified Main to   *
*  create a method UserStatus that Paulina had written in Main, David just moved it into its own method so     *
*  that we can call it in the losing and victory screen.                                                       *
***************************************************************************************************************/

import java.util.Scanner; //imports java.util.Scanner;

public class Main {
   
   public static void main(String[] args) {
      //declared variables used for main
      Scanner input = new Scanner(System.in);
      int selection = 4;
      int[] stats = new int[2];
      UserStats newUser = new UserStats(stats);
      boolean exit = false;
      int count1 = 0;
      int count2 = 0;
      String continue1 = "Yes";
      //begins game
      while(continue1 == "Yes" && selection != 0){ //if continue1 is No and selection is 0 then game ends
         do{
            menuPrompt();
            selection = input.nextInt();
               if (selection == 1){
                  System.out.println("Let's begin!");
                  break;
               }
               else if (selection == 2){
                  instructions();
               }
               else if (selection == 0){
                  System.out.println("Goodbye");
                  exit = true;
               }
         }while (selection != 0);
           
            // This is where the bulk of the game will be played after choosing option 1
            // if (selection == 1){
         while (!exit){ // this section will end if boolean exit == true
            // Print out current game stats written by Paulina Cruz 
            userStatus(newUser);
                
            System.out.println("Enter what you would like to do from the three options"); // prints out prompt for user
            gameMenuPrompt(); // calls gameMenuPrompt();
            System.out.println(); // prints out empty line for formatting
                
            // Get selection
            selection = input.nextInt();
            if (count1 < 3 && count2 < 3){
               switch (selection){
                  case 1   :  OptionOneContinue.pick(newUser);
                              count1++;
                              break;
                  case 2   :  OptionTwoRest.optionTwo(newUser);
                              count2++;
                              break;
                  case 3   :  losingScreen(newUser);
                              exit = true;
                              break;
                  default  :  System.out.println("Enter a valid selection");
                              break;
               }
            }
            if (count1 == 3){ // if option 1 is selected 3 times in a row, removes that option from being selected for one round
               userStatus(newUser);
               System.out.println("Enter what you would like to do from the two options"); // prints out prompt for user
               gameMenuPrompt2(); // calls gameMenuPrompt();
               System.out.println(); // prints out empty line for formatting
               selection = input.nextInt();
               count1 = 0;
                     
               switch (selection){
                  case 2   :  OptionTwoRest.optionTwo(newUser);
                              count2++;
                              break;
                  case 3   :  losingScreen(newUser);
                              exit = true;
                              break;
                  default  :  System.out.println("Enter a valid selection");
                              break;
               }
            }
            if (count2 == 3){ // if option 2 is selected 3 times in a row, removes that option from being selected for one round
               userStatus(newUser);
               System.out.println("Enter what you would like to do from the two options"); //prints out prompt for user
               gameMenuPrompt3(); //calls gameMenuPrompt();
               System.out.println(); //prints out empty line for formatting
               selection = input.nextInt();
               count2 = 0;
                    
               switch (selection){
                  case 1   :  OptionOneContinue.pick(newUser);
                              count2++;
                              break;
                  case 3   :  losingScreen(newUser);
                              exit = true;
                              break;
                  default  :  System.out.println("Enter a valid selection");
                              break;
               }
            }
                 
            if (newUser.getMilesLeft() <= 0 && newUser.getMembers() >= 1) {
               victoryScreen(newUser);
               exit = true;
               System.out.print("Do you wish to play again (Yes/No)? "); // prompts user if they want to replay the game
               continue1 = input.next(); // valid selection is either Yes or No
            }
            else if (newUser.getMembers() <= 0) {
               losingScreen(newUser);
               exit = true;
               System.out.print("Do you wish to play again (Yes/No)? "); // prompts user if they want to replay the game
               continue1 = input.next(); // valid selection is either Yes or No
            }
         }
      }
   }
    

  
    private static void menuPrompt(){  // creates a menu option for the user to choose from written by David Monsen
        
       System.out.println("Welcome to the Oregon Trail for Beginners");
	    System.out.println("1 .. Begin Journey");
		 System.out.println("2 .. Read Instructions");
	    System.out.println("0 .. exit");
		 System.out.print("Your choice: ");
	 }
    
    private static void gameMenuPrompt(){ // written by David Monsen
       System.out.println("1 .. continue journey");
       System.out.println("2 .. rest for the night");
       System.out.println("3 .. give up");
       System.out.print("Your choice: ");
    }
    
    private static void gameMenuPrompt2(){ // written by David Monsen
       System.out.println("2 .. rest for the night");
       System.out.println("3 .. give up");
       System.out.print("Your choice: ");
    }
    
    private static void gameMenuPrompt3(){ // written by David Monsen
       System.out.println("1 .. continue journey");
       System.out.println("3 .. give up");
       System.out.print("Your choice: ");
    }
            
    private static void instructions(){ // briefly explains the objective and the way to play the game. Written by David Monsen
       System.out.println("This game begins with a small group of 10 individuals who are making their journey along the famous Oregon Trail.");
       System.out.println("When you begin the journey, you start travelling towards your destination at 10 miles each time option 1 is chosen.");
       System.out.println("If you would like to rest for the night, choose option 2, " + 
                             "you have the possibility of gaining a group member. You cannot exceed 10 group members.");
       System.out.println("If you choose option 3, you choose to end the game and give up your journey.");
       System.out.println("There are many treacherous pitfalls and dangerous bandits along the trail that will take away group members as you progress on the trail.");
       System.out.println("It is wise to rest when there are few group members remaining to strengthen your odds of success."); 
       System.out.println();
    }
    
    public static void victoryScreen(UserStats newUser) { // victory screen
      userStatus(newUser);
      System.out.printf("Congratulations! %d of your group made it! You are now free to set up a new society.%n" , newUser.getMembers()); 
      System.out.println("You can begin by remembering those lost on the journey.");
      System.out.println("Thought you never knew what spontaneous combustion was before this journey, you feel the urge to ");
      System.out.println("research this strange phenomena to determine why travellers along this particular path were affected");
    }
    
    public static void losingScreen(UserStats newUser) { // losing screen
      userStatus(newUser);
      System.out.println("Unfortunately, all of your group members have perished,");
      System.out.println("either by wandering off a cliff, dying from dysentery, or being killed by bandits.");
      System.out.println("A few may have even been lost by spontaneous combustion, something that appears");
      System.out.println("to affect those travelling along this pathway. Strange");
      System.out.println("So comes to a close the unfortunate tragedy of a group lost to the world on their journey to a new land");
    }
    
    public static void userStatus(UserStats newUser){
       System.out.printf("Members Remaining: %d%n", newUser.getMembers()); // prints out members remaining
       System.out.printf("Miles Journeyed: %d%n", newUser.getMilesJourneyed()); // prints out miles journeyed
       System.out.println(); // prints out empty line for formatting
    }
} 
