package takai.exAd085C;

import takai.exAd085C.Enum.BillRate;

//count == tenThousandBillCount + fiveThousandBillCount + thousandBillCount
//amount == 10000*x + 5000*y + 1000*z
//count == x+y+z
public class CheckIsLie {
	public void checkAmount(int count, int amount) {
		int nowCount = 0;
//		int remainingCount = count;
		int remainingAmount = amount;
		int tenThousandBillCount = 0;
		int fiveThousandBillCount = 0;
		int thousandBillCount = 0;
		boolean isTrue = false;

		thousandBillCount = remainingAmount / BillRate.Thousand.getBillRate();
		nowCount += thousandBillCount;

		if(0 != remainingAmount % BillRate.Thousand.getBillRate()) {
			remainingAmount = remainingAmount % BillRate.Thousand.getBillRate();
		}

//		fiveThousandBillCount = remainingAmount / BillRate.FiveThousand.getBillRate();
//		nowCount += fiveThousandBillCount;
//
//		if(0 != remainingAmount % BillRate.FiveThousand.getBillRate()) {
//			remainingAmount = remainingAmount % BillRate.FiveThousand.getBillRate();
//		}
//
//		tenThousandBillCount = remainingAmount / BillRate.TenThousand.getBillRate();
//		nowCount += tenThousandBillCount;
//
//		if(0 != remainingAmount % BillRate.TenThousand.getBillRate()) {
//			remainingAmount = remainingAmount % BillRate.TenThousand.getBillRate();
//		}

		if(nowCount == count) {
			isTrue = true;
		}

		while(nowCount != count) {
			if(fiveThousandBillCount > thousandBillCount) {
				fiveThousandBillCount--;
				thousandBillCount += 5;
			}

			if(tenThousandBillCount > fiveThousandBillCount) {
				tenThousandBillCount--;
				fiveThousandBillCount +=2;
			}
			nowCount = tenThousandBillCount + fiveThousandBillCount + thousandBillCount;
		}

//		while(remainingCount > 0) {
//			tenThousandBillCount = remainingAmount / BillRate.TenThousand.getBillRate();
//			remainingCount -= tenThousandBillCount;
//
//			if(0 == remainingAmount % BillRate.TenThousand.getBillRate()) {
//				isTrue = true;
//				break;
//			}else {
//				remainingAmount = remainingAmount % BillRate.TenThousand.getBillRate();
//			}
//
//			fiveThousandBillCount = remainingAmount / BillRate.FiveThousand.getBillRate();
//			remainingCount -= fiveThousandBillCount;
//			if(0 == remainingAmount % BillRate.FiveThousand.getBillRate()) {
//				isTrue = true;
//				break;
//			}else {
//				remainingAmount = remainingAmount % BillRate.FiveThousand.getBillRate();
//			}
//
//			thousandBillCount = remainingAmount / BillRate.Thousand.getBillRate();
//			remainingCount -= thousandBillCount;
//			if(0 == remainingAmount % BillRate.Thousand.getBillRate()) {
//				isTrue = true;
//				break;
//			}else {
//				remainingAmount = remainingAmount % BillRate.Thousand.getBillRate();
//			}
//		}

		if(isTrue && nowCount == count) {
			System.out.println(tenThousandBillCount+" "+fiveThousandBillCount+" "+thousandBillCount );
		}else {
			System.out.println("-1 -1 -1");
		}
	}
}