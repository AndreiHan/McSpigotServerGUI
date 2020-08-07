package gui.server;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

class Gui extends JDialog {
    //TODO : Improve UI with checkmarks
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public Gui() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> {
            try {
                onOK();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws IOException {
        String spigotVersion = (String) comboBox1.getSelectedItem();
        //System.out.println(ram);
        String ram = (String) comboBox2.getSelectedItem();
        //System.out.println(spigotVersion);

        FileManager.makeFiles(spigotVersion, ram);
        //dispose();
    }

    private void onCancel() {
        dispose();
    }
}
