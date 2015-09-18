package edu.upenn.cis573.hwk1;

import java.io.File;

public class Main {

	static long totalCount = 0;
	static long totalCorrect = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("The number of runtime arguments is not correct");
			return;
		}
		File dir = new File(args[0]);
		if (!dir.isDirectory()) {
			System.out.println("The specified directory does not exist");
			return;
		}
		File[] directoryListing = dir.listFiles();
		if (directoryListing.length == 0) {
			System.out.println("The specified directory is empty.");
			return;
		}
		for (File file : directoryListing) {
			Util u = new Util();
			String originaltext = "";
			String encrypted = "";
			originaltext = u.convertFileToString(file);
			encrypted = u.encrypt(originaltext);
			int[] frequency = new int[26];
			for (File file1 : directoryListing) {
				if (!file1.getName().equals(file.getName())) {
					String text = u.convertFileToString(file1);
					u.getFrequencyTable(text, frequency);
				}
			}
			String decrypted = u.decrypt(encrypted, frequency);
			u.compareAndCount(originaltext, decrypted, file.getName());
			}
		Util.printSummary(totalCount, totalCorrect);
	}
}
