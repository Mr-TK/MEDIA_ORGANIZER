import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExifToolCreationDateExtractor {

    public static String main(String imageFilePath) {
        //String imageFilePath = "E://MEDIA_ORGANIZER//img01.jpg";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("exiftool", "-FileCreateDate", imageFilePath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Extract and print creation date
                String creationDate = extractCreationDate(line).substring(0,10);
                if (creationDate != null) {
                    return creationDate;
                    //System.out.println(creationDate.substring(0,10));
                    //System.out.println("File Creation Date: " + creationDate);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("ExifTool process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String extractCreationDate(String line) {
        Pattern pattern = Pattern.compile(":\\s(.+)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
