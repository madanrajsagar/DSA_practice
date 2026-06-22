import java.util.HashMap;
import java.util.Set;

public class Hash_Map_implement{
    public static void main(String args[]){
        HashMap<String,Integer> hm= new HashMap<>();

        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("Pak",70);
        System.out.println(hm);    

        // Iterate
        Set<String> keys= hm.keySet();
        
        for(String str :keys){
            System.out.println("key ="+str+","+"value ="+hm.get(str));
        }
    }
}   