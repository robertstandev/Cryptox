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
        userInputOption = uiBuilderComponent.getSelectedUserOption("Choose Option");
        executeOption();
    }
    
    private static void executeOption()
    {
        switch (userInputOption)
        {
       
        case "Encrypt":
          encryptInputString = uiBuilderComponent.getEncryptOrDecryptFileInputPath("Select the file you wish to encrypt");

          encryptOutputString = uiBuilderComponent.getEncryptOrDecryptFileOutputPath("Select the location and name for your encrypted file");

          encryptPassword = uiBuilderComponent.getUserPassword("Insert the password for the encrypted file (password that will be used to decrypt the encrypred file)");

          fileEncrypterComponent.encryptFile(encryptInputString, encryptOutputString, encryptPassword);
          break;

        case "Decrypt":
          decryptInputString = uiBuilderComponent.getEncryptOrDecryptFileInputPath("Select the file you wish to decrypt");

          decryptOutputString = uiBuilderComponent.getEncryptOrDecryptFileOutputPath("Select the location and name for your decrypted file");

          decryptPassword = uiBuilderComponent.getUserPassword("Insert the password of the encrypted file (password that was used when the file was encrypted)");

          fileDecrypterComponent.decryptFile(decryptInputString, decryptOutputString, decryptPassword);
          break;
          
        }
    }
}
