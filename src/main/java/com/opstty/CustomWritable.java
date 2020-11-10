package com.opstty;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.jetbrains.annotations.NotNull;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CustomWritable implements Writable {
    private int district;
    private int age;

    public CustomWritable(int d, int a){
        this.district = d;
        this.age = a;
    }

    public int getAge(){
        return this.age;
    }

    public int getDistrict(){
        return this.district;
    }

    public void setAge(int a){
        this.age = a;
    }

    public void setDistrict(int d){
        this.district = d;
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        district = in.readInt();
        age = in.readInt();
    }

    @Override
    public void write(DataOutput data) throws IOException {
        data.writeInt(district);
        data.writeInt(age);
    }

}