package practice.miscelleneous;

public class BuyAndSellStock {
	public static int getMaximumProfit(int[] stockPrice ) {
		int maxProfit=0;
		for(int dayIndex=0;dayIndex<stockPrice.length;dayIndex++) {
			for(int nextDayIndex=dayIndex+1;nextDayIndex<stockPrice.length;nextDayIndex++) {
				maxProfit=Math.max(maxProfit, stockPrice[nextDayIndex]-stockPrice[dayIndex]);
			}
		}
		return maxProfit;
	}
	
	public static int getOptimumMaximumProfit(int[] stockPrice ) {
		int maxProfit=0;
		int min = Integer.MAX_VALUE;
		for(int dayIndex=0;dayIndex<stockPrice.length-1;dayIndex++) {
			if(stockPrice[dayIndex]<min) {
				min=stockPrice[dayIndex];
			}else {
				maxProfit=Math.max(maxProfit,stockPrice[dayIndex]-min );
			}
			
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] stockPrice = {7,1,5,3,6,4};
		int maxProfit=0;
		
		// System.out.println(" :::: maxProfit :::: "+ getMaximumProfit(stockPrice));
		System.out.println(" :::: maxProfit :::: "+ getOptimumMaximumProfit(stockPrice));
	}
}
