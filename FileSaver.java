import java.io.BufferedWriter;
import java.io.File;

/**
 * Created by Guga on 12/15/2016.
 */
public class FileSaver {
    public static void save(String fileName, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(new File(fileName)));
            bw.write(content);
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
