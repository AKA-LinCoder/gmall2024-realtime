package com.echo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Spark02_Operate_Transform_Map {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("a");
        sparkConf.setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<Integer> rdd = javaSparkContext.parallelize(Arrays.asList(1, 2, 3, 4),2);


        JavaRDD<String> stringJavaRDD = rdd.map(new Function<Integer, String>() {
            @Override
            public String call(Integer integer) throws Exception {
                return integer.toString()+" 这是一个数字";
            }
        });


        JavaRDD<Integer> rdd1 = rdd.map(a -> a * 2);


        JavaRDD<Integer> filter = rdd.filter(new Function<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) throws Exception {
                return integer > 2;
            }
        });

        JavaRDD<String> stringJavaRDD1 = rdd.flatMap(new FlatMapFunction<Integer, String>() {
            @Override
            public Iterator<String> call(Integer integer) throws Exception {
                return  integer.toString().lines().iterator();
            }
        });




        stringJavaRDD.saveAsTextFile("ool");

        javaSparkContext.close();
    }
}
