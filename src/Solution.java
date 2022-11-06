import java.util.HashMap;
import java.util.*;

public class Solution {
	public static List<String> letterCombinations(String digits){
		HashMap<Character, String> teleButtons = new HashMap();
	    teleButtons.put('2', "abc");
	    teleButtons.put('3', "def");
	    teleButtons.put('4', "ghi");
	    teleButtons.put('5', "jkl");
	    teleButtons.put('6', "mno");
	    teleButtons.put('7', "pqrs");
	    teleButtons.put('8', "tuv");
	    teleButtons.put('9', "wxyz");
		int index = 0; String comboStr = "";
		List<String> builtList = new ArrayList();
		backTrack(index, digits, comboStr, builtList, teleButtons);
		return builtList;
	}
	
	public static void backTrack(int index, String digits, String comboStr, List<String> builtList, HashMap<Character, String> teleButtons) {
		if(index >= digits.length()) {
			builtList.add(comboStr);
			return;
		}
		String initialLetterStr = teleButtons.get(digits.charAt(index));
		for(int i = 0; i < initialLetterStr.length(); i++) {
			comboStr = comboStr + initialLetterStr.charAt(i);
			backTrack(index+1, digits, comboStr, builtList, teleButtons);
			comboStr = comboStr.substring(0, comboStr.length()-1);
		}
	}
}
