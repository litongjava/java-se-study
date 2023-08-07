package com.litongjava.utils.excel;

import org.junit.Test;

public class PostGresqlReadTest {

  @Test
  public void test() {
    String filename = "F:\\document\\dev-docs-internal\\postgresql.xlsx";
    PostGresqlRead postGresqlRead = new PostGresqlRead(filename);
    PostGresql postGresql = postGresqlRead.get("dfec2467-57f3-40af-be1e-3808957652a2");
    System.out.println(postGresql);
  }

}
