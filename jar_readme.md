## 编译 jar
``` 
package com.sunwu.wordcount;

public class demo_jar {
    public static void main(String[] args) {
        System.out.println("i am main in demo_jar");
    }
}

D:\GZUniversity\ApacheHadoopWordCountApplication>javac demo_jar.java

D:\GZUniversity\ApacheHadoopWordCountApplication>java demo_jar
i am main in demo_jar

D:\GZUniversity\ApacheHadoopWordCountApplication>jar -cvf hello.jar demo_jar.class
已添加清单
正在添加: demo_jar.class(输入 = 431) (输出 = 292)(压缩了 32%)

D:\GZUniversity\ApacheHadoopWordCountApplication>java -jar hello.jar
hello.jar中没有主清单属性


jar -cvfm hello.jar manifest.mf demo_jar.class 
java -jar hello.jar
```


