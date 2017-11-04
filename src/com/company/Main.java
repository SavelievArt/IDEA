package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File input = new File("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\plain.txt");
        File output = new File("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\encrypted.txt");
        File result = new File("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\result.txt");

        String keyStr = "";

        try{
            FileInputStream key = new FileInputStream("C:\\Users\\savel\\Desktop\\Cipher-2\\src\\com\\company\\key.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(key));
            String strLine;
            while ((strLine = br.readLine()) != null){
                keyStr += strLine;
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }

        FileCipher task;

        boolean encrypt = true;
        System.out.println(input.canRead());
        System.out.println(output.canWrite());
        System.out.println(result.canWrite());
        task = new FileCipher(input.getPath(), output.getPath(), keyStr, encrypt, OperationMode.Mode.ECB);
        task.cryptFile();

        encrypt = false;

        FileCipher task2 = new FileCipher(output.getPath(), result.getPath(), keyStr, encrypt, OperationMode.Mode.ECB);
        task2.cryptFile();

    }
}
