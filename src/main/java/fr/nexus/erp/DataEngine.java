package fr.nexus.erp;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import java.util.Properties;

public class DataEngine {

    public static void runPipeline() {

        System.setProperty("hadoop.home.dir", "C:\\Hadoop\\hadoop-3.3.6");
        System.load("C:\\Hadoop\\hadoop-3.3.6\\bin\\hadoop.dll");

        SparkSession spark = SparkSession.builder()
                .appName("Nexus ERP")
                .config("spark.master", "local[*]")
                .getOrCreate();

        String url = "jdbc:mysql://localhost:3306/nexus_erp";
        Properties connectionProp = new Properties();
        connectionProp.put("user", "root");
        connectionProp.put("password", "");
        connectionProp.put("driver", "com.mysql.cj.jdbc.Driver");

        Dataset<Row> df = spark.read().jdbc(url, "server_logs", connectionProp);

        Dataset<Row> dfNettoye = df
                .select("server_name", "region", "status")
                .filter(df.col("region").isNotNull())
                .orderBy("region", "server_name");

        dfNettoye.show();

        dfNettoye.write()
                .partitionBy("region")
                .mode(SaveMode.Overwrite)
                .json("archives_logs_serveurs");

        System.out.println("Export terminé dans : archives_logs_serveurs");

        spark.stop();
    }
}