package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class Spark01_Env {
    public static void main(String[] args) {
        //TODO 构建spark的运行环境

        //创建配置
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("Spark");
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
        //TODO 释放资源
        sparkContext.close();
    }
}
