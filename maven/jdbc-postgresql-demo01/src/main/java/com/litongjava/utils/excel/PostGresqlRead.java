package com.litongjava.utils.excel;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class PostGresqlRead {

  private List<PostGresql> list = new ArrayList<>();

  public PostGresqlRead(String filename) {
    EasyExcel.read(filename, PostGresql.class, new AnalysisEventListener<PostGresql>() {

      @Override
      public void invoke(PostGresql data, AnalysisContext context) {
        list.add(data);
      }

      @Override
      public void doAfterAllAnalysed(AnalysisContext context) {

      }
    }).sheet().doRead();
  }

  public PostGresql get(String uuid) {
    for (PostGresql postGresql : list) {
      if (postGresql.getId().equals(uuid)) {
        return postGresql;
      }
    }
    return null;

  }
}
