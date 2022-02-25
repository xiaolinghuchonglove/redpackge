package com.zh.io.input;

import java.io.*;

public class input {
    /**
     *
     * @throws Exception
     */
    public void testFileOutStrem()throws Exception{
        File xigua = new File("C:\\Users\\meidalao\\Desktop\\xigua3.0.txt");
        FileInputStream fileInputStream = null;



        try {
             fileInputStream = new FileInputStream(xigua);
            while(true){
//                返回的的是字节的int表示
//                int n =  fileInputStream.read(a);

                byte [] a=new byte[1];
//                返回的是读取的字节数，数组存储在a数组中
              int n =  fileInputStream.read(a);
              if(n==-1)
                  break;
                System.out.println((new String(a,0,n)));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }




}
}
