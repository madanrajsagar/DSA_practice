import java.util.*;
public class ActivitySelectionProblem{
    public static void main(String args[]){
       int startTime[]= {1,3,0,5,8,5};
       int endTime[]={2,4,6,7,9,9};

        ArrayList<Integer> activities = new ArrayList<>();
       int Act[][]= new int[endTime.length][3];

        // sorting of the endtime
        for(int i=0;i<endTime.length;i++){
            Act[i][0]=i+1;
            Act[i][1]=startTime[i];
            Act[i][2]=endTime[i];
        }

        // lamda function ->shortform
        Arrays.sort(Act,Comparator.comparingDouble(o->o[2]));
        // select first activity
        activities.add(0);
        int maxact=1;
        int lastend= Act[0][2];

        for(int i=1;i<endTime.length;i++){
            if(lastend<=Act[i][1]){
                activities.add(i);
                maxact++;
                lastend=Act[i][2];
            }
        }

System.out.println("Number of activities can be performed : "+maxact);
        

    }
}