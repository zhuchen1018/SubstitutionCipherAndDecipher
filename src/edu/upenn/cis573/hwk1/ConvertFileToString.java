package edu.upenn.cis573.hwk1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConvertFileToString {
	public String convertFileToString(File file) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + " ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}
}
