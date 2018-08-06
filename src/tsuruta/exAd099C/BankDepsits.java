package exAd099C;

import java.util.ArrayList;
import java.util.Collections;
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
	 * N円引き出すには最低何回の操作が必要か求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void Withdrawals(InputNumber inputNumber) {
		// 引き出し金額に入力値Nを格納します
		int depositMoney = inputNumber.getNumberN();
		// 9の累乗値、6の累乗値をそれぞれ格納します
		int nineSquared = 9;
		int sixSquared = 6;

		// 操作回数を格納します
		int manipulationTimes = 0;

		// 1、6、9の累乗値を格納するためのリストを用意します
		List<Integer> list = new ArrayList<>();

		// 限界値(100000)までの9の累乗を入れる
		while (LIMITNUMBER >= nineSquared) {
			list.add(nineSquared);
			nineSquared *= 9;
		}
		// 限界値(100000)までの6の累乗を入れる
		while (LIMITNUMBER >= sixSquared) {
			list.add(sixSquared);
			sixSquared *= 6;
		}
		// 1を入れる(1の累乗はすべて1)
		list.add(1);

		// リストを昇順に並び替えます
		Collections.sort(list);

		// 余りが0になるまで操作回数を求めます
		while (depositMoney != 0) {
			// listの一番大きい値から見ていく
			for (int i = list.size() - 1; i >= 0; i--) {
				// 引き下ろし金額が0なら終了
				if (depositMoney == 0) {
					break;
				}
				// 引き出す金額が取得した累乗値と同じかそれ以上なら
				if (depositMoney >= list.get(i)) {
					depositMoney -= list.get(i);
					// 取得した要素を表示します
					System.out.print("[" + list.get(i) + "]");
					// 次の繰り返し時にもう一度今見たリストの要素を確認できるようにします
					i++;
					manipulationTimes += 1;
				}
			}
		}
		System.out.println();
		// 操作回数を出力します
		System.out.println("操作回数は" + manipulationTimes + "回です");
	}
}
