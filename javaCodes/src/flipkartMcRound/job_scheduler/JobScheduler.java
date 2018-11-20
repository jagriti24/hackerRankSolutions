package flipkartMcRound.job_scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class JobScheduler {

    public static void main(String[] args) {

        List<Jobs> jobs = new ArrayList<>();
        jobs.add(new Jobs("a",2,100));
        jobs.add(new Jobs("b",4,19));
        jobs.add(new Jobs("c",1,27));
        jobs.add(new Jobs("d",2,25));
        jobs.add(new Jobs("e",3,15));

        printData(jobs,"Before sort");

        jobs.sort(new JobComparison());

        printData(jobs, "After sort");
        jobSelection(jobs);

    }

    private static void jobSelection(List<Jobs> jobsList){
        System.out.print("here");
        final int[] counter = {0};
        List<Jobs> finalJobs = new ArrayList<>();
        jobsList.forEach(job -> {
            if(counter[0] <= job.deadline){
                finalJobs.add(job);
                counter[0] = counter[0] +1;
            }
        });
        finalJobs.sort(new DeadlineComparison());
        printData(finalJobs, "Final result:");
    }


    private static void printData(List<Jobs> jobs, String message){
        System.out.println(message);
        jobs.forEach(a -> {
            System.out.println("jobId: "+ a.jobId+" deadline : "+ a.deadline+" profit : "+a.profit);
        });
    }
}


class JobComparison implements Comparator<Jobs>{
    @Override
    public int compare(Jobs o1, Jobs o2) {
        return o2.profit - o1.profit;
    }
}

class DeadlineComparison implements Comparator<Jobs>{
    @Override
    public int compare(Jobs o1, Jobs o2) {
        return o1.deadline - o2.deadline;
    }
}

