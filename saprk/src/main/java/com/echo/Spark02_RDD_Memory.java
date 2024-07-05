package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Spark02_RDD_Memory {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("");
        sparkConf.setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);


        //TODO 利用环境对象对接内存数据源，构建RDD对象
        List<String> stringList = Arrays.asList("zhangsan", "王五", "lishi");
        //RDD类似于数据管道，可以流转数据，但是不能保存数据
        JavaRDD<String> stringJavaRDD = javaSparkContext.parallelize(stringList);
        List<String> collect = stringJavaRDD.collect();
        collect.forEach(System.out::println);

        javaSparkContext.close();
    }
}
