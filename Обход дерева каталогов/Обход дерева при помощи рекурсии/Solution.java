package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {

  /**
   * рекурсивный вызов, однако не учитывает, если в подпапках файлы с одинаковым названием
   *
   * @param filePath
   * @param list
   */
  public static void findFilesInFolders(File filePath, List<File> list) {
    if (filePath.isDirectory()) {
      for (File one : filePath.listFiles()) {
        findFilesInFolders(one, list);
      }
    } else {
      if (filePath.length() <= 50 && filePath.getPath().endsWith(".txt")) {
        list.add(filePath);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    String path = args[0];
    String resultFileAbsolutePath = args[1];

    File file = new File(resultFileAbsolutePath);
    File dstFile = new File(file.getParent() + "/allFilesContent.txt");
    if (!FileUtils.isExist(dstFile)) {
      FileUtils.renameFile(file, dstFile);
    }
    FileWriter fw = new FileWriter(dstFile);

    File filePath = new File(path);
    ArrayList<File> list = new ArrayList<>();
    findFilesInFolders(filePath, list);

    Comparator<File> comparable = Comparator.comparing(File::getName);
    Collections.sort(list, comparable);

    for (File element : list) {
      if (!element.getAbsolutePath().equals(dstFile.getAbsolutePath())) {
        char[] cbuf = new char[(int) element.length()];
        try (FileReader fileReader = new FileReader(element)) {
          fileReader.read(cbuf);
          fw.write(cbuf);
          fw.write("\n");
        } catch (Exception e) {
        }
      }
    }
    fw.close();
  }
}
