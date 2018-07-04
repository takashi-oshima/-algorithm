package exAd098A;

import exAd098A.ExAd098A.IntLength;

public class MaxResearch {
	public boolean isIntNumber(String inputTxt) {
		boolean isInt = false;
		int i = 0;
		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (IntLength.Min.getLength() <= i && IntLength.Max.getLength() >= i) {
			isInt = true;
		}
		return isInt;
	}

	public int maxNumber(IntegrityConfirmation integrityConfirmation) {
		final int ARRAY_LENGTH = 3;
		int[] numbers = new int[ARRAY_LENGTH];

		numbers[0] = integrityConfirmation.getSum();
		numbers[1] = integrityConfirmation.getDifference();
		numbers[2] = integrityConfirmation.getProduct();

		int max = numbers[0];
		for(int i = 0; i < numbers.length ; i++) {
			max = Math.max(max, numbers[i]);
		}
		return max;
	}
}