package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author litong
 * @date 2018��4��11��
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {
	private String password;
}
