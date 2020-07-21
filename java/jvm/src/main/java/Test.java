import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws ParseException {
        String str= "2016/11/510:24";

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/ddHH:mm");

        Date format1 = format.parse(str);
        System.out.println(format1);


        SimpleDateFormat formatAA = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String format2 = formatAA.format(format1);
        System.out.println(format2);
    }
}
