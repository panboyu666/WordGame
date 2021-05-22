package com.pan.on1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileBuff {

	static String[] s2;// s2是所有的資料輸出

	public static void FilewordsMethod(String fpath) {
		int rows = 0; // rows 是讀取檔案內行數
		int size; // 檔案大小放進去size S1陣列
		String[] s1;

		try {
			File file01 = new File(fpath); // 引用File的length方法得到檔案大小
			FileReader fin = new FileReader(fpath); // 讀取筆記本
			BufferedReader br = new BufferedReader(fin); // 放入緩衝

			size = (int) file01.length(); // 檔案大小放進去size S1陣列

			s1 = new String[size];

			// 掃描檔案後 讀取檔案內行數rows
			while (br.ready()) {
				s1[rows] = br.readLine();
				rows++;
			}

			// 把S1複製到S2 解決陣列長度不正確問題
			s2 = new String[rows];

			for (int i = 0; i < s2.length; i++) {
				s2[i] = s1[i];

			}

			fin.close();
			br.close();

		} catch (IOException e) {
			System.out.println("讀取區域error");
		}
	}

}
