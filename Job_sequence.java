
import java.util.*;

public class Job_sequence{
    static class Job{
        int id;
        int deadline;
        int profit;

        Job(int id,int deadline, int profit){
            this.id=id;
            this.deadline=deadline;
            this.profit=profit;
        }
    }
    public static void main(String[] args) {
        int job_info[][]={{4,20},{1,10},{1,40},{1,30}};

        Job job[]= new Job[job_info.length];
        ArrayList<Job>jobs= new ArrayList<>();
        
        for(int i=0;i<job_info.length;i++){
            jobs.add(new Job(i,job_info[i][0],job_info[i][1]));    
        }

        Collections.sort(jobs,(obj1,obj2)-> obj2.profit-obj1.profit);
    
        ArrayList<Job> job_seq= new ArrayList<>();

        int time=0;
        for(int i=0;i<jobs.size();i++)
        {
            Job obj=jobs.get(i);
            if(obj.deadline>time){
                job_seq.add(obj);
                time+=obj.deadline;
            }
        }

        System.out.println(job_seq.size());
    }
}