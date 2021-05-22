package com.pan.on1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SimplePanel extends JPanel implements ActionListener, MouseListener, KeyListener {

	//public static int graphicsFill = 1; // 滿格296
	static int aaa;
	private static final long serialVersionUID = 1L;

	private JButton b1 = new JButton("Back", Frame.icon);
	private JButton b2 = new JButton("Exit", Frame.icon);
	java.net.URL  imgURL1  = HomePanel. class .getResource("showMassage.jpg");
	static java.net.URL  imgURL2  = HomePanel. class .getResource("1.3.gif");
	static java.net.URL  imgURL3  = HomePanel. class .getResource("AA.png");
	static java.net.URL  imgURL4  = HomePanel. class .getResource("SS.png");
	static java.net.URL  imgURL5  = HomePanel. class .getResource("DD.png");
	static java.net.URL  imgURL6  = HomePanel. class .getResource("FF.png");
	

	ImageIcon iconMassage = new ImageIcon(imgURL1);
	static ImageIcon icon1 = new ImageIcon(imgURL2);
	static ImageIcon iconA = new ImageIcon(imgURL3);
	static ImageIcon iconS = new ImageIcon(imgURL4);
	static ImageIcon iconD = new ImageIcon(imgURL5);
	static ImageIcon iconF = new ImageIcon(imgURL6);

	static JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan4 = new JPanel();
	JPanel pan5 = new JPanel();
	JPanel panAll = new JPanel();

	ExpPanel expPanel = new ExpPanel();

	//static int lv = 1;  
	static JLabel lab1 = new JLabel(icon1);
	static JLabel lab2 = new JLabel("LV:" +Store.lvSimple);
	static JLabel lab3 = new JLabel("", JLabel.CENTER);

	static JLabel labA = new JLabel("", iconA, JLabel.CENTER);
	static JLabel labB = new JLabel("", iconS, JLabel.CENTER);
	static JLabel labC = new JLabel("", iconD, JLabel.CENTER);
	static JLabel labD = new JLabel("", iconF, JLabel.CENTER);

	JLabel labelShow = new JLabel("訊息框", iconMassage, JLabel.CENTER);
	
	
	JLabel exp = new JLabel(""); // 數值顯示 目前未新增
	static JLabel exp02 = new JLabel("%");

	private Font font01 = new Font("標楷體", 1, 60);
	private Font font02 = new Font("標楷體", 1, 25);

	private Font showFont = new Font("標楷體", 1, 20);
	private Font expFont = new Font("NO Continue", 0, 15);
	static String[] strTotal;
	static int randomeABCD;
	static JButton bnTest = new JButton();

	double d1 = 20; // 這是%數
	//double t = d1 * 2.9; // 永遠58 = 20% t就是20%

	Store store = new Store();
	
	public SimplePanel() {
		
		this.setLayout(null);
		panAll.setLayout(null);
		panAll.setBounds(0, 0, 900, 506);
		this.add(panAll);

		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setOpaque(false);
		b1.setFont(Frame.fontButton01);
		b1.setForeground(Color.WHITE);
		b1.setContentAreaFilled(true);
		b1.setMargin(new Insets(0, 0, 0, 0));
		b1.setFocusPainted(true);
		b1.setBounds(1, 430, 170, 38);
		b1.addActionListener(this);
		b1.addMouseListener(this);

		panAll.add(b1);

		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setOpaque(false);
		b2.setBounds(715, 430, 170, 38);
		b2.setFont(Frame.fontButton01);
		b2.setForeground(Color.WHITE);
		b2.setContentAreaFilled(true);
		b2.setMargin(new Insets(0, 0, 0, 0));
		b2.setFocusPainted(true);
		b2.addActionListener(this);
		b2.addMouseListener(this);
		panAll.add(b2);

		pan1.setBounds(0, 95, 584, 335);
		// pan1.setBackground(Color.black);
		pan1.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, Color.BLACK));
		pan1.setLayout(null);

		labA.setBounds(20, 20, 220, 100);
		labB.setBounds(140, 80, 220, 100);
		labC.setBounds(260, 150, 220, 100);
		labD.setBounds(380, 215, 220, 100);

		labA.setVerticalTextPosition(JLabel.TOP);
		labA.setHorizontalTextPosition(JLabel.CENTER);
		labB.setVerticalTextPosition(JLabel.TOP);
		labB.setHorizontalTextPosition(JLabel.CENTER);
		labC.setVerticalTextPosition(JLabel.TOP);
		labC.setHorizontalTextPosition(JLabel.CENTER);
		labD.setVerticalTextPosition(JLabel.TOP);
		labD.setHorizontalTextPosition(JLabel.CENTER);

		labA.setFont(font02);
		labB.setFont(font02);
		labC.setFont(font02);
		labD.setFont(font02);

		pan1.add(labA);
		pan1.add(labB);
		pan1.add(labC);
		pan1.add(labD);

		pan1.addKeyListener(this);

		panAll.add(pan1);

		pan5.setLayout(new BorderLayout());
		pan5.setBounds(0, 0, 584, 100);
		pan5.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, Color.BLACK));

		lab3.setFont(font01);

		lab3.setVerticalAlignment(JLabel.BOTTOM);
		pan5.add(lab3);
		pan5.addKeyListener(this);
		panAll.add(pan5);

		pan2.setBounds(579, 0, 307, 430);
		pan2.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, Color.BLACK));
		pan2.setLayout(null);
		lab1.setBounds(0, 0, 300, 400);
		pan2.add(lab1);
		

		lab2.setBounds(20, 0, 200, 100);
		lab2.setFont(Frame.lvFont);
		pan2.add(lab2);

		labelShow.setBounds(0, 373, 306, 50);

		labelShow.setHorizontalTextPosition(JLabel.CENTER);
		labelShow.setForeground(Color.yellow);
		labelShow.setFont(showFont);

		pan2.add(labelShow);
		exp02.setBounds(143, 5, 100, 10);
		exp02.setForeground(Color.BLACK);
		exp02.setFont(expFont);
		expPanel.add(exp02);

		expPanel.setBounds(6, 350, 290, 30);

		pan2.add(expPanel);
		// exp.setBounds(10, 310, 200, 50);
		// exp.setFont(expFont);
		// pan2.add(exp);

		panAll.add(pan2);

	}// 建構式結束

	public static void Random_98() {
	
		Simple simp = new Simple();
		strTotal = simp.ran98(); // 回傳四個Stirng
		randomeABCD = (int) (Math.random() * 4 + 1);
		switch (randomeABCD) {
		case 1:
			lab3.setText(strTotal[0]);
			labA.setText(strTotal[1]);
			labB.setText(strTotal[2]);
			labC.setText(strTotal[3]);
			labD.setText(strTotal[4]);
			break;
		case 2:
			lab3.setText(strTotal[0]);
			labA.setText(strTotal[2]);
			labB.setText(strTotal[1]);
			labC.setText(strTotal[3]);
			labD.setText(strTotal[4]);
			break;
		case 3:
			lab3.setText(strTotal[0]);
			labA.setText(strTotal[3]);
			labB.setText(strTotal[2]);
			labC.setText(strTotal[1]);
			labD.setText(strTotal[4]);
			break;
		case 4:
			lab3.setText(strTotal[0]);
			labA.setText(strTotal[4]);
			labB.setText(strTotal[2]);
			labC.setText(strTotal[3]);
			labD.setText(strTotal[1]);
			break;
		}
		lab3.setText(strTotal[0]);
		
		
	
		

	}

	public void expMethdo() {
		
		Store.expSimple = (int) ((int) Store.expSimple + Store.tSimple);

	

		if (Store.expSimple >= 290 || Store.expSimple == 290) {
			PlayMp3 mp8 =new PlayMp3(8);
			mp8.start();
			Store.tSimple = (int) (Store.tSimple * 0.8);
			Store.expSimple = 1;
			
			
			Store.lvSimple = Store.lvSimple + 1;
			lab2.setText("LV:" + Store.lvSimple);

		}

		exp02.setText(Store.expSimple / 3 + "%");

		repaint();
		
		try {
			store.StoreWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == b2) {// 按鈕
			
			System.exit(0);
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == b2) {
			b2.setIcon(Frame.icon2);
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
		}
		
		if (arg0.getSource() == b1) {
			b1.setIcon(Frame.icon2);
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == b1) {
			b1.setIcon(Frame.icon);
		}
		
		if (arg0.getSource() == b2) {
			b2.setIcon(Frame.icon);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == b1) {
			Frame.flag=11;
			Frame.getmethod03();
		}

	}

	@Override
	public void keyPressed(KeyEvent k) {

		if (KeyEvent.VK_A == k.getKeyCode()) {
			if (randomeABCD == 1) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				labelShow.setText(strTotal[0] + "是" + strTotal[1]);
				expMethdo();
				Random_98();
			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
			}
		}

		if (KeyEvent.VK_S == k.getKeyCode()) {
			if (randomeABCD == 2) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				labelShow.setText(strTotal[0] + "是" + strTotal[1]);
				expMethdo();
				Random_98();
			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
			}
		}

		if (KeyEvent.VK_D == k.getKeyCode()) {
			if (randomeABCD == 3) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				labelShow.setText(strTotal[0] + "是" + strTotal[1]);
				expMethdo();
				Random_98();

			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
			}
		}

		if (KeyEvent.VK_F == k.getKeyCode()) {
			if (randomeABCD == 4) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				labelShow.setText(strTotal[0] + "是" + strTotal[1]);
				expMethdo();
				Random_98();

			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public static class ExpPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			// this.setBackground(Color.BLUE);
			Graphics2D g2D = (Graphics2D) g;
			// g2D.setStroke(new BasicStroke(40));
			g2D.setColor(Color.BLUE);
			// g2D.drawLine(1, 1, 2, 1);
			g2D.fillRect(3, 0, Store.expSimple, 20);

		}

		ExpPanel() {
			this.setLayout(null);
		}

		public void ExpMethod() {

		}

	}

}