import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Day2{
    public static void main(String[] args) {
        int REDLIMIT = 12;
        int GREENLIMIT = 13;
        int BLUELIMIT = 14;
        int res = 0;
        try{
            File obj = new File("input.txt");
            Scanner sc = new Scanner(obj);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                int flag = 1;
                String[] firstSplit = data.split(":");
                int n = Integer.parseInt(firstSplit[0].split(" ")[1]);
                // System.out.println(n);
                String[] secondSplit = firstSplit[1].split(";");
                for(String second : secondSplit){
                    String[] thirdSplit = second.split(",");
                    // System.out.println(Arrays.toString(thirdSplit));
                    for(String third : thirdSplit){
                        String[] fourthSplit = third.trim().split(" ");
                        // System.out.println(Arrays.toString(fourthSplit));
                        if((fourthSplit[1].equals("red") && Integer.parseInt(fourthSplit[0]) > REDLIMIT) || (fourthSplit[1].equals("blue") && Integer.parseInt(fourthSplit[0]) > BLUELIMIT) || (fourthSplit[1].equals("green") && Integer.parseInt(fourthSplit[0]) > GREENLIMIT)) flag = 0;
                    }
                }
                if(flag == 1) res += n;
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        System.out.println(res);
    }
}