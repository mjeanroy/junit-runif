package com.github.mjeanroy.junit4.runif.conditions;

import org.junit.Before;

public class AbstractJavaConditionTest {

	String javaSpecificationVersion;

	@Before
	public void initJavaSpecificationVersion() {
		javaSpecificationVersion = System.getProperty("java.specification.version");
	}
}
