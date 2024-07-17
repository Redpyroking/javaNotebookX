/**
 * NotepadType
 */
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI implements ActionListener {
    JFrame window;

    JTextArea textArea;
    JScrollPane scrollPane;

    JMenuBar menuBar;
    JMenu menuFile,menuEdit,menuFormat;
    JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
    JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR,iFont8,iFont10,iFont12,iFont14,iFont16,iFont18,iFont20;
    JMenu menuFont,menuFontSize;
    JMenu menuColor;
    JMenuItem iColor1,iColor2,iColor3,iColor4,iColor5;

    Function_File function_file = new Function_File(this);
    Function_Format function_format = new Function_Format(this);
    Function_Edit function_edit = new Function_Edit(this);

    boolean wordWrapOn = false;
    public static void main(String[] args) {
        new GUI();
    }

    public GUI()
    {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createEditMenu();
        function_format.selectedFont = "Arial";
        function_format.createFont(14);
        function_format.wordWrap();
        function_edit.changeColor("White");
        window.setVisible(true);
    }
    
    public void createWindow()
    {
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea()
    {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        
    }
    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
    }
    public void createFileMenu()
    {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }
    public void createFormatMenu()
    {
        iWrap = new JMenuItem("Wrap word :off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Wrap"); 
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        iFont8 = new JMenuItem("8");
        iFont8.addActionListener(this);
        iFont8.setActionCommand("size8");
        menuFontSize.add(iFont8);

        iFont10 = new JMenuItem("10");
        iFont10.addActionListener(this);
        iFont10.setActionCommand("size10");
        menuFontSize.add(iFont10);

        iFont12 = new JMenuItem("12");
        iFont12.addActionListener(this);
        iFont12.setActionCommand("size12");
        menuFontSize.add(iFont12);

        iFont14 = new JMenuItem("14");
        iFont14.addActionListener(this);
        iFont14.setActionCommand("size14");
        menuFontSize.add(iFont14);

        iFont16 = new JMenuItem("16");
        iFont16.addActionListener(this);
        iFont16.setActionCommand("size16");
        menuFontSize.add(iFont16);

        iFont18 = new JMenuItem("18");
        iFont18.addActionListener(this);
        iFont18.setActionCommand("size18");
        menuFontSize.add(iFont18);

        iFont20 = new JMenuItem("20");
        iFont20.addActionListener(this);
        iFont20.setActionCommand("size20");
        menuFontSize.add(iFont20);

    }
    public void createEditMenu()
    {
        menuColor = new JMenu("Color");
        menuEdit.add(menuColor);

        iColor1 = new JMenuItem("Red");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("Red");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Blue");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Blue");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Yellow");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Yellow");
        menuColor.add(iColor3);

        iColor3 = new JMenuItem("White");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("White");
        menuColor.add(iColor3);

        iColor4 = new JMenuItem("Black");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("Black");
        menuColor.add(iColor4);
    }
    @Override
    public void actionPerformed(ActionEvent e){  
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                function_file.newFile();
                break;
            case "Open":
                function_file.openFile();
                break;
            case "Save":
                function_file.saveFile();
                break;
            case "SaveAs":
                function_file.saveAsFile();
                break;
            case "Exit":
                function_file.exitFile();
                break;
            case "Wrap":
                function_format.wordWrap();
                break;
            case "Arial":
                function_format.setFont(command);
                break;
            case "Comic Sans MS":
                function_format.setFont(command);
                break;
            case "Times New Roman":
                function_format.setFont(command);
                break;
            case "size8":
                function_format.createFont(8);
                break;
            case "size10":
                function_format.createFont(10);
                break;
            case "size12":
                function_format.createFont(12);
                break;
            case "size14":
                function_format.createFont(14);
                break;
            case "size16":
                function_format.createFont(16);
                break;
            case "size18":
                function_format.createFont(18);
                break;
            case "size20":
                function_format.createFont(20);
                break;
            case "Red":
                function_edit.changeColor(command);
                break;
            case "Blue":
                function_edit.changeColor(command);
                break;
            case "Yellow":
                function_edit.changeColor(command);
                break;
            case "White":
                function_edit.changeColor(command);
                break;
            case "Black":
                function_edit.changeColor(command);
                break;
            default:
                break;
        }
}  
} 