import java.awt.Font;

public class Function_Format {
    GUI gui;
    Font arial,comic_sans,times_new_roman;
    String selectedFont;
    public Function_Format(GUI gui)
    {
        this.gui = gui;
    }
    public void wordWrap()
    {
        gui.wordWrapOn = !gui.wordWrapOn;
        gui.textArea.setLineWrap(gui.wordWrapOn);
        gui.textArea.setWrapStyleWord(gui.wordWrapOn);
        if (gui.wordWrapOn == true)
        gui.iWrap.setText("Wrap word: Off");
        else
        gui.iWrap.setText("Wrap word: On");
    }
    public void createFont(int menuFontSize)
    {
        arial = new Font("Arial",Font.PLAIN,menuFontSize);
        comic_sans = new Font("Comic Sans MS",Font.PLAIN,menuFontSize);
        times_new_roman = new Font("Times New Roman",Font.PLAIN,menuFontSize);
        setFont(selectedFont);
    }
    public void setFont(String font)
    {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comic_sans);
                break;
            case "Times New Roman":
                gui.textArea.setFont(times_new_roman);
                break;
            default:
                break;
        }
    }
    
    

}
