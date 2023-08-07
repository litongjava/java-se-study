package com.litongjava.demo.jdbc.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;

import com.litongjava.utils.excel.PostGresql;
import com.litongjava.utils.excel.PostGresqlRead;

public class MFSample {
  public static void main(String[] args) {
    String filename = "F:\\document\\dev-docs-internal\\postgresql.xlsx";
    PostGresqlRead postGresqlRead = new PostGresqlRead(filename);
    PostGresql postGresql = postGresqlRead.get("dfec2467-57f3-40af-be1e-3808957652a2");

    String host = postGresql.getHost();
    String port = postGresql.getPort();
    String dbname = postGresql.getDbname();
    String dbuser = postGresql.getUser();
    String dbpassword = postGresql.getPswd();
    String url = "jdbc:postgresql://" + host +":"+port+ "/" + dbname;
    try {

      Connection connection = DriverManager.getConnection(url, dbuser, dbpassword);
      connection.close();
      System.out.println(url);
      System.out.println(dbuser);
      System.out.println(dbpassword);
      System.out.println("OK");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}