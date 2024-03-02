import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    //takes a file of words and returns a map containing each different word as the key and
    //the amount of times the word appears in the file as the value corresponding to the key
    //the words are not case sensitive and counts both capital and lowercase letters as the same key/word
    public static <K, V> Map<String,Integer> sortFile(String filePath) throws IOException{
        FileReader f = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(f);

        Map<String, Integer> fileContents = new HashMap<>();

        //sets first map value which cannot be a repeat
        fileContents.put(reader.readLine(), 1);

        String newLine;
        //loops through entire file until the end
        while((newLine = reader.readLine()) !=null){
            String key = null;
            //loops through map until a key equal to the newly scanned line is found
            for(Map.Entry<String, Integer> entry : fileContents.entrySet()){
                if(entry.getKey().equalsIgnoreCase(newLine)){
                    key = entry.getKey();
                    break;
                }
            }

            //if a match was found within the map, it adds one to the value
            if(key != null){
                fileContents.put(key, fileContents.get(key)+1);
            //if no match was found, it makes the newly scanned line a new key with a value of 1
            }else{
                fileContents.put(newLine, 1);
            }
        }

        reader.close();
        return fileContents;
    }

    //writes a map to a file given the filepath and the map to be written
    //has the key and then the value on the same line
    //each map entry is on a different line
    public static <K, V> void writeMapToFile(String filePath, Map<K, V> m) throws IOException{
        FileWriter w = new FileWriter(filePath);
        BufferedWriter writer = new BufferedWriter(w);

        int countdown = m.size();
        //loops through entire map
        for(Map.Entry<K, V> entry : m.entrySet()){
            //writes map entry
            writer.write(entry.getKey() + " " + entry.getValue());

            //creates a new line unless it is the last map entry to be written
            if(countdown != 1){
                writer.newLine();
            }
            countdown--;
        }

        writer.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to WordCounter!");
        System.out.println("Please input the path to the file to have it's words counted:");
        String filePath = scan.nextLine();
        try{
            writeMapToFile("countedWords.txt", sortFile(filePath));
            System.out.println("Your file has been counted. \nResults can be found in the file: countedWords.txt");
        }catch(Exception e){
            System.out.println("This is not a valid file path.");
        }
        scan.close();
    }
}
