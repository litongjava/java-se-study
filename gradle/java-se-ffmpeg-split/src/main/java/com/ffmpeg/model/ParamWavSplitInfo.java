package com.ffmpeg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author litong
 * @date 2018��4��9��
 * parameter model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamWavSplitInfo {
	private String wavFile,startTime,endTime,textContent; 
}
