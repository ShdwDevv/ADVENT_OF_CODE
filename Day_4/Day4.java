import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
public class Day4{
    public static int[] makeArray(String[] s){
        int n = s.length;
        int[] arr = new int[n];
        for(int idx = 0;idx < n;idx++){
            arr[idx] = Integer.parseInt(s[idx]);
        }
        return arr;
    }
    public static int findSame(int[] arr1,int[] arr2,int n,int m){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        double res  = 0.5;
        boolean found = false;
        while(i < n && j < m){
            if(arr1[i] < arr2[j]) i++;
            else if(arr1[i] > arr2[j]) j++;
            else {
                // System.out.println(arr1[i]+" "+arr2[j]);
                found = true;
                res *= 2;
                i++;
                j++;
            }
        }
        if(found) return (int)res;
        return 0;
    }
    public static void main(String[] args) {
        int res = 0;
        try{
            File obj = new File("input.txt");
            Scanner sc = new Scanner(obj);
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                String[] firstSplit = s.split(":");
                String numbers = firstSplit[1].trim();
                // System.out.println(numbers);
                String[] twoArrays = numbers.split("\\|");
                String[] s1 = twoArrays[0].trim().split("\\s+");;
                String[] s2 = twoArrays[1].trim().split("\\s+");  
                int[] arr1 = makeArray(s1);
                int[] arr2 = makeArray(s2);
                int n = arr1.length;
                int m = arr2.length;
                res += findSame(arr1,arr2,n,m);
            }
            System.out.println(res);
            sc.close();
        }
        catch(Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}