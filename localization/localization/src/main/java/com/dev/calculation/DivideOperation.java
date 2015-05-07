package com.dev.calculation;

public class DivideOperation implements Operation {
	Calculator calculator;

	public DivideOperation(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	@Override
	public double calculate(int a, int b) {
		return calculator.divide(a, b);
	}

}
