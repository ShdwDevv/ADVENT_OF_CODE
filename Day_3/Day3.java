import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day3{
    public static void validating(int r,int c,List<char[]> arr,int[][] valid,int row,int  col){
        int[][] points =  {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int[] point : points){
            int newR = r + point[0];
            int newC = c + point[1];
            if(newR >= 0 && newR < row && newC >= 0 && newC < col && (!Character.isDigit(arr.get(newR)[newC]) && arr.get(newR)[newC] != '.')){
                valid[r][c] = 1;
                return ;
            }
        }

    }
    public static void main(String[] args) {
        int res = 0;
        try{
            // To get file
            File input = new File("input.txt");
            Scanner sc = new Scanner(input);
            List<char[]> arr = new ArrayList<>();
            // To read input
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                arr.add(s.toCharArray());
            }
            int n = arr.size();
            int m = arr.get(0).length;
            int[][] valid = new int[n][m];
            for(int r = 0 ; r < n;r++){
                for(int c = 0 ; c < m;c++){
                    // if the current character is number the validate it
                    if(Character.isDigit(arr.get(r)[c])) validating(r,c,arr,valid,n,m);
                }
            }
            for(int i =0;i < n;i++){
                int j = 0;
                while(j < m){
                    boolean yes = false;
                    int temp = 0;
                    while(j < m && Character.isDigit(arr.get(i)[j])){
                        temp = (temp * 10) + Character.getNumericValue(arr.get(i)[j]);
                        if(valid[i][j] == 1) yes = true;
                        j++;
                    }
                    j++;
                    if(yes){
                        res += temp;
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
