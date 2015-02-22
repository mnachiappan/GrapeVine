package com.mnachiappan.graphmessage;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * Created by Anam on 2015-02-22.
 */
public class FileData {
    public static void main (String[] args) throws IOException {

    }
}
public class ReadFile {
    private String path;
    public ReadFile(String file_path) {
        this.path = file_path;
    }

    public String[] OpenFile() throws IOException{
        FileReader file_r = new FileReader(this.path);
        BufferedReader buffered_r = new BufferedReader(file_r);
        String[] animals = new String[600];
        for (int i = 0; i<600; i++) {
            animals[i]=buffered_r.readLine()
            animals[i].toUpperCase();
        }
        buffered_r.close();
        return animals;
    }
}
