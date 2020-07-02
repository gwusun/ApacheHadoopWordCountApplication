package com.sunwu.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSClient {
    public static void main(String[] args) throws IOException, Exception, URISyntaxException {
        HDFSClient hdfsClient = new HDFSClient();
        hdfsClient.hdfsDownload();
    }

    public void hdfsUpload() throws IOException, URISyntaxException, InterruptedException {

        Configuration conf = new Configuration();
//        获取一个hdfs对象
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.5.10:9000"), conf, "root");
//        使用这个对象操作 hdfs
        fs.copyFromLocalFile(new Path("e://test.txt"), new Path("/"));
//        关闭
        fs.close();
    }
    public void hdfsDownload() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
//        获取hdfs句柄
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.5.10:9000"), conf, "root");
//        拿这个句柄操作 hdfs
        fs.copyToLocalFile(new Path("/test.txt"),new Path("D:/"));
//        用完关闭
        fs.close();
    }
}
