/*
 * Name: W.A.K.Dasun Tharuka
*/

import java.util.ArrayList;
import java.util.HashMap; // To store the grid

public class DFSAlgorithm {

    // Create an ArrayList object called direction_path
    private static final ArrayList<String> direction_path = new ArrayList<>(); // List of Path from the Start to Finish

    public ArrayList<String> dfs(HashMap<Integer,ArrayList<String>> grid, ArrayList<Integer> vertex_S, ArrayList<Integer> vertex_F) {

        try {

            // Declaration of ArrayList
            ArrayList<String> visited = new ArrayList<>(); // visited vertices list
            ArrayList<ArrayList> stack = new ArrayList<>(); // stack data structure
            ArrayList<String> direction = new ArrayList<>(); // direction list
            ArrayList<ArrayList> path = new ArrayList<>(); // vertices path list
            //ArrayList<String> direction_path = new ArrayList<>(); // List of Path from the Start to Finish

            // Add start position to the ArrayList called direction_path
            direction_path.add("Start at " + vertex_S);

            // Modify the first index element (column), use the set() method
            // because, ArrayList index start from 0 and end to ArrayList.size()-1
            vertex_S.set(1, vertex_S.get(1) - 1);
            vertex_F.set(1, vertex_F.get(1) - 1);

            // Assigning the start position row and column values to variables
            int row = vertex_S.get(0);
            int column = vertex_S.get(1);

            // Add start position to the ArrayList called visited
            visited.add(vertex_S.get(0) + "," + vertex_S.get(1));
            // Add start position to the ArrayList called path
            path.add(vertex_S);

            // Declaring an ArrayList to store vertex row and column values
            ArrayList<Integer> nextVertex = new ArrayList<>();

            // Looping until vertex_F is found in the ArrayList called stack
            while (!stack.contains(vertex_F)) {

                // Up
                if (row != 1 && !grid.get(row - 1).get(column).equals("0") && !visited.contains((row - 1) + "," + column)) { // && row >= vertex_F.get(0)

                    // Looping until 0 (a stone) or the end of grid is found
                    while (row != 1 && !grid.get(row - 1).get(column).equals("0")) {

                        // Removing all elements from the ArrayList called nextVertex
                        nextVertex.clear();

                        // Decreasing row by 1
                        row--;

                        // Adding row and column values to an ArrayList called nextVertex
                        nextVertex.add(row);
                        nextVertex.add(column);

                        // Adding current vertex position to ArrayLists called visited and stack
                        visited.add(row + "," + column);
                        stack.add(new ArrayList<>(nextVertex));

                        // Adding the moved direction to ArrayList called direction
                        direction.add("Move up to ");

                        // Stop (break) while loop (ice path sliding) if vertex_F is found
                        if (stack.contains(vertex_F)) {
                            break;
                        }
                    }
                }

                // Right
                else if (column != grid.get(row).size() - 1 && !grid.get(row).get(column + 1).equals("0") && column <= vertex_F.get(1) && !visited.contains(row + "," + (column + 1))) {

                    // Looping until 0 (a stone) or the end of grid is found
                    while (column != grid.get(row).size() - 1 && !grid.get(row).get(column + 1).equals("0")) {

                        // Removing all elements from the ArrayList called nextVertex
                        nextVertex.clear();

                        // Increasing column by 1
                        column++;

                        // Adding row and column values to an ArrayList called nextVertex
                        nextVertex.add(row);
                        nextVertex.add(column);

                        // Adding current vertex position to ArrayLists called visited and stack
                        visited.add(row + "," + column);
                        stack.add(new ArrayList<>(nextVertex));

                        // Adding the moved direction to ArrayList called direction
                        direction.add("Move right to ");

                        // Stop (break) while loop (ice path sliding) if vertex_F is found
                        if (stack.contains(vertex_F)) {
                            break;
                        }
                    }
                }

                // Down
                else if (row != grid.size() && !grid.get(row + 1).get(column).equals("0") && !visited.contains((row + 1) + "," + column)) { // && row <= vertex_F.get(0)

                    // Looping until 0 (a stone) or the end of grid is found
                    while (row != grid.size() && !grid.get(row + 1).get(column).equals("0")) {

                        // Removing all elements from the ArrayList called nextVertex
                        nextVertex.clear();

                        // Increasing row by 1
                        row++;

                        // Adding row and column values to an ArrayList called nextVertex
                        nextVertex.add(row);
                        nextVertex.add(column);

                        // Adding current vertex position to ArrayLists called visited and stack
                        visited.add(row + "," + column);
                        stack.add(new ArrayList<>(nextVertex));

                        // Adding the moved direction to ArrayList called direction
                        direction.add("Move down to ");

                        // Stop (break) while loop (ice path sliding) if vertex_F is found
                        if (stack.contains(vertex_F)) {
                            break;
                        }
                    }
                }

                // Left
                else if (column != 0 && !grid.get(row).get(column - 1).equals("0") && column >= vertex_F.get(1) && !visited.contains(row + "," + (column - 1))) {

                    // Looping until 0 (a stone) or the end of grid is found
                    while (column != 0 && !grid.get(row).get(column - 1).equals("0")) {

                        // Removing all elements from the ArrayList called nextVertex
                        nextVertex.clear();

                        // Decreasing column by 1
                        column--;

                        // Adding row and column values to an ArrayList called nextVertex
                        nextVertex.add(row);
                        nextVertex.add(column);

                        // Adding current vertex position to ArrayLists called visited and stack
                        visited.add(row + "," + column);
                        stack.add(new ArrayList<>(nextVertex));

                        // Adding the moved direction to ArrayList called direction
                        direction.add("Move left to ");

                        // Stop (break) while loop (ice path sliding) if vertex_F is found
                        if (stack.contains(vertex_F)) {
                            break;
                        }
                    }
                }

                // if player cannot go up, right, down, left and it is a visited vertex
                else {
                    // Removing the last element of the following ArrayLists
                    stack.remove(stack.size() - 1);
                    direction.remove(direction.size() - 1);
                    path.remove(path.size() - 1);
                    direction_path.remove(direction_path.size() - 1);

                    // Assigning the current vertex position to the row and column variables after removing the last element
                    row = (int) stack.get(stack.size() - 1).get(0);
                    column = (int) stack.get(stack.size() - 1).get(1);
                }

                // Removing all elements from the ArrayList called nextVertex
                nextVertex.clear();

                // Adding row and column values to an ArrayList called nextVertex
                nextVertex.add(row);
                nextVertex.add(column + 1);

                //
                if (!path.contains(nextVertex)) {
                    // Adding current vertex position to ArrayList called path
                    path.add(new ArrayList<>(nextVertex));
                    // Adding current direction and path to ArrayList called direction_path
                    direction_path.add(direction.get(direction.size() - 1) + path.get(path.size() - 1));
                }
            }
            direction_path.add("Done !");

//        System.out.println(stack);
//        System.out.println(visited);

        } catch (Exception e) {
            direction_path.add("-1");
        }

        return direction_path;
    }
}
