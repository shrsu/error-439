import java.util.*;

public class StepsByKnightSolution {

    static class Cell {
        int x, y, dist;

        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // 1-based to 0-based
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;

        if (startX == targetX && startY == targetY)
            return 0;

        // 8 possible moves of a knight
        int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

        boolean[][] visited = new boolean[N][N];
        Queue<Cell> queue = new LinkedList<>();

        queue.offer(new Cell(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            for (int i = 0; i < 8; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];

                if (isInsideBoard(newX, newY, N) && !visited[newX][newY]) {
                    if (newX == targetX && newY == targetY) {
                        return curr.dist + 1;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new Cell(newX, newY, curr.dist + 1));
                }
            }
        }

        return -1;
    }

    // Helper method to check if position is inside the board
    static boolean isInsideBoard(int x, int y, int N) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

}