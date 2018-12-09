package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;;
	JButton remove;
	JButton save;
	JButton load;
	ArrayList<String> currentList = new ArrayList<String>();

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		add = new JButton();
		view = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		add.setText("Add Task");
		view.setText("View Tasks");
		remove.setText("Remove Task");
		save.setText("Save List");
		load.setText("Load LIst");
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.pack();
		panel.setVisible(true);
		frame.setVisible(true);
		currentList = new ArrayList<String>();
		String fileName="";
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("src/_03_To_Do_List/IfYouTouchThisYouWillBreakTheCode.txt"));
			fileName=br2.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i =0;
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/"+fileName+".txt"));
			String line=br.readLine();
			currentList.add(line);
			while(line != null){
				line=br.readLine();
				currentList.add(line);
				i++;
			}
			currentList.remove(i);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ToDoList t = new ToDoList();
		t.setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			currentList.add(JOptionPane.showInputDialog("What task would you like to add?"));
		}
		if (e.getSource() == view) {
			String v="";
			for (int i = 0; i < currentList.size(); i++) {
				v+="\n"+(i+1)+".) "+currentList.get(i);
			}
			JOptionPane.showMessageDialog(null, "Your current list is:"+v);
		}
		if (e.getSource() == remove) {
			String v="";
			for (int i = 0; i < currentList.size(); i++) {
				v+="\n"+(i+1)+".) "+currentList.get(i);
			}
			String input = JOptionPane.showInputDialog("Your current list is:"+v+"\nWhich item would you like to remove? (please only give numbers)");
			int r = Integer.parseInt(input)-1;
			currentList.remove(r);
			
		}
		if (e.getSource() == save) {
			String name = JOptionPane.showInputDialog("Please enter a file name.");
			String v="";
			v+=currentList.get(0);
			for (int i = 1; i < currentList.size(); i++) {
				v+="\n"+currentList.get(i);
			}
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/"+name+".txt");
				fw.write(v);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				FileWriter fw2 = new FileWriter("src/_03_To_Do_List/IfYouTouchThisYouWillBreakTheCode.txt");
				fw2.write(name);
				fw2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == load) {		
			
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				//System.out.println(fileName);
				currentList = new ArrayList<String>();
				try {
					int i =0;
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String line=br.readLine();
					currentList.add(line);
					while(line != null){
						line=br.readLine();
						currentList.add(line);
						i++;
					}
					currentList.remove(i);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
		}

	}
}
