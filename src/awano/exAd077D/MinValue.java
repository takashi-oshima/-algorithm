package awano.exAd077D;

/**
 * 入力値Nの正の倍数の10進法における
 * 各桁の和としてありうる最小の値を求めます。
 *
 * @author 粟野真司
 */
public class MinValue {

	/**
	 * 各桁の和の最小値を求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void getdigitsSum(InputNumber inputNumber) {
		//入力値N
		int n = inputNumber.getInputN();
		//各桁の和
		int sum = 0;
		//配列の要素数
		int elementCount = 300;
		//各桁の和を格納する配列
		int[] digitSum = new int[elementCount];
		//乗数
		int multiplier = 0;
		//配列を格納していくための要素番号
		int index = 0;

		/*
		 * 要素番号が配列の要素数の最大になるまで、
		 * 入力値Nの正の倍数の各桁の和を求めます。
		 */
		while (true) {

			if (index >= elementCount) {
				break;
			}
			sum = 0;
			multiplier++;

			//入力値N×乗数の計算結果
			int product = n * multiplier;

			//各桁の和を求めます。
			while (product != 0) {
				sum += product % 10;
				product /= 10;
			}

			//配列の指定した要素番号に各桁の和を格納
			digitSum[index] = sum;
			index++;
			continue;
		}

		//配列内を表示(各桁の和の最小値の候補を挙げるため)
		for (int i = 0; i < digitSum.length; i++) {
			System.out.print(digitSum[i] + ",");
		}

		//配列内の最小値を求めます。
		int min = digitSum[0];
		for (int i = 1; i < digitSum.length; ++i) {
			if (min > digitSum[i]) {
				min = digitSum[i];
			}
		}
		System.out.println("\n最小値:" + min);

		//最小値を達成する計算式を表示します。
		int a = 0;
		int b = 1;
		while (true) {
			if (digitSum[a] == min) {
				int result = n * b;
				System.out.println(result + " = " + n + "×" + b + "が最小値を達成します。");
				break;
			}
			a++;
			b++;
			continue;
		}
	}
}