package com.pan.on1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartPanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	// 背景圖
	java.net.URL  imgURL5  = HomePanel. class .getResource("background01.gif");
	private Image image = (Image) new ImageIcon(imgURL5).getImage();

	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 900, 506, this);
	}
	// 背景圖

	private JButton b1 = new JButton("Back", Frame.icon);
	java.net.URL  imgURL51  = HomePanel. class .getResource("1.1.gif");
	java.net.URL  imgURL52  = HomePanel. class .getResource("1.2.gif");
	java.net.URL  imgURL53  = HomePanel. class .getResource("2.1.gif");
	java.net.URL  imgURL54  = HomePanel. class .getResource("2.2.gif");
	java.net.URL  imgURL55  = HomePanel. class .getResource("3.1.gif");
	java.net.URL  imgURL56  = HomePanel. class .getResource("3.2.gif");
	private ImageIcon icon1_1 = new ImageIcon(imgURL51);
	private ImageIcon icon1_2 = new ImageIcon(imgURL52);
	private ImageIcon icon2_1 = new ImageIcon(imgURL53);
	private ImageIcon icon2_2 = new ImageIcon(imgURL54);
	private ImageIcon icon3_1 = new ImageIcon(imgURL55);
	private ImageIcon icon3_2 = new ImageIcon(imgURL56);
	

	private JLabel lb1 = new JLabel(icon1_1);
	private JLabel lb2 = new JLabel(icon2_1);
	private JLabel lb3 = new JLabel(icon3_1);

	private JLabel labelView = new JLabel();

	public StartPanel() {

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
		add(b1);

		lb1.setBounds(30, 20, 240, 400);
		lb1.addMouseListener(this);
		add(lb1);

		lb2.setBounds(325, 17, 260, 400);
		lb2.addMouseListener(this);
		add(lb2);

		lb3.setBounds(620, 25, 240, 400);
		lb3.addMouseListener(this);
		add(lb3);

		labelView.setBounds(360, 320, 400, 250);

		labelView.setFont(Frame.panelStratJLabel01);
		labelView.setForeground(Color.WHITE);
		labelView.setText("選擇模式");
		add(labelView);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == b1) {
			PlayMp3 mp1 =new PlayMp3(1);
			mp1.start();
			Frame.getmethod02();

		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lb1) {
			PlayMp3 mp1 =new PlayMp3(1);
			mp1.start();
			Frame.mode="simple";
			Frame.getmethod04();
		}
		if (arg0.getSource() == lb2) {
			PlayMp3 mp1 =new PlayMp3(1);
			mp1.start();
			Frame.mode="basic";
			Frame.getmethod04();
		}
		if (arg0.getSource() == lb3) {
			PlayMp3 mp1 =new PlayMp3(1);
			mp1.start();
			Frame.mode="highOrder";
			Frame.getmethod04();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == b1) {
			b1.setIcon(Frame.icon2);
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
		}

		if (arg0.getSource() == lb1) {
			lb1.setIcon(icon1_2);
			labelView.setText("初階模式");
			PlayMp3 mp6 = new PlayMp3(6);
			mp6.start();
		}
		if (arg0.getSource() == lb2) {
			lb2.setIcon(icon2_2);
			labelView.setText("中階模式");
			PlayMp3 mp5 = new PlayMp3(5);
			mp5.start();
		}
		if (arg0.getSource() == lb3) {
			lb3.setIcon(icon3_2);
			labelView.setText("高階模式");
			PlayMp3 mp7 = new PlayMp3(7);
			mp7.start();
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

		if (arg0.getSource() == b1) {
			b1.setIcon(Frame.icon);
		}

		if (arg0.getSource() == lb1) {
			lb1.setIcon(icon1_1);
			labelView.setText("選擇模式");

		}
		if (arg0.getSource() == lb2) {
			lb2.setIcon(icon2_1);
			labelView.setText("選擇模式");

		}
		if (arg0.getSource() == lb3) {
			lb3.setIcon(icon3_1);
			labelView.setText("選擇模式");

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

} // StartPanel 結尾
