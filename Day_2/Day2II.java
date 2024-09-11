import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day2II {
    public static void main(String[] args) {
        int res = 0;
        try{
            File obj = new File("input.txt");
            Scanner sc = new Scanner(obj);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] firstSplit = line.split(":");
                String[] secondSplit = firstSplit[1].split(";");
                int red = 0,blue = 0,green = 0;
                for(String each : secondSplit){
                    String[] thirdSplit = each.trim().split(",");
                    for(String single : thirdSplit){
                        single = single.trim();
                        String[] s = single.split(" ");
                        if(s[1].trim().equals("blue")) blue = Math.max(blue,Integer.parseInt(s[0]));
                        if(s[1].trim().equals("red")) red = Math.max(red,Integer.parseInt(s[0]));
                        if(s[1].trim().equals("green")) green = Math.max(green,Integer.parseInt(s[0]));
                    }
                }
                res += (blue * red * green);
            }
            System.out.println(res);
            sc.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
