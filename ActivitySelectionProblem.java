import java.util.*;

public class ActivitySelectionProblem{
    public static void main(String args[]){
        ArrayList<Integer> ans = new ArrayList<>();
        int startTime[]={0,1,3,5,5,8};
        int endTime[]={6,2,4,7,9,9};

        // sorting

        int activities[][]= new int[startTime.length][3];
        for(int i=0;i<startTime.length;i++){
            activities[i][0]=i;
            activities[i][1]=startTime[i];
            activities[i][2]=endTime[i];
        }
        // lambda function ->shortform
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
        // for(int i=0;i<activities.length;i++){
        //     for(int j=0;j<3;j++){
        //         System.out.print(activities[i][j]+" ");
        //     }
        //         System.out.println();
            
        // }

        ans.add(0);
        int maxAct=1;
        int endAct=activities[0][2];

        for(int i=1;i<endTime.length;i++){
            if(activities[i][1]>=endAct){
                ans.add(i);
                maxAct++;
                endAct=activities[i][2];
            }
        }

        for(int i=0;i<maxAct;i++){
        System.out.println("A"+ans.get(i).toString()+" ");    
                }
        System.out.println("Maximum number of activities we can perform : "+maxAct);    
        

    }
}