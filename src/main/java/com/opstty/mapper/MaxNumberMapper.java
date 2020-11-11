package com.opstty.mapper;

import com.opstty.CustomWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opstty.CustomWritable2;

import java.io.IOException;

public class MaxNumberMapper extends Mapper<LongWritable, Text, NullWritable, CustomWritable2>{

    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        int district = Integer.parseInt(value.toString().split("      ")[0]);
        int trees = Integer.parseInt(value.toString().split("      ")[1]);
        IntWritable iwa = new IntWritable(trees);
        IntWritable iwd = new IntWritable(district);
        CustomWritable2 info = new CustomWritable2(iwd, iwa);
        context.write(NullWritable.get(),info);
        }

    }