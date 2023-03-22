package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author litong
 * @date 2018Äê4ÔÂ11ÈÕ
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {
	private String password;
}
