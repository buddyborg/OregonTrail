import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int selection;
        int[] stats = new int[2];
        UserStats newUser = new UserStats(stats);
        
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
           }
         }while (selection != 0);
           
            //This is where the bulk of the game will be played after choosing option 1
            //OptionOneContinue(); //force the game to choose option one to begin.
            if (selection == 1){
               do{
                  System.out.println("Enter what you would like to do from the three options");
                  gameMenuPrompt();
                  selection = input.nextInt();
              
                  switch (selection){
                     case 1   :  //option one will go here
                                 break;
                     case 2   :  //option two will go here
                                 break;
                     case 3   :  //option three will go here
                                 break;
                     default  :  System.out.println("Enter a valid selection");
                                 break;
                  }
               }while (selection != 3 || newUser.getMembers() != 0); //continues the loop until option 3 is chosen OR members is 0
            }
      }
  
    private static void menuPrompt(){  //creates a menu option for the user to choose from
        
       System.out.println("Welcome to the Oregon Trail for Beginners");
	    System.out.println("1 .. Begin Journey");
		 System.out.println("2 .. Read Instructions");
	    System.out.println("0 .. exit");
		 System.out.print("Your choice: ");
	 }
    
    private static void gameMenuPrompt(){
       System.out.println("1 .. continue journey");
       System.out.println("2 .. rest for the night");
       System.out.println("3 .. give up");
       System.out.print("Your choice: ");
    }
            
    private static void instructions(){ //briefly explains the objective and the way to play the game.
       System.out.println("This game begins with a small group of 10 individuals who are making their journey along the famous Oregon Trail.");
       System.out.println("When you begin the journey, you start travelling towards your destination at 10 miles each time option 1 is chosen.");
       System.out.println("If you would like to rest for the night, choose option 2, " + 
                             "you have the possibility of gaining a group member. You cannot exceed 10 group members.");
       System.out.println("If you choose option 3, you choose to end the game and give up your journey.");
       System.out.println("There are many treacherous pitfalls and dangerous bandits along the trail that will take away group members as you progress on the trail.");
       System.out.println("It is wise to rest when there are few group members remaining to strengthen your odds of success."); 
    }

} 
