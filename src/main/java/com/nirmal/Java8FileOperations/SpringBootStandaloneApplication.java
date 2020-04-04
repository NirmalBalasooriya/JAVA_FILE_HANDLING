package com.nirmal.Java8FileOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStandaloneApplication implements CommandLineRunner {

    @Autowired
    FileManagementService fileManagementService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStandaloneApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        fileManagementService.listDownAllFilesAndFolder();
        System.out.println(fileManagementService.searchFile("SampleProperty"));
        fileManagementService.readPropertyFileLineByLine();
        System.out.println();
    }

}
