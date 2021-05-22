package com.pan.on1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Store {
	static String v = null;
	public static String v2[] = new String[20];
	public static int lvSimple;
	public static int expSimple;
	public static int tSimple;
	public static int lvBasic;
	public static int expBasic;
	public static int tBasic;
	public static int lvHighOrder;
	public static int expHighOrder;
	public static int tHighOrder;

	public  void StoreReader() throws IOException  {
		
		FileReader fr = new FileReader(".\\wa1.txt");
		BufferedReader br = new BufferedReader(fr);
		
		int i = 0;
		while (br.ready()) {
			v = br.readLine();
			v2[i] = v;
			i++;
		}
		fr.close();
		br.close();
		lvSimple = Integer.valueOf(v2[0]);
		expSimple = Integer.valueOf(v2[1]);
		tSimple= Integer.valueOf(v2[2]);
		lvBasic = Integer.valueOf(v2[3]);
		expBasic = Integer.valueOf(v2[4]);
		tBasic = Integer.valueOf(v2[5]);
		lvHighOrder = Integer.valueOf(v2[6]);
		expHighOrder = Integer.valueOf(v2[7]);
		tHighOrder = Integer.valueOf(v2[8]);

	}

	
	public  void StoreWriter() throws IOException {
		FileWriter fw = new FileWriter(".\\wa1.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(""+lvSimple);
		bw.newLine();
		bw.write(""+expSimple);
		bw.newLine();
		bw.write(""+tSimple);
		bw.newLine();
		bw.write(""+lvBasic);
		bw.newLine();
		bw.write(""+expBasic);
		bw.newLine();
		bw.write(""+tBasic);
		bw.newLine();
		bw.write(""+lvHighOrder);
		bw.newLine();
		bw.write(""+expHighOrder);
		bw.newLine();
		bw.write(""+tHighOrder);
		bw.flush();
		bw.close();
	}


	public  void StoreClear() throws IOException {
		FileWriter fa = new FileWriter(".\\wa1.txt");
		BufferedWriter bw = new BufferedWriter(fa);

		bw.write(""+1);
		bw.newLine();
		bw.write(""+1);
		bw.newLine();
		bw.write(""+58);
		bw.newLine();
		bw.write(""+1);
		bw.newLine();
		bw.write(""+1);
		bw.newLine();
		bw.write(""+58);
		bw.newLine();
		bw.write(""+1);
		bw.newLine();
		bw.write(""+1);
		bw.newLine();
		bw.write(""+87);
		bw.flush();
		bw.close();
	
	
		}
}
