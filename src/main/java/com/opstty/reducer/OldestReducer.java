package com.opstty.reducer;

import com.opstty.CustomWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OldestReducer extends Reducer<NullWritable, CustomWritable, IntWritable ,NullWritable> {
    private IntWritable result = new IntWritable();

    public void Reduce(NullWritable key,Iterable<CustomWritable> values, Context context) throws IOException, InterruptedException{
       int a = 2020;
       int d = 0;
       for (CustomWritable i : values){
            if (i.getAge()<a){
                a = i.getAge();
                d = i.getDistrict();
            }
       }
        context.write(new IntWritable(d),NullWritable.get());
    }
}
