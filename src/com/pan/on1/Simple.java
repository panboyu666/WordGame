package com.pan.on1;

public class Simple {

//得到了S2[]  還先把他spilt
	FileBuff file_s2 = new FileBuff();

//先抽題目

	int num1, num2, num3, num4;

	String str1, str2, str3, str4;
	String[] strTotal = new String[5];

	public String[] ran98() {

		num1 = (int) (Math.random() * FileBuff.s2.length);

		num2 = (int) (Math.random() * FileBuff.s2.length);
		while (num2 == num1) {
			num2 = (int) (Math.random() * FileBuff.s2.length);
		}
		num3 = (int) (Math.random() * FileBuff.s2.length);
		while (num3 == num2 || num3 == num1) {
			num3 = (int) (Math.random() * FileBuff.s2.length);
		}
		num4 = (int) (Math.random() * FileBuff.s2.length);
		while (num4 == num3 || num4 == num2 || num4 == num1) {
			num4 = (int) (Math.random() * FileBuff.s2.length);
		}

		

		
		str1 = FileBuff.s2[num1];
		str2 = FileBuff.s2[num2];
		str3 = FileBuff.s2[num3];
		str4 = FileBuff.s2[num4];

		String[] str11 = str1.split("-");
		String[] str22 = str2.split("-");
		String[] str33 = str3.split("-");
		String[] str44 = str4.split("-");

		strTotal[0] = str11[0];
		strTotal[1] = str11[1];
		strTotal[2] = str22[1];
		strTotal[3] = str33[1];
		strTotal[4] = str44[1];

		return strTotal;

	}

}
