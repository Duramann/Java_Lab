package com.opstty.job;

import com.opstty.mapper.MaximumHeightMapper;
import com.opstty.mapper.NumberTreesSpeciesMapper;
import com.opstty.reducer.IntSumReducer;
import com.opstty.reducer.MaximumHeightReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

//1.8.4 Maximum height per specie of tree

public class MaximumHeight {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: max_height <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "max_height");
        job.setJarByClass(MaximumHeight.class);
        job.setMapperClass(MaximumHeightMapper.class);
        job.setCombinerClass(MaximumHeightReducer.class);
        job.setReducerClass(MaximumHeightReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}