import java.awt.Color;

public class Function_Edit {
    GUI gui;

    public Function_Edit(GUI gui) {
        this.gui = gui;
    }

    public void changeColor(String color) {
        switch (color) {
            case "Red":
                gui.textArea.setBackground(new Color(255, 200, 200)); // Light red
                gui.textArea.setForeground(Color.RED);
                break;
            case "Blue":
                gui.textArea.setBackground(new Color(200, 200, 255)); // Light blue
                gui.textArea.setForeground(Color.BLUE);
                break;
            case "Yellow":
                gui.textArea.setBackground(new Color(255, 255, 200)); // Light yellow
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "White":
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "Black":
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.WHITE);
                break;
            default:
                break;
        }
        
        // Ensure the changes are immediately visible
        gui.textArea.repaint();
    }
}