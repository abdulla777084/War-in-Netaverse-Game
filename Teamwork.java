package cwk4;

/**
 * This class holds the details of our team made up of first and last names and student ID numbers.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 01/03/2023
 */
public class Teamwork {
    private final String[] details = new String[13];

    /**
     * Constructs a Teamwork object.
     */
    public Teamwork() {
        // Team name
        details[0] = "12";

        // First team member's details
        details[1] = "Ashwell";
        details[2] = "Jack";
        details[3] = "20035866";

        // Second team member's details
        details[4] = "Alliu";
        details[5] = "Klevi";
        details[6] = "20067052";

        // Third team member's details
        details[7] = "Lovegrove";
        details[8] = "Luke";
        details[9] = "21000135";

        // Fourth team member's details
        details[10] = "Salimov";
        details[11] = "Abdulla";
        details[12] = "20075156";
    }

    /**
     * Get the details of the stored team.
     *
     * @return A string array of the team's details.
     */
    public String[] getTeamDetails() {
        return details;
    }

    /**
     * Displays the team's details.
     */
    public void displayDetails() {
        for (String temp : details) {
            System.out.println(temp);
        }
    }
}
