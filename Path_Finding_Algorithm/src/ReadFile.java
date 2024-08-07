/*
 * Name: W.A.K.Dasun Tharuka
*/

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // To store the grid rows
import java.util.HashMap; // To store the grid

public class ReadFile {

    // Create a HashMap object called grid to initialise the data structure from a given input file
    private static final HashMap<Integer,ArrayList<String>> grid = new HashMap<>();

    public HashMap<Integer,ArrayList<String>> getGridMap(String fileName) {

        try {
            System.out.println("\nFile Name :- "+fileName);
            // Create a File class object called gridFile
            File gridFile = new File("GridFiles/"+fileName);
            // Read the contents of the text file
            Scanner gridReader = new Scanner(gridFile);

            // Initializing gridRowNo for HashMap key
            int gridRowNo = 1;

            // Get a line in each iteration
            while (gridReader.hasNextLine()) {

                // Assigning the line to the variable called data
                String data = gridReader.nextLine();

                // Create an ArrayList object called gridRow
                ArrayList<String> gridRow = new ArrayList<>();

                for (int i=0; i<data.length(); i++) {
                    // Add line elements to the ArrayList called gridRow
                    gridRow.add(String.valueOf(data.charAt(i)));
                }

                // Add/put key and value (gridRowNo, gridRow)
                grid.put(gridRowNo,gridRow);

                gridRowNo++;
            }

            // Close the file connection
            gridReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return grid;
    }
}
