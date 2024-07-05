package com.echo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    //Spark 分布式计算引擎 基于MR开发
//HDFS 分布式存储
//Kafka 分布式消息传输
//分布式计算的核心是切分数据，减小数据规模
//分布式存储
//hdfs,spark 集群中心化
//Kafka 集群去中心化
//spark是一种基于内存的快速，通用，可扩展的大数据分析计算引擎
//RDD 分布式计算模型 一定是一个对象，一定封装了大量方法和属性 一定需要适合进行分布式处理（减小数据规模，并行计算）
    //RDD的功能类似于字符串的功能，需要通过大量的RDD对象组合在一起实现复杂的功能
    //RDD的功能是分布式的，功能调用但不会马上执行，字符串的功能是单点操作，功能一旦调用，就会马上执行
    //
    /**
     * 多个RDD的组合成复杂逻辑：　
     */
}