package com.dev.calculation;

public class MultiplyOperation implements Operation {
	Calculator calculator;

	public MultiplyOperation(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	@Override
	public double calculate(int a, int b) {
		return calculator.multiply(a, b);
	}

}
