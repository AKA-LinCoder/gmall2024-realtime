package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;

public class Spark03_RDD_Disk_Partition_Data {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("阿斯顿");
        sparkConf.setMaster("local[*]");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        //TODO 尽可能的平均
        //spark不支持文件操作的，文件操作都是Hadoop完成的
        //Hadoop进行文件切片数量的计算和文件数据存储的计算规则不一样
        //1 分区数量计算的时候，考虑的是尽可能的平均，按照字节
        //2 分区数据的存储是考虑业务数据的完整性：按照行来读取
        // 读取数据时，还需要考虑数据偏移量，偏移量从0开始，相同的偏移量不能重复读取
        JavaRDD<String> javaRDD = javaSparkContext.textFile("data/test.txt",2);
        javaRDD.saveAsTextFile("output886");
        List<String> collect = javaRDD.collect();
        collect.forEach(System.out::println);
        javaSparkContext.close();
    }
}
