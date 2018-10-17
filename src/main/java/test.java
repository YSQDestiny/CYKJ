import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/2 17:17.
 */
public class test {



    public static void main(String[] args){
        test test = new test();
        try {
            test.showURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showURL() throws IOException {
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
    }
}
