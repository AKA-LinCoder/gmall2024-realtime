package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Spark02_RDD_Memory_Partition {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("");
        sparkConf.setMaster("local[6]");
        sparkConf.set("spark.default.parallelism","4");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<String> stringList = Arrays.asList("zhangsan", "王五", "lishi");
        //parallelize
        // 第一个参数：对接的数据源集合
        //第二个参数表示分区的数量
        JavaRDD<String> stringJavaRDD = javaSparkContext.parallelize(stringList ,3);
        //TODO 将数据模型分区后的数据保存到磁盘中
        //local分区数量和环境的核数相关,一般不推荐
        //分区数量一般手动设定
        //路径可以为绝对路径，也可以是相对路径(默认项目根路径)

        //TODO 分区数的设定
        //优先使用方法参数
        //使用配置参数
        //采用环境默认值
        stringJavaRDD.saveAsTextFile("output1");
        List<String> collect = stringJavaRDD.collect();
        collect.forEach(System.out::println);

        javaSparkContext.close();
    }
}
