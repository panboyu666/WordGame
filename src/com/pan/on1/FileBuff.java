package com.pan.on1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileBuff {

	static String[] s2;// s2�O�Ҧ�����ƿ�X

	public static void FilewordsMethod(String fpath) {
		int rows = 0; // rows �OŪ���ɮפ����
		int size; // �ɮפj�p��i�hsize S1�}�C
		String[] s1;

		try {
			File file01 = new File(fpath); // �ޥ�File��length��k�o���ɮפj�p
			FileReader fin = new FileReader(fpath); // Ū�����O��
			BufferedReader br = new BufferedReader(fin); // ��J�w��

			size = (int) file01.length(); // �ɮפj�p��i�hsize S1�}�C

			s1 = new String[size];

			// ���y�ɮ׫� Ū���ɮפ����rows
			while (br.ready()) {
				s1[rows] = br.readLine();
				rows++;
			}

			// ��S1�ƻs��S2 �ѨM�}�C���פ����T���D
			s2 = new String[rows];

			for (int i = 0; i < s2.length; i++) {
				s2[i] = s1[i];

			}

			fin.close();
			br.close();

		} catch (IOException e) {
			System.out.println("Ū���ϰ�error");
		}
	}

}
