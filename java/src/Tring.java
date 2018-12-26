import java.util.Date;
import org.joda.time.DateTime;

public class Tring {
    public static void main(String[] args){
        DateTime now = DateTime.now();
        int year = now.getYear();
        int monthOfYear = now.getMonthOfYear();
        int dayOfMonth = now.getDayOfMonth();
        int weekOfYear = now.getWeekOfWeekyear();
        int dayOfWeek = now.getDayOfWeek();
        int dayOfYear = now.getDayOfYear();
		System.out.println(" year:"+year+" monthOfYear:"+monthOfYear+" dayOfMonth:"+dayOfMonth+" weekOfYear:"+weekOfYear+" dayOfWeek:"+dayOfWeek+" dayOfYear:"+dayOfYear);
    }
}
