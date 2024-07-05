package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Spark03_RDD_Disk {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("");
        sparkConf.setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);


        //TODO 利用环境对象对接磁盘数据源，构建RDD对象
        JavaRDD<String> javaRDD = javaSparkContext.textFile("/Users/estim/Desktop/Lin_coding/2024/bigData/gmall-20240-realtime/gmall-20240-realtime/data/test.txt");


        List<String> collect = javaRDD.collect();
        collect.forEach(System.out::println);
        javaSparkContext.close();
    }
}
