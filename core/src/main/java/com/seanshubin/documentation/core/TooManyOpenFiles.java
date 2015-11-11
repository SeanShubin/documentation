package com.seanshubin.documentation.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TooManyOpenFiles {
    public static void main(String[] args) {
        new TooManyOpenFiles().run();
    }

    public void run() {
        Path path = Paths.get(System.getenv("HOME"));
        listRecursive(path);
    }

    public void listRecursive(Path path) {
        System.out.println(path);
        if (Files.isDirectory(path)) {
            list(path).forEach(this::listRecursive);
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
