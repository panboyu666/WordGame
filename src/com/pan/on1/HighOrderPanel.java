package com.pan.on1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HighOrderPanel extends JPanel implements MouseListener, ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;

	// public static int expInt=1; //435滿格
	// public static float expDouble =87;
	public static float expfloat;
	public static float expfloat2;
	
	java.net.URL  imgURL1  = HomePanel. class .getResource("highOrder.jpg");
	
	//String imageString = "./image/highOrder.jpg";
	private Image image = (Image) new ImageIcon(imgURL1).getImage();

	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 900, 506, this);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.BLACK);
		g2D.setStroke(new BasicStroke(7));

		g2D.drawLine(0, 5, 900, 5);

		g2D.drawLine(3, 5, 3, 490); // 1.3格 是左邊 到左邊 2.4 上到下

		g2D.drawLine(882, 5, 882, 490);

		Graphics2D g2D2 = (Graphics2D) g; // 經驗值底色
		g2D.setStroke(new BasicStroke(5));
		g2D2.setColor(new Color(255, 255, 184));
		g2D2.fillRect(274, 442, 441, 23);

		Graphics2D g2D4 = (Graphics2D) g; // 經驗值框線
		g2D4.setStroke(new BasicStroke(3));
		g2D4.setColor(Color.BLACK);
		g2D4.drawRect(272, 440, 442, 27);

		Graphics2D g2D3 = (Graphics2D) g; // 經驗值
		g2D3.setStroke(new BasicStroke(5));
		g2D3.setColor(new Color(255, 255, 56));
		g2D3.fillRect(274, 442, Store.expHighOrder, 23);
	}

	private JButton b1 = new JButton("Back", Frame.icon);
	private JButton b2 = new JButton("Exit", Frame.icon);

	private Font font01 = new Font("標楷體", 1, 60);
	private Font fieldFont01 = new Font("標楷體", 1, 25);
	private Font expFont = new Font("NO Continue", 0, 18);
	private Font answerFont = new Font("Arial Rounded MT Bold", 0, 25);
	

	// public static int lvint =1;

	static JLabel headingLabel = new JLabel("標題", JLabel.CENTER);
	static JLabel lvLabel = new JLabel("LV:" + Store.lvHighOrder, JLabel.CENTER);
	static JLabel expLabel = new JLabel("%", JLabel.CENTER);
	JLabel enterLabel = new JLabel("請輸入英文");
	java.net.URL  imgURL33  = HomePanel. class .getResource("enter02.png");
	ImageIcon imageEnter = new ImageIcon(imgURL33);
	
	JLabel enterLabe = new JLabel(imageEnter);
	JTextField textField = new JTextField();
	java.net.URL  imgURL44  = HomePanel. class .getResource("3.3.gif");
	java.net.URL  imgURL55  = HomePanel. class .getResource("3.5.gif");
	ImageIcon roleIcon01 = new ImageIcon(imgURL44);
	ImageIcon roleIcon02 = new ImageIcon(imgURL55);
	JLabel roleLabel01 = new JLabel(roleIcon01);
	JLabel roleLabel02 = new JLabel(roleIcon02);

	JLabel answerLabel = new JLabel("查看答案", JLabel.CENTER);
	JLabel answerLabel02 = new JLabel("", JLabel.CENTER);

	JLabel expLabel2 = new JLabel("Exp:");
	JLabel Labelw = new JLabel("Ctrl"); // 查看答案Ctrl
	static int whileRan = 0;
	static String[] splitS2;

	
	Store st = new Store();
	
	public HighOrderPanel() {
		this.setLayout(null);

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

		this.add(b1);

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
		this.add(b2);

		headingLabel.setBounds(300, 50, 350, 100);
		headingLabel.setFont(font01);
		this.add(headingLabel);
		lvLabel.setBounds(5, 5, 100, 80);
		lvLabel.setFont(Frame.lvFont);
		this.add(lvLabel);
		expLabel.setBounds(465, 438, 100, 30);
		expLabel.setFont(expFont);
		this.add(expLabel);

		enterLabel.setBounds(390, 240, 100, 25);
		this.add(enterLabel);

		textField.setBounds(390, 270, 180, 40);
		textField.setFont(fieldFont01);
		textField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		textField.addKeyListener(this);
		textField.enableInputMethods(false);
		this.add(textField);

		enterLabe.setBounds(560, 235, 100, 100);
		this.add(enterLabe);

		answerLabel.setBounds(680, 350, 200, 20);
		answerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		answerLabel.addMouseListener(this);
		this.add(answerLabel);

		answerLabel02.setBounds(680, 370, 200, 30);
		answerLabel02.addMouseListener(this);
		answerLabel02.setFont(answerFont);
		this.add(answerLabel02);
		// roleLabel01.setBounds(700, 20, 250, 300);
		// this.add(roleLabel01);

		expLabel2.setBounds(283, 380, 100, 100);
		expLabel2.setFont(expFont);
		this.add(expLabel2);

		Labelw.setBounds(757, 320, 100, 30);
		Labelw.setFont(expFont);

		this.add(Labelw);

	}

	public static void run() {

		if (whileRan == FileBuff.s2.length) {
			JOptionPane.showConfirmDialog(null, "已結束 , 按OK重新測試  ", "訊息", JOptionPane.DEFAULT_OPTION);
			whileRan = 0;

		}
		splitS2 = FileBuff.s2[whileRan].split("-");
		headingLabel.setText(splitS2[0]);

	}

	public void timerMethod() {

		Store.expHighOrder = (int) (Store.expHighOrder + Store.tHighOrder);
		
		if (Store.expHighOrder >= 435 || Store.expHighOrder == 435) {
			PlayMp3 mp8 =new PlayMp3(8);
			mp8.start();
			Store.lvHighOrder = Store.lvHighOrder + 1;
			Store.expHighOrder = 1;
			Store.tHighOrder = (int) (Store.tHighOrder * 0.8);
			lvLabel.setText("LV:" + Store.lvHighOrder);
			// repaint();
		}

		expfloat = Store.expHighOrder / 4.35f;
		expfloat2 = (float) (Math.round(expfloat * 1));

		expLabel.setText(expfloat2 + "%");

		try {
			st.StoreWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		java.net.URL  imgURL5  = HomePanel. class .getResource("highOrder2.jpg");
		//imageString = "./image/highOrder2.jpg";
		image = (Image) new ImageIcon(imgURL5).getImage();
		PlayMp3 mp9 =new PlayMp3(9);
		mp9.start();
		roleLabel02.setBounds(500, 20, 400, 300);
		add(roleLabel02);

		repaint();
		Timer timer = new Timer();
		Timer timer2 = new Timer();
		TimerTask tk2 = new TimerTask() {
			@Override
			public void run() {
				java.net.URL  imgURL5  = HomePanel. class .getResource("highOrder.jpg");
				//String imageString = "./image/highOrder.jpg";
				image = (Image) new ImageIcon(imgURL5).getImage();

				repaint();
			}
		};

		TimerTask tk = new TimerTask() {

			@Override
			public void run() {

				remove(roleLabel02);
				repaint();
			}

		};

		timer2.schedule(tk2, 100);
		timer.schedule(tk, 1300);

	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == b2) {// 按鈕
			System.exit(0);
		}
		if (arg0.getSource() == b1) {// 按鈕
			Frame.flag=13;
			Frame.getmethod03();
			whileRan = 0;
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

		if (arg0.getSource() == answerLabel) {

			answerLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			answerLabel.setForeground(Color.RED);
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
			answerLabel02.setText(splitS2[1]);
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
		if (arg0.getSource() == answerLabel) {

			answerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			answerLabel.setForeground(Color.BLACK);
			answerLabel02.setText("");
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (KeyEvent.VK_ENTER == arg0.getKeyCode()) {

			if (splitS2[1].equals(textField.getText())) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				textField.setText("");
				whileRan++;
				run();
				timerMethod();
			} else if (!splitS2[1].equals(textField.getText())) {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
				textField.setText("");
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {

			answerLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			answerLabel.setForeground(Color.RED);

			answerLabel02.setText(splitS2[1]);

		}
	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		answerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		answerLabel.setForeground(Color.BLACK);
		answerLabel02.setText("");

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
