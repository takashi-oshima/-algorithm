package oshima.exAd084A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 12 月 30 日の M 時から次の年になるまでは何時間か、求めます。
 *
 * @author 大島
 */
public class CalcNewYearTime {

	/**
	 * 12月30日のM時から次の年になるまでは何時間かを求めます。
	 *
	 * @param input Inputクラス
	 */
	public void calcNewYear(Input input){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");
	    Date dateTo = null;
	    Date dateFrom = null;

	    // 基準点となる日付を作成します。
	    // 12月30日から01日01月までは年を跨ぐため、便宜的に2018年と2019年を設定します。
	    try {
	        dateFrom = sdf.parse("2018/12/30/" + input.getIntegerM());
	        dateTo = sdf.parse("2019/01/01/00");
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    // 日付をlong値に変換し、差分の時間を計算します。
	    long dateTimeTo = dateTo.getTime();
	    long dateTimeFrom = dateFrom.getTime();
	    long dayDiff = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 60 );

	    System.out.println(dayDiff);
	}
}