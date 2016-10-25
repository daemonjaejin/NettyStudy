package study.funzin.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author ChangHoon
 */
public class NumberUtil {

	public static final long KBytes = 1024;
	public static final long MBytes = 1024 * KBytes;
	public static final long GBytes = 1024 * MBytes;
	public static final long TBytes = 1024 * GBytes;
	private static final Short ZREO_SHORT = new Short((short) 0);
	private static final Integer ZREO_INT = new Integer(0);
	private static final Long ZREO_LONG = new Long(0);
	private static final Float ZREO_FLOAT = new Float(0);
	private static final Double ZREO_DOUBLE = new Double(0);
	//private static final BigInteger ZREO_BIGINT = BigInteger.ZERO;
	//private static final BigDecimal ZREO_BIGDECIMAL = new BigDecimal(BigInteger.ZERO);
	private static final Random random;

	static {
		Random rd = null;
		try {
			rd = SecureRandom.getInstance("SHA1PRNG");
		} catch (Exception ex) {
			rd = new Random();
		}
		random = rd;
	}

	private NumberUtil() {
	}

	public static Number getNumber(String value) throws ParseException {
		NumberFormat number = NumberFormat.getNumberInstance();
		return number.parse(value);
	}

	public static Number getNumber(String value, Locale locale) throws ParseException {
		NumberFormat number = NumberFormat.getNumberInstance(locale);
		return number.parse(value);
	}

