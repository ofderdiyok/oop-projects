import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;

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

    public static String doubleFormat(double number)
    {
        NumberFormat formatter = new DecimalFormat("#0.00");
        String lastNumber = formatter.format(number);
        return lastNumber;
    }

    public static String returnFirstDigits(String text)
    {
        String firstTwoDigits = text.substring(0,text.length()-1);
        return firstTwoDigits;
    }

    public static double calculateFinalGrade(String midterm1, String finalExam)
    {
        double finalGrade = Integer.parseInt(midterm1)*(0.4) + Integer.parseInt(finalExam)*(0.6);
        return finalGrade;
    }

    public static double calculateFinalGrade(String midterm1, String midterm2, String finalExam)
    {
        double finalGrade = Integer.parseInt(midterm1)*(0.25) + Integer.parseInt(midterm2)*(0.25) + Integer.parseInt(finalExam)*(0.5);
        return finalGrade;
    }
}
