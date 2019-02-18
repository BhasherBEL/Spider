package be.bhasher.spider.utils;

/**
 * Class managing formatting.
 */
public class Format {

	/**
	 * Round the value to the precision.
	 * @param val The value to round.
	 * @param prec The precision.
	 * @return The string with the rounded value.
	 */
	public static String round(final Object val, final int prec){
		if(val.toString().contains(".")){
			return String.format("%." + prec + "f", val);
		}else{
			return val.toString();
		}
	}

}
