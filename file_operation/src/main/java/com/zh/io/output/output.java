package com.zh.io.output;

import java.io.*;
import java.util.stream.Stream;

/**
 * @author ：mmzs
 * @date ：Created in 2021/12/24 9:43
 * @description：
 * @modified By：
 * @version: $
 */
public class output {
    public void testFileOutStrem()throws Exception{
        File out= new File("C:\\Users\\meidalao\\Desktop\\testout");
      OutputStream outputStream = null;
        String [] strings= new String[100];
        char c ='a';
        int i =0;

        for(; i<100;i++)
        {
            c = (char) ((int) (c) + i);
            strings[i] =String.valueOf(c);
        }


        try {
            outputStream = new FileOutputStream( out);
            for(String a:strings)
            outputStream.write(a.getBytes("UTF-8"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
           outputStream.close();
        }




    }

}


