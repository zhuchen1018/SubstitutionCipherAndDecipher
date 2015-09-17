package edu.upenn.cis573.hwk1;

import java.util.HashMap;

public class EncryptAndDecrypt {
	public String encrypt(String text) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('A', 'o');
		map.put('B', 'p');
		map.put('C', 'q');
		map.put('D', 'r');
		map.put('E', 's');
		map.put('F', 't');
		map.put('G', 'u');
		map.put('H', 'v');
		map.put('I', 'w');
		map.put('J', 'x');
		map.put('K', 'y');
		map.put('L', 'z');
		map.put('M', 'a');
		map.put('N', 'b');
		map.put('O', 'c');
		map.put('P', 'd');
		map.put('Q', 'e');
		map.put('R', 'f');
		map.put('S', 'g');
		map.put('T', 'h');
		map.put('U', 'i');
		map.put('V', 'j');
		map.put('W', 'k');
		map.put('X', 'l');
		map.put('Y', 'm');
		map.put('Z', 'n');
		char[] chars = text.toCharArray();
		for (int i = 0; i < text.length(); i++) {
			char c = chars[i];
			if ((97 <= c && c <= 122) || (65 <= c && c <= 90)) {
				if (97 <= c && c <= 122) {
					c = (char) (c - 32);
				}
				chars[i] = map.get(c);
			}
		}
		return new String(chars);
	}
	
	public String decrypt(String encryptText, int[] frequencyTable) {
		int[] frequencyTable2 = new int[26];
		getFrequencyTable(encryptText, frequencyTable2);
		char[] corpusFreq = new char[26];
		char[] encryptFreq = new char[26];
		for (int i = 0; i < frequencyTable.length; i++) {
			corpusFreq[i] = getMax(frequencyTable);
		}
		for (int i = 0; i < frequencyTable2.length; i++) {
			encryptFreq[i] = getMax(frequencyTable2);
		}
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < corpusFreq.length; i++) {
			map.put(encryptFreq[i], corpusFreq[i]);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < encryptText.length(); i++) {
			if (map.containsKey(encryptText.charAt(i))) {
				sb.append(map.get(encryptText.charAt(i)));
			} else {
				sb.append(encryptText.charAt(i));
			}
		}
		return sb.toString();

	}

	private static char getMax(int[] frequencyTable) {
		char c = 0;
		int max = -1;
		int maxIndex = -1;
		for (int i = 0; i < frequencyTable.length; i++) {
			if (frequencyTable[i] > max) {
				max = frequencyTable[i];
				c = (char) ('a' + i);
				maxIndex = i;
			}
		}
		frequencyTable[maxIndex] = -1;
		return c;
	}
	
	public void getFrequencyTable(String text, int[] frequencyTable) {
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if ((97 <= c && c <= 122) || (65 <= c && c <= 90)) {
				int index = c - 'a';
				if (index >= 0)
					frequencyTable[index] += 1;
				else
					frequencyTable[index + 32] += 1;
			}
		}
		return;
	}
}