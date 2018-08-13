package takizawa.exAd079C;

/**
 * 他のクラスを呼び出して、実行します
 *
 * @author 瀧澤
 */
public class ExAd079C {
	public static void main(String[] args) {
		Check check = new Check();
		ReferenceNumber referenceNum = new ReferenceNumber();

		if (!check.valid()) {
			System.out.println("入力は、0～9の数字を使い4桁で入力してください");
			return;
		}
		referenceNum.referenceNum(check);
	}
}