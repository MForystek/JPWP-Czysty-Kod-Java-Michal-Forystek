package zadania.PrimeNumbers;

import java.util.ArrayList;
import java.util.List;

//Return list of prime numbers less or equal to given number
//Method -> Sieve of Eratosthenes

public class PrimeNumbers {
    public static List<Integer> search(int n){
        List<Integer> temp=new ArrayList<>();
        List<Integer>p=new ArrayList<>();
        //Error code in first element of list
        //0 - success
        //-1 - too small input
        if(n<2)p.add(-1);
        else p.add(0);
        for(int l=2;l<=n;l++)if(!temp.contains(l)){
            p.add(l);
            //we're using l*2 to ensure that "temp" contains only composite numbers
            for(int j=l*2;j<=n;j+=l)if(!temp.contains(j))temp.add(j);
        }
        return p;
    }
}
