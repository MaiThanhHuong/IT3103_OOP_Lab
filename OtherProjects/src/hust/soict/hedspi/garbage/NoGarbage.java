package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) {
        String filename = "D:/oop_lab/IT3103_OOP/OtherProjects/Huong.txt"; 
        StringBuffer outputBuffer = new StringBuffer(); 
        byte[] inputBytes = null;
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return; 
        }

        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputBuffer.append((char) b);
        }
        endTime = System.currentTimeMillis();

        System.out.println("Thời gian sử dụng StringBuffer: " + (endTime - startTime) + " ms");
    }
}
