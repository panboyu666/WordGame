package com.pan.on1;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame {
	static String mode;
	static java.net.URL imgURL1 = HomePanel.class.getResource("button01.jpg");
	static java.net.URL imgURL2 = HomePanel.class.getResource("button02.jpg");
	static ImageIcon icon = new ImageIcon(imgURL1);
	static ImageIcon icon2 = new ImageIcon(imgURL2);

	private static final long serialVersionUID = 1L;

	static CardLayout cardLayout = new CardLayout();
	static Container container = new Container();

	static Font fontButton01 = new Font("No Continue", 2, 32);
	static Font panelStratJLabel01 = new Font("標楷體", 2, 40);
	static Font lvFont = new Font("標楷體", 2, 40);

	HomePanel homePanel = new HomePanel();
	StartPanel startPanel = new StartPanel();
	ChoosePanel choosePanel = new ChoosePanel();
	SimplePanel simplePanel = new SimplePanel();
	BasicPanel basicPanel = new BasicPanel();
	HighOrderPanel highorderpanel = new HighOrderPanel();

	public static PlayMp3 mp10;
	public static PlayMp3 mp11;
	public static PlayMp3 mp12;
	public static PlayMp3 mp13;
	static int flag = 100;

	public Frame() {

		setBounds(380, 120, 900, 506); // 前面380.120 位置無用 但語法需要 已用絕對位置
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 調整大小
		setLocationRelativeTo(null);
		setVisible(true);
		add(homePanel);

		mp10 = new PlayMp3(10);
		mp10.start();
		container = this.getContentPane();
		container.setLayout(cardLayout);
		container.add(homePanel, "1");
		container.add(startPanel, "2");
		container.add(choosePanel, "3");

		container.add(simplePanel, "4");
		container.add(basicPanel, "5");
		container.add(highorderpanel, "6");

	}

	public static void getmethod() { // 進入選擇模式面板
		cardLayout.next(container);
	}

	public static void getmethod02() { // 回到home面板
		cardLayout.show(container, "1");
	}

	public static void getmethod03() { // startPane選擇模式面板
		cardLayout.show(container, "2");
		if (flag == 11) {
			mp11.stop();
		}
		else if (flag == 12) {
			mp12.stop();
		}
		else if (flag == 13) {
			mp13.stop();
		}
		mp10 = new PlayMp3(10);
		mp10.start();
		
	}

	public static void getmethod04() { // 選擇筆記本面板
		cardLayout.show(container, "3");
	}

	public static void getmethod05() { // 跳轉啟動初階模式

		cardLayout.show(container, "4");

		JOptionPane.showConfirmDialog(null, "準備開始", "訊息", JOptionPane.DEFAULT_OPTION);

		SimplePanel.Random_98();
		SimplePanel.pan1.requestFocusInWindow(); // 重要獲取焦點鍵盤事件才有用
		SimplePanel.pan1.enableInputMethods(false); // 禁止輸入法

		mp10.stop();
		mp11 = new PlayMp3(11);
		mp11.start();

	}

	public static void getmethod06() { // 跳轉啟動中階模式

		cardLayout.show(container, "5");

		JOptionPane.showConfirmDialog(null, "準備開始", "訊息", JOptionPane.DEFAULT_OPTION);

		mp10.stop();
		mp12 = new PlayMp3(12);
		mp12.start();

		BasicPanel.ran();

	}

	public static void getmethod07() { // 跳轉啟動高階模式

		cardLayout.show(container, "6");

		JOptionPane.showConfirmDialog(null, "準備開始", "訊息", JOptionPane.DEFAULT_OPTION);

		mp10.stop();
		mp13 = new PlayMp3(13);
		mp13.start();
		HighOrderPanel.run();

	}

}
