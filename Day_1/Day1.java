import java.util.*;
public class Day1{
    public static void main(String[] args) {
        List<String> inputs = readInput.Input();
        int res = 0;
        for(String input : inputs){
            String val = "";
            for(char c : input.toCharArray()){
                if(Character.isDigit(c)) val+= c;
            }
            int n = val.length();
            // if(n > 2) val = ""+val.charAt(0) + val.charAt(n-1);
            // else if(n == 1) val = ""+val.charAt(0)+val.charAt(0) ;
            if(n > 2) val = String.format("%c%c",val.charAt(0),val.charAt(n-1));
            else if(n == 1) val = String.format("%c%c",val.charAt(0),val.charAt(0));
            int v = Integer.parseInt(val);
            res += v;
        }
        System.out.println(res);
    }
}