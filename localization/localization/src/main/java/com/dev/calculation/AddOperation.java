package com.dev.calculation;

public class AddOperation implements Operation {
	Calculator calculator;

	public AddOperation(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	@Override
	public double calculate(int a, int b) {
		return calculator.add(a, b);
	}

}
