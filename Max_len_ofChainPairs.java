import java.util.*;
public class Max_len_ofChainPairs{
    public static void main(String[] args) {
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int chainlen=1;
        int lastfinish=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>lastfinish){
                chainlen++;
                lastfinish=pairs[i][1];
            }
        }
        System.out.println(chainlen);
    }
}