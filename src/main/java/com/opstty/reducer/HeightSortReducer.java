package com.opstty.reducer;

import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class HeightSortReducer extends Reducer<DoubleWritable, NullWritable, DoubleWritable, NullWritable> {
}