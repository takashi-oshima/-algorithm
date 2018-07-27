package takai.exAd071B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 入力値から、含まれていない英小文字を探索し、
 * 最も辞書順で小さいものを出力します。
 *
 * @author 高井勇輝
 *
 */
public class FindNotContainsAlpfabrt {

	public void searchAlpfabrt(String inputString) {
		//探索対象とする英小文字を格納します。
		List<Character> refalenceAlpfabrt = new ArrayList<>();
		//存在しなかった英小文字を格納します。
		List<String> notFindAlpfabrt = new ArrayList<>();
		char Alpfabrt = 'a';

		//すべての英小文字を格納します。
		for (int i = 0; i <= ('z' - 'a'); i++) {
			refalenceAlpfabrt.add(Alpfabrt++);
		}

		//探索する文字列に探索対象の英小文字がないとき、
		//探索対象の英小文字をListに格納します。
		for (int i = 0; i < refalenceAlpfabrt.size(); i++) {
			if (!inputString.contains(String.valueOf(refalenceAlpfabrt.get(i)))) {
				notFindAlpfabrt.add(String.valueOf(refalenceAlpfabrt.get(i)));
			}
		}

		if (notFindAlpfabrt.isEmpty()) {
			System.out.println("None");
			return;
		}
		Collections.sort(notFindAlpfabrt);
		System.out.println(notFindAlpfabrt.get(0));
	}
}