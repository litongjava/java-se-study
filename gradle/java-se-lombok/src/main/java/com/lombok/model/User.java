package com.lombok.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author litong
 * @date 2018��4��9��
 *
 */
@Data
@NoArgsConstructor

public class User {
	private String name;
	
	//ʹ��lomok
	public User(@NonNull String name) {
		this.name=name;
	}
}
