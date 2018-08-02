package awano.exAd079B;

/**
 * 入力値NからN番目のリュカ数を求めるクラスです。
 * リュカ数とは、初項を2、次の項を1と定義し、
 * それ以降の項は前の2つの項の和になっている数列のことです。
 *
 * @author 粟野真司
 */
public class LucasNumber {
	/**
	 * N番目のリュカ数を求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void calcuLucasNumber(InputNumber inputNumber) {
		//リュカ数を格納する配列
		long[] lucasNumArray = new long[87];
		//1番目の要素
		lucasNumArray[0] = 2;
		//2番目の要素
		lucasNumArray[1] = 1;
		//配列N番目の要素を指定するための変数
		int index = inputNumber.getInputNumber();

		//要素2番目以降のリュカ数を配列に格納していきます。
		for (int i = 2; i < 87; i++) {
			lucasNumArray[i] = lucasNumArray[i - 1] + lucasNumArray[i - 2];
		}
		System.out.println(lucasNumArray[index]);
	}
}