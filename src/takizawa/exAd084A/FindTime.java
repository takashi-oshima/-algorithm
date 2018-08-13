package takizawa.exAd084A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 12月30日のM時から次の年になるまでは何時間かを求めます
 *
 * @author 瀧澤
 */
public class FindTime {
	/**
	 * 何時間かを求めます
	 *
	 * @param check Checkクラス
	 */
	public void findTime(Check check) {
		int time = check.getTimeM();
		String date = "2018/12/30 " + time;
		String nextYear = "2019/01/01 00"; // 次の年の0時を設定します

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH");
		Date dateFrom = null;
		Date dateTo = null;

		try {
			dateFrom = sdf.parse(date);
			dateTo = sdf.parse(nextYear);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long dateFromTime = dateFrom.getTime();
		long dateToTime = dateTo.getTime();

		// 時刻の差を求めます。
		long timeDifference = (dateToTime - dateFromTime) / (1000 * 60 * 60);

		System.out.println(timeDifference);
		return;
	}
}