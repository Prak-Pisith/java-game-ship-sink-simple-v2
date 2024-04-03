import java.util.ArrayList;
import java.util.Scanner;

class Ship {
    private ArrayList<String> locationCell;

    public void setLocationCell(ArrayList<String> locationCell) {
        this.locationCell = locationCell;
    }

    public String healthCheck(String cell) {
        String result = "MISS";

        int index = this.locationCell.indexOf(cell);
        if (index >= 0) {
            this.locationCell.remove(index);
            if (this.locationCell.isEmpty()) result = "KILL";
            else result = "HIT";
        }
        System.out.println("You've " + result + " the ship.");
        return result;
    }
}

// Launcher Class
class GameLauncher {
    public static void main(String[] args) {
        System.out.println("Game Launching ...");
        System.out.println("");

        // TDD
        System.out.println("============ START TESTING GAME ============");
        testCase1();
        testCase2();
        testCase3();
        System.out.println("============ END TESTING GAME ============");
        System.out.println("");

        // Gameplay
        System.out.println("============ START PLAYING GAME ============");
        gamePlay();
        System.out.println("============ END PLAYING GAME ============");
    }

    public static void gamePlay() {
        // Helper
        Scanner scanner = new Scanner(System.in);

        // Init user input
        String userInput;

        // Init Ship Object
        Ship ship = new Ship();

        ArrayList<String> cells = new ArrayList<String>();
        // Get random head cell
        int headCell = (int) (Math.random() * 5);
        // Set maximum cells
        int maxCell = 3;
        // Set Location Cell
        while (maxCell > 0) {
            cells.add(String.valueOf(headCell));
            ++headCell;
            --maxCell;
        }
        ship.setLocationCell(cells);

        // Ship Status
        boolean isAlive = true;

        while (isAlive) {
            // Prompt the user for input
            System.out.print("Enter number: ");
            userInput = scanner.nextLine();
            String result = ship.healthCheck(userInput);
            if (result == "KILL") {
                isAlive = false;
                System.out.println("Ship Sinked");
            }
        }
        // Close the Scanner (optional but good practice)
        scanner.close();
    }

    // ================= TEST CASES =====================
    public static void testCase1 () {
        // ========= START TEST =========
        String testResult = "FAILED";

        // Init Ship
        Ship ship = new Ship();

        // Init Locations
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("2");
        locations.add("3");
        locations.add("4");
        ship.setLocationCell(locations);

        // Guessing
        String userGuess = "2";
        String result = ship.healthCheck(userGuess);

        // Check Result
        if (result == "HIT") testResult = "PASSED";

        // Output
        System.out.println("Test 1:");
        System.out.println("Expected : PASSED");
        System.out.println("Result   : " + testResult);
        // ========= END TEST =========
    }

    public static void testCase2 () {
        // ========= START TEST =========
        String testResult = "FAILED";

        // Init Ship
        Ship ship = new Ship();

        // Init Locations
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("2");
        locations.add("3");
        locations.add("4");
        ship.setLocationCell(locations);

        // Guessing
        String userGuess = "1";
        String result = ship.healthCheck(userGuess);

        // Check Result
        if (result == "MISS") testResult = "PASSED";

        // Output
        System.out.println("Test 2:");
        System.out.println("Expected : PASSED");
        System.out.println("Result   : " + testResult);
        // ========= END TEST =========
    }

    public static void testCase3 () {
        // ========= START TEST =========
        String testResult = "FAILED";

        // Init Ship
        Ship ship = new Ship();

        // Init Locations
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("2");
        locations.add("3");
        locations.add("4");
        ship.setLocationCell(locations);

        // Guessing
        String[] userGuesses = {"2", "3", "4"};
        String result = null;
        for (String userGuess : userGuesses) {
            result = ship.healthCheck(userGuess);
        }

        // Check Result
        if (result == "KILL") testResult = "PASSED";

        // Output
        System.out.println("Test 3:");
        System.out.println("Expected : PASSED");
        System.out.println("Result   : " + testResult);
        // ========= END TEST =========
    }
}