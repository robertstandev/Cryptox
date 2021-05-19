package com.robertstan;

import java.io.File;

public class ErrorBuilder
{
    public void createErrorMessage(Exception errorString, String outputFile)
    {
        System.out.println(errorString);
        File file = new File(outputFile);
        if (file.exists())
        {
            file.delete();
        }  
    }
}