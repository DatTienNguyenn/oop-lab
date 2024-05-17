package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.disc.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
	private Store store;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenu smUpdateStore = new JMenu("Update Store");
		
		ButtonListener btnListener = new ButtonListener();
		
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(btnListener);
		smUpdateStore.add(addBook);
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(btnListener);
		smUpdateStore.add(addDVD);

		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(btnListener);
		smUpdateStore.add(addCD);
		
		menu.add(smUpdateStore);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
		
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media: mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }
	
	public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setLocationRelativeTo(null);
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public static void main(String[] args) {
		Store storeTest = new Store();
		new StoreManagerScreen(storeTest);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1101,"Cinderella","Cartoon",3, 10,"Disney");
		storeTest.addMedia(dvd1);
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("View Store")) {
				dispose();
				new StoreManagerScreen(store);
			}
			else if(button.equals("Add DVD")) {
				dispose();
				new AddDigitalVideoDiscToStoreScreen(store);
			}
			else if(button.equals("Add CD")){
				dispose();
				new AddCompactDiscToStoreScreen(store);
			}
			else if(button.equals("Add Book")) {
				dispose();
				new AddBookToStoreScreen(store);
			}
			
		}
	}

}