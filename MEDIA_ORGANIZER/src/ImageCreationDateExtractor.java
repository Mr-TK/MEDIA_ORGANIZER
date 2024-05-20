import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageCreationDateExtractor {
    public static void main(String[] args) {
        // Path as input
        String imageFilePath = "E://MEDIA_ORGANIZER//img01.jpg";

        try{
            // Creating object of 'ProcessBuilder' class to execute exiftool command
            // exiftool 'path' path of jpg or png file
            // '-FileModifyDate' will fetch the creation date of that image
            ProcessBuilder processBuilder = new ProcessBuilder("exiftool","-FileModifyDate", imageFilePath);

            // Merging the error stream with input
            processBuilder.redirectErrorStream(true);

            // Intiating the command and the result of the process is storing in process variable
            Process process = processBuilder.start();

            // Creating Bufferreader object to read the input stream of the  process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Creating a String object line
            String line;


            while ((line = reader.readLine()) != null){
                /*  Initiating loop To read each line of the process input strem by assigning
                    it to line variable
                    within loop calling the method 'extractcreationDate' to extract the creation
                    date from 'line' and checking if it's not null.
                 */

                String creationDate = extractcreationDate(line);
                if(creationDate != null)
                    System.out.println(creationDate.substring(0,10));
                    //System.out.println("File Creation date: "+creationDate);

            }
            // After the loop  waiting for exiftool to execute its process and storing the exitcode
            int exitCode = process.waitFor();

            //Displaying the exitcode
            System.out.println("ExifTool process exited with code:"+ exitCode);
        }catch (IOException | InterruptedException exc){
            // To handle the exception that might be thrown during execution
            exc.printStackTrace();
        }
    }

    private static String extractcreationDate(String inputstream){
        Pattern pattern = Pattern.compile(":\\s(.+)");
        Matcher matcher = pattern.matcher(inputstream);
        if (matcher.find())
            return matcher.group(1);


        return null;
    }
}
