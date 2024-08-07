/*
* Name: W.A.K.Dasun Tharuka
*/

// Import ArrayList and HashMap class from java.util package
import java.util.ArrayList;
import java.util.HashMap; // To store the grid

public class PathFind {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        // Create a ReadFile class object called readFile
        ReadFile readFile = new ReadFile();
        // Get the grid HashMap from ReadFile class using method called getGridMap()
        HashMap<Integer, ArrayList<String>> grid = readFile.getGridMap("puzzle_10.txt");

        // Assigning the linearSearch method return values to ArrayLists
        ArrayList<Integer> vertex_S = linearSearch(grid, "S"); // Invokes the linearSearch method
        ArrayList<Integer> vertex_F = linearSearch(grid, "F"); // Invokes the linearSearch method

        System.out.println("Puzzle size : (" + grid.size() + " x " + grid.get(1).size() + ")\n");

        // Print the entire grid
        for (int i : grid.keySet()) {
            System.out.println(i + " " + grid.get(i));
        }

        // Print the start and finish position index
        System.out.println("\n\" S \" found at " + vertex_S);
        System.out.println("\" F \" found at " + vertex_F + "\n");

        // Create a DFSAlgorithm class object called dfsAlgorithm
        DFSAlgorithm dfsAlgorithm = new DFSAlgorithm();
        // Get the direction_path ArrayList from DFSAlgorithm class using method called dfs()
        ArrayList<String> direction_path = dfsAlgorithm.dfs(grid, vertex_S, vertex_F);

        System.out.println("Steps of the shortest path from start to finish");
        System.out.println("-----------------------------------------------");
        System.out.println("Note: [row, column]\n");

        if (!direction_path.contains("-1")) {
            // Print all the steps of the solution algorithm found
            for (int i = 0; i < direction_path.size(); i++) {
                System.out.println((i + 1) + ". " + direction_path.get(i));
            }
        } else {
            System.out.println("** Path does not exist **");
        }

        long endTime = System.currentTimeMillis();
        long runtimes = endTime - startTime;

        System.out.println("\n-----------------------------------------------");
        System.out.println("\nExecution time in milliseconds (ms) : " + runtimes);
    }




    // Create the method to find the start and finish points (vertices)
    public static ArrayList<Integer> linearSearch(HashMap<Integer,ArrayList<String>> grid, String find) {
        // Declare an ArrayList
        ArrayList<Integer> vertex = new ArrayList<>();
        for (int i=1; i<= grid.size(); i++) {
            for (int j=0; j<grid.get(i).size(); j++) {
                if (grid.get(i).get(j).equals(find)) {
                    vertex.add(i);
                    vertex.add(j+1);
                    break;
                }
            }
        }
        return vertex;
    }

}