import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesUtil {
    public static void main(String[] args) throws IOException {

        printFiles();
    }

    private static void printFiles() throws IOException {
        List<String> files = new ArrayList<>();
        Files.walk(Paths.get("D:/projects/bit-merrimack/merrimack-master/uploads/products"))
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    files.add(file.getFileName().toString());
                });
        ConvertJavaToJson.createJsonFile(files,"files");
    }
}
