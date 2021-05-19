package com.robertstan;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class UIBuilder
{
    public String userInputDialogs(int option, String dialogTitle)
    {
        
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle(dialogTitle);
        String returnedString = "null";
        
        if (option == 0)
        {
            String[] taskyOptions = { "Encrypt", "Decrypt" };
            String userInputResult = (String) JOptionPane.showInputDialog(null, "What would you like to do?", dialogTitle, JOptionPane.QUESTION_MESSAGE, null, taskyOptions, taskyOptions[0]);
            if (userInputResult != null) {
                returnedString =  userInputResult;
            }else {
                System.exit(0);
            }
        } 
        else if (option == 1) 
        {
            int userInputResult = fileChooser.showOpenDialog(null);
            if (userInputResult == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().exists()) {
                returnedString = fileChooser.getSelectedFile().getAbsolutePath();
            }else {
                System.exit(0);
            }
        } 
        else if (option == 2) 
        {
            int userInputResult = fileChooser.showSaveDialog(null);
            if (userInputResult == JFileChooser.APPROVE_OPTION) {
                returnedString = fileChooser.getSelectedFile().getAbsolutePath();
            }else {
                System.exit(0);
            }
        } 
        else if (option == 3) 
        {
            String userInputResult = JOptionPane.showInputDialog(dialogTitle);
            if (userInputResult != null && !userInputResult.isEmpty()) {
                returnedString = userInputResult;
            }else {
                System.exit(0);
            }
        }
        
        return returnedString;
        
    }
}