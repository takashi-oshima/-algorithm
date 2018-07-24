package takai.exAd084A;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 12月30日の入力時から1月1日まで何時間かを計算するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class CheckRemainingTime {
	/** カレンダークラス */
	Calendar calendar = Calendar.getInstance();
	/** 入力値を時間として持つ12月30日をDate型として格納する */
	Date fromDate = null;
	/** 1月1日の0時をDate型として格納する */
	Date toDate = null;
	/** 12月30日のDate型をlong型として格納する */
	long fromDateLong = 0;
	/** 1月1日のDate型をlong型として格納する */
	long toDateLong = 0;
	/** 時間の差をミリ秒単位で格納する */
	long remainingTime = 0;
	/** ミリ秒の時間差から時間単位の差に変換するための定数 */
	final long DATE_TIME = 1000 * 60 * 60;

	/**
	 * 1月1日0時のカレンダーを作成します。
	 */
	public void setCalendar() {
		calendar.get(Calendar.YEAR);
		calendar.add(Calendar.YEAR, 1);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
	}

	/**
	 * 2つのカレンダーから時差を求めます。
	 *
	 * @param date 入力値を時間として持つカレンダー
	 * @return 時間差
	 */
	public long checkRemainingTime(Calendar date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH");
		format.setLenient(false);
		fromDate = date.getTime();
		toDate = calendar.getTime();

		fromDateLong = fromDate.getTime();
		toDateLong = toDate.getTime();
		remainingTime = (toDateLong - fromDateLong) / DATE_TIME;
		return remainingTime;
	}
}