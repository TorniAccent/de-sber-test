package task1

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{DateType, IntegerType, StructType}

import java.sql.Date

object IsBackwardSelected extends App {
  val spark = SparkSession.builder
    .config("spark.driver.bindAddress", "127.0.0.1")
    .master("local")
    .getOrCreate()

  val schema = new StructType()
    .add("id", IntegerType)
    .add("timestamp", DateType)

//  val someDatesRaw = Seq(
//    Row(1, Date.valueOf("2016-09-17")),
//    Row(2, Date.valueOf("2016-09-22")),
//    Row(3, Date.valueOf("2016-09-18")),
//    Row(4, Date.valueOf("2016-09-19")),
//    Row(5, Date.valueOf("2016-09-21")),
//    Row(6, Date.valueOf("2016-09-20")),
//    Row(7, Date.valueOf("2016-09-23")),
//    Row(8, Date.valueOf("2016-09-26")),
//    Row(9, Date.valueOf("2016-09-24")),
//    Row(10, Date.valueOf("2016-09-25")),
//    Row(11, Date.valueOf("2016-09-27")),
//  )

  val someDatesRaw = Seq(
    Row(1, Date.valueOf("2016-09-11")),
    Row(2, Date.valueOf("2016-09-12")),
    Row(3, Date.valueOf("2016-09-13")),
    Row(4, Date.valueOf("2016-09-14")),
    Row(5, Date.valueOf("2016-09-09")),
    Row(6, Date.valueOf("2016-09-08")),
    Row(7, Date.valueOf("2016-09-15")),
  )

  val someDates = spark.createDataFrame(spark.sparkContext.parallelize(someDatesRaw), schema)

  val backwardSelected =
  someDates.as("t1")
    .join(someDates.as("t2"))
    .where("t1.id > t2.id AND t1.timestamp < t2.timestamp")
    .select("t1.id")
    .distinct()
    .orderBy("id")

  backwardSelected.show()

}
