import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImageMetadataExample {

    public static void main(String[] args) {
        String imageFilePath = "E://PHOTOS1//WIN_20211006_10_31_14_Pro.jpg";

        try {

            ProcessBuilder processBuilder = new ProcessBuilder("exiftool", imageFilePath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("ExifTool process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
