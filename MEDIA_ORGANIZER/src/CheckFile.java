import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Paths.*;

class CheckFile {
    public static void checkFilePresent(Path path){
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                System.out.println("It is a directory");
            } else if (Files.isRegularFile(path)) {
                System.out.println("File test.txt present");
            }

        } else {
            System.out.println("File not found ");
        }
    }
    public static void main( String args[] ) {
        String currentDir = "E://";

        String fileName1 = "PHOTOS";
        Path path = get(currentDir + fileName1);
        checkFilePresent(path);

//        String fileName2 = "write.txt";
//        path = Paths.get(currentDir + fileName2);
//        checkFilePresent(path);

    }
}