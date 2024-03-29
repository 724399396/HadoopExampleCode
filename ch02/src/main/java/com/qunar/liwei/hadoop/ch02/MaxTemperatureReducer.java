package com.qunar.liwei.hadoop.ch02;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class MaxTemperatureReducer extends MapReduceBase
	implements Reducer<Text, IntWritable, Text, IntWritable>{
	
	public void reduce(Text key, Iterator<IntWritable> values,
			OutputCollector<Text,IntWritable> output, Reporter reporter)
			throws IOException {
		
		int maxValue = Integer.MIN_VALUE;
		while (values.hasNext()) {
			maxValue = Math.max(values.next().get() , maxValue);
		}
		output.collect(key, new IntWritable(maxValue));
	}
}
