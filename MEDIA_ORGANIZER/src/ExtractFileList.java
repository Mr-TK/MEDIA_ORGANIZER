
import java.io.File;

public class ExtractFileList {

    public String[] printFileNames(File[] filelist, int count){
        /*
        Objective : This method is to show the file names with extension
        variable  : 'filelist' list of name of the file from the file object
                    'count' the ittretive couter through which we will
                    traverse through the file object.
        input     : Empty
        return    : void
        */

        if (count == filelist.length)
            //'filelist.length' will give the count of total files
            return new String[0];

        String[] imgarr;
//        if(filelist[count].isFile()) {
//            // Checking if the encountered object is a file or not if True
//            // Diplay the file name
//
//            imgarr[count]=filelist[count].getName();
//
//
//        }
//
//        // Recursively printing files from the directory
//        printFileNames(filelist, count + 1, imgarr);

        if (filelist[count].isFile()) {
            // Create an array to hold the result of the recursive call.
            String[] recursiveResult = printFileNames(filelist, count + 1);

            // Create a new array with space for the current file name and the recursive result.
            imgarr = new String[recursiveResult.length + 1];

            // Copy the recursive result into the new array.
            System.arraycopy(recursiveResult, 0, imgarr, 1, recursiveResult.length);

            // Store the current file name in the first position.
            imgarr[0] = filelist[count].getName();
        } else {
            // If the current item is not a file, skip it and continue the recursive call.
            imgarr = printFileNames(filelist, count + 1);
        }
        return imgarr;
    }


    public static String[] fileLocation(String path) {
        // Providing path of the directory
        //String path = "E://PHOTOS";

        // Creating a file object
        File fileobj = new File(path);

        // Creating object of the class ExtractfileList
        ExtractFileList fobj = new ExtractFileList();

        // checking if the given path exists or is it a directory or not

        if (fileobj.exists() && fileobj.isDirectory()){
            // Array for the files of the directory pointed by fileObj
            File[] filelist = fileobj.listFiles();

            // Display statements
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.println("Displaying Files from the directory : " + fileobj);
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            // Calling the method

            String[] imga =  fobj.printFileNames(filelist, 0);

            for(int i = 0 ; i<imga.length;i++)
                imga[i] = path+"//"+imga[i];

            return imga;
        }


        return new String[0];
    }

}
