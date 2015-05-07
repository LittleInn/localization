package com.dev.calculation;

import java.math.BigDecimal;

public class Calculator{
	int add(int a, int b){
		return a + b;
	}

	int multiply(int a, int b){
		return a * b;
	}

	int subtract(int a, int b){
		return a - b;
	}

	double divide(int a, int b){
		BigDecimal bigDecimalA = new BigDecimal(a);
		BigDecimal bigDecimalB = new BigDecimal(b);
		BigDecimal divide = bigDecimalA.divide(bigDecimalB);
		return divide.doubleValue();
	}
}
