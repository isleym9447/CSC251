package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {
    public static boolean writeToFile(File file, String content) throws IOException {
        if (file.exists()) {
            return false;
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            return true;
        }
    }
}
