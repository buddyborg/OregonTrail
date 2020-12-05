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
 *  changed variable names to proper variable naming conventions (make it a bit more descriptive)             *
 *  pulled the switch out into a new method called OptionChoicesSelection() and pass in each variable to avoid repeating code                                                     *
 ***************************************************************************************************************/

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int amountOfTimesForOption1 = 0;
    private static int amountOfTimesForOption2 = 0;

    public static void main(String[] args) {
        //declared variables used for main
        Scanner input = new Scanner(System.in);
        int userSelection = 4;
        UserStats user = new UserStats();
        boolean shouldExit = false;
        String playAgainInput = "Yes";
        //begins game
        while (playAgainInput.equalsIgnoreCase("Yes") && userSelection != 0) { //if playAgainInput is No and userSelection is 0 then game ends
            do {
                menuPrompt();
                userSelection = input.nextInt();
                if (userSelection == 1) {
                    System.out.println();
                    System.out.println("Let's begin!");
                    shouldExit = false;
                    UserStats.resetUserStats();
                    break;
                } else if (userSelection == 2) {
                    instructions();
                } else if (userSelection == 0) {
                    System.out.println("Goodbye");
                    shouldExit = true;
                }
            } while (userSelection != 0);

            // This is where the bulk of the game will be played after choosing option 1
            // if (userSelection == 1){
            while (!shouldExit) { // this section will end if boolean shouldExit == true
                // Print out current game stats
                userStatus(user);

                System.out.println("Enter what you would like to do from the three options"); // prints out prompt for user
                gameMenuPrompt(); // calls gameMenuPrompt();
                System.out.println(); // prints out empty line for formatting
                // Get userSelection
                userSelection = input.nextInt();
                shouldExit = optionChoicesSelection(userSelection, user);

                if (user.getMilesLeft() <= 0 && user.getMembers() >= 1) {
                    victoryScreen(user);
                    shouldExit = true;
                    playAgainInput = input.nextLine(); // valid userSelection is either Yes or No
                 while(!playAgainInput.equalsIgnoreCase("No") && !playAgainInput.equalsIgnoreCase("Yes")) {
                     System.out.print("Do you wish to play again (Yes/No)? "); // prompts user if they want to replay the game
                     playAgainInput = input.nextLine();
                     }
                } else if (user.getMembers() <= 0) {
                    losingScreen(user);
                    shouldExit = true;

                    playAgainInput = input.nextLine(); // valid userSelection is either Yes or No
                  while(!playAgainInput.equalsIgnoreCase("No") && !playAgainInput.equalsIgnoreCase("Yes")) {
                        System.out.print("Do you wish to play again (Yes/No)? "); // prompts user if they want to replay the game
                        playAgainInput = input.nextLine();
                     }
                }
            }
        }
    }

    private static boolean optionChoicesSelection(int userSelection, UserStats user) { 
        if (userSelection == 1 && amountOfTimesForOption1 < 3) { // if userSelection ==1 and Option1 is chosen < 3 times, do this
            OptionOneContinue.pick(); // handles OptionOne
            amountOfTimesForOption1++; // adds 1 to counter for amountOfTimesForOption1
            amountOfTimesForOption2 = 0; // sets amountOfTimesForOption2 = 0
            return false;
        } else if (userSelection == 2 && amountOfTimesForOption2 < 3) { // if userSelection ==2 and Option2 is chosen < 3 times, do this
            OptionTwoRest.optionTwo(); // handles OptionTwo
            amountOfTimesForOption2++; // adds 1 to counter for amountOfTimesForOption3
            amountOfTimesForOption1 = 0; // sets amountOfTimesForOption1 = 0
            return false;
        } else if (userSelection == 3) { // if userSelection == 3, do this
            losingScreen(user); // calls losingScreen()
            amountOfTimesForOption1 = 0; // sets amountOfTimesForOption1 = 0
            amountOfTimesForOption2 = 0; // sets amountOfTimesForOption2 = 0
            return true;
        } else {
            System.out.println("Enter a valid selection"); // prompts user to enter a valid selection
            return false;
        }
    }

    private static void menuPrompt() {  // creates a menu option for the user to choose from written by David Monsen
        System.out.println("Welcome to the Oregon Trail for Beginners");
        System.out.println("1 .. Begin Journey");
        System.out.println("2 .. Read Instructions");
        System.out.println("0 .. exit");
        System.out.print("Your choice: ");
    }

    private static void gameMenuPrompt() { // written by David Monsen
        if (amountOfTimesForOption1 < 3) System.out.println("1 .. continue journey");
        if (amountOfTimesForOption2 < 3) System.out.println("2 .. rest for the night");
        System.out.println("3 .. give up");
        System.out.print("Your choice: ");
    }

    private static void instructions() { // briefly explains the objective and the way to play the game. Written by David Monsen
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
        System.out.printf("Congratulations! %d of your group made it! You are now free to set up a new society.%n", newUser.getMembers());
        System.out.println("You can begin by remembering those lost on the journey.");
        System.out.println("Thought you never knew what spontaneous combustion was before this journey, you feel the urge to ");
        System.out.println("research this strange phenomena to determine why travellers along this particular path were affected");
    }

    public static void losingScreen(UserStats newUser) { // losing screen
        userStatus(newUser);
        OptionThreeGiveUp.losingScreen();
    }

    public static void userStatus(UserStats newUser) {  // Print out current game stats written by Paulina Cruz
        System.out.printf("Members Remaining: %d%n", newUser.getMembers()); // prints out members remaining
        System.out.printf("Miles Journeyed: %d%n", newUser.getMilesJourneyed()); // prints out miles journeyed
        System.out.println(); // prints out empty line for formatting
    }

    public static int rollRandomTo100() { //method that generates a random percentage written by Paulina Cruz
        return new Random().nextInt(100);
    }
} 
