package com.opstty.job;

import com.opstty.CustomWritable2;
import com.opstty.mapper.MaxNumberMapper;
import com.opstty.reducer.MaxNumberReducer;
import com.opstty.reducer.MaximumHeightReducer;
import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MaxNumber {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: max_number <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "max_number");
        job.setJarByClass(MaxNumber.class);
        job.setMapperClass(MaxNumberMapper.class);
        job.setCombinerClass(MaxNumberReducer.class);
        job.setReducerClass(MaxNumberReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(CustomWritable2.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
