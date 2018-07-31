package awano.exAd098A;

/**
 * 2つの整数の足し算、引き算、掛け算結果を比較し、
 * 最大値を求めるクラスです。
 *
 * @author 粟野真司
 */
public class FindMax {
	//最大値
	int max = 0;
	//足し算結果
	int sum = 0;
	//引き算結果
	int difference = 0;
	//掛け算結果
	int product = 0;

	/**
	 * 計算結果後、最大値を求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void calcuNum(InputNumber inputNumber) {
		sum = inputNumber.getA() + inputNumber.getB();
		difference = inputNumber.getA() - inputNumber.getB();
		product = inputNumber.getA() * inputNumber.getB();

		//最大値を求めます。
		max = sum;

		if (difference > max) {
			max = difference;
		}

		if (product > max) {
			max = product;
		}
		System.out.println(max);
	}
}