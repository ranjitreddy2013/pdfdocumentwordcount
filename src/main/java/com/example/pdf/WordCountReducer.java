package com.example.pdf;

/**
 * Created by ranjitlingaiah on 10/7/16.
 */
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    protected void reduce(Text word, Iterable<LongWritable> counts, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (LongWritable count : counts) {
            sum += count.get();
        }
        context.write(word, new LongWritable(sum));
    }
}
