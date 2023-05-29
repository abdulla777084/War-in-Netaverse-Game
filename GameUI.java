package cwk4;

import java.util.Scanner;

/**
 * Provides a command-line user interface for the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class GameUI {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Runs the command-line interface.
     *
     * @param args A string array of CLI arguments.
     */
    public static void main(String[] args) {
        GameUI myGame = new GameUI();
        myGame.playGame();
    }

    /**
     * Plays the game through a text-based interface.
     */
    private void playGame() {
        // Create a game
        System.out.println("Enter admiral's name:");
        WIN game = new SpaceWars(scanner.nextLine());

        // Accept user input and play game
        int choice = 100;
        while (choice != 0) {
            choice = getMenuItem();
            if (choice == 1) {
                // Display all forces
                System.out.println(game.getAllForces());
            } else if (choice == 2) {
                // Display all battles
                System.out.println(game.getAllBattles());
            } else if (choice == 3) {
                // Display a force
                System.out.println("Enter force reference: ");
                scanner.nextLine();
                System.out.println(game.getForceDetails(scanner.nextLine()));
            } else if (choice == 4) {
                // Activate a force
                System.out.println("Enter force reference: ");
                scanner.nextLine();
                System.out.println(activateResult(game.activateForce(scanner.nextLine())));
            } else if (choice == 5) {
                // Display ASF
                System.out.println(game.getASFleet());
            } else if (choice == 6) {
                // Display the result of a battle
                System.out.println("Enter battle number: ");
                System.out.println(battleResult(game.doBattle(scanner.nextInt())));
            } else if (choice == 7) {
                // Recall a force
                System.out.println("Enter force reference: ");
                scanner.nextLine();
                game.recallForce(scanner.nextLine());
            } else if (choice == 8) {
                // Display the game state
                System.out.println(game);
            } else if (choice == 9) {
                // Save the game
                System.out.println("Enter filename to save as: ");
                scanner.nextLine();
                game.saveGame(scanner.nextLine());
            } else if (choice == 10) {
                // Load the game
                System.out.println("Enter filename to load: ");
                scanner.nextLine();
                game = game.restoreGame(scanner.nextLine());
            }
        }
    }

    /**
     * Display the menu with number of choices.
     */
    private int getMenuItem() {
        // Display the main menu
        System.out.println("Main Menu");
        System.out.println("0. Quit");
        System.out.println("1. List all forces");
        System.out.println("2. List all battles");
        System.out.println("3. View details of a force");
        System.out.println("4. Activate a force into the Active Star Fleet");
        System.out.println("5. List forces in Active Star Fleet");
        System.out.println("6. Engage in a battle");
        System.out.println("7. Recall a force");
        System.out.println("8. View the state of the game");
        System.out.println("9. Save this game");
        System.out.println("10. Restore a game");

        // Get the user's choice
        int choice = -1;
        while (choice < 0 || choice > 10) {
            System.out.println("Enter the number of your choice: ");
            choice = scanner.nextInt();
        }
        return choice;
    }

    /**
     * Process the result of activating a force.
     *
     * @param code The result of activating a force.
     * @return A string representation of the result of activating a force.
     */
    public static String activateResult(int code) {
        switch (code) {
            case 0:
                return "Force is activated";
            case 1:
                return "Force is not in the UFF dock or is destroyed";
            case 2:
                return "Not enough money";
            default:
                return "No such force";
        }
    }

    /**
     * Process the result of a battle.
     *
     * @param code The result of the battle.
     * @return A string representation of the result of a battle.
     */
    public static String battleResult(int code) {
        switch (code) {
            case 0:
                return "Battle won";
            case 1:
                return "Battle lost as no suitable force available";
            case 2:
                return "Battle lost on battle strength so force is destroyed";
            case 3:
                return "Battle is lost and admiral is completely defeated";
            default:
                return "No such battle";
        }
    }
}
