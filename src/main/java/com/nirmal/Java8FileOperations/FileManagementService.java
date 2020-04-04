package com.nirmal.Java8FileOperations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileManagementService {

    @Value("${file.location.parentfolder.path}")
    private String parentFolderPath;


    protected  void moveFilesAndFolders() throws IOException {

        String parentFolderPath="C:\\Users\\User\\IdeaProjects\\JAVA8_FILE_HANDLING\\src\\main\\resources\\PARENT_FOLDER\\";

        String destFolderPath="C:\\Users\\User\\IdeaProjects\\JAVA8_FILE_HANDLING\\src\\main\\resources\\OUTPUT\\";

        Files.move(Paths.get(parentFolderPath),Paths.get(destFolderPath), StandardCopyOption.REPLACE_EXISTING);

        List fileList = Files.list(Paths.get(destFolderPath)).collect(Collectors.toList());

        fileList.forEach(System.out::println);

    }

    protected void listDownAllFilesAndFolder() throws IOException {
        List fileList = Files.list(Paths.get(parentFolderPath)).collect(Collectors.toList());
        fileList.forEach(System.out::println);
    }

    protected void createFile() throws IOException {

        String parentFolderPath="C:\\Users\\User\\IdeaProjects\\JAVA8_FILE_HANDLING\\src\\main\\resources\\PARENT_FOLDER\\";

        File newFile= new File(parentFolderPath+"Test.txt");

        if(!newFile.exists())
            Files.createFile(newFile.toPath());

        System.out.println("Newly created file exists :: "+newFile.exists());

    }

    protected void SearchFilesInFolder() throws IOException {
        String parentFolderPath="C:\\Users\\User\\IdeaProjects\\JAVA8_FILE_HANDLING\\src\\main\\resources\\PARENT_FOLDER\\";
        String fileToSearch="srilanka";

        List fileList = Files.list(Paths.get(parentFolderPath))
                .filter(path -> new File(path.toString()).getName().startsWith(fileToSearch))
                .collect(Collectors.toList());
        fileList.forEach(System.out::println);
    }

    protected void readPropertyFileLineByLine(){
        String fileName = "C:\\Users\\User\\IdeaProjects\\JAVA8_FILE_HANDLING\\src\\main\\resources\\PARENT_FOLDER\\SampleProperty-2020-04-04.properties";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }

    protected File readFile(String fileName){
        File rootfolder=new File(parentFolderPath);
        return rootfolder;
    }

    protected List<File> searchFile(String fileName) throws IOException {
        List<File> listofFiles=new ArrayList<>();
        Files.list(Paths.get(parentFolderPath)).filter(
                path -> new File(path.toString()).getName().startsWith(fileName)
        ).forEach(
                path -> {
                    listofFiles.add(new File(path.toString()));
                }
        );
        return listofFiles;
    }
}
