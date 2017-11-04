package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        try{
            File input = new File("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\resources\\plain.txt");
            File output = new File("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\resources\\encrypted.txt");
            File result = new File("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\resources\\result.txt");
            if(!input.canRead() || (!output.canRead() && !output.canWrite()) || !result.canWrite()){
                if(!input.canRead())
                    System.err.println("Can not read input file. Check file!");
                if(!output.canRead())
                    System.err.println("Can not read output file. Check file!");
                if(!output.canWrite())
                    System.err.println("Can not write output file. Check file!");
                if(!output.canWrite())
                    System.err.println("Can not write result file. Check file!");
                throw new Exception("Check files!");
            }

            else{
                String keyStr = "";
                try{
                    FileInputStream key = new FileInputStream("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\key.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(key));
                    String strLine;
                    while ((strLine = br.readLine()) != null){
                        keyStr += strLine;

                    }
                }catch (IOException e){
                }

                //Encrypt file
                FileCipher task;

                boolean encrypt = true;
                task = new FileCipher(input.getPath(), output.getPath(), keyStr, encrypt, OperationMode.Mode.ECB);
                task.cryptFile();
                //Decrypt file
                encrypt = false;

                FileCipher task2 = new FileCipher(output.getPath(), result.getPath(), keyStr, encrypt, OperationMode.Mode.ECB);
                task2.cryptFile();
            }
        }catch (Exception e){
            System.err.println("File error");
        }
    }
}
