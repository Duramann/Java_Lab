package com.opstty.reducer;

import com.opstty.CustomWritable2;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxNumberReducer extends Reducer<NullWritable, CustomWritable2, NullWritable ,CustomWritable2> {

    private CustomWritable2 result = new CustomWritable2();

    @Override
    public void reduce(NullWritable key,Iterable<CustomWritable2> values, Context context) throws IOException, InterruptedException{
        int t = 0;
        int d = 0;
        for (CustomWritable2 i : values){
            if (i.getTrees().get() > t){
                t = i.getTrees().get();
                d = i.getDistrict().get();
                result.setDistrict(new IntWritable(d));
                result.setTrees(new IntWritable(t));
            }
        }
        context.write(key,result);
    }

}