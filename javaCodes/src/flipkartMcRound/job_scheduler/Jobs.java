package flipkartMcRound.job_scheduler;

import java.util.List;

public class Jobs {

    String jobId;
    Integer deadline;
    Integer profit;

    public Jobs(String jobId, Integer deadline, Integer profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}
