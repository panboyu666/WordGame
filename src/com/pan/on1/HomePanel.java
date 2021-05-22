package com.pan.on1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = -6352788025440244338L;

	// 背景圖片 以下
	java.net.URL  imgURL5  = HomePanel. class .getResource("background01.gif");
	private Image image = (Image) new ImageIcon(imgURL5).getImage();

	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 900, 506, this);

	}
	// 背景圖片 以上

	JButton b1 = new JButton("Start", Frame.icon);
	JButton b2 = new JButton("EXIT", Frame.icon);
	JButton b3 = new JButton("Clear data", Frame.icon);
	
	Store st = new Store();
	
	public HomePanel() {

		this.setLayout(null);
		this.setOpaque(false);

		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setOpaque(false);
		b1.setBounds(355, 270, 170, 38);
		b1.setFont(Frame.fontButton01);
		b1.setForeground(Color.WHITE);
		b1.setContentAreaFilled(true);
		b1.setMargin(new Insets(0, 0, 0, 0));
		b1.setFocusPainted(true);
		b1.addActionListener(this);
		b1.addMouseListener(this);
		add(b1);

		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setOpaque(false);
		b2.setBounds(355, 400, 170, 38);
		b2.setFont(Frame.fontButton01);
		b2.setForeground(Color.WHITE);
		b2.setContentAreaFilled(true);
		b2.setMargin(new Insets(0, 0, 0, 0));
		b2.setFocusPainted(true);
		b2.addActionListener(this);
		b2.addMouseListener(this);
		add(b2);

		b3.setHorizontalTextPosition(SwingConstants.CENTER);
		b3.setOpaque(false);
		b3.setBounds(355, 335, 170, 38);
		b3.setFont(Frame.fontButton01);
		b3.setForeground(Color.WHITE);
		b3.setContentAreaFilled(true);
		b3.setMargin(new Insets(0, 0, 0, 0));
		b3.setFocusPainted(true);
		b3.addActionListener(this);
		b3.addMouseListener(this);
		add(b3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {// 按鈕
		
			PlayMp3 mp1 =new PlayMp3(1);
			mp1.start();
			Frame.getmethod();
		}

		if (e.getSource() == b2) {// 按鈕
			PlayMp3 mp1 =new PlayMp3(1);
			mp1.start();
			System.exit(0);
		}

		if (e.getSource() == b3) {// 按鈕
			PlayMp3 mp1 =new PlayMp3(1);
			mp1.start();
			int i;
			i = JOptionPane.showConfirmDialog(null, "確定清除資料?", "訊息", JOptionPane.YES_NO_OPTION);
			System.out.println(i);
			if (i == 0) {
				try {
					st.StoreClear();
					st.StoreReader();
					SimplePanel.lab2.setText("LV:" + Store.lvSimple);
					SimplePanel.exp02.setText(Store.expSimple / 3 + "%");
					BasicPanel.lvLabel.setText("LV:" + Store.lvBasic);
					BasicPanel.expLabel.setText(Store.expBasic / 3 + "%");
					HighOrderPanel.lvLabel.setText("LV:" + Store.lvHighOrder);
					HighOrderPanel.expLabel.setText(0 + "%");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == b1) {
			b1.setIcon(Frame.icon2);
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
		}
		if (arg0.getSource() == b2) {
			b2.setIcon(Frame.icon2);
			PlayMp3 mp2 = new PlayMp3(2);
			mp2.start();
		}

		if (arg0.getSource() == b3) {
			b3.setIcon(Frame.icon2);
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
		if (arg0.getSource() == b3) {
			b3.setIcon(Frame.icon);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

} // HomePanel class 結束
