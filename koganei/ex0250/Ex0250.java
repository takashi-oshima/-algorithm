package koganei.ex0250;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * キーボードから２桁の数値を入力し、その数値が１００以下の素数か判断し出力します
 * 数値が素数か否かの判断は、二分探索を使用して行います
 *
 * @author 小金井 広輝
 */
public class Ex0250 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int inputInt;

		//キーボードから入力された整数を取得します。
		System.out.println("input number：");
		try {
			inputInt = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//入力された数字が範囲内（10～99）かの判別を行います
		if (inputInt < 10 || inputInt > 99) {
			System.out.println("範囲内(２桁の正数)の数値を入力してください");
			return;
		}

		//0～99の素数を取得します
		List<Integer> primeList = getPrime();

		//素数配列に入力された数字があるかを二分探索を使用して行い結果を取得します
		String ans = judgePrime(inputInt, primeList);

		//結果を表示します
		System.out.println(ans);
	}

	/**
	 * 0～99までの中からすべての素数を抽出し配列に入れ、それを返します
	 *
	 * @return 0～99までの中に含まれる素数
	 */
	public static List<Integer> getPrime() {
		//10～99の中で素数をすべて抜出し配列に入れます
		List<Integer> primeList = new ArrayList<>();
		boolean primeFlg = true;
		for (int i = 10; i < 100; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					//素数でない場合
					primeFlg = false;
					break;
				}
			}
			if (primeFlg) {
				//素数である場合
				primeList.add(i);
			}
			primeFlg = true;
		}
		return primeList;
	}

	/**
	 * 入力された（２桁の）数字が素数であるかの判定を行います
	 *
	 * @param inputInt 入力された（２桁の）数字
	 * @param primeList 0～99までの中に含まれる素数
	 * @return 素数であるかの判定結果
	 */
	public static String judgePrime(int inputInt, List<Integer> primeList) {
		String ansText = "";
		int left = 0;
		int right = primeList.size();
		int mid;
		//二分探索で素数配列に入力された数字があるかの判定を行います
		while (right > left) {
			mid = (left + right) / 2;
			if (inputInt == primeList.get(mid)) {
				ansText = "素数です";
				break;
			} else if (primeList.get(mid) > inputInt) {
				right = mid;
			} else if (primeList.get(mid) < inputInt) {
				left = mid + 1;
			}
		}
		if (ansText.equals("")) {
			ansText = "素数ではありません";
		}
		return ansText;
	}
}
