import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Day3II {
    static void findStar(int r,int c,int row,int col,List<String> coOrd,List<char[]> arr){
        for(int x = -1; x<= 1;x++){
            for(int y=-1;y <= 1;y++){
                if(x == 0 && y == 0) continue;
                int nx = r + x;
                int ny = c + y;
                if(nx >= 0 && ny >= 0 && nx < row && ny < col && arr.get(nx)[ny] == '*')coOrd.add(nx+","+ny);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        File input = new File("input.txt");
        Scanner sc = new Scanner(input);
        List<char[]> arr = new ArrayList<>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            arr.add(s.toCharArray());
        }
        int row = arr.size();
        int col = arr.get(0).length;
        Map<String,List<Integer>> gears = new HashMap<>();
        for(int r=0;r < row;r++){
            String gear = null;
            int number = 0;
            for(int c = 0 ; c < col;c++){
                char val = arr.get(r)[c];
                if(!Character.isDigit(val)){
                    if(gear != null){
                        if(!gears.containsKey(gear)) gears.put(gear,new ArrayList<>());
                        // System.out.println(number);
                        gears.get(gear).add(number);
                    }
                    number = 0;
                    gear = null;
                    continue;
                }
                List<String> coOrd = new ArrayList<>();
                // Number
                findStar(r,c,row,col,coOrd,arr);
                if(coOrd.size() > 0) {
                    gear = coOrd.get(0);
                }
                number = (number * 10) + Character.getNumericValue(val);
            }
            // for last numbers
            if(gear != null){
                if(!gears.containsKey(gear)) gears.put(gear,new ArrayList<>());
                // System.out.println(number);
                gears.get(gear).add(number);
            }
        }
        int res = 0;
        // System.out.println(gears);
        for(String gear : gears.keySet()){
            if(gears.get(gear).size() ==2){
                res = res + (gears.get(gear).get(0) * gears.get(gear).get(1));
            }
        }
        System.out.println(res);
        sc.close();
    }
}

// 86879020
// 86745264