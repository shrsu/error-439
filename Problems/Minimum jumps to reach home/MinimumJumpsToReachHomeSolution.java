import java.util.*;

public class MinimumJumpsToReachHomeSolution {

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbid = new HashSet<>();
        for (int f : forbidden) {
            forbid.add(f);
        }

        // Upper bound: we shouldn't go infinitely right
        int limit = 6000; // safe upper bound

        // BFS queue: {pos, lastJumpWasBackward}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 }); // 0 -> position, 0 -> last jump not backward

        // visited[pos][0] = visited with forward last, visited[pos][1] = visited with
        // backward last
        boolean[][] visited = new boolean[limit + 1][2];
        visited[0][0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int pos = curr[0];
                int back = curr[1];

                if (pos == x)
                    return steps;

                // Forward jump
                int forward = pos + a;
                if (forward <= limit && !forbid.contains(forward) && !visited[forward][0]) {
                    visited[forward][0] = true;
                    q.offer(new int[] { forward, 0 });
                }

                // Backward jump (only if last move wasn't backward)
                int backward = pos - b;
                if (back == 0 && backward >= 0 && !forbid.contains(backward) && !visited[backward][1]) {
                    visited[backward][1] = true;
                    q.offer(new int[] { backward, 1 });
                }
            }
            steps++;
        }

        return -1;
    }

}
