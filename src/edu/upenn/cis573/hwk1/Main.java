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
        File[] directoryListing = Util.readInFile(args[0]);
        if(directoryListing == null)
            return;
        if (directoryListing.length == 0) {
            System.out.println("The specified directory is empty.");
            return;
        }
        for (File file : directoryListing) {
            String originaltext = "";
            String encrypted = "";
            originaltext = Util.convertFileToString(file);
            encrypted = Util.encrypt(originaltext);
            int[] frequencyTable = new int[26];
            for (File file1 : directoryListing) {
                if (!file1.getName().equals(file.getName())) {
                    String text = Util.convertFileToString(file1);
                    Util.updateFrequencyTable(text, frequencyTable);
                }
            }
            String decrypted = Util.decrypt(encrypted, frequencyTable);
            Util.compareAndCount(originaltext, decrypted, file.getName());
        }
        Util.printSummary(totalCount, totalCorrect);
    }
}
