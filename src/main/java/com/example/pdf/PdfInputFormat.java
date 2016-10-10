package com.example.pdf;

/**
 * Created by ranjitlingaiah on 10/7/16.
 */
import java.io.IOException;

import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class PdfInputFormat extends FileInputFormat {

    @Override
    public RecordReader createRecordReader(
            InputSplit split, TaskAttemptContext context) throws IOException,
            InterruptedException {

        return new PdfRecordReader();
    }

}
