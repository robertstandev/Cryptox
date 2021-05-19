package com.robertstan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt
{
    ErrorBuilder errorMessageComponent = new ErrorBuilder();
    ProcessFile processFileComponent; 
    
    public void encryptFile(String inputFile, String outputFile, String password)
    {
        
        try
        {
            FileOutputStream out = new FileOutputStream(outputFile);
            
            byte[] salt = new byte[8];
            byte[] iv = new byte[128 / 8];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(salt);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 128);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            secureRandom.nextBytes(iv);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            out.write(salt);
            out.write(iv);
            Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ci.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            
            try (FileInputStream in = new FileInputStream(inputFile))
            {
                processFileComponent = new ProcessFile();
                processFileComponent.processFile(ci, in, out);
            }
        }
        catch (Exception e)
        {
            errorMessageComponent.createErrorMessage(e, outputFile);
        }
    }
}