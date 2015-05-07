package com.dev.calculation;

public class SubtractOperation implements Operation {
	Calculator calculator;

	public SubtractOperation(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	@Override
	public double calculate(int a, int b) {
		return calculator.subtract(a, b);
	}

}
