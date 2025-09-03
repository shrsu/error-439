import java.util.*;

public class RatInMazeSolution {

    private final int n;
    private final int[][] maze;
    private final boolean[][] visited;

    // Directions: Right, Down, Left, Up
    private final int[] rowDir = {0, 1, 0, -1};
    private final int[] colDir = {1, 0, -1, 0};

    public RatInMazeSolution(int[][] maze) {
        this.maze = maze;
        this.n = maze.length;
        this.visited = new boolean[n][n];
    }

    // Public method: returns all possible paths
    public List<List<String>> findAllPaths() {
        List<List<String>> allPaths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(0, 0, path, allPaths);
        return allPaths;
    }

    private void backtrack(int i, int j, List<String> path, List<List<String>> allPaths) {
        // Base case: destination reached
        if (i == n - 1 && j == n - 1 && maze[i][j] == 1) {
            List<String> successfulPath = new ArrayList<>(path);
            successfulPath.add("(" + i + "," + j + ")");
            allPaths.add(successfulPath);
            return;
        }

        // Check validity
        if (i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0 || visited[i][j]) {
            return;
        }

        // Mark visited
        visited[i][j] = true;
        path.add("(" + i + "," + j + ")");

        // Explore all 4 directions
        for (int d = 0; d < 4; d++) {
            int newRow = i + rowDir[d];
            int newCol = j + colDir[d];
            backtrack(newRow, newCol, path, allPaths);
        }

        // Backtrack
        path.remove(path.size() - 1);
        visited[i][j] = false;
    }

    // Demo
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 1}
        };

        RatInMazeSolution solver = new RatInMazeSolution(maze);
        List<List<String>> paths = solver.findAllPaths();

        if (paths.isEmpty()) {
            System.out.println("No path found!");
        } else {
            System.out.println("All possible paths:");
            for (List<String> p : paths) {
                System.out.println(p);
            }
        }
    }
}