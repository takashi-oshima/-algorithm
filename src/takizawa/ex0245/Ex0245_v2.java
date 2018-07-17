package takizawa.ex0245;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex0245_v2 {

	public static void main(String[] args) {
		String inputNumber1 = "";
		String inputNumber2 = "";
		int number1 = 0;
		int number2 = 0;

		// 入力処理とエラー処理を行います
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number1:");
		inputNumber1 = scanner.nextLine();
		if (inputNumber1 == "" || inputNumber1.isEmpty()) {
			System.out.println("\r\n文字列を確認できませんでした。\n"
					+ "処理を終了します");
			return;
		}
		System.out.println("input number2:");
		inputNumber2 = scanner.nextLine();
		if (inputNumber2 == "" || inputNumber2.isEmpty()) {
			System.out.println("\r\n文字列を確認できませんでした。\n"
					+ "処理を終了します");
			return;
		}
		try {
			number1 = Integer.parseInt(inputNumber1);
			number2 = Integer.parseInt(inputNumber2);
		} catch (NumberFormatException e) {
			System.out.println("\r\n数字以外が入力されました。\n"
					+ "処理を終了します");
			return;
		}
		if (number1 < 0 || number2 < 0) {
			System.out.println("\r\n負数が入力されました。\n"
					+ "正数を記入してください");
			return;
		}
		List<Integer> num1List = new ArrayList<>();
		List<Integer> num2List = new ArrayList<>();
		List<Integer> commonDiviser = new ArrayList<>();

		int max = Math.max(number1, number2);
		int min = Math.min(number1, number2);

		for (int i = 1; i <= max; i++) {
			if ((max % i) == 0) {
				num1List.add(i);
			}
		}
		System.out.println(num1List);
		for (int j = 1; j <= min; j++) {
			if ((min % j) == 0) {
				num2List.add(j);
			}
		}
		System.out.println(num2List);
		for (int k = 0; k < num1List.size(); k++) {
			for (int i = 0; i < num2List.size(); i++) {
				if (num1List.get(k) == num2List.get(i)) {
					commonDiviser.add(num1List.get(k));
				}
			}
		}

		int greatestCommonDivisor = 0;
		for(int j = 0;j < commonDiviser.size();j++) {
			  greatestCommonDivisor = Math.max(greatestCommonDivisor, commonDiviser.get(j));
		}
		System.out.println("最大公約数 =" + greatestCommonDivisor);
	}
}
