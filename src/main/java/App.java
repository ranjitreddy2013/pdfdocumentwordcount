/**
 * Created by ranjitlingaiah on 10/7/16.
 */


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

public class App {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new WordCount(), args);
        System.exit(res);
    }
}
