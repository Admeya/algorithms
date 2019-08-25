package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {
  private static int folders;
  private static int files;
  private static int bytes;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String fileName = sc.nextLine();
    Path path = Paths.get(fileName);
    if (!Files.isDirectory(path)) {
      System.out.println(path.toString() + " - не папка");
      return;
    }

    getFileTree(path);
    System.out.println("Всего папок - " + (folders - 1));
    System.out.println("Всего файлов - " + files);
    System.out.println("Общий размер - " + bytes);
  }

  public static void getFileTree(Path root) throws IOException {
    // не проходит по вложенным
    //        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {
    //            for (Path entry : stream) {
    //                if (Files.isDirectory(entry)) {
    //                    folders++;
    //                } else {
    //                    files++;
    //                    bytes += Files.size(entry);
    //                }
    //            }
    //        }

    Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        files++;
        bytes += Files.size(file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()) {
          folders++;
        }
        return FileVisitResult.CONTINUE;
      }
    });

  }
}
