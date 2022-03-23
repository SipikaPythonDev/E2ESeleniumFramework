package capabilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) {
        String dir =System.getProperty("user.dir")+"\\reports";
       /* System.out.println(System.getProperty("user.dir")+"\\reports");
        Path path = Paths.get(dir);
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            FileUtils.deleteDirectory(new File(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
