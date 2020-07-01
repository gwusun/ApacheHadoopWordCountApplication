package com.sunwu.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSClient {
    public static void main(String[] args) throws IOException, Exception, URISyntaxException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.5.10:9000"), conf, "root");
        fs.copyFromLocalFile(new Path("e://test.txt"),new Path("/"));
        fs.close();
    }
}
