package zadania;

import java.util.ArrayList;
import java.util.Scanner;

//Print divisors of given number

public class Divisors {
    public static void print() {
        long n=0;
        Scanner s=new Scanner(System.in);
        ArrayList<Long>res=new ArrayList<>();
        while(n==0){
            try{
                System.out.print("Input positive natural number: ");
                String in=s.next();
                long inL=Long.parseLong(in);
                if(inL>0)n=inL;
                else throw new NumberFormatException();
            }catch(NumberFormatException e){
            System.out.println("Wrong input");}}
        for (long i=1;i<=n;i++)if(n%i==0)res.add(i);
        System.out.println("Divisors of number: "+n);
        for (int i=0;i<res.size()-1;i++)System.out.print(res.get(i)+", ");
        System.out.println(res.get(res.size()-1));
    }
}
