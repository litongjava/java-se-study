package com.lombok.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author litong
 * @date 2018年4月9日
 *
 */
@Data
@NoArgsConstructor

public class User {
	private String name;
	
	//使用lomok
	public User(@NonNull String name) {
		this.name=name;
	}
}
