package awano.exAd099C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ある銀行では、お金の引き出しを難しくするために、
 * 一回の操作で引き出せる金額が以下のいずれかとなっています。
 * ・1円
 * ・6円の累乗値
 * ・9円の累乗値
 * この銀行からちょうどN円引き出すには少なくとも何回の操作が必要か求めてください。
 * ただし、一度引き出したお金を再び預け入れてはならないとします。
 *
 * @author 粟野真司
 */
public class DrowOutMoney {
	/**入力値Nの最大限界値*/
	public static final int MAX_LIMIT = 100000;

	public void drawerTimes(InputPrice inputPrice) {
		//お金を引き出す操作回数;
		int operationCount = 0;
		//引き出したい余り金額
		int reminderPrice = inputPrice.getInputN();

		//引き出すことのできる金額単位のリストを生成します。
		List<Integer> drowOutUnit = new ArrayList<>();
		//1円をdrowOutUnitリストに追加
		drowOutUnit.add(1);

		int six = 6;
		int nine = 9;
		//100000以下の6と9の累乗値をdrowOutUnitリストに追加します。
		while (six <= MAX_LIMIT && nine <= MAX_LIMIT) {
			drowOutUnit.add(six);
			drowOutUnit.add(nine);
			six *= 6;
			nine *= 9;
		}
		//drowOutUnitリスト昇順にソートします。
		Collections.sort(drowOutUnit);
		System.out.println(drowOutUnit);
		//引き出したい余り金額が0になるまでループします。
		while (reminderPrice != 0) {

			for (int i = drowOutUnit.size() - 1; i >= 0; i--) {
				if (reminderPrice == 0) {
					break;
				}
				//引き出したい余り金額が引き出すことのできる金額単位以上の場合
				if (reminderPrice >= drowOutUnit.get(i)) {
					//割った回数分をお金を引き出す操作回数に代入
					operationCount += reminderPrice / drowOutUnit.get(i);
					//引き出したい余り金額を更新
					reminderPrice %= drowOutUnit.get(i);
				}
			}
		}
		System.out.println(operationCount);
	}
}