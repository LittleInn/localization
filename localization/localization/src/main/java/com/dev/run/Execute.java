package com.dev.run;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.dev.bundle.ResourceBundleControl;
import com.dev.calculation.AddOperation;
import com.dev.calculation.Calculator;
import com.dev.calculation.DivideOperation;
import com.dev.calculation.MultiplyOperation;
import com.dev.calculation.Operation;
import com.dev.calculation.SubtractOperation;

public class Execute {
	private static final Logger logger = Logger.getLogger(Execute.class);
	private static final String FILE_NAME = "menu";
	private static final String USER_LANGUAGE = "user.language";

	private ResourceBundle bundle = ResourceBundle.getBundle(FILE_NAME,
			getCurrentLocale(), new ResourceBundleControl());

	public void execute() throws IOException {
		boolean correctResult = true;
		Calculator calculator = new Calculator();

		logger.info(bundle.getObject("greeting"));
		logger.info("1: " + bundle.getObject("add"));
		logger.info("2: " + bundle.getObject("multiply"));
		logger.info("3: " + bundle.getObject("divide"));
		logger.info("4: " + bundle.getObject("subtract"));

		Scanner scanner = new Scanner(System.in);
		int operationNum = scanner.nextInt();
		Operation operation = createOperation(operationNum, calculator);
		logger.info(bundle.getObject("input_first"));
		Integer firstNumber = isCorrectInput(scanner);
		logger.info(bundle.getObject("input_second"));
		Integer secondNumber = isCorrectInput(scanner);

		if (isNotZero(secondNumber, operationNum)) {
			logger.info(bundle.getObject("zero_devide"));
			correctResult = false;
		}
		if (correctResult && firstNumber != null && secondNumber != null) {
			double result = operation.calculate(firstNumber, secondNumber);
			logger.info(bundle.getObject("result") + " " + result);
		}

	}

	public Operation createOperation(int operationNumber, Calculator calculator) {
		Operation operation = null;
		switch (operationNumber) {
		case 1:
			operation = new AddOperation(calculator);
			break;
		case 2:
			operation = new MultiplyOperation(calculator);
			break;
		case 3:
			operation = new DivideOperation(calculator);
			break;
		case 4:
			operation = new SubtractOperation(calculator);
			break;
		default:
			logger.error(bundle.getObject("wrong_choice"));
		}
		return operation;
	}

	public Integer isCorrectInput(Scanner scanner) {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		} else {
			logger.info(bundle.getObject("warning"));
			return null;
		}
	}

	private boolean isNotZero(Integer number, Integer operation) {
		if (operation == null || number == null) {
			return false;
		}
		if (operation == 3 && number == 0) {
			return true;
		}
		return false;
	}

	private static Locale getCurrentLocale() {
		Properties properties = System.getProperties();
		return new Locale(properties.getProperty(USER_LANGUAGE));
	}

}
