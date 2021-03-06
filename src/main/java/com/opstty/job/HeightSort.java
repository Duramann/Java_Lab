package com.opstty.job;

import com.opstty.mapper.HeightSortMapper;
import com.opstty.reducer.HeightSortReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

//Answer to 1.8.5 Sort the trees height from smallest to largest

public class HeightSort {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: sort_height <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "sort_height");
        job.setJarByClass(HeightSort.class);
        job.setMapperClass(HeightSortMapper.class);
        job.setCombinerClass(HeightSortReducer.class);
        job.setReducerClass(HeightSortReducer.class);
        job.setOutputKeyClass(DoubleWritable.class);
        job.setOutputValueClass(NullWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
