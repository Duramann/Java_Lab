package com.opstty;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.jetbrains.annotations.NotNull;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CustomWritable implements Writable {
    private IntWritable district;
    private IntWritable age;

    public CustomWritable(){
        this.district = new IntWritable(0);
        this.age = new IntWritable(2020);
    }

    public CustomWritable(IntWritable d, IntWritable a){
        this.district = d;
        this.age = a;
    }

    public IntWritable getAge(){
        return this.age;
    }

    public IntWritable getDistrict(){
        return this.district;
    }

    public void setAge(IntWritable a){
        this.age = a;
    }

    public void setDistrict(IntWritable d){
        this.district = d;
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        district.readFields(in);
        age.readFields(in);
    }

    @Override
    public void write(DataOutput data) throws IOException {
        district.write(data);
        age.write(data);
    }

    @Override
    public String toString() {
        return "District : " + getDistrict();
    }



}
