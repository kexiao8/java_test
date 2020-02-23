import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tommyxiao on 2/23/20 11:07
 */
public class TryWithResoureTest {

    public static void main(String[] args) {

        try {
            String result= readFirstLineFromFile("/tmp/adobegc.log");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}
