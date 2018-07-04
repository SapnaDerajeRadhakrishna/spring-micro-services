package org.maxwell.microservices.limitservices.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LimitConfiguration {

	private int maximum;
	private int minimum;

}
