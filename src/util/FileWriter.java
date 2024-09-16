package util;

import java.io.BufferedWriter;

public class FileWriter {

    public static void writefile(String filename,String message) {
        try{
            java.io.FileWriter writer = new java.io.FileWriter("text.file",true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("Welcome to javaTpoint.");
            buffer.close();
            System.out.println("Success");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
