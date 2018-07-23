package takizawa.ex0235;

import java.util.Scanner;

/**
 * 0～255の範囲の10進数整数値を2進数と16進数に
 * 変換します
 *
 * @author 瀧澤
 */
public class Ex0235 {
	public static void main(String[] args) {
		String inputDecimal = "";
		int decimalNumber = 0;
		@SuppressWarnings("resource")
		//入力処理の用意
		Scanner scanner = new Scanner(System.in);
		System.out.println("0～255の範囲の１０進数:");

		inputDecimal = scanner.nextLine();
		if(inputDecimal == null || inputDecimal.isEmpty()) {
			System.out.println("\r\n数値が確認できませんでした。\n" +
					"処理を終了します");
			return;
		}
		try {
			//String型のinputDecimalをint型に直す
			decimalNumber = Integer.parseInt(inputDecimal);
		}catch(NumberFormatException e) {
			System.out.println("\r\n数値以外が入力されました\n"
					+ "処理を終了します");
			return;
		}
		if(decimalNumber < 0 || decimalNumber > 255) {
			System.out.println("\r\n範囲外の数値が入力されました\n"
					+ "処理を終了します");
		}

		//decimalNumberを2進数に直したものをbinaryNumberに代入
		String binaryNumber = Integer.toBinaryString(decimalNumber);

		//decimalNumberを16進数に直したものをhexToransformに代入
		String hexToransform = Integer.toHexString(decimalNumber);

		//小文字で出力されるものを大文字に直す
		String upperHex = hexToransform.toUpperCase();

		//2進数binaryNumberをint型に直した物をbinaryIntegerに代入
		int binaryInteger = Integer.parseInt(binaryNumber);

		//8桁表示で、余白があった場合に0で埋める
		binaryNumber = String.format("%08d", binaryInteger);

		//結果の表示
		System.out.println("\r\n2進数の変換結果:" + binaryNumber);
		System.out.println("16進数の変換結果:" + upperHex);
		return;
	}
}