package takizawa.ex0215;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 複数の数字を入力して、足して10になる2つの数値をペアとして
 * 出力します
 *
 * @author 瀧澤
 */
public class Ex0215 {

	public static void main(String args[]) {
		//入力処理の用意
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");
		String multiNumber = scanner.nextLine();

		//入力した数字が空文字だったときの処理
		if (multiNumber == null || multiNumber.isEmpty()) {
			System.out.println("\r\n数字が確認できませんでした。\n" +
					"処理を終了します");
			return;
		}

		String[] inputStringArray = multiNumber.split(" ");
		//ペアが見つかった時に格納するリストpairStringを用意
		List<String> pairStoring = new ArrayList<>();

		//配列elementArrayを先頭からint型配列に入れ直す
		int[] elementArray = new int[inputStringArray.length];
		try {
			for (int i = 0; i < inputStringArray.length; i++) {
				elementArray[i] = Integer.parseInt(inputStringArray[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("\r\n数字ではありません。\n" +
					"処理を終了します");
			return;
		}

		System.out.println("\r\n");
		//要素0から端までを検索するfor文
		for (int j = 0; j < elementArray.length-1; j++) {
			//要素0+1から端までを探索するfor文
			for (int k =1 + j; k < elementArray.length; k++) {
				//もし、for文を回している間に10とマッチングしているものがあれば
				//リストstrに追加する
				if (10 == elementArray[j] + elementArray[k]) {
					pairStoring.add(elementArray[j] + "と" + elementArray[k]);
				}
			}
		}
		//ペアが見つかった時に格納するstrが空だったときに表示します
		if (pairStoring.isEmpty()) {
			System.out.println("ペアとなる数字はありません");
			return;
		}
		//拡張forでstrの先頭から要素を取り出していきます
		for (String number : pairStoring) {
			System.out.print(number + "、");
		}
		System.out.print("は足して10となるペアです");
	}
}