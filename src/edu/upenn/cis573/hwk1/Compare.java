package edu.upenn.cis573.hwk1;

public class Compare {
	public float compare(String originalText, String decryptedText,
			String Filename) {
		int count = 0;
		int correctCount = 0;
		float correctRate = 0;
		for (int i = 0; i < originalText.length(); i++) {
			char c = originalText.charAt(i);
			if ((97 <= c && c <= 122) || (65 <= c && c <= 90)) {
				count++;
				if (c == decryptedText.charAt(i) || c + 32 == decryptedText.charAt(i))
					correctCount++;
			}
		}
		Main.totalCount += count;
		Main.totalCorrect += correctCount;
		System.out.println(Filename + " " + correctCount + " correct "
				+ (count - correctCount) + " incorrect");
		correctRate = (float) correctCount / count;
		return correctRate;
	}
}
