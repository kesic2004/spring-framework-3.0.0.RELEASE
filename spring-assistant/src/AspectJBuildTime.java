import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * *********************************
 * @ClassName: AspectJBuildTime.java
 * @Description: 用于输出AJ文件的编译时间
 * @author: ak
 * @createdAt: 2020-07-26下午14:35:21
 **********************************
 */
public class AspectJBuildTime {

	public static void main(String[] args) {
		long t = 0x011E64D55830L;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(t);
		Integer year        = new Integer(gc.get(Calendar.YEAR));
		Integer month       = new Integer(gc.get(Calendar.MONTH) + 1);
		Integer day         = new Integer(gc.get(Calendar.DAY_OF_MONTH));
		Integer hour        = new Integer(gc.get(Calendar.HOUR_OF_DAY));
		Integer minute      = new Integer(gc.get(Calendar.MINUTE));
		Integer second      = new Integer(gc.get(Calendar.SECOND));
		Integer millisecond = new Integer(gc.get(Calendar.MILLISECOND));
		System.out.println(t);
		System.out.println(String.format("%d-%02d-%02d_%02d-%02d-%02d.%03d", year, month, day, hour, minute, second, millisecond));
	}
}
