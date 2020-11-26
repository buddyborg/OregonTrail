import java.util.Scanner; //imports java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); //creates new Scanner called input
        int selection;
        int[] stats = new int[2];
        UserStats newUser = new UserStats(stats);
        boolean exit = false;
        
        do {
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
           
            //This is where the bulk of the game will be played after choosing option 1
            //OptionOneContinue(); //force the game to choose option one to begin.
            //if (selection == 1){
               while (!exit){
                  //Print out current game stats written by Paulina Cruz
                  System.out.printf("Members Remaining: %d%n", newUser.getMembers()); //prints out members remaining
                  System.out.printf("Miles Journeyed: %d%n", newUser.getMilesJourneyed()); //prints out miles journeyed
                  System.out.println(); //prints out empty line for formatting
                  
                  System.out.println("Enter what you would like to do from the three options"); //prints out prompt for user
                  gameMenuPrompt(); //calls gameMenuPrompt();
                  System.out.println(); //prints out empty line for formatting
                  
                  // Get selection
                  selection = input.nextInt();
              
                  switch (selection){
                     case 1   : 
                        OptionOneContinue.pick(newUser);
                                 break;
                     case 2   :
                        OptionTwoRest.optionTwo(newUser);
                                 break;
                     case 3   :
                        System.out.println("Goodbye");
                        exit = true;
                                 break;
                     default  :  System.out.println("Enter a valid selection");
                                 break;
                  }
                  
                  // TODO: check if game is ended
                  // If newUser.getMilesLeft() <= 0 and newUser.getMembers() >= 1 - user wins MAKE WIN/LOSE SCREEN
                  if (newUser.getMilesLeft() <= 0 && newUser.getMembers() >= 1) {
                      victoryScreen();
                      exit = true;
                  }
                  else if (newUser.getMembers() <= 0) {
                     losingScreen();
                     exit = true;
                  }
                  // If newUser.getMembers() <= 0 - user loses
               }
           // }
      }

  
    private static void menuPrompt(){  //creates a menu option for the user to choose from written by David Monsen
        
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
            
    private static void instructions(){ //briefly explains the objective and the way to play the game. Written by David Monsen
       System.out.println("This game begins with a small group of 10 individuals who are making their journey along the famous Oregon Trail.");
       System.out.println("When you begin the journey, you start travelling towards your destination at 10 miles each time option 1 is chosen.");
       System.out.println("If you would like to rest for the night, choose option 2, " + 
                             "you have the possibility of gaining a group member. You cannot exceed 10 group members.");
       System.out.println("If you choose option 3, you choose to end the game and give up your journey.");
       System.out.println("There are many treacherous pitfalls and dangerous bandits along the trail that will take away group members as you progress on the trail.");
       System.out.println("It is wise to rest when there are few group members remaining to strengthen your odds of success."); 
       System.out.println();
    }
    
    public static void victoryScreen() { //victory screen
      System.out.println("Congratulations! You made it!"); 
    }
    
    public static void losingScreen() { //losing screen
      System.out.println("You have no members remaining!");
    }

} 
