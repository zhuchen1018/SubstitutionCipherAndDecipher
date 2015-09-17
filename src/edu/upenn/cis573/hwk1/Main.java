package edu.upenn.cis573.hwk1;

import java.io.File;

public class Main {
  
	static long totalCount = 0;
	static long totalCorrect = 0;

	public static void main(String[] args){
		if (args.length == 1) {
			File dir = new File(args[0]);
			if (dir.isDirectory()) {
				File[] directoryListing = dir.listFiles();
				float correctRate = 0;
				if (directoryListing.length != 0) {
					for (File file : directoryListing) {
						String original = "";
						String encrypted = "";
						ConvertFileToString a = new ConvertFileToString();
						original = a.convertFileToString(file);
						EncryptAndDecrypt e = new EncryptAndDecrypt();
						encrypted = e.encrypt(original);
						int[] frequency = new int[26];
						for (File file1 : directoryListing) {
							if (!file1.getName().equals(file.getName())) {
								String text = a.convertFileToString(file1);
								e.getFrequencyTable(text, frequency);
							}
						}
						String decrypted = e.decrypt(encrypted, frequency);
						Compare c = new Compare();
						correctRate += c.compare(original, decrypted,
								file.getName());
					}
					correctRate = (float) totalCorrect / totalCount;
					System.out.println();
					System.out.println("TotalCorrect " + totalCorrect + " , "
							+ (totalCount - totalCorrect) + " incorrect");
					System.out.println("Accuracy : " + correctRate * 100 + "%");
				} else {
					System.out.println("The specified directory is empty.");
				}
			} else {
				System.out.println("The specified directory does not exist");
			}
		} else {
			System.out.println("The number of runtime arguments is not correct");
		}
	}
}
