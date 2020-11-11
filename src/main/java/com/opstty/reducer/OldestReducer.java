package com.opstty.reducer;

import com.opstty.CustomWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OldestReducer extends Reducer<IntWritable, CustomWritable, IntWritable ,CustomWritable> {
    private CustomWritable result = new CustomWritable();

    @Override
    public void reduce(IntWritable key,Iterable<CustomWritable> values, Context context) throws IOException, InterruptedException{
       int a = 2020;
       int d = 0;
       for (CustomWritable i : values){
            if (i.getAge().get()<a){
                a = i.getAge().get();
                d = i.getDistrict().get();
                result.setDistrict(new IntWritable(d));
                result.setAge(new IntWritable(a));
            }
       }
        context.write(key,result);
    }
}
