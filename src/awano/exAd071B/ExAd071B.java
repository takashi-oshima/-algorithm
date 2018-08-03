package awano.exAd071B;
/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd071B {
	public static void main(String[] args) {
		InputWord inputWord = new InputWord();
		NotAppearAlphabet notAppearAlphabet = new NotAppearAlphabet();
		//入力値が正しい場合
		if(inputWord.checkInputWord()) {
			//現れない英小文字を探索します。
			notAppearAlphabet.findAlphabet(inputWord);
		}
	}
}