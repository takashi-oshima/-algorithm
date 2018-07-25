package takai.exAd079C;

import java.util.ArrayList;
import java.util.List;

/**
 * 4つの数値を足す、引くして解が7になる式を求めます。
 *
 * @author 高井勇輝
 *
 */
public class FindSeven {
	// AとBの和
	int sumA2B;
	// CとDの和
	int sumC2D;
	// AとBの差
	int differenceA2B;
	// CとDの差
	int differenceC2D;
	// 和の解
	int sumAnswer;
	// 差の解
	int differenceAnswer;
	// AB間の符号
	String op1 = "";
	// BC間の符号
	String op2 = "";
	// CD間の符号
	String op3 = "";
	// 数値を格納するList
	List<Integer> numbers = new ArrayList<>();
	// 符号を格納するList
	List<String> sign = new ArrayList<>();
	// 解
	final int ANSWER = 7;
	// 7かどうか
	boolean isSeven = false;

	/**
	 * 入力値を分解し、それぞれ計算を行います。
	 *
	 * @param inputNumber 入力値
	 */
	public void calculationNumbers(String inputNumber) {
		String[] strNumber = inputNumber.split("");

		for (String str : strNumber) {
			numbers.add(Integer.parseInt(str));
		}
		//入力値を各項として変数に格納します。
		int firstTerm = numbers.get(0);
		int secondaryTerm = numbers.get(1);
		int thirdTerm = numbers.get(2);
		int fourthTerm = numbers.get(3);

		checkPattern1(firstTerm, secondaryTerm, thirdTerm, fourthTerm);
		checkPattern2(firstTerm);

		if (!isSeven) {
			System.out.println("Error");
			return;
		}
		System.out.println(
				firstTerm + op1 + secondaryTerm + op2 + thirdTerm + op3 + fourthTerm + "=" + ANSWER);
	}

	/**
	 * AとBの和と差、CとDの和と差を求め、それらの和、もしくは差が7かどうかを見ます。
	 */
	private void checkPattern1(int firstTerm, int secondaryTerm, int thirdTerm, int fourthTerm) {
		//AとBの和と差を、CとDの和と差を求めます。
		calculationA2B(firstTerm, secondaryTerm);
		calculationC2D(thirdTerm, fourthTerm);

		int[][] pattern = { { sumA2B, sumC2D, 1 },
				{ sumA2B, differenceC2D, 2 },
				{ differenceA2B, sumC2D, 3 },
				{ differenceA2B, differenceC2D, 4 } };

		//AとBの計算結果と、CとDの計算結果の和と差を求めます。
		//和と差のどちらかが7であったときに、pattern[i][2]の数値を元に、
		//AとBの計算結果と、CとDの計算結果の符号を求めます。
		for (int[] i : pattern) {
			boolean isCheck = false;
			boolean isReversal = false;

			sumAnswer = i[0] + i[1];
			differenceAnswer = i[0] - i[1];

			if (sumAnswer == ANSWER) {
				op2 = "+";
				isCheck = true;
			}

			if (differenceAnswer == ANSWER) {
				op2 = "-";
				isCheck = true;
				isReversal = true;
			}

			if (isCheck) {
				signConfirmation(i[2], isReversal);
			}
		}
		return;
	}

	/**
	 * AとBの和と差を求めます。
	 *
	 * @param numberA 入力値A
	 * @param numberB 入力値B
	 */
	private void calculationA2B(int numberA, int numberB) {
		sumA2B = numberA + numberB;
		differenceA2B = numberA - numberB;
	}

	/**
	 * CとDの和と差を求めます。
	 *
	 * @param numberC 入力値C
	 * @param numberD 入力値D
	 */
	private void calculationC2D(int numberC, int numberD) {
		sumC2D = numberC + numberD;
		differenceC2D = numberC - numberD;
	}

	/**
	 * pattern[i][2]の数値を元に、
	 * AとBの計算結果と、CとDの計算結果それぞれの符号を求めて、
	 * 画面に全体の式を出力します。
	 * この時、op2が-だったとき、op3の符号を反転させます。
	 *
	 * @param pattern pattern[i][2]の値
	 * @param isReversal op2が「-」かどうか
	 */
	private void signConfirmation(int pattern, boolean isReversal) {
		switch (pattern) {
		case 1:
			op1 = "+";
			op3 = "+";
			break;
		case 2:
			op1 = "+";
			op3 = "-";
			break;
		case 3:
			op1 = "-";
			op3 = "+";
			break;
		case 4:
			op1 = "-";
			op3 = "-";
			break;
		default:
			break;
		}
		isSeven = true;

		if (!isReversal) {
			return;
		}

		if (op3.equals("+")) {
			op3 = "-";
			return;
		}

		if (op3.equals("-")) {
			op3 = "+";
			return;
		}
	}

	/**
	 * 一つ目の値から順に計算していき、途中の解が7より大きければ「-」を、
	 * 7以下であれば「＋」を設定します。
	 */
	private void checkPattern2(int firstTerm) {
		int answer = firstTerm;

		for (int i = 1; i < numbers.size(); i++) {

			if (answer <= ANSWER) {
				answer += numbers.get(i);
				sign.add("+");
			} else {
				answer -= numbers.get(i);
				sign.add("-");
			}
		}

		if (answer != ANSWER) {
			return;
		}
		op1 = sign.get(0);
		op2 = sign.get(1);
		op3 = sign.get(2);
		isSeven = true;
	}
}