package com.opstty.mapper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class HeightSortMapper extends Mapper<LongWritable, Text, DoubleWritable, NullWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!value.toString().contains("GENRE") && !value.toString().contains("HAUTEUR")) {
            String sheight = value.toString().split(";")[6];
            double dheight = 0;
            if (sheight!=null && sheight.length()>0){
                dheight = Double.parseDouble(sheight);
            }
            DoubleWritable height = new DoubleWritable(dheight);
            context.write(height, NullWritable.get());
        }

    }
}