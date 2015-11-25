package song;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by limingda on 15/11/25.
 */
public class Song {

    private JPanel backGroundPanel;
    private JTable table;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton 切歌Button;
    private JLabel currentSong;
    private JLabel bottom;
    private JLabel middle;
    private String song1 = "";
    private String song2 = "";
    private String song3 = "";
    private String song4 = "";


    private int id = 1;
    public static String[] DEFAULT_FONT = new String[]{
            "Table.font"
            , "TableHeader.font"
            , "CheckBox.font"
            , "Tree.font"
            , "Viewport.font"
            , "ProgressBar.font"
            , "RadioButtonMenuItem.font"
            , "ToolBar.font"
            , "ColorChooser.font"
            , "ToggleButton.font"
            , "Panel.font"
            , "TextArea.font"
            , "Menu.font"
            , "TableHeader.font"
            // ,"TextField.font"
            , "OptionPane.font"
            , "MenuBar.font"
            , "Button.font"
            , "Label.font"
            , "PasswordField.font"
            , "ScrollPane.font"
            , "MenuItem.font"
            , "ToolTip.font"
            , "List.font"
            , "EditorPane.font"
            , "Table.font"
            , "TabbedPane.font"
            , "RadioButton.font"
            , "CheckBoxMenuItem.font"
            , "TextPane.font"
            , "PopupMenu.font"
            , "TitledBorder.font"
            , "ComboBox.font"
    };

    private void removeSong() {
        textField1.setText(textField2.getText());
        textField2.setText(textField3.getText());
        textField3.setText(textField4.getText());
        textField4.setText(textField5.getText());
        textField5.setText("");
    }

    private void setTable() {
        if (null != currentSong.getText() && !currentSong.getText().isEmpty()) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.addRow(new Object[]{id, currentSong.getText()});
            id++;
        }
    }

    public Song() {
        currentSong.setText("空");
        bottom.setText("想再听一遍,你求我呀~咩^_^");
        middle.setText("五首一轮,唱完咱们聊会儿人生呗~");


        切歌Button.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));

        切歌Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentSong.setText(textField1.getText());
                setTable();
                removeSong();
            }
        });
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);

            Font font = new Font("微软雅黑", 0 ,12);
            UIManager.put("OptionPane.font", font);
            UIManager.put("OptionPane.messageFont", font);
            UIManager.put("OptionPane.buttonFont", font);

            BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame jFrame = new JFrame("点歌器");
        jFrame.setResizable(false);
        JPanel rootPane = new Song().backGroundPanel;
        jFrame.setContentPane(rootPane);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(500, 900);
        jFrame.setLocationRelativeTo(rootPane);//居中
        jFrame.setVisible(true);
    }

    private void createUIComponents() {
        String[] columnNames = {"ID", "Song",};
        Object[][] data = null;
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column.setMinWidth(40);
        column.setMaxWidth(70);
        table.setShowVerticalLines(true);
    }
}
