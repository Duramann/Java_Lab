package com.opstty.mapper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import com.opstty.CustomWritable;
import org.apache.hadoop.io.IntWritable;

import java.io.IOException;

public class OldestMapper extends Mapper<LongWritable, Text, IntWritable, CustomWritable>{

    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        if (!value.toString().contains("ARRONDISSEMENT") && !value.toString().contains("ANNEE PLANTATION")) {
            int district = (Integer.parseInt(value.toString().split(";")[1]));
            int annee = 2020;
            String a = value.toString().split(";")[5];
            if (a!= null && a.length()>0){
                    annee = Integer.parseInt(a);
            }
            IntWritable iwa = new IntWritable(annee);
            IntWritable iwd = new IntWritable(district);
            CustomWritable info = new CustomWritable(iwd, iwa);
            IntWritable i = new IntWritable(1);
            context.write(i,info);
        }

    }

}
