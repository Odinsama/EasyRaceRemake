package racedemo;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ProofPane extends JFrame{

	ProofPane(Color[] p) {

		setTitle("Race condition examination");
		setBounds(300,300,500, 400);
		getContentPane().setBackground(Color.BLACK);
		int length = (int) Math.sqrt(p.length);
		setLayout(new GridLayout(length, 0, 1, 1));
		for (Color c : p) {		
			JPanel smallSquare = new JPanel();
			smallSquare.setBackground(c);
			add(smallSquare);
		}
		setVisible(true);
	}

}
