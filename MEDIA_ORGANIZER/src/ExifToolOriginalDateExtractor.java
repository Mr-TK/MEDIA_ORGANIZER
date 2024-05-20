import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExifToolOriginalDateExtractor {

    public static void main(String[] args) {
        String imageFilePath = "E://MEDIA_ORGANIZER//img01.jpg";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("exiftool", "-OriginalDate", imageFilePath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Extract and print original date
                System.out.println(line);
                String originalDate = extractOriginalDate(line);
                if (originalDate != null) {
                    System.out.println("Original Date: " + originalDate);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("ExifTool process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String extractOriginalDate(String line) {
        // Assuming the format is "Original Date: [date]"
        int indexOfColon = line.indexOf(":");
        if (indexOfColon != -1 && indexOfColon < line.length() - 1) {
            return line.substring(indexOfColon + 1).trim();
        }
        return null;
    }
}
