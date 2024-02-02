import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class filesinjava {
    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter writefile = new FileWriter("filename.txt");
            writefile.write("testing");
            writefile.close();
            System.out.println("Successfully written in file!");
        } catch(IOException e){

            System.out.println("Error!");
            e.printStackTrace();
        }

    }
}