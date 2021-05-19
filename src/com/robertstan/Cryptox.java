package com.robertstan;

public class Cryptox
{
    private static String userInputOption;
    private static String encryptInputString, encryptOutputString, encryptPassword;
    private static String decryptInputString, decryptOutputString, decryptPassword;
    
    private static UIBuilder uiBuilderComponent = new UIBuilder();
    private static Encrypt fileEncrypterComponent = new Encrypt();
    private static Decrypt fileDecrypterComponent = new Decrypt();
    
    public static void main(String[] args)
    {
        createOptionsDialog();
    }
    
    private static void createOptionsDialog()
    {
        userInputOption = uiBuilderComponent.userInputDialogs(0, "Choose Option");
        executeOption();
    }
    
    private static void executeOption()
    {
        switch (userInputOption)
        {
       
        case "Encrypt":
          encryptInputString = uiBuilderComponent.userInputDialogs(1, "Select the file you wish to encrypt");

          encryptOutputString = uiBuilderComponent.userInputDialogs(2, "Select the location and name for your encrypted file");

          encryptPassword = uiBuilderComponent.userInputDialogs(3, "Insert the password for the encrypted file (password that will be used to decrypt the encrypred file)");

          fileEncrypterComponent.encryptFile(encryptInputString, encryptOutputString, encryptPassword);
          break;

        case "Decrypt":
          decryptInputString = uiBuilderComponent.userInputDialogs(1, "Select the file you wish to decrypt");

          decryptOutputString = uiBuilderComponent.userInputDialogs(2, "Select the location and name for your decrypted file");

          decryptPassword = uiBuilderComponent.userInputDialogs(3, "Insert the password of the encrypted file (password that was used when the file was encrypted)");

          fileDecrypterComponent.decryptFile(decryptInputString, decryptOutputString, decryptPassword);
          break;
          
        }
    }
}