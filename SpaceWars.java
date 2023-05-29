package cwk4;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


/**
 * This class implements the behaviour expected from a WIN
 * system as required for 5COM2007.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class SpaceWars implements WIN {
    private final String name;
    private final HashMap<String, Force> forces = new HashMap<>();
    private final HashMap<Integer, Battle> battles = new HashMap<>();
    private int warChest = 1000;

    /**
     * Constructs a SpaceWars object.
     *
     * @param admiral The name of the admiral.
     */
    public SpaceWars(String admiral) {
        name = admiral;
        setupForces();
        setupBattles();
    }

    /**
     * Constructs a SpaceWars object reading battles from a file.
     *
     * @param admiral  The name of the admiral.
     * @param filename The filename of the battles file.
     */
    public SpaceWars(String admiral, String filename) {
        name = admiral;
        setupForces();
        readBattles(filename);
    }

    /**
     * Get a human-readable representation of the state of the
     * game including the name of the admiral, the state of the
     * war chest, and whether defeated or not
     *
     * @return A string representation of the state of the game.
     **/
    public String toString() {
        return "<Admiral Name: " + name + " - Current War Chest: " + warChest + " - Defeated: " + isDefeated() + ">";
    }

    /**
     * Determines if the admiral is defeated or not. It returns
     * true if the war chest <= 0 and the ASF has no forces which
     * can be recalled.
     *
     * @return Whether the admiral is defeated or not.
     */
    public boolean isDefeated() {
        return warChest <= 0 && !getASFleet().contains("Force");
    }

    /**
     * Get the number of bit coins in the war chest.
     *
     * @return The number of bit coins in the war chest.
     */
    public int getWarchest() {
        return warChest;
    }

    /**
     * Get a list of all forces in the system listing all forces
     * in the ASF, the UFF dock, and destroyed forces.
     *
     * @return A list of all forces in the system.
     */
    public String getAllForces() {
        // Get all forces in the UFF
        String s = "********************\n";
        for (Force value : forces.values()) {
            s += value + "\n";
        }

        // If no forces are retrieved, add "No forces" to the result
        if (!s.contains("Force")) {
            s += "No forces\n";
        }
        return s + "********************\n";
    }

    /**
     * Determines if a force reference is in the UFF dock.
     *
     * @param ref The reference of the force.
     * @return Whether the force is in the UFF dock or not.
     **/
    public boolean isInUFFDock(String ref) {
        // Get the force from the hashmap and check if it's docked. If one is not found, return false
        Force force = forces.get(ref);
        return force != null && force.isDocked();
    }

    /**
     * Get a list of all forces in the UFF dock.
     *
     * @return A list of all forces in the UFF dock.
     **/
    public String getForcesInDock() {
        // Get all forces in dock
        String s = "********************\n";
        for (Force value : forces.values()) {
            if (value.isDocked()) {
                s += value + "\n";
            }
        }

        // If no forces are retrieved, add "No forces" to the result
        if (!s.contains("Force")) {
            s += "No forces\n";
        }
        return s + "********************\n";
    }

    /**
     * Get a list of all destroyed forces in the system.
     *
     * @return A list of all destroyed forces in the system.
     */
    public String getDestroyedForces() {
        // Get all destroyed forces
        String s = "********************\n";
        for (Force value : forces.values()) {
            if (value.isDestroyed()) {
                s += value + "\n";
            }
        }

        // If no forces are retrieved, add "No forces" to the result
        if (!s.contains("Force")) {
            s += "No forces\n";
        }
        return s + "********************\n";
    }

    /**
     * Get a force's details from a given force reference or "No
     * such force" if one doesn't exist.
     *
     * @param ref The reference of the force.
     * @return The force's details from a given force reference.
     **/
    public String getForceDetails(String ref) {
        // Get the force from the hashmap. If one is not found, return "No such force"
        Force force = forces.get(ref);
        return force != null ? force.toString() : "No such force";
    }

    /**
     * Activates a force into the ASF only if there are enough
     * resources for the activation fee. The force's state is
     * then set to "active".
     *
     * @param ref The reference of the force.
     * @return 0 if the force is activated, 1 if the force is not
     * in the UFF dock or is destroyed, 2 if there is not enough
     * bit coins, or -1 if the force doesn't exist.
     **/
    public int activateForce(String ref) {
        // Get the force from the hashmap
        Force force = forces.get(ref);

        // If the force doesn't exist, return -1. Otherwise, check if it can be activated
        if (force != null) {
            if (!force.isDocked()) {
                return 1;
            } else if (getWarchest() >= force.getFee()) {
                force.setActive();
                warChest -= force.getFee();
                return 0;
            } else {
                return 2;
            }
        }
        return -1;
    }

    /**
     * Determines if a given force reference exists in the ASF.
     *
     * @param ref The reference of the force.
     * @return Whether the given force reference exists in the ASF.
     **/
    public boolean isInASFleet(String ref) {
        // Get the force from the hashmap and check if it's active. If one is not found, return false
        Force force = forces.get(ref);
        return force != null && force.isActive();
    }

    /**
     * Get a list of all forces in the ASF.
     *
     * @return A list of all forces in the ASF.
     **/
    public String getASFleet() {
        // Get all forces in the ASF
        String s = "********************\n";
        for (Force value : forces.values()) {
            if (value.isActive()) {
                s += value + "\n";
            }
        }

        // If no forces are retrieved, add "No forces" to the result
        if (!s.contains("Force")) {
            s += "No forces\n";
        }
        return s + "********************\n";
    }

    /**
     * Recalls a force from the ASF back to the UFF dock.
     *
     * @param ref The reference of the force.
     **/
    public void recallForce(String ref) {
        // Get the force from the hashmap
        Force force = forces.get(ref);

        // If the force doesn't exist, return null. Otherwise, check if it can be recalled
        if (force != null && force.isActive()) {
            force.setInDock();
            warChest += force.getFee() / 2;
        }
    }

    /**
     * Determines if a given number represents a battle.
     *
     * @param num The number of the battle.
     * @return Whether the given number represents a battle or not.
     **/
    public boolean isBattle(int num) {
        // Get the battle from the hashmap. If one is not found, return false
        Battle battle = battles.get(num);
        return battle != null;
    }

    /**
     * Get a battle's details from a given battle number or
     * "No such battle" if one doesn't exist.
     *
     * @param num The number of the battle.
     * @return The battle's details from a given battle number.
     **/
    public String getBattle(int num) {
        // Get the battle from the hashmap. If one is not found, return "No such battle"
        Battle battle = battles.get(num);
        return battle != null ? battle.toString() : "No such battle";
    }

    /**
     * Get a list of all battles in the system.
     *
     * @return A list of all battles in the system.
     **/
    public String getAllBattles() {
        // Get all battles
        String s = "********************\n";
        for (Battle value : battles.values()) {
            s += value + "\n";
        }

        // If no battles are retrieved, add "No battles" to the result
        if (!s.contains("Battle")) {
            s += "No battles\n";
        }
        return s + "********************\n";
    }

    /**
     * Simulates a battle by locating a force from the ASF
     * which can engage in the battle. The result of the
     * battle will be one of the following:
     * 0 - Battle won so the gains are added to the
     * war chest.
     * 1 - Battle lost as no suitable force is available
     * so losses are deducted from the war chest.
     * 2 - Battle lost on battle strength so losses are
     * deducted from the war chest and the force is destroyed.
     * 3 - Battle lost and the admiral is completely defeated
     * (war chest is empty and no forces to recall).
     * -1 - No such battle is found.
     *
     * @param battleNo The number of the battle.
     * @return An integer showing the result of the battle.
     */
    public int doBattle(int battleNo) {
        // Get the battle from the hashmap
        Battle battle = battles.get(battleNo);

        // If the battle doesn't exist, return -1
        if (battle == null) {
            return -1;
        }

        for (Force force : forces.values()) {
            if (!force.isActive() || !force.canFight(battle.getBattleType())) {
                continue;
            }

            if (force.getStrength() >= battle.getEnemyStrength()) {
                warChest += battle.getGains();
                return 0;
            } else {
                warChest -= battle.getLosses();
                force.setDestroyed();
                return 2;
            }
        }

        if (isDefeated()) {
            return 3;
        } else {
            warChest -= battle.getLosses();
            return 1;
        }
    }

    /**
     * Initialises the forces into the system.
     */
    private void setupForces() {
        // Load all the forces into the system
        forces.put("IW1", new Wing("IW1", "Twister", 200, 10));
        forces.put("SS2", new StarShip("SS2", "Enterprise", 10, 20));
        forces.put("WB3", new WarBird("WB3", "Droop", 100, false));
        forces.put("IW4", new Wing("IW4", "Winger", 200, 20));
        forces.put("WB5", new WarBird("WB5", "Hang", 300, true));
        forces.put("SS6", new StarShip("SS6", "Voyager", 15, 10));
        forces.put("SS7", new StarShip("SS7", "Explorer", 4, 5));
        forces.put("WB9", new WarBird("WB9", "Hover", 400, false));
        forces.put("IW10", new Wing("IW10", "Flyer", 200, 5));
    }

    /**
     * Initialises the battles into the system.
     */
    private void setupBattles() {
        // Load all the battles into the system
        battles.put(1, new Battle(1, BattleType.FIGHT, "Borg", 200, 300, 100));
        battles.put(2, new Battle(2, BattleType.SKIRMISH, "Kardassians", 700, 200, 120));
        battles.put(3, new Battle(3, BattleType.AMBUSH, "Ferengi", 100, 400, 150));
        battles.put(4, new Battle(4, BattleType.FIGHT, "Ewoks", 600, 600, 200));
        battles.put(5, new Battle(5, BattleType.AMBUSH, "Borg", 500, 400, 90));
        battles.put(6, new Battle(6, BattleType.SKIRMISH, "Groaners", 150, 100, 100));
        battles.put(7, new Battle(7, BattleType.FIGHT, "Borg", 150, 500, 300));
        battles.put(8, new Battle(8, BattleType.AMBUSH, "Wailers", 300, 300, 300));
    }

    /**
     * Writes the game state to a specified file.
     *
     * @param fname The name of the file to store the game state.
     */
    public void saveGame(String fname) {
        // Save the current game's state to fname. If an error occurs, print the stack trace
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fname))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialise a SpaceWars object from a given filename
     * storing the game state.
     *
     * @param fname The name of the file storing the game state.
     * @return The initialised SpaceWars object.
     */
    public SpaceWars restoreGame(String fname) {
        // Load the current game's state from fname and return it. If an error occurs, print the stack trace
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fname))) {
            return (SpaceWars) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Loads the battles from a given filename.
     *
     * @param fname The name of the file storing the battles.
     */
    private void readBattles(String fname) {
        // Open fname in a scanner object, so it can be iterated through. If an error occurs, print the stack trace
        try (Scanner scanner = new Scanner(new File(fname))) {
            // While there's still more data, keep reading
            int battleNumber = 1;
            while (scanner.hasNextLine()) {
                // Get the whole line of data into an array, so we can process it
                String[] tokens = scanner.nextLine().split(",");

                // Determine the battle type of the current line
                BattleType battleType;
                switch (tokens[0]) {
                    case "Skirmish":
                        battleType = BattleType.SKIRMISH;
                        break;
                    case "Ambush":
                        battleType = BattleType.AMBUSH;
                        break;
                    case "Fight":
                        battleType = BattleType.FIGHT;
                        break;
                    default:
                        battleType = null;
                }

                // Create a new battle from the current line
                battles.put(battleNumber, new Battle(battleNumber, battleType, tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                battleNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
