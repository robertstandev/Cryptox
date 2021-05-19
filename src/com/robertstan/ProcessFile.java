package com.robertstan;

import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;

public class ProcessFile
{
    public void processFile(Cipher ci, InputStream in, OutputStream out) throws javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, java.io.IOException
    {
        byte[] ibuf = new byte[1024];
        int len;
        
        while ((len = in.read(ibuf)) != -1)
        {
            byte[] obuf = ci.update(ibuf, 0, len);
            if (obuf != null)
            {
                out.write(obuf);
            }
        }
        
        byte[] obuf = ci.doFinal();
        
        if (obuf != null)
        {
            out.write(obuf);
        }
    }
}