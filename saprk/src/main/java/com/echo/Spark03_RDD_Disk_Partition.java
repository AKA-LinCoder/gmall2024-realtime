package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;

public class Spark03_RDD_Disk_Partition {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("");
        sparkConf.setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        //TODO 利用环境对象对接磁盘数据源，构建RDD对象
        //路径可以是绝对路径或者相对路径
        //spark框架文件的操作没有的实现，采用MR库（hadoop）来实现
        // 当前读取文件的操作是由Hadoop来决定的



        //文件数据源分区
        // textfile 可以传递一个最小分区数
        // 使用配置参数 min(参数，2)
        // 采用环境默认总核值 min(总核数，2)
        //
        JavaRDD<String> javaRDD = javaSparkContext.textFile("data/test.txt");
        javaRDD.saveAsTextFile("output886");
        List<String> collect = javaRDD.collect();
        collect.forEach(System.out::println);
        javaSparkContext.close();
    }
}
