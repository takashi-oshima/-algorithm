package takai.exAd079B;

import java.util.ArrayList;
import java.util.List;

/**
 * 入力値をnとして要素ｎのリュカ数を計算し、出力します。
 *
 * @author 高井勇輝
 *
 */
public class SearchLucasNumber {

	public void checkNumber(int inputNumber) {
		List<Long> lucasNumbers = new ArrayList<>();

		lucasNumbers.add((long) 2);
		lucasNumbers.add((long) 1);
		for (int i = 2; i <= inputNumber; i++) {
			lucasNumbers.add(i, lucasNumbers.get(i - 1) + lucasNumbers.get(i - 2));
		}

		System.out.println(lucasNumbers.get(inputNumber));
	}
}