package com.example.pdf;

/**
 * Created by ranjitlingaiah on 10/7/16.
 */
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private Text word = new Text();
    private final static LongWritable one = new LongWritable(1);
    private boolean caseSensitive = false;
    private Set<String> patternsToSkip = new HashSet<String>();
    private static final Pattern WORD_BOUNDARY = Pattern.compile("\\s*\\b\\s*");

    protected void map(LongWritable key, Text lineText, Context context)
            throws IOException, InterruptedException {

        String line = lineText.toString();
        if (!caseSensitive) {
            line = line.toLowerCase();
        }
        Text currentWord = new Text();
        for (String word : WORD_BOUNDARY.split(line)) {
            if (word.isEmpty() || patternsToSkip.contains(word)) {
                continue;
            }
            currentWord = new Text(word);
            context.write(currentWord,one);
        }

    }
}