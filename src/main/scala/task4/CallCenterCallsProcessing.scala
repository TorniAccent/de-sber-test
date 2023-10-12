package task4

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object CallCenterCallsProcessing extends App {
  val spark = SparkSession.builder
    .config("spark.driver.bindAddress", "127.0.0.1")
    .master("local")
    .getOrCreate()

  val datesSchema = new StructType().add("date", StringType)
  val datesRaw = Seq(
    Row("2022-01-20"),
    Row("2022-01-18"),
    Row("2022-01-16")
  )

  val callsSchema = new StructType()
    .add("date", StringType)
    .add("call_id", StringType)
    .add("audio_file", StringType)
    .add("oper_id", IntegerType)
  val callsRaw = Seq(
    Row("2022-01-20", "ERCERCER", "rec_12536123.wav", 134),
    Row("2022-01-20", "34FEWEC3", "rec_89372934.wav", 134),
    Row("2022-01-20", "ERC34F3E", "rec_56756775.wav", 134),
    Row("2022-01-20", "ERCJNER8", "rec_32454565.wav", 128),
    Row("2022-01-20", "ERLHCRE8", "rec_34545567.wav", 125),
    Row("2022-01-20", "LKECRE9C", "rec_23434564.wav", 125),
    Row("2022-01-19", "LJC8ER24", "rec_65778978.wav", 127),
    Row("2022-01-19", "KJNDFC94", "rec_34545766.wav", 128),
    Row("2022-01-19", "KJDC9833", "rec_34545656.wav", 125),
    Row("2022-01-19", "JHB38743", "rec_23434545.wav", 125),
    Row("2022-01-19", "U7JH76H5", "rec_56767876.wav", 127),
    Row("2022-01-18", "34F345F4", "rec_56567678.wav", 134),
    Row("2022-01-18", "WED34F45", "rec_34534534.wav", 134),
    Row("2022-01-18", "W3D34F56", "rec_56756767.wav", 134),
    Row("2022-01-18", "WF435F55", "rec_23434534.wav", 116),
    Row("2022-01-17", "NKDBUS83", "rec_13434876.wav", 134),
    Row("2022-01-17", "NBE83642", "rec_13434468.wav", 116),
    Row("2022-01-17", "NVID49DF", "rec_13434111.wav", 134)
  )

  val dates = spark.createDataFrame(spark.sparkContext.parallelize(datesRaw), datesSchema)
  val calls = spark.createDataFrame(spark.sparkContext.parallelize(callsRaw), callsSchema)

  dates.show()
  calls.show()

}