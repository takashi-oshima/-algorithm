package takizawa.exAd086B;
/**
 * 他のクラスを呼び出し、実行します
 *
 * @author 瀧澤
 */
public class ExAd086B {
	public static void main(String[] args) {
		Check check = new Check();
		SquareNumber square = new SquareNumber();

		if(!check.valid()) {
			System.out.println("入力値はスペースで区切った\\n2つの整数で入力してください");
			return;
		}
		square.squareNumber(check);
	}
}