package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TreesByDistrictMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        if (!value.toString().contains("ARRONDISSEMENT")) {
            Text species = new Text(value.toString().split(";")[1]);
            context.write(species, new IntWritable(1));
        }
    }
}
