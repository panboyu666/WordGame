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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BasicPanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	java.net.URL  imgURL5  = HomePanel. class .getResource("basicbackground.jpg");
	private Image image = (Image) new ImageIcon(imgURL5).getImage();

	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 900, 506, this);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.BLACK);
		g2D.setStroke(new BasicStroke(7));
		g2D.drawLine(0, 97, 580, 97);
		g2D.drawLine(0, 5, 900, 5);
		g2D.drawLine(0, 425, 900, 425);
		g2D.drawLine(3, 5, 3, 420); // 1.3格 是左邊 到左邊 2.4 上到下
		g2D.drawLine(580, 5, 580, 420);
		g2D.drawLine(882, 5, 882, 420);

	}

	private JButton b1 = new JButton("Back", Frame.icon);
	private JButton b2 = new JButton("Exit", Frame.icon);
	static java.net.URL  imgURL6  = HomePanel. class .getResource("2.3.gif");
	static ImageIcon roleIcon = new ImageIcon(imgURL6);

	// static short lv = 1;
	static int RandomTitle;
	static int whileRan = 0;
	static short error = 0;
	static short true01 = 0;

	static int expfill = 290;

	static int expNow = 1;

	static JLabel roleLabel = new JLabel(roleIcon);
	static JLabel titleLabel = new JLabel("標題", JLabel.CENTER);
	static JLabel aLabel = new JLabel("A選擇", JLabel.CENTER);
	static JLabel bLabel = new JLabel("B選擇", JLabel.CENTER);
	static JLabel cLabel = new JLabel("C選擇", JLabel.CENTER);
	static JLabel dLabel = new JLabel("D選擇", JLabel.CENTER);
	static JLabel totalLabel = new JLabel("0/");
	static JLabel lvLabel = new JLabel("LV:" + Store.lvBasic);
	static JLabel expLabel = new JLabel("%");

	private Font font01 = new Font("標楷體", 1, 60);
	private Font font02 = new Font("標楷體", 1, 25);
	private Font expFont = new Font("NO Continue", 0, 15);

	ExpJPanel expJPanel = new ExpJPanel();

	Store st = new Store();

	public BasicPanel() {
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

		roleLabel.setBounds(610, 0, 300, 400);
		this.add(roleLabel);

		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(150, 5, 300, 110);
		titleLabel.setFont(font01);
		aLabel.setBounds(170, 110, 250, 100);
		bLabel.setBounds(170, 160, 250, 100);
		cLabel.setBounds(170, 210, 250, 100);
		dLabel.setBounds(170, 260, 250, 100);
		aLabel.setForeground(Color.BLACK);
		bLabel.setForeground(Color.BLACK);
		cLabel.setForeground(Color.BLACK);
		dLabel.setForeground(Color.BLACK);

		aLabel.setFont(font02);
		bLabel.setFont(font02);
		cLabel.setFont(font02);
		dLabel.setFont(font02);

		aLabel.addMouseListener(this);
		bLabel.addMouseListener(this);
		cLabel.addMouseListener(this);
		dLabel.addMouseListener(this);

		this.add(titleLabel);
		this.add(aLabel);
		this.add(bLabel);
		this.add(cLabel);
		this.add(dLabel);
		totalLabel.setBounds(415, 280, 200, 200);
		totalLabel.setFont(font01);
		this.add(totalLabel);

		lvLabel.setBounds(600, 7, 150, 100);
		lvLabel.setFont(Frame.lvFont);
		lvLabel.setForeground(Color.WHITE);
		this.add(lvLabel);

		expJPanel.setBounds(585, 400, 290, 20);
		expJPanel.setLayout(null);
		this.add(expJPanel);

		expLabel.setBounds(143, 3, 100, 13);
		expLabel.setForeground(Color.BLACK);
		expLabel.setFont(expFont);
		expJPanel.add(expLabel);

	}

	public static void ran() {

		totalLabel.setText(whileRan + "/" + FileBuff.s2.length);

		if (whileRan == FileBuff.s2.length) {
			JOptionPane.showConfirmDialog(null, "已結束 , 按OK重新測試\n  答錯:" + error + "題" + ",  答對:" + true01 + "題", "訊息",
					JOptionPane.DEFAULT_OPTION);
			whileRan = 0;
			totalLabel.setText(whileRan + "/" + FileBuff.s2.length);
			true01 = 0;
			error = 0;
		}

		String[] splitS2 = FileBuff.s2[whileRan].split("-");
		titleLabel.setText(splitS2[0]);

		int i = FileBuff.s2.length;

		int Random1 = (int) (Math.random() * i);

		while (Random1 == whileRan) {
			Random1 = (int) (Math.random() * i);
		}
		int Random2 = (int) (Math.random() * i);
		while (Random2 == Random1 || Random2 == whileRan) {
			Random2 = (int) (Math.random() * i);
		}
		int Random3 = (int) (Math.random() * i);
		while (Random3 == Random1 || Random3 == Random2 || Random3 == whileRan) {
			Random3 = (int) (Math.random() * i);
		}

		RandomTitle = (int) (Math.random() * 4 + 1);
		String[] aStr1 = FileBuff.s2[Random1].split("-");
		String[] aStr2 = FileBuff.s2[Random2].split("-");
		String[] aStr3 = FileBuff.s2[Random3].split("-");

		switch (RandomTitle) {
		case 1:
			aLabel.setText(splitS2[1]);
			bLabel.setText(aStr1[1]);
			cLabel.setText(aStr2[1]);
			dLabel.setText(aStr3[1]);
			break;
		case 2:
			aLabel.setText(aStr1[1]);
			bLabel.setText(splitS2[1]);
			cLabel.setText(aStr2[1]);
			dLabel.setText(aStr3[1]);
			break;
		case 3:
			aLabel.setText(aStr1[1]);
			bLabel.setText(aStr2[1]);
			cLabel.setText(splitS2[1]);
			dLabel.setText(aStr3[1]);
			break;
		case 4:
			aLabel.setText(aStr1[1]);
			bLabel.setText(aStr2[1]);
			cLabel.setText(aStr3[1]);
			dLabel.setText(splitS2[1]);
			break;

		}
		whileRan++;

	}

	public void expMethod() {

		try {
			st.StoreWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Store.expBasic = (int) ((int) Store.expBasic + Store.tBasic);

		if (Store.expBasic >= 290 || Store.expBasic == 290) {
			PlayMp3 mp8 =new PlayMp3(8);
			mp8.start();
			Store.tBasic = (int) (Store.tBasic * 0.8);
			Store.expBasic = 1;

			Store.lvBasic = (short) (Store.lvBasic + 1);
			lvLabel.setText("LV:" + Store.lvBasic);

		}

		expLabel.setText(Store.expBasic / 3 + "%");

		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == b2) {// 按鈕
			System.exit(0);
		}
		if (arg0.getSource() == b1) {// 按鈕
			
			Frame.flag=12;
			Frame.getmethod03();
			whileRan = 0;
			
		}

		if (arg0.getSource() == aLabel) {
			if (RandomTitle == 1) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				ran();
				true01++;
				expMethod();
			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
				ran();
				error++;
			}

			expMethod();

		}
		if (arg0.getSource() == bLabel) {
			if (RandomTitle == 2) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				ran();
				true01++;
				expMethod();
			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
				ran();
				error++;
			}

		}
		if (arg0.getSource() == cLabel) {
			if (RandomTitle == 3) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				ran();
				true01++;
				expMethod();
			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
				ran();
				error++;
			}
		}
		if (arg0.getSource() == dLabel) {
			if (RandomTitle == 4) {
				PlayMp3 mp3= new PlayMp3(3);
				mp3.start();
				ran();
				true01++;
				expMethod();
			} else {
				PlayMp3 mp4 = new PlayMp3(4);
				mp4.start();
				ran();
				error++;
			}
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
		if (arg0.getSource() == aLabel) {
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
			aLabel.setForeground(Color.WHITE);
		}
		if (arg0.getSource() == bLabel) {
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
			bLabel.setForeground(Color.WHITE);
		}
		if (arg0.getSource() == cLabel) {
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
			cLabel.setForeground(Color.WHITE);
		}
		if (arg0.getSource() == dLabel) {
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
			dLabel.setForeground(Color.WHITE);
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

		if (arg0.getSource() == aLabel) {
			aLabel.setForeground(Color.BLACK);
		}
		if (arg0.getSource() == bLabel) {
			bLabel.setForeground(Color.BLACK);
		}
		if (arg0.getSource() == cLabel) {
			cLabel.setForeground(Color.BLACK);
		}
		if (arg0.getSource() == dLabel) {
			dLabel.setForeground(Color.BLACK);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public class ExpJPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// this.setBackground(Color.BLUE);
			Graphics2D g2D = (Graphics2D) g;
			// g2D.setStroke(new BasicStroke(40));
			g2D.setColor(Color.RED);
			// g2D.drawLine(1, 1, 2, 1);
			g2D.fillRect(3, 0, Store.expBasic, 20);

		}
	}

}
