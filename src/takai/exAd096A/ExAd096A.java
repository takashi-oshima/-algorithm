package takai.exAd096A;

/**
 * 月日を入力し、月と日が同じ値の日が何日あるかを数えるクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd096A {

	public static void main(String[] args) {
		IntegrityConfirmation input = new IntegrityConfirmation();
		input.scanTxt();

		DateSearch dateSearch = new DateSearch();
		//カレンダーの初期値を設定します。
		dateSearch.setCalendar();

		//入力値を新しいカレンダーに設定し、入力値並びに日付の整合性を確認します。
		dateSearch.setInputDate(input);

		if (input.isScan()) {
			//出力用の文字列を取得します。
			String txt = dateSearch.getDate();
			System.out.println(txt);
		}
	}
}