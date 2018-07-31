package awano.exAd096A;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd096A {

	public static void main(String[] args) {
		InputDate inputDate = new InputDate();
		CountTakahashi countTakahashi = new CountTakahashi();

		//入力された日付が2018年グレゴリオ暦において正しい日付の場合
		if (inputDate.checkDate() == true) {
			countTakahashi.countWhatDate(inputDate);
		}
	}
}