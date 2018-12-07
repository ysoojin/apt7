import java.util.Arrays;
public class OlympicCandles{
   public int numberOfNights(int[] candles){
      int k = 1;
	  Arrays.sort(candles);
	  while (good(candles,k)) {
		  Arrays.sort(candles);
		  for (int c = candles.length-1; c >= candles.length-k; c--) {
			  candles[c] -= 1;
		  }
		  k++;
	  }
	  return k-1;
   }
   private boolean good(int[] candles, int k) {
	   Arrays.sort(candles);
	   if (k > candles.length) return false;
	   for (int c = candles.length-1; c >= candles.length-k; c--) {
		   if (candles[c] < 1) return false;
	   }
	   return true;
   }
 }