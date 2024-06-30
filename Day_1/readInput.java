import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
class readInput {
    public static List<String> Input(){
        List<String> inputs = new ArrayList<>();
        try{
            File obj = new File("input.txt");
            Scanner sc = new Scanner(obj);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                inputs.add(data);
            }
            sc.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        return inputs;
    }
}
