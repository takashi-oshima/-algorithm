package takizawa.exAd071B;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import takizawa.exAdInput.Input3;

/**
 * 入力値が正しいかを調べます
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値S */
	private String inputS;

	/**
	 * 入力範囲を超えていないか、英小文字以外を入力していないかを調べます
	 *
	 * @return isValid 入力値が正しいか
	 */
	public boolean valid() {
		boolean isValid = false;
		Input3 input = new Input3();
		inputS = input.string();
		String[] lowerCaseArray = inputS.split("");

		// 文字列の長さが0以下または100000以上ならfalseを返す
		if (lowerCaseArray.length < 1 || lowerCaseArray.length > 100000) {
			System.out.println("文字列の長さは1から100000までです。");
			return isValid;
		}

		// 正規表現で、文字列から半角英小文字を見つけます
		Pattern p = Pattern.compile("^[a-z]+$");
		Matcher m = p.matcher(inputS);

		// 半角英小文字が見つからなかった場合はfalseを返します
		if (!m.find()) {
			return isValid;
		}

		isValid = true;
		return isValid;
	}

	/**
	 * 入力値Sの取得
	 *
	 * @return inputS 入力値S
	 */
	public String getInputS() {
		return inputS;
	}

	/**
	 * 入力値Sの設定
	 *
	 * @param inputS セットする inputS
	 */
	public void setInputS(String inputS) {
		this.inputS = inputS;
	}
}