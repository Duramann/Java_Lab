package com.opstty.job;

import com.opstty.CustomWritable;
import com.opstty.mapper.HeightSortMapper;
import com.opstty.mapper.OldestMapper;
import com.opstty.reducer.HeightSortReducer;
import com.opstty.reducer.OldestReducer;
import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

//Answer to 1.8.6 District containing the oldest tree

public class Oldest {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: oldest <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "oldest");
        job.setJarByClass(Oldest.class);
        job.setMapperClass(OldestMapper.class);
        job.setCombinerClass(OldestReducer.class);
        job.setReducerClass(OldestReducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(CustomWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}