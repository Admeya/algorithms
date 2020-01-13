package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // полный путь к файлу
        String fileToZip = args[0];
        // путь к zip-архиву
        String zipArchiveString = args[1];
        ZipFile zipFile = new ZipFile(zipArchiveString);

        // прочитали файл
        Path source = Paths.get(fileToZip);
        String absoluteName = "new/" + source.getFileName();
        Map<String, byte[]> map = new HashMap<>();

        // поток из зип-архива
        try (FileInputStream fos = new FileInputStream(zipArchiveString);
            ZipInputStream zipInStream = new ZipInputStream(fos)) {
            ZipEntry entry;
            while ((entry = zipInStream.getNextEntry()) != null) {
                map.put(entry.getName(), inputStreamToByteArray(zipFile.getInputStream(entry)));
            }
        } catch (Exception e) {
            System.out.println("Ooops 1");
        }

        try (FileOutputStream fos = new FileOutputStream(zipArchiveString);
            ZipOutputStream zipoutputstream = new ZipOutputStream(fos);
          //  FileInputStream fis = new FileInputStream(fileToZip)
        ) {
            zipoutputstream.putNextEntry(new ZipEntry(absoluteName));
//            zipoutputstream.write(inputStreamToByteArray(fis));
            Files.copy(source, zipoutputstream);
            zipoutputstream.closeEntry();

            for (Map.Entry<String, byte[]> in : map.entrySet()) {
                if (!absoluteName.equals(in.getKey())) {
                    zipoutputstream.putNextEntry(new ZipEntry(in.getKey()));
                    zipoutputstream.write(in.getValue());
                    zipoutputstream.closeEntry();
                }
            }
        } catch (Exception e) {
            System.out.println("Ooops 2");
        }
    }

    static byte[] inputStreamToByteArray(InputStream is) {
        byte[] result;
        try(ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

            int nRead;
            byte[] data = new byte[1024];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            result = buffer.toByteArray();
        } catch (Exception ex) {
            result = new byte[] {};
        }

        return result;
    }
}
