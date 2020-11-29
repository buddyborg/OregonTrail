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
*  is correctly indented.                                                                               *
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
            System.out.printf("Members Remaining: %d%n", newUser.getMembers()); // prints out members remaining
            System.out.printf("Miles Journeyed: %d%n", newUser.getMilesJourneyed()); // prints out miles journeyed
            System.out.println(); // prints out empty line for formatting
                
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
                  case 3   :  losingScreen();
                              exit = true;
                              break;
                  default  :  System.out.println("Enter a valid selection");
                              break;
               }
            }
            if (count1 == 3){ // if option 1 is selected 3 times in a row, removes that option from being selected for one round
               System.out.println("Enter what you would like to do from the two options"); // prints out prompt for user
               gameMenuPrompt2(); // calls gameMenuPrompt();
               System.out.println(); // prints out empty line for formatting
               selection = input.nextInt();
               count1 = 0;
                     
               switch (selection){
                  case 2   :  OptionTwoRest.optionTwo(newUser);
                              count2++;
                              break;
                  case 3   :  losingScreen();
                              exit = true;
                              break;
                  default  :  System.out.println("Enter a valid selection");
                              break;
               }
            }
            if (count2 == 3){ // if option 2 is selected 3 times in a row, removes that option from being selected for one round
               System.out.println("Enter what you would like to do from the two options"); //prints out prompt for user
               gameMenuPrompt3(); //calls gameMenuPrompt();
               System.out.println(); //prints out empty line for formatting
               selection = input.nextInt();
               count2 = 0;
                    
               switch (selection){
                  case 1   :  OptionTwoRest.optionTwo(newUser);
                              count2++;
                              break;
                  case 3   :  losingScreen();
                              exit = true;
                              break;
                  default  :  System.out.println("Enter a valid selection");
                              break;
               }
            }
                 
            if (newUser.getMilesLeft() <= 0 && newUser.getMembers() >= 1) {
               victoryScreen();
               exit = true;
               System.out.print("Do you wish to play again (Yes/No)? "); // prompts user if they want to replay the game
               continue1 = input.next(); // valid selection is either Yes or No
            }
            else if (newUser.getMembers() <= 0) {
               losingScreen();
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
    
    public static void victoryScreen() { // victory screen
      System.out.println("Congratulations! You made it!");  
    }
    
    public static void losingScreen() { // losing screen
      System.out.println("You have no members remaining!");
    }
} 
