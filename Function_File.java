import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName;
    String fileAddress;
    public Function_File(GUI gui)
    {
        this.gui = gui;
    }
    public void newFile()
    {
        gui.textArea.setText(null);
        gui.window.setTitle("*New");
        fileName = null;
        fileAddress = null;
    }
    public void openFile()
    {
        FileDialog fileDialog = new FileDialog(gui.window,"Open",FileDialog.LOAD);
        fileDialog.setVisible(true);
        if (fileDialog.getFile()!= null)
        {
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            gui.textArea.setText("");
            String line = null;
            while ((line = br.readLine())!=null) {
                gui.textArea.append(line + '\n');
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File can't be opened!");
        }
    }
    public void saveFile()
    {
        if (fileName == null)
        {
            saveAsFile();
        }
        else
        {try {
            FileWriter fw = new FileWriter(fileAddress+fileName);
            fw.write(gui.textArea.getText());
            gui.window.setTitle(fileName);
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        }
    }
    public void saveAsFile()
    {
        FileDialog fileDialog = new FileDialog(gui.window,"Save",FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile()!= null)
        {
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        } 
        try {
            FileWriter fw = new FileWriter(fileAddress+fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("Not able to save");
            // TODO: handle exception
        }
    }
    public void exitFile()
    {
        System.exit(0);
    }
}