	public static Short getShort(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Short(getNumber(value).shortValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static Short getShort(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Short(getNumber(value, locale).shortValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static short getShortValue(String value) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_SHORT.shortValue();
		}
		try {
			return getNumber(value).shortValue();
		} catch (ParseException nfe) {
			return ZREO_SHORT.shortValue();
		} catch (NumberFormatException nfe) {
			return ZREO_SHORT.shortValue();
		}
	}

	public static short getShortValue(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_SHORT.shortValue();
		}
		try {
			return getNumber(value, locale).shortValue();
		} catch (ParseException nfe) {
			return ZREO_SHORT.shortValue();
		} catch (NumberFormatException nfe) {
			return ZREO_SHORT.shortValue();
		}
	}

	public static Short getShort(Number value) {
		if (value == null) {
			return null;
		}
		try {
			return new Short(value.shortValue());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static short getShortValue(Number value) {
		if (value == null) {
			return ZREO_SHORT.shortValue();
		}
		try {
			return value.shortValue();
		} catch (NumberFormatException nfe) {
			return ZREO_SHORT.shortValue();
		}
	}

	public static short[] getShortValues(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		short[] results = new short[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getShortValue(values[i]);
		}
		return results;
	}

	public static short[] getShortValues(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		short[] results = new short[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getShortValue(values[i], locale);
		}
		return results;
	}

	public static Short[] getShortArray(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Short[] results = new Short[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getShort(values[i]);
		}
		return results;
	}

	public static Short[] getShortArray(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Short[] results = new Short[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getShort(values[i], locale);
		}
		return results;
	}

	public static Integer getInt(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Integer(getNumber(value).intValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static Integer getInt(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Integer(getNumber(value, locale).intValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static int getIntValue(String value) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_INT.intValue();
		}
		try {
			return getNumber(value).intValue();
		} catch (ParseException nfe) {
			return ZREO_INT.intValue();
		} catch (NumberFormatException nfe) {
			return ZREO_INT.intValue();
		}
	}

	public static int getIntValue(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_INT.intValue();
		}
		try {
			return getNumber(value, locale).intValue();
		} catch (ParseException nfe) {
			return ZREO_INT.intValue();
		} catch (NumberFormatException nfe) {
			return ZREO_INT.intValue();
		}
	}

	public static Integer getInt(Number value) {
		if (value == null) {
			return null;
		}
		try {
			return new Integer(value.intValue());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static int getIntValue(Number value) {
		if (value == null) {
			return ZREO_INT.intValue();
		}
		try {
			return value.intValue();
		} catch (NumberFormatException nfe) {
			return ZREO_INT.intValue();
		}
	}

	public static int[] getIntValues(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		int[] results = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getIntValue(values[i]);
		}
		return results;
	}

	public static int[] getIntValues(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		int[] results = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getIntValue(values[i], locale);
		}
		return results;
	}

	public static Integer[] getIntArray(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Integer[] results = new Integer[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getInt(values[i]);
		}
		return results;
	}

	public static Integer[] getIntArray(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Integer[] results = new Integer[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getInt(values[i], locale);
		}
		return results;
	}

	public static Long getLong(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Long(getNumber(value).longValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static Long getLong(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Long(getNumber(value, locale).longValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static long getLongValue(String value) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_LONG.longValue();
		}
		try {
			return getNumber(value).longValue();
		} catch (ParseException nfe) {
			return ZREO_LONG.longValue();
		} catch (NumberFormatException nfe) {
			return ZREO_LONG.longValue();
		}
	}

	public static long getLongValue(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_LONG.longValue();
		}
		try {
			return getNumber(value, locale).longValue();
		} catch (ParseException nfe) {
			return ZREO_LONG.longValue();
		} catch (NumberFormatException nfe) {
			return ZREO_LONG.longValue();
		}
	}

	public static Long getLong(Number value) {
		if (value == null) {
			return null;
		}
		try {
			return new Long(value.longValue());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static long getLongValue(Number value) {
		if (value == null) {
			return ZREO_LONG.longValue();
		}
		try {
			return value.longValue();
		} catch (NumberFormatException nfe) {
			return ZREO_LONG.longValue();
		}
	}

	public static long[] getLongValues(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		long[] results = new long[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getLongValue(values[i]);
		}
		return results;
	}

	public static long[] getLongValues(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		long[] results = new long[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getLongValue(values[i], locale);
		}
		return results;
	}

	public static Long[] getLongArray(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Long[] results = new Long[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getLong(values[i]);
		}
		return results;
	}

	public static Long[] getLongArray(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Long[] results = new Long[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getLong(values[i], locale);
		}
		return results;
	}

	public static Float getFloat(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Float(getNumber(value).floatValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static Float getFloat(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Float(getNumber(value, locale).floatValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static float getFloatValue(String value) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_FLOAT.floatValue();
		}
		try {
			return getNumber(value).floatValue();
		} catch (ParseException nfe) {
			return ZREO_FLOAT.floatValue();
		} catch (NumberFormatException nfe) {
			return ZREO_FLOAT.floatValue();
		}
	}

	public static float getFloatValue(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_FLOAT.floatValue();
		}
		try {
			return getNumber(value, locale).floatValue();
		} catch (ParseException nfe) {
			return ZREO_FLOAT.floatValue();
		} catch (NumberFormatException nfe) {
			return ZREO_FLOAT.floatValue();
		}
	}

	public static Float getFloat(Number value) {
		if (value == null) {
			return null;
		}
		try {
			return new Float(value.floatValue());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static float getFloatValue(Number value) {
		if (value == null) {
			return ZREO_FLOAT.floatValue();
		}
		try {
			return value.floatValue();
		} catch (NumberFormatException nfe) {
			return ZREO_FLOAT.floatValue();
		}
	}

	public static float[] getFloatValues(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		float[] results = new float[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getFloatValue(values[i]);
		}
		return results;
	}

	public static float[] getFloatValues(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		float[] results = new float[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getFloatValue(values[i], locale);
		}
		return results;
	}

	public static Float[] getFloatArray(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Float[] results = new Float[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getFloat(values[i]);
		}
		return results;
	}

	public static Float[] getFloatArray(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Float[] results = new Float[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getFloat(values[i], locale);
		}
		return results;
	}

	public static Double getDouble(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Double(getNumber(value).doubleValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static Double getDouble(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new Double(getNumber(value, locale).doubleValue());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static double getDoubleValue(String value) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_DOUBLE.doubleValue();
		}
		try {
			return getNumber(value).doubleValue();
		} catch (ParseException nfe) {
			return ZREO_DOUBLE.doubleValue();
		} catch (NumberFormatException nfe) {
			return ZREO_DOUBLE.doubleValue();
		}
	}

	public static double getDoubleValue(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return ZREO_DOUBLE.doubleValue();
		}
		try {
			return getNumber(value, locale).doubleValue();
		} catch (ParseException nfe) {
			return ZREO_DOUBLE.doubleValue();
		} catch (NumberFormatException nfe) {
			return ZREO_DOUBLE.doubleValue();
		}
	}

	public static Double getDouble(Number value) {
		if (value == null) {
			return null;
		}
		try {
			return new Double(value.doubleValue());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static double getDoubleValue(Number value) {
		if (value == null) {
			return ZREO_DOUBLE.doubleValue();
		}
		try {
			return value.doubleValue();
		} catch (NumberFormatException nfe) {
			return ZREO_DOUBLE.doubleValue();
		}
	}

	public static double[] getDoubleValues(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		double[] results = new double[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getDoubleValue(values[i]);
		}
		return results;
	}

	public static double[] getDoubleValues(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		double[] results = new double[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getDoubleValue(values[i], locale);
		}
		return results;
	}

	public static Double[] getDoubleArray(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Double[] results = new Double[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getDouble(values[i]);
		}
		return results;
	}

	public static Double[] getDoubleArray(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		Double[] results = new Double[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getDouble(values[i], locale);
		}
		return results;
	}

	public static BigInteger getBigInteger(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new BigInteger(getNumber(value).toString());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static BigInteger getBigInteger(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new BigInteger(getNumber(value, locale).toString());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static BigInteger getBigInteger(Number value) {
		if (value == null) {
			return null;
		}
		try {
			return new BigInteger(value.toString());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static BigInteger[] getBigIntegerArray(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		BigInteger[] results = new BigInteger[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getBigInteger(values[i]);
		}
		return results;
	}

	public static BigInteger[] getBigIntegerArray(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		BigInteger[] results = new BigInteger[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getBigInteger(values[i], locale);
		}
		return results;
	}

	public static BigDecimal getBigDecimal(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new BigDecimal(getNumber(value).toString());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static BigDecimal getBigDecimal(String value, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		try {
			return new BigDecimal(getNumber(value, locale).toString());
		} catch (ParseException nfe) {
			return null;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static BigDecimal getBigDecimal(Number value) {
		if (value == null) {
			return null;
		}
		try {
			return new BigDecimal(value.toString());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public static BigDecimal[] getBigDecimalArray(String value, String delimiter) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		BigDecimal[] results = new BigDecimal[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getBigDecimal(values[i]);
		}
		return results;
	}

	public static BigDecimal[] getBigDecimalArray(String value, String delimiter, Locale locale) {
		if (value == null || "".equals(value.trim())) {
			return null;
		}
		String[] values = value.split(delimiter);
		BigDecimal[] results = new BigDecimal[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = getBigDecimal(values[i], locale);
		}
		return results;
	}

	public static int ceil(float value) {
		int ret = (int) value;
		if (value > ret) {
			return ret + 1;
		}
		return ret;
	}

	public static long ceil(double value) {
		long ret = (long) value;
		if (value > ret) {
			return ret + 1;
		}
		return ret;
	}

	public static int floor(float value) {
		return (int) value;
	}

	public static long floor(double value) {
		return (long) value;
	}

	public static double round(double a, int pos) {
		long up_pos = (long) Math.pow(10, pos);
		long rounded = (long) ((a * up_pos) + 0.5);
		double round_val = (double) rounded / (double) up_pos;
		return round_val;
	}

	public static float round(float a, int pos) {
		//int up_pos = 10 * pos;
		long up_pos = (long) Math.pow(10, pos);
		long rounded = (long) ((a * up_pos) + 0.5);
		float round_val = (float) rounded / (float) up_pos;
		return round_val;
	}

	public static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) + (int) (bytes[i] & 0xFF);
		}
		return result;
	}

	public static int getRandomInt() {
		random.setSeed(System.currentTimeMillis());
		return random.nextInt();
	}

	public static long getRandomLong() {
		random.setSeed(System.currentTimeMillis());
		return random.nextLong();
	}

	public static float getRandomFloat() {
		random.setSeed(System.currentTimeMillis());
		return random.nextFloat();
	}

	public static double getRandomDouble() {
		random.setSeed(System.currentTimeMillis());
		return random.nextDouble();
	}

	public static int getRandomInt(int max) {
		random.setSeed(System.currentTimeMillis());
		return random.nextInt(max);
	}

	public static int getRandomInt(int min, int max) {
		random.setSeed(System.currentTimeMillis());
		return random.nextInt((max - min + 1)) + min;
	}

	public static String getFileSize(long fileSize) {
		if (fileSize >= KBytes && fileSize < MBytes) {
			return (Math.ceil(((double) fileSize / KBytes) * 100) / 100) + " KB";
		} else if (fileSize >= MBytes && fileSize < GBytes) {
			return (Math.ceil(((double) fileSize / MBytes) * 100) / 100) + " MB";
		} else if (fileSize >= GBytes && fileSize < TBytes) {
			return (Math.ceil(((double) fileSize / GBytes) * 100) / 100) + " GB";
		} else if (fileSize >= TBytes) {
			return (Math.ceil(((double) fileSize / TBytes) * 100) / 100) + " TB";
		} else {
			return "" + fileSize;
		}
	}

	public static String getFileSize(String sfileSize) {
		long fileSize = Long.parseLong(sfileSize);
		if (fileSize >= KBytes && fileSize < MBytes) {
			return (Math.ceil(((double) fileSize / KBytes) * 100) / 100) + " KB";
		} else if (fileSize >= MBytes && fileSize < GBytes) {
			return (Math.ceil(((double) fileSize / MBytes) * 100) / 100) + " MB";
		} else if (fileSize >= GBytes && fileSize < TBytes) {
			return (Math.ceil(((double) fileSize / GBytes) * 100) / 100) + " GB";
		} else if (fileSize >= TBytes) {
			return (Math.ceil(((double) fileSize / TBytes) * 100) / 100) + " TB";
		} else {
			return "" + fileSize;
		}
	}
	
	public static boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public static boolean equals(Short src, Short desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equals(Short src, Integer desc) {
		if (src != null && desc != null) {
			return src.equals(desc.shortValue());
		}
		return false;
	}
	
	public static boolean equals(Short src, Long desc) {
		if (src != null && desc != null) {
			return src.equals(desc.shortValue());
		}
		return false;
	}
	
	public static boolean equals(Short src, Float desc) {
		if (src != null && desc != null) {
			return src.equals(desc.shortValue());
		}
		return false;
	}
	
	public static boolean equals(Short src, Double desc) {
		if (src != null && desc != null) {
			return src.equals(desc.shortValue());
		}
		return false;
	}
	
	public static boolean equals(Short src, BigInteger desc) {
		if (src != null && desc != null) {
			return src.equals(desc.shortValue());
		}
		return false;
	}
	
	public static boolean equals(Short src, BigDecimal desc) {
		if (src != null && desc != null) {
			return src.equals(desc.shortValue());
		}
		return false;
	}
	
	public static boolean equals(Integer src, Integer desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equals(Integer src, Short desc) {
		if (src != null && desc != null) {
			return src.equals(desc.intValue());
		}
		return false;
	}
	
	public static boolean equals(Integer src, Long desc) {
		if (src != null && desc != null) {
			return src.equals(desc.intValue());
		}
		return false;
	}
	
	public static boolean equals(Integer src, Float desc) {
		if (src != null && desc != null) {
			return src.equals(desc.intValue());
		}
		return false;
	}
	
	public static boolean equals(Integer src, Double desc) {
		if (src != null && desc != null) {
			return src.equals(desc.intValue());
		}
		return false;
	}
	
	public static boolean equals(Integer src, BigInteger desc) {
		if (src != null && desc != null) {
			return src.equals(desc.intValue());
		}
		return false;
	}
	
	public static boolean equals(Integer src, BigDecimal desc) {
		if (src != null && desc != null) {
			return src.equals(desc.intValue());
		}
		return false;
	}
	
	public static boolean equals(Long src, Long desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equals(Long src, Short desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(Long src, Integer desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(Long src, Float desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(Long src, Double desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(Long src, BigInteger desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(Long src, BigDecimal desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(Float src, Float desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equals(Float src, Short desc) {
		if (src != null && desc != null) {
			return src.equals(desc.floatValue());
		}
		return false;
	}
	
	public static boolean equals(Float src, Integer desc) {
		if (src != null && desc != null) {
			return src.equals(desc.floatValue());
		}
		return false;
	}
	
	public static boolean equals(Float src, Long desc) {
		if (src != null && desc != null) {
			return src.equals(desc.floatValue());
		}
		return false;
	}
	
	public static boolean equals(Float src, Double desc) {
		if (src != null && desc != null) {
			return src.equals(desc.floatValue());
		}
		return false;
	}
	
	public static boolean equals(Float src, BigInteger desc) {
		if (src != null && desc != null) {
			return src.equals(desc.floatValue());
		}
		return false;
	}
	
	public static boolean equals(Float src, BigDecimal desc) {
		if (src != null && desc != null) {
			return src.equals(desc.floatValue());
		}
		return false;
	}

	public static boolean equals(Double src, Double desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equals(Double src, Short desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(Double src, Integer desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(Double src, Long desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(Double src, Float desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(Double src, BigInteger desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(Double src, BigDecimal desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(BigInteger src, BigInteger desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equals(BigInteger src, Short desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(BigInteger src, Integer desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(BigInteger src, Long desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(BigInteger src, Float desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(BigInteger src, Double desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}
	
	public static boolean equals(BigInteger src, BigDecimal desc) {
		if (src != null && desc != null) {
			return src.equals(desc.longValue());
		}
		return false;
	}

	public static boolean equals(BigDecimal src, BigDecimal desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equals(BigDecimal src, Short desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(BigDecimal src, Integer desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(BigDecimal src, Long desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(BigDecimal src, Float desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(BigDecimal src, Double desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	public static boolean equals(BigDecimal src, BigInteger desc) {
		if (src != null && desc != null) {
			return src.equals(desc.doubleValue());
		}
		return false;
	}
	
	/*public static String toFixed(Double number, Number scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale.intValue() + 2));

		return decimalFormat.format(number);
	}
	
	public static String toFixed(Double number, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale + 2));

		return decimalFormat.format(number);
	}
	
	public static String toFixed(Float number, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale + 2));
		
		return decimalFormat.format(number);
	}
	
	public static String toFixed(Long number, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale + 2));
		
		return decimalFormat.format(number);
	}
	
	public static String toFixed(Integer number, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale + 2));
		
		return decimalFormat.format(number);
	}
	
	public static String toFixed(Short number, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale + 2));
		
		return decimalFormat.format(number);
	}
	
	public static String toFixed(BigDecimal number, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale + 2));
		
		return decimalFormat.format(number);
	}
	
	public static String toFixed(BigInteger number, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "#", scale + 2));
		
		return decimalFormat.format(number);
	}*/
	
	public static String toFixed(Number number, Number scale) {
		if (number == null || scale == null) {
			return "";
		}

        System.out.println("toFixed.number : " + number);
        System.out.println("toFixed.scale : " + scale);

		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "0", scale.intValue() + 2));
//        DecimalFormat decimalFormat = new DecimalFormat("0.0");

		String value = decimalFormat.format(number);

        System.out.println("toFixed.value1 : " + value);

		value = value.substring(0, value.indexOf(".") + scale.intValue() + 1);

        System.out.println("toFixed.value2 : " + value);
		
		return value;
	}
	
	public static String toFixed(BigDecimal number, Number scale) {
		if (number == null || scale == null) {
			return "";
		}
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "0", scale.intValue() + 2));
		
		String value = decimalFormat.format(number);

		value = value.substring(0, value.indexOf(".") + scale.intValue() + 1);

		return value;
	}
	
	public static String toFixed(BigInteger number, Number scale) {
		if (number == null || scale == null) {
			return "";
		}
		DecimalFormat decimalFormat = new DecimalFormat(StringUtil.paddingRight("0.", "0", scale.intValue() + 2));
		
		String value = decimalFormat.format(number);
		
		value = value.substring(0, value.indexOf(".") + scale.intValue() + 1);
		
		return value;
	}
	
	/*public static String divide(Double numerator, int divisor, int scale) {
		BigDecimal decimalNumerator = new BigDecimal(numerator);
		BigDecimal decimalDivisor = new BigDecimal(divisor);
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(Float numerator, int divisor, int scale) {
		BigDecimal decimalNumerator = new BigDecimal(numerator);
		BigDecimal decimalDivisor = new BigDecimal(divisor);
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(Long numerator, int divisor, int scale) {
		BigDecimal decimalNumerator = new BigDecimal(numerator);
		BigDecimal decimalDivisor = new BigDecimal(divisor);
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(Integer numerator, int divisor, int scale) {
		BigDecimal decimalNumerator = new BigDecimal(numerator);
		BigDecimal decimalDivisor = new BigDecimal(divisor);
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(Short numerator, int divisor, int scale) {
		BigDecimal decimalNumerator = new BigDecimal(numerator);
		BigDecimal decimalDivisor = new BigDecimal(divisor);
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(BigDecimal numerator, int divisor, int scale) {
		BigDecimal decimalDivisor = new BigDecimal(divisor);
		return toFixed(numerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(BigInteger numerator, int divisor, int scale) {
		BigDecimal decimalNumerator = new BigDecimal(numerator);
		BigDecimal decimalDivisor = new BigDecimal(divisor);
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}*/
	
	public static String divide(Number numerator, Number divisor, Number scale) {
		if (numerator == null || divisor == null || scale == null) {
			return "";
		}
		BigDecimal decimalNumerator = new BigDecimal(numerator.doubleValue());
		BigDecimal decimalDivisor = new BigDecimal(divisor.doubleValue());
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(BigDecimal numerator, Number divisor, Number scale) {
		if (numerator == null || divisor == null || scale == null) {
			return "";
		}
		BigDecimal decimalDivisor = new BigDecimal(divisor.doubleValue());
		return toFixed(numerator.divide(decimalDivisor), scale);
	}
	
	public static String divide(BigInteger numerator, Number divisor, Number scale) {
		if (numerator == null || divisor == null || scale == null) {
			return "";
		}
		BigDecimal decimalNumerator = new BigDecimal(numerator);
		BigDecimal decimalDivisor = new BigDecimal(divisor.doubleValue());
		return toFixed(decimalNumerator.divide(decimalDivisor), scale);
	}
	
	public static boolean isNull(Number number) {
		if (number != null) {
			return false;
		}
		return true;
	}
	
	public static boolean isNull(BigInteger number) {
		if (number != null) {
			return false;
		}
		return true;
	}
	
	public static boolean isNull(BigDecimal number) {
		if (number != null) {
			return false;
		}
		return true;
	}
	
	public static String toString(Number number) {
		if (number == null) {
			return null;
		}
		return number.toString();
	}
	
	public static String toString(BigInteger number) {
		if (number == null) {
			return null;
		}
		return number.toString();
	}
	
	public static String toString(BigDecimal number) {
		if (number == null) {
			return null;
		}
		return number.toString();
	}
}
