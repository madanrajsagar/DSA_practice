import java.util.ArrayList;
public class MulDArrayList {
    public static void main(String args[]){

       ArrayList<ArrayList<Integer>> mainlist= new ArrayList<>();
        ArrayList<Integer> li1= new ArrayList<>();
        ArrayList<Integer> li2= new ArrayList<>();
        ArrayList<Integer>li3= new ArrayList<>();

        for(int i=1;i<=5;i++){
            li1.add(i*1);
            li2.add(i*2);
            li3.add(i*3);
            }

        mainlist.add(li1);
        mainlist.add(li2);
        mainlist.add(li3);

        for(int i=0;i<mainlist.size();i++){
            ArrayList<Integer> list= mainlist.get(i);
            for(int j=0;j<list.size();j++){
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
        }

       System.out.println(mainlist); 
       }
}