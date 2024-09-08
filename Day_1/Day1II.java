import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Day1II{
    static Map<String,Integer> map = new HashMap<>();
    static{
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
    }
    public static void main(String[] args) {
        try{
            File ip = new File("input.txt");
            Scanner sc = new Scanner(ip);
            int res = 0;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String first = null;
                String last = null;
                for(int idx = 0; idx < line.length();idx++){
                    if(Character.isDigit(line.charAt(idx))){
                        if(first == null) first = String.valueOf(line.charAt(idx));
                        last = String.valueOf(line.charAt(idx));
                    }
                    for(String word : map.keySet()){
                        if(line.startsWith(word,idx)){
                            if(first == null){
                                first = word;
                            }
                            last = word;
                            idx += word.length() - 2;
                            break;
                        }
                    }
                }   
                int firstInt = map.containsKey(first) ? map.get(first) : Integer.parseInt(first);
                int lastInt = map.containsKey(last) ? map.get(last) : Integer.parseInt(last);
                res += ((firstInt * 10) + lastInt);
            }
            System.out.println(res);
            sc.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
}

