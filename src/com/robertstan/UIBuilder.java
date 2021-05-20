package com.robertstan;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class UIBuilder
{
    private String[] cryptoxOptions = { "Encrypt", "Decrypt" };
    private String userInputString;
    private JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());;
    
    public String getSelectedUserOption(String dialogTitle)
    {
        userInputString = "";
        userInputString = (String) JOptionPane.showInputDialog(null, "What would you like to do?", dialogTitle, JOptionPane.QUESTION_MESSAGE, null, cryptoxOptions, cryptoxOptions[0]);
        
        exitIfInputInvalid();
        
        return userInputString;
    }
    
    public String getUserPassword(String dialogTitle)
    {
        userInputString = "";
        userInputString = JOptionPane.showInputDialog(dialogTitle);
        
        exitIfInputInvalid();
        
        return userInputString;
    }
    
    public String getEncryptOrDecryptFileInputPath(String dialogTitle)
    {
        userInputString = "";
        fileChooser.setDialogTitle(dialogTitle);
        
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            userInputString = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        exitIfInputInvalid();
        
        return userInputString;
    }
    
    public String getEncryptOrDecryptFileOutputPath(String dialogTitle)
    {
        userInputString = "";
        fileChooser.setDialogTitle(dialogTitle);
        
        if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            userInputString = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        exitIfInputInvalid();
        
        return userInputString;
    }
    
    private void exitIfInputInvalid()
    {
        if(userInputString == null || userInputString.isEmpty())
        {
            System.out.println("Invalid Input");
            System.exit(0);
        }
    }
}
