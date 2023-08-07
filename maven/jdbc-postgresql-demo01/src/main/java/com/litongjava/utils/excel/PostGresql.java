package com.litongjava.utils.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostGresql {
  private String id, user, pswd, host, port, dbname;
}
