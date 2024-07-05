package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Spark02_RDD_Memory_Partition_Data {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("");
        sparkConf.setMaster("local[6]");
        sparkConf.set("spark.default.parallelism","4");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        List<String> stringList = Arrays.asList("zhangsan", "王五", "lishi");
        JavaRDD<String> stringJavaRDD = javaSparkContext.parallelize(stringList ,3);
        //TODO Saprk分区数据的存储基本原则：平均分，使用了一定的算法
        stringJavaRDD.saveAsTextFile("output1");
        List<String> collect = stringJavaRDD.collect();
        collect.forEach(System.out::println);
        javaSparkContext.close();
    }
}
