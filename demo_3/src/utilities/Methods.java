package utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Methods {

    public static String readFileasString(String filename) throws Exception
    {
        String data = new String(Files.readAllBytes(Paths.get(filename)));
        return data;
    }

    public static void writeFileasString(String filename,String str)throws IOException
    {
        FileWriter fw=new FileWriter(filename,true);
        for (int i = 0; i < str.length(); i++)
            fw.write(str.charAt(i));
        fw.write("\n");
        fw.close();
    }

    public static String[] CreateList(String filename) throws Exception
    {
        String text = Methods.readFileasString(filename);
        String[] newList = text.split("\n");
        return newList;
    }

    public static String[] CreateListComma(String text) throws Exception
    {
        String[] newList = text.split(",");
        return newList;
    }
}
