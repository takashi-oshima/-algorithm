package exAd099C;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * N円引き出すには最低何回の操作が必要か求めるクラスになります。
 *
 * @author 鶴田竜也
 */
public class BankDepsits {
	// キーボード入力時の限界値を格納します
	private final int LIMITNUMBER = 100000;

	/**
	 * 引数として渡された値の累乗値を計算します。
	 *
	 * @param square 底の値(掛け算する数)
	 * @return result resultリスト
	 */
	public List<Integer> calc(int square) {
		List<Integer> result = new ArrayList<>();

		if (square == 1) {
			result.add(square);
			return result;
		}

		// 指数を格納します
		int i = 1;
		Integer powerValue = square;
		while (powerValue < LIMITNUMBER) {
			result.add(powerValue);
			powerValue = (int) Math.pow(square, i);
			i++;
		}

		return result;
	}

	/**
	 * N円引き出すには最低何回の操作が必要か求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void Withdrawals(InputNumber inputNumber) {
		// 引き出し金額に入力値Nを格納します
		int depositMoney = inputNumber.getNumberN();

		// 1、6、9の累乗値を格納するためのリストを用意します
		List<Integer> list = new ArrayList<>();
		list.addAll(calc(1));
		list.addAll(calc(6));
		list.addAll(calc(9));

		// リストを降順に並び替えます
		list.sort(Comparator.reverseOrder());

		// 操作回数の合計を格納します
		int totalCount = 0;
		// リストが空じゃない且つ入力値が0円より多い時
		while (!list.isEmpty() && depositMoney > 0) {

			// 0番目(累乗値の最大値)から順にみていきます
			int max = list.remove(0);
			if (max > depositMoney) {
				continue;
			}

			totalCount += depositMoney / max;
			depositMoney = depositMoney % max;
		}
		System.out.println();
		// 操作回数を出力します
		System.out.println("操作回数は" + totalCount + "回です");
	}
}
