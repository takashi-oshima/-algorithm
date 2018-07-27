package takai.exAd071B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindNotContainsEnglish {

	public void searchEnglish(String inputString) {
		String searchArray = inputString.replaceAll("[^a-z]", "");
		List<Character> refalenceEnglish = new ArrayList<>();
		List<String> notFindEnglish = new ArrayList<>();
		char english = 'a';

		for (int i = 0; i <= ('z' - 'a'); i++) {
			refalenceEnglish.add(english++);
		}

		for (int i = 0; i < refalenceEnglish.size(); i++) {
			if (!searchArray.contains(String.valueOf(refalenceEnglish.get(i)))) {
				notFindEnglish.add(String.valueOf(refalenceEnglish.get(i)));
			}
		}
		Collections.sort(notFindEnglish);
		System.out.println(notFindEnglish.get(0));
	}
}