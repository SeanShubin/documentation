package com.seanshubin.documentation.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SpecifyEncodingSampleMain {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("README.md");
        System.out.println(fileReader.getEncoding());

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("README.md"), Charset.defaultCharset());
        System.out.println(inputStreamReader.getEncoding());
    }
}
