package simpledb.buffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample1 {

    public static void main(String[] args) {
        // Make a new Date object. It will be initialized to the current time.
        Date now = new Date();

        // See what toString() returns
//        System.out.println(" 1. " + now.toString());
//
//        // Next, try the default DateFormat
//        System.out.println(" 2. " + DateFormat.getInstance().format(now));
//
//        // And the default time and date-time DateFormats
//        System.out.println(" 3. " + DateFormat.getTimeInstance().format(now));
//        System.out.println(" 4. " + 
//            DateFormat.getDateTimeInstance().format(now));
//
//        // Next, try the short, medium and long variants of the 
//        // default time format 
//        System.out.println(" 5. " + 
//            DateFormat.getTimeInstance(DateFormat.SHORT).format(now));
//        System.out.println(" 6. " + 
//            DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now));
//        System.out.println(" 7. " + 
//            DateFormat.getTimeInstance(DateFormat.LONG).format(now));

        // For the default date-time format, the length of both the
        // date and time elements can be specified. Here are some examples:
       // SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
//        String date = DATE_FORMAT.format(now);
////        String s = DateFormat.getDateTimeInstance(
////                DateFormat.SHORT, DateFormat.SHORT).format(now);
////        System.out.println(s);
//        System.out.println(date);
//        Date date1 =null;
//        try {
//			 date1 = DATE_FORMAT.parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(date1);
        //  System.out.println(" 9. " + DateFormat.getDateTimeInstance(
//            DateFormat.MEDIUM, DateFormat.SHORT).format(now));
//        System.out.println("10. " + DateFormat.getDateTimeInstance(
//            DateFormat.LONG, DateFormat.LONG).format(now));
long time = System.currentTimeMillis()/1000;
System.out.println(System.currentTimeMillis());
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
long time2 = System.currentTimeMillis();
System.out.println((time-time2)/1000);

    }
}