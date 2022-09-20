package Interval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resultant {
    public static Map<Interval,Integer> resulting(List<Interval> a){
        int count=0;
        int starting=1;
        Map<Interval,Integer> mp=new HashMap<Interval, Integer>();
        while(starting<10){
        for(int b=0;b<a.size();b++){
            if(a.get(b).start<=starting&&a.get(b).ending>=(starting+1)){
                count+=1;}
        }
        mp.put(new Interval(starting,starting+1),count);
        starting++;
        count=0;}
        return mp;
    }
    public static void main(String args[]){

        List<Interval> lst=new ArrayList<>();
        lst.add(new Interval(3,6));
        lst.add(new Interval(1,10));
        lst.add(new Interval(2,9));
        lst.add(new Interval(5,8));
        lst.add(new Interval(1,7));
        lst.add(new Interval(2,8));
        lst.add(new Interval(2,5));
        Map<Interval,Integer> rlt=resulting(lst);
        System.out.println(lst);
        System.out.println();
        System.out.println(rlt);


    }

}
