package com.seanshubin.documentation.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TooManyOpenFilesFixed {
    public static void main(String[] args) {
        new TooManyOpenFilesFixed().run();
    }

    public void run() {
        Path path = Paths.get(System.getenv("HOME"));
        listRecursive(path);
    }

    public void listRecursive(Path path) {
        System.out.println(path);
        if (Files.isDirectory(path)) {
            Stream<Path> list = list(path);
            list.forEach(this::listRecursive);
            list.close();
        }
    }

    private Stream<Path> list(Path path) {
        try {
            return Files.list(path);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
