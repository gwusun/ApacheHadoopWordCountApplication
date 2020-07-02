package com.sunwu.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

//import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;

public class WordcountDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		args = new String[] { "E:/input", "E:/out" };
		System.setProperty("HADOOP_USER_NAME", "root");
		Configuration conf = new Configuration();
		// 开启map端输出压缩

		// 1 获取Job对象
		Job job = Job.getInstance(conf);

		// 2 设置jar存储位置
		job.setJarByClass(WordcountDriver.class);

		// 3 关联Map和Reduce类
		job.setMapperClass(WordcountMapper.class);
		job.setReducerClass(WordcountReducer.class);

		// 4 设置Mapper阶段输出数据的key和value类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		// 5 设置最终数据输出的key和value类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// 6 设置输入路径和输出路径
		// FileInputFormat.setInputPaths(wcjob, "D:/wc/words.txt");
		FileInputFormat.setInputPaths(job, "hdfs://192.168.5.10:9000/wccount/README.txt");

		// 指定处理之后的结果输出到哪个路径
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.5.10:9000/wcoutput2"));

		boolean res = job.waitForCompletion(true);
		// 7 提交job
		System.exit(res ? 0 : 1);
	}
}
