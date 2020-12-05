/*********************************************************
 * Written by     : David Monsen                          *
 * Modified by    : David Monsen & Paulina Cruz           *
 * Date created   : 11/11/2020                            *
 * Dates modified : 11/21/2020 & 11/25/2020 & 12/04/2020  *
 * 11/21/2020     : methods updated to return values      *
 * 11/25/2020     : made methods/variables static         *   
 * 12/04/2020     : changed ints in the array to constant *
                    indexes, added resetUserStats method  *
 *********************************************************/

public class UserStats {

    //fields
    private final static int MEMBERS_INDEX = 0;
    private final static int MAX_MILES_INDEX = 1;

    public static int Members = 10;
    private final static int MAX_MILES = 100;
    private static final int[] userStats = {Members, MAX_MILES}; // userStats[0] is members, userStats[1] is miles left which starts at 100
    private static int milesJourneyed = 0; // total milesJourneyed at the start is 0

    //constructors
    public UserStats() {
        userStats[MEMBERS_INDEX] = Members;  // begins the UserStats array with 10 in userStats[0]
        userStats[MAX_MILES_INDEX] = MAX_MILES;    // and 100 in userStats[1]
    }

    //methods
    public static void increaseMilesJourneyed() {  // increases miles journeyd AND decreases miles left
        if (milesJourneyed < MAX_MILES) { // increases the milesJourneyed by 10 each time it is called up to 100
            milesJourneyed += 10;   // will have to have a check in the code to verify if 100 has been reached
        }
        if (userStats[MAX_MILES_INDEX] > 0) {
            userStats[MAX_MILES_INDEX] -= 10;  // subtracts 10 from the milesleft portion of the array
        }
    }

    public int getMilesLeft() {   // //prints out the remaining miles left
        return userStats[MAX_MILES_INDEX];
    }

    public int getMilesJourneyed() { // prints out the miles journeyed so far
        return milesJourneyed;
    }

    public int getMembers() {  // prints out the remaining members
        return userStats[MEMBERS_INDEX];
    }

    public static void increaseMembers() {
        if (userStats[MEMBERS_INDEX] < Members) { // if member is less than 10, increase by 1
            userStats[MEMBERS_INDEX] += 1;
            System.out.println("You have gained a member in your travels.");
        } else { // if tries to add a member beyond 10, it won't and will return this message
            System.out.println("You found a traveller on your journey. Unfortunately, your group is maxed out, " +
                    "and is unable to survive with additional group members. You leave the traveller to his fate.");
        }
    }

    public static void decreaseMembers() { // decreases total members by 1 when called
        if (userStats[MEMBERS_INDEX] > 0) {   // if total members is greater than 0 which it always should be for the game to continue
            userStats[MEMBERS_INDEX] -= 1;
        }
    }
    
    public static void resetUserStats() {
         userStats[MEMBERS_INDEX] = 10;
         userStats[MAX_MILES_INDEX] = MAX_MILES;
         milesJourneyed = 0;
    }
}
