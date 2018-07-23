package day1;

import java.io.File;
import java.util.Scanner;

public class FileAndFolders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        System.out.println("File Path: " + filePath);
        File file = new File(filePath);
        if(file.exists()){
            getAllFilesOfDirectory(file);
        }else {
            System.out.println("Invalid Path");
        }
    }

    public static void getAllFilesOfDirectory(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if(file1.isFile()){
                    System.out.println(file1.getName() + "is File");
                }else {
                    System.out.println("Inside Directory : " + file1.getName());
                    getAllFilesOfDirectory(file1);
                }
            }
        }
        else {
            System.out.println(file.getName() + "is file");
        }
    }
}
