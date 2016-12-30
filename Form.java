import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guga on 12/15/2016.
 */
public class Form {
    JFrame frame = new JFrame("Form");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu;
    String message;

    List<Person> persons = new ArrayList<Person>();

    public void createForm(){
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        final JTextArea textArea = new JTextArea(20, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        JMenuItem menuItemOpen = new JMenuItem("Open", KeyEvent.VK_O);
        menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItemOpen.getAccessibleContext().setAccessibleDescription("Opens the excell file");
        menuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(frame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    persons = ExcelReader.getData(file.getPath());
                    message = "ფაილი წარმატებით დამუშავდა";
                } else {
                    message = "ვერ მოხერხდა ფაილის დამუშავება";
                }
                textArea.append(message);
            }
        });


        JMenuItem menuItemSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItemSave.getAccessibleContext().setAccessibleDescription("Saves the html file");
        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(frame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    FileSaver.save(file.getPath(), DataProcesor.convert(persons));
                    message = "ფაილი წარმატებით შეინახა";
                } else {
                    message = "ფაილი ვერ შეინახა";
                }
            }
        });

        menu.add(menuItemOpen);
        menu.add(menuItemSave);

        frame.setJMenuBar(menuBar);

        frame.setSize(600, 600);
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setBounds(400, 300, 0, 0);
        frame.setLayout(new FlowLayout());
        frame.add(textArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
