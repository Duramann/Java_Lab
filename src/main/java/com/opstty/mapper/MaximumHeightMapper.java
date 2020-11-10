package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;

import java.io.IOException;

public class MaximumHeightMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!value.toString().contains("GENRE") && !value.toString().contains("HAUTEUR")) {
            Text species = new Text(value.toString().split(";")[2]);
            String sheight = value.toString().split(";")[6];
            double dheight = 0;
            if (sheight!=null && sheight.length()>0){
                dheight = Double.parseDouble(sheight);
            }
            int iheight = (int)dheight;
            IntWritable height = new IntWritable(iheight);
            context.write(species,height);
        }

    }
}
