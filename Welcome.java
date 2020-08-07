package gui.server;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

class Welcome extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton runBuildToolsButton;
    private JLabel clickFindFirstLabel;

    private Welcome() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.setEnabled(false);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        runBuildToolsButton.addActionListener(e -> {
            try {
                onRun();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

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

    private void onRun() throws IOException {
        if(FileManager.findBuiltTools())
        buttonOK.setEnabled(true);
        else{
            clickFindFirstLabel.setText("Run BuildTools.bat First");
        }
    }

    private void onOK() {
        dispose();
        Gui dialogGUI = new Gui();
        dialogGUI.pack();
        dialogGUI.setLocationRelativeTo(null);
        dialogGUI.setVisible(true);

    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Welcome dialog = new Welcome();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }
}
