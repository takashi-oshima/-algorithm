package takai.exAd079A;
/**
 * 3つ以上の連続した数字があるかどうかを判定します。
 *
 * @author 高井勇輝
 *
 */
public class SearchGoodNumber {

	public boolean checkNumber(String inputNumber) {
		/** 3つ以上の連続した数字があるか */
		boolean isGoodNumber = false;

		if (inputNumber.charAt(0) == inputNumber.charAt(1) && inputNumber.charAt(0) == inputNumber.charAt(2)) {
			isGoodNumber = true;
		}

		if (inputNumber.charAt(1) == inputNumber.charAt(2) && inputNumber.charAt(1) == inputNumber.charAt(3)) {
			isGoodNumber = true;
		}

		return isGoodNumber;
	}
}
