package com.ffmpeg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author litong
 * @date 2018Äê4ÔÂ9ÈÕ
 * parameter model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamWavSplitInfo {
	private String wavFile,startTime,endTime,textContent; 
}
