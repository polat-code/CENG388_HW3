import utils.FileReadUtil;
import utils.FileWriteUtil;

public class Main {
    public static void main(String[] args) {

        String a = FileReadUtil.readBibFiles("Homework3");

        FileWriteUtil.WriteCsvFile(a);
        FileWriteUtil.createReadingListOnJsonFile("abc","x");

        System.out.println("Hello world!");
    }
}