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
	case 1://���s�I��
		s="true.mp3";
		break;
	case 2://���s�g�L
		s="music02.mp3";
		break;
	case 3: //���ﭵ��
		s="music3.mp3";
		break;
	case 4://��������
		s="music4.mp3";
		break;
	case 5://�k�ͺϩ�
		s="girl01.mp3";
		break;
	case 6://�춥�k��
		s="man2.mp3";
		break;
	case 7://�����k��
		s="man.mp3";
		break;
	case 8://�ɯ�
		s="uplv.mp3";
		break;
	case 9://���K
		s="fire.mp3";
		break;
	case 10://�I��
		s="music.mp3";
		break;
	case 11://�춥
		s="musicSmiple.mp3";
		break;
	case 12://����
		s="basicMusic.mp3";
		break;
	case 13://����
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
