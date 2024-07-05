package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class Spark_RDD_Operate {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("app");
        JavaSparkContext javaSparkContext = new JavaSparkContext();
        JavaRDD<Integer> rdd = javaSparkContext.parallelize(Arrays.asList(1, 2, 3));


        //TODO RDD的方法们

        //RDD 方法的分类
        //1 将数据向下流转  转换
        //2 控制数据流转  行动

        //RDD方法处理数据的分类
        //1 单值类型
        //2 键值类型 kv



        javaSparkContext.close();
    }
}
