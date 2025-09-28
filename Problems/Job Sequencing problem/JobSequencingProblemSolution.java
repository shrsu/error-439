import java.util.*;

class Job {
    int id;        // Job ID
    int deadline;  // Deadline of job
    int profit;    // Profit if completed before deadline

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblemSolution {

    // Function to schedule jobs for maximum profit
    public static int[] jobSequencing(Job[] jobs, int n) {
        // Step 1: Sort jobs by profit (descending order)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Initialize schedule
        int[] result = new int[maxDeadline + 1]; // index 0 unused
        Arrays.fill(result, -1);
        int totalProfit = 0;
        int jobsDone = 0;

        // Step 4: Assign jobs to slots
        for (Job job : jobs) {
            // Find a free slot for this job (latest possible before deadline)
            for (int j = job.deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = job.id;
                    totalProfit += job.profit;
                    jobsDone++;
                    break;
                }
            }
        }

        System.out.println("Total Jobs Done: " + jobsDone);
        System.out.println("Total Profit: " + totalProfit);

        return result;
    }
}
