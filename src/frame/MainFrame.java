package frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

	public class MainFrame extends JFrame{
		public MainFrame() {
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("학생용");
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("학생등록");
			mnNewMenu.add(mntmNewMenuItem_1);
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("학생정보수정");
			mnNewMenu.add(mntmNewMenuItem_2);
			
			JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
			mnNewMenu.add(mntmNewMenuItem_3);
			
			JMenu mnNewMenu_1 = new JMenu("교수용");
			menuBar.add(mnNewMenu_1);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("교수등록");
			mnNewMenu_1.add(mntmNewMenuItem);
			
			this.setSize(500,600);
			this.setVisible(true);
		}
	}
