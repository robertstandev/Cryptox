package com.robertstan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt
{
    ErrorBuilder errorMessageComponent;
    ProcessFile processFileComponent; 
    
    public void decryptFile(String inputFile, String outputFile, String password)
    {
        
        try
        {
            FileInputStream in = new FileInputStream(inputFile);
            
            byte[] salt = new byte[8];
            byte[] iv = new byte[128 / 8];
            in.read(salt);
            in.read(iv);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 128);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ci.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
            
            try (FileOutputStream out = new FileOutputStream(outputFile))
            {
                processFileComponent = new ProcessFile();
                processFileComponent.processFile(ci, in, out);
            }
        }
        catch (Exception e)
        {
            errorMessageComponent = new ErrorBuilder();
            errorMessageComponent.createErrorMessage(e, outputFile);
        }
    }
}