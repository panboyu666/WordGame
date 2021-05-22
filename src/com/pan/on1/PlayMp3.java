package com.pan.on1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayMp3 extends Thread {

int i ;	
String s;
PlayMp3(int i){
	
this.i=i;	
	
}
@Override
public void run() {
	switch(i) {
	case 1://按鈕點擊
		s="true.mp3";
		break;
	case 2://按鈕經過
		s="music02.mp3";
		break;
	case 3: //答對音效
		s="music3.mp3";
		break;
	case 4://答錯音效
		s="music4.mp3";
		break;
	case 5://女生磁性
		s="girl01.mp3";
		break;
	case 6://初階男生
		s="man2.mp3";
		break;
	case 7://高階男生
		s="man.mp3";
		break;
	case 8://升級
		s="uplv.mp3";
		break;
	case 9://火焰
		s="fire.mp3";
		break;
	case 10://背景
		s="music.mp3";
		break;
	case 11://初階
		s="musicSmiple.mp3";
		break;
	case 12://中階
		s="basicMusic.mp3";
		break;
	case 13://高階
		s="musichigh.mp3";
		break;
	}
	

	   try{
		   
		 
		 java.net.URL  imgURL2  = HomePanel. class .getResource(s);
		 BufferedInputStream fis = new BufferedInputStream(imgURL2.openStream());
		 
		Player  playMP3 = new Player(fis);

		playMP3.play();
			           
		}  catch(Exception e){
			             System.out.println(e);
		 }

	
}
	
	
}
