package takai.exAd084A;

import java.util.Calendar;

import takai.exAdInput.Input;

/**
 * 入力値および日付の整合性を確認するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfirmation {
	/** 入力値を時間として保持したカレンダー */
	private Calendar date = Calendar.getInstance();
	/** 入力値が正しいか */
	private boolean canScan = false;

	public enum Time {
		One(1), TwentyThree(23);

		final int time;

		public int getTime() {
			return time;
		}

		private Time(int time) {
			this.time = time;
		}
	}

	/**
	 * @return inputDate
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @return canScan
	 */
	public boolean isCanScan() {
		return canScan;
	}

	/**
	 * @param inputDate セットする inputDate
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @param canScan セットする canScan
	 */
	public void setCanScan(boolean canScan) {
		this.canScan = canScan;
	}

	/**
	 * キーボードから入力値を取得し、入力値が正しいものか判定します。
	 * 正しければ入力値を時間としたカレンダーを作成します。
	 */
	public void scanTxt() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isIntMonth(inputTxt[0])) {
			System.out.println("不適な文字列です。");
			System.out.println("1～23の整数を入力してください。");
			return;
		}

		date.get(Calendar.YEAR);
		date.set(Calendar.MONTH, Calendar.DECEMBER);
		date.set(Calendar.DATE, 30);
		date.set(Calendar.HOUR_OF_DAY, Integer.parseInt(inputTxt[0]));
		setCanScan(true);
		return;
	}

	/**
	 * 入力値が正しいものかを判定します
	 *
	 * @param inputTxt 入力値
	 * @return 判定結果
	 */
	private boolean isIntMonth(String inputTxt) {
		boolean isInt = false;
		int i = 0;

		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (Time.One.getTime() <= i && Time.TwentyThree.getTime() >= i) {
			isInt = true;
		}
		return isInt;
	}
}