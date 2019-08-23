package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();

        File rootDir = new File(root);
        Queue<File> fileTree = new PriorityQueue<>();
        Collections.addAll(fileTree, rootDir.listFiles());

        while(!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                list.add(currentFile.getAbsolutePath());
            }
        }

        return list;

    }

    public static void main(String[] args) throws IOException {
        List<String> ls = getFileTree("c:\\temp");
        ls.stream().forEach(System.out::println);
    }
}
