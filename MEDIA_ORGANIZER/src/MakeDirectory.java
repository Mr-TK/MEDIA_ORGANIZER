import java.io.File;
import java.util.Scanner;
public class MakeDirectory {
    //main() method start
    public static void main(String args[]) {
        //Using Scanner class to get the path from the user where he wants to create a folder.
        System.out.println("Enter the path where you want to create a folder: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        //Using Scanner class to get the folder name from the user
        System.out.println("Enter the name of the desired a directory: ");
        path = path+sc.next();
        //Instantiate the File class
        File f1 = new File(path);
        //Creating a folder using mkdirs() method
        boolean bool2 = f1.mkdirs();
        if(bool2){
            System.out.println("Folder is created successfully");
        }else{
            System.out.println("Error Found!");
        }
    }
}

