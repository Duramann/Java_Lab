package com.opstty;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.jetbrains.annotations.NotNull;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CustomWritable2 implements Writable {
    private IntWritable district;
    private IntWritable trees;

    public CustomWritable2(){
        this.district = new IntWritable(0);
        this.trees = new IntWritable(0);
    }

    public CustomWritable2(IntWritable d, IntWritable a){
        this.district = d;
        this.trees = a;
    }

    public IntWritable getAge(){
        return this.trees;
    }

    public IntWritable getDistrict(){
        return this.district;
    }

    public void setTrees(IntWritable a){
        this.trees = a;
    }

    public void setDistrict(IntWritable d){
        this.district = d;
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        district.readFields(in);
        trees.readFields(in);
    }

    @Override
    public void write(DataOutput data) throws IOException {
        district.write(data);
        trees.write(data);
    }

    @Override
    public String toString() {
        return "District : " + getDistrict() + ", Number of trees : " + getAge() ;
    }



}