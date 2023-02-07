package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

	public class MainFrame extends JFrame{
		public MainFrame() {
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("학생용");
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("학생등록");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new JoinFrame();
				}
			});
			mnNewMenu.add(mntmNewMenuItem_1);
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("학생정보수정");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Dialog2();
				}
			});
			mnNewMenu.add(mntmNewMenuItem_2);
			
			JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnNewMenu.add(mntmNewMenuItem_3);
			
			JMenu mnNewMenu_1 = new JMenu("교수용");
			menuBar.add(mnNewMenu_1);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("교수등록");
			mnNewMenu_1.add(mntmNewMenuItem);
			
			this.setSize(500,600);
			this.setVisible(true);
		}
	}
