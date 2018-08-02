package exAd098A;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */
public class InputNumber {

		/** Aの数字を格納します */
		private int numberA;
		/** Bの数字を格納します */
		private int numberB;
		/** c地点を格納します */

		/**
		 * 入力内容が正しいか判定し、結果を返します。
		 * 正しければtrue、正しくなければfalseを返します。
		 *
		 * @return 入力内容の真偽
		 */
		public boolean isValidInput() {
			this.numberA = 0;
			this.numberB = 0;

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

			System.out.println(">");

			String inputNumber = scan.nextLine();

			String[] inputDate = inputNumber.split(" ");

			if (inputDate.length != 2) {
				System.out.println("入力値は2つです。再入力してください。");
				return isValidInput();
			}

			try {
				this.numberA = Integer.parseInt(inputDate[0]);
				this.numberB = Integer.parseInt(inputDate[1]);

			} catch (NumberFormatException e) {
				System.out.println("数字以外を入力しないでください。");
				return isValidInput();
			}
			// 1～100以外の整数を受け付けないようにします
			if (this.numberA < -1000 || this.numberB < -1000 ) {
				System.out.println("-1000以下の数字を入力しないでください");
				return isValidInput();
			}
			if (this.numberA > 1000 || this.numberB > 1000) {
				System.out.println("1000以上の整数を入力しないでください");
				return isValidInput();
			}
			return true;
		}

		/**
		 * Aの入力値を取得します。
		 *
		 * @return Aの入力値
		 */
		public int getNumberA() {
			return numberA;
		}

		/**
		 * Aの入力値を設定します。
		 *
		 * @param numberA Aの入力値
		 */
		public void setNumberA(int numberA) {
			this.numberA = numberA;
		}

		/**
		 * Bの入力値を取得します。
		 *
		 * @return Bの入力値
		 */
		public int getNumberB() {
			return numberB;
		}

		/**
		 * Bの入力値を設定します。
		 * @param numberB
		 */
		public void setNumberB(int numberB) {
			this.numberB = numberB;
		}
}
