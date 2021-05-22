package com.pan.on1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChoosePanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = -8135338717979404415L;

	// 背景圖片 以下
	java.net.URL  imgURL5  = HomePanel. class .getResource("background02.jpg");
	private Image image = (Image) new ImageIcon(imgURL5).getImage();

	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 900, 506, this);
	}
	// 背景圖片 以上
	java.net.URL  imgURL6  = HomePanel. class .getResource("word1.png");
	private ImageIcon iconWord = new ImageIcon(imgURL6);
	private JButton b1 = new JButton("Back", Frame.icon);
	private JPanel ppanel = new JPanel();

	String[] children;

	public ChoosePanel() {

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

		FlowLayout flow = new FlowLayout(FlowLayout.LEFT);

		ppanel.setBounds(150, 100, 650, 300);
		ppanel.setOpaque(false);
		ppanel.setLayout(flow);

		// 運行讀取幾個檔案
		File dir = new File("./english");
		children = dir.list();
		// 新建數個Label 圖片跟名字
		for (int f = 0; f < children.length; f++) {

			String e[] = children[f].split("\\.");
			JLabel jlabel = new JLabel(e[0], iconWord, JLabel.CENTER);

			jlabel.setVerticalTextPosition(JLabel.BOTTOM);
			jlabel.setHorizontalTextPosition(JLabel.CENTER);
			jlabel.setFont(new Font("標楷體", 1, 20));
			jlabel.setForeground(Color.WHITE);

			String s = children[f];

			jlabel.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent mouse0) {

					String pathh = "./english/" + s;
					FileBuff.FilewordsMethod(pathh); // 得到路徑

					switch (Frame.mode) {
					case "simple":
						Frame.getmethod05();
						break;
					case "basic":
						Frame.getmethod06();
						break;
					case "highOrder":
						Frame.getmethod07();

					}

				}

				@Override
				public void mouseEntered(MouseEvent mouse0) {

				}

				@Override
				public void mouseExited(MouseEvent mouse0) {

				}

				@Override
				public void mousePressed(MouseEvent mouse0) {

				}

				@Override
				public void mouseReleased(MouseEvent mouse0) {
				}
			});
			ppanel.add(jlabel);
		} // for迴圈結束

		add(ppanel);

	}// 建構市結束

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
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
			Frame.getmethod03();
		}
	}

} // Choose 結束
