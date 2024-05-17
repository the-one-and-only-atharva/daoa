package Java;
import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {

    public static void scheduleJobs(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> -job.profit)); // Sort by profit descending

        int totalProfit = 0;
        List<Character> result = new ArrayList<>();
        boolean[] slot = new boolean[jobs.length];

        for (Job job : jobs) {
            for (int j = Math.min(jobs.length - 1, job.deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result.add(job.id);
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Profit: " + totalProfit);
        System.out.print("Job sequence: ");
        for (char jobId : result) {
            System.out.print(jobId + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = scanner.nextInt();

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter job " + (i + 1) + " details:");
            System.out.print("ID (single character): ");
            char id = scanner.next().charAt(0);
            System.out.print("Deadline: ");
            int deadline = scanner.nextInt();
            System.out.print("Profit: ");
            int profit = scanner.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        scheduleJobs(jobs);

        scanner.close();
    }
}
