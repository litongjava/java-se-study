package com.litongjava.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
  private Integer id;
  private String username;
  private Integer age;

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof UserInfo) {
      UserInfo tmp = (UserInfo) obj;
      if (this.getId().equals(tmp.getId())) {
        return true;
      }
    }
    return false;
  }
}
