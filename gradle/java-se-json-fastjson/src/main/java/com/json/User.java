package com.json;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author litong
 * @date 2018年4月14日_上午12:06:00 
 * @version 1.0 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@JSONField(serialize=false)
	private String username;
	private String password;
}
