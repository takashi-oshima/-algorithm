package takai.ex0110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex0110List {

	public static void main(String[] args) {
		String inputTxt = "";
		List<String> outputTxt = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		while(true) {
			inputTxt = scan.nextLine();
			if(inputTxt.isEmpty()) {
				break;
			}
			outputTxt.add(inputTxt);
		}

		for(int i = 0 ; i < outputTxt.size() - 1 ; i++) {
			for(int j = 0 ; j < outputTxt.size() ; j++) {
				if(outputTxt[i].compareTo(outputTxt[j]) > 0) {
					String str = outputTxt[i];
					outputTxt[i] = outputTxt[j];
					outputTxt[j] = str;
				}
			}
		}

	}
}
