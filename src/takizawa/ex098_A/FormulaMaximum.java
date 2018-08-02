package takizawa.ex098_A;

/**
 * 2つの整数A、BをA+B、A-B、A*Bで計算した時の
 * 計算結果が最大値のものを表示します
 *
 * @author 瀧澤
 */
public class FormulaMaximum {
	/**
	 * 3つの計算式の中で最も計算結果が大きいものを求めます
	 *
	 * @param check getNumberAとgetNumberBを呼び出す
	 * @return result 3つの計算式の中での最大値
	 */
	public int maximum(Check check) {
		int add = (check.getNumberA() + check.getNumberB());
		int sub = (check.getNumberA() - check.getNumberB());
		int multi = (check.getNumberA() * check.getNumberB());

		// Math.maxを使って最大値を求めます
		int result = Math.max(add, Math.max(multi, sub));
		return result;
	}
}