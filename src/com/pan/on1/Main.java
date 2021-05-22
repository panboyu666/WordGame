package com.pan.on1;

import java.io.IOException;

public class Main {

	public static void main(String[] args)  {

		Store st = new Store();
		try {
			st.StoreReader();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		new Frame();
	
	
		
 
	}

}
