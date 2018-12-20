package com.zjc.demo.utils.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Sandu
 * @date 2018/11/6
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Base implements Serializable {
	/**
	 *
	 */
	private Long s;
	private LocalDateTime s;
	private BigDecimal s;
	private String s;
}
