package study.funzin.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author ChangHoon
 */
public class StringUtil {

	private static final char[] cho = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ".toCharArray();
	private static final char[] jung = "ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ".toCharArray();
	private static final char[] jong =  " ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ".toCharArray();
	private static final Pattern SPACE_PATTERN = Pattern.compile("(\\s)+");
	private static final Pattern FIRST_SPACE_PATTERN = Pattern.compile("^(\\s)+");
	private static final Pattern LAST_SPACE_PATTERN = Pattern.compile("(\\s)+$");
	private static final Pattern MORE_SPACE_PATTERN = Pattern.compile("(\\s){2,}");
	private static final Pattern PATTERN_ZIP = Pattern.compile("^(\\d\\d\\d)?([-])?(\\d\\d\\d)?$");
	private static final Pattern PATTERN_PHONE_NO = Pattern.compile("^(\\+)?(\\d)+(([\\s\\-])*(\\d)+)+$");
	private static final Pattern PATTERN_PHONE = Pattern.compile("^(\\d\\d(\\d)?(\\d)?)?([-])?(\\d\\d\\d(\\d)?)+([-])?(\\d\\d\\d\\d)+$");
	private static final Pattern PATTERN_KOREAN_PHONE = Pattern
			.compile("^(02|031|062|053|042|051|032|052|033|055|054|061|063|064|041|043|070|0303|010|011|012|013|016|017|018|019)?([-])?(\\d\\d\\d(\\d)?)+([-])?(\\d\\d\\d\\d)+$");
	private static final Pattern PATTERN_KOREAN_MOBILE = Pattern.compile("^(010|011|016|017|018|019)?([-])?(\\d\\d\\d(\\d)?)+([-])?(\\d\\d\\d\\d)+$");
	private static final Pattern PATTERN_EMAIL = Pattern.compile("^(\\S+)?@(\\S+\\.[a-z]+)?$");
	private static final Pattern PATTERN_ALPHABET = Pattern.compile("^[a-zA-Z]+$");
	private static final Pattern PATTERN_LOWER_ALPHABET = Pattern.compile("^[a-z]+$");
	private static final Pattern PATTERN_UPPER_ALPHABET = Pattern.compile("^[A-Z]+$");
	private static final Pattern PATTERN_ALPHABET_DIGIT = Pattern.compile("^[a-zA-Z0-9]+$");
	private static final Pattern PATTERN_DIGIT = Pattern.compile("^[0-9]+$");
	private static final Pattern PATTERN_NUMBER = Pattern.compile("^([\\-\\+]?[0-9]+(\\.[0-9]*)?)(E([\\+|\\-]{0,1})?([0-9])+)?$");
	private static final Pattern PATTERN_LOWER_ALPHABET_DIGIT = Pattern.compile("^[a-z0-9]+$");
	private static final Pattern PATTERN_UPPER_ALPHABET_DIGIT = Pattern.compile("^[A-Z0-9]+$");
	private static final Pattern PATTERN_ALPHABET_DIGIT_WITH_WHITESPACE = Pattern.compile("^[a-zA-Z0-9\\s]+$");
	private static final Pattern PATTERN_TRIM_FIRST_DIGITS = Pattern.compile("^([0-9])+");
	private static final Pattern PATTERN_MACID = Pattern
			.compile("^([0-9a-fA-F]{0,2})?(:)?([0-9a-fA-F]{0,2})?(:)?([0-9a-fA-F]{0,2})?(:)?([0-9a-fA-F]{0,2})?(:)?([0-9a-fA-F]{0,2})?(:)?([0-9a-fA-F]{0,2})?$");
	private static final Pattern PATTERN_MACID_EXACT = Pattern.compile("^(([a-fA-F0-9]{2}(:)){5,6}([a-fA-F0-9]{2}))?$");
	private static final Pattern PATTERN_ISO_FULL_DATE = Pattern.compile("^(\\d\\d\\d\\d)([-])?(\\d\\d)([-])?(\\d\\d)(\\s)?(\\d\\d)([:])?(\\d\\d)([:])?(\\d\\d)([\\.])?(\\d\\d\\d)?$");
	private static final Pattern PATTERN_ISO_DATE = Pattern.compile("^(\\d\\d\\d\\d)([-])?(\\d\\d)([-])?(\\d\\d)$");
	private static final Pattern PATTERN_UNDERSCORE = Pattern.compile("_(.)");
	private static final Pattern PATTERN_DASHERIZE = Pattern.compile("([A-Z])");
	
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	private static final ObjectMapper prettyJsonMapper = new ObjectMapper();
	private static final ObjectMapper objectJsonMapper = new ObjectMapper();
	
	static {
		objectJsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jsonMapper.setSerializationInclusion(Include.NON_EMPTY);
		
		prettyJsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		prettyJsonMapper.setSerializationInclusion(Include.NON_EMPTY);
		prettyJsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	private StringUtil() {
	}
	
	public static String camelize(String word) {
		if (word == null || "".equals(word.trim()) || !PATTERN_UNDERSCORE.matcher(word.toLowerCase()).find()) {
			return word;
		}
		StringBuffer output = new StringBuffer();
		Matcher matcher = PATTERN_UNDERSCORE.matcher(word.toLowerCase());
		while (matcher.find()) {
			matcher.appendReplacement(output, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(output);
		return output.toString();
	}
	
	public static String dasherize(String word) {
		if (word == null || "".equals(word.trim()) || !PATTERN_DASHERIZE.matcher(word).find()) {
			return word;
		}
		StringBuffer output = new StringBuffer();
		Matcher matcher = PATTERN_DASHERIZE.matcher(word);
		while (matcher.find()) {
			matcher.appendReplacement(output, "_" + matcher.group(1).toUpperCase());
		}
		matcher.appendTail(output);
		return output.toString().toUpperCase();
	}
	
	public static String disassembleHangul(String value) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < value.length(); i++) {
			int code = value.codePointAt(i);
			 if (code >= 44032 && code <= 55203) {
				 code = code - 44032;
				 int choIndex = code / 21 / 28;
				 int jungIndex = code % (21 * 28) / 28;
				 int jongIndex = code % 28;
				 sb.append(cho[choIndex]);
				 sb.append(jung[jungIndex]);
				 sb.append(jong[jongIndex]);
			 }
		}
		return sb.toString().replaceAll(" ", "");
	}
	
	public static String escapeComma(String source) {
		source = (source == null ? "" : source);
		source = unescapeComma(source);
		source = source.replaceAll(",", "&#44;");
		return source;
	}

	public static String unescapeComma(String source) {
		source = (source == null ? "" : source.trim());
		source = source.replaceAll("&#44;", ",");
		return source;
	}

	public static String trimClassName(String source) {
		source = (source == null ? "" : source.trim());
		source = source.replaceAll("([\\s_,\\.\\-\\+\\(\\)/\\\\;|:!#@\\$%~`\\^\\&\\*ㅡ><\\[\\]])+", "");
		return source;
	}

	public static boolean isISOFullDate(String value) {
		if (value == null) {
			return false;
		}
		return PATTERN_ISO_FULL_DATE.matcher(value).matches();
	}

	public static boolean isISODate(String value) {
		if (value == null) {
			return false;
		}
		return PATTERN_ISO_DATE.matcher(value).matches();
	}

	public static boolean isNumber(String value) {
		if (value == null || "".equals(value.trim())) {
			return false;
		}
		if ("-".equals(value.trim()) || "+".equals(value.trim()) || ".".equals(value.trim()) || "-.".equals(value.trim()) || "+.".equals(value.trim())) {
			return false;
		}
		return PATTERN_NUMBER.matcher(value.trim()).matches();
	}
	
	public boolean contains(String[] values, String target) {
		if (values == null || target == null) {
			return false;
		}
		for (String src : values) {
			if (src == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 반각문자로 변경한다
	 * 
	 * @param src
	 *            변경할 값
	 * @return String 변경된 값
	 */
	public static String halfChar(String src) {
		if (src == null) {
			return "";
		}
		StringBuilder strBuf = new StringBuilder();
		char c = 0;
		int nSrcLength = src.length();
		for (int i = 0; i < nSrcLength; i++) {
			c = src.charAt(i);
			if (c >= '！' && c <= '～') {
				c -= 0xfee0;
			} else if (c == '　') {
				c = 0x20;
			}

			strBuf.append(c);
		}
		return strBuf.toString();
	}

	/**
	 * 전각문자로 변경한다.
	 * 
	 * @param src
	 *            변경할 값
	 * @return String 변경된 값
	 */
	public static String fullChar(String src) {
		if (src == null) {
			return "";
		}

		StringBuilder strBuf = new StringBuilder();
		char c = 0;
		int nSrcLength = src.length();
		for (int i = 0; i < nSrcLength; i++) {
			c = src.charAt(i);
			if (c >= 0x21 && c <= 0x7e) {
				c += 0xfee0;
			} else if (c == 0x20) {
				c = 0x3000;
			}
			strBuf.append(c);
		}
		return strBuf.toString();
	}

	public static String regNo(String bizRegNo) {
		if (bizRegNo == null) {
			return "";
		}
		bizRegNo = bizRegNo.trim();
		if (bizRegNo.length() == 10) {
			return bizRegNo.substring(0, 3) + "-" + bizRegNo.substring(3, 5) + "-" + bizRegNo.substring(5);
		}
		if (bizRegNo.length() == 13) {
			return bizRegNo.substring(0, 6) + "-" + bizRegNo.substring(6);
		}
		return bizRegNo;
	}

	public static boolean isEmptyString(String value) {
		if (value == null) {
			return true;
		}
		if (value.trim().isEmpty()) {
			return true;
		}

		return false;
	}

	public static boolean isNullString(String value) {
		if (value == null) {
			return true;
		}

		return false;
	}

	public static String stringAt(String numberValue, String posValue) {
		if (numberValue == null || "".equals(numberValue.trim())) {
			return "";
		}
		int pos = Integer.parseInt(posValue);
		numberValue = numberValue.trim();
		int len = numberValue.length();
		if (pos > 0 && len >= pos) {
			return numberValue.substring(len - pos, len - (pos - 1));
		}
		return "";
	}

	public static String zip1(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_ZIP.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(1);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String zip2(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_ZIP.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(3);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String zip(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		String retValue = "";
		value = value.trim();
		Matcher matcher = PATTERN_ZIP.matcher(value);
		if (matcher.find()) {
			String zip1 = matcher.group(1);
			String zip2 = matcher.group(3);
			if (zip1 != null && !"".equals(zip1.trim())) {
				retValue = zip1 + "-";
			}
			if (zip2 != null && !"".equals(zip2.trim())) {
				retValue = retValue + zip2;
			}
		}
		return retValue;
	}

	public static String telNo1(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_PHONE.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(1);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String telNo2(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_PHONE.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(5);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String telNo3(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_PHONE.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(8);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String telNo(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		StringBuilder sb = new StringBuilder();
		Matcher matcher = PATTERN_PHONE.matcher(value);
		if (matcher.find()) {
			String telNo1 = matcher.group(1);
			String telNo2 = matcher.group(5);
			String telNo3 = matcher.group(8);
			if (telNo1 != null && !"".equals(telNo1.trim())) {
				sb.append(telNo1).append("-");
			}
			if (telNo2 != null && !"".equals(telNo2.trim())) {
				sb.append(telNo2).append("-");
			}
			if (telNo3 != null && !"".equals(telNo3.trim())) {
				sb.append(telNo3);
			}
		}
		return sb.toString();
	}

	public static String koreanTelNo(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		StringBuilder sb = new StringBuilder();
		Matcher matcher = PATTERN_KOREAN_PHONE.matcher(value);
		if (matcher.find()) {
			String telNo1 = matcher.group(1);
			String telNo2 = matcher.group(3);
			String telNo3 = matcher.group(6);
			if (telNo1 != null && !"".equals(telNo1.trim())) {
				sb.append(telNo1).append("-");
			}
			if (telNo2 != null && !"".equals(telNo2.trim())) {
				sb.append(telNo2).append("-");
			}
			if (telNo3 != null && !"".equals(telNo3.trim())) {
				sb.append(telNo3);
			}
		}
		return sb.toString();
	}

	public static String koreanTelNo1(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_KOREAN_PHONE.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(1);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String koreanTelNo2(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_KOREAN_PHONE.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(3);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String koreanTelNo3(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_KOREAN_PHONE.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(6);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String email(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_EMAIL.matcher(value);
		if (matcher.find()) {
			String emailId = matcher.group(1);
			if (emailId == null) {
				emailId = "";
			}
			String emailDomain = matcher.group(2);
			if (emailDomain == null) {
				emailDomain = "";
			}
			if (!"".equals(emailId) && !"".equals(emailDomain)) {
				return value;
			}
		}
		return "";
	}

	public static String emailId(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_EMAIL.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(1);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String emailDomain(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		value = value.trim();
		Matcher matcher = PATTERN_EMAIL.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(2);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	public static String macId(String value, int index) {
		if (value == null || "".equals(value.trim())) {
			return "";
		}
		int idx = 0;
		switch (index) {
			case 1:
				idx = 1;
				break;
			case 2:
				idx = 3;
				break;
			case 3:
				idx = 5;
				break;
			case 4:
				idx = 7;
				break;
			case 5:
				idx = 9;
				break;
			case 6:
				idx = 11;
				break;
			default:
				idx = 0;
		}
		value = value.trim();
		Matcher matcher = PATTERN_MACID.matcher(value);
		if (matcher.find()) {
			String retValue = matcher.group(idx);
			if (retValue == null) {
				return "";
			}
			return retValue;
		}
		return "";
	}

	/**
	 * Decodes the passed UTF-8 String using an algorithm that's compatible with
	 * JavaScript's <code>decodeURIComponent</code> function. Returns
	 * <code>null</code> if the String is <code>null</code>.
	 * 
	 * @param s
	 *            The UTF-8 encoded String to be decoded
	 * @param charset
	 * @return the decoded String
	 */
	public static String decodeURIComponent(String s, String charset) {
		if (s == null) {
			return null;
		}

		String result = null;

		try {
			result = URLDecoder.decode(s, charset);
		} // This exception should never occur.
		catch (UnsupportedEncodingException e) {
			result = s;
		}

		return result;
	}

	/**
	 * Decodes the passed UTF-8 String using an algorithm that's compatible with
	 * JavaScript's <code>decodeURIComponent</code> function. Returns
	 * <code>null</code> if the String is <code>null</code>.
	 * 
	 * @param s
	 *            The UTF-8 encoded String to be decoded
	 * @return the decoded String
	 */
	public static String decodeURIComponent(String s) {
		return decodeURIComponent(s, "UTF-8");
	}

	/**
	 * Encodes the passed String as UTF-8 using an algorithm that's compatible
	 * with JavaScript's <code>encodeURIComponent</code> function. Returns
	 * <code>null</code> if the String is <code>null</code>.
	 * 
	 * @param s
	 *            The String to be encoded
	 * @param charset
	 * @return the encoded String
	 */
	public static String encodeURIComponent(String s, String charset) {
		String result = null;

		try {
			result = URLEncoder.encode(s, charset).replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")")
					.replaceAll("\\%7E", "~");
		} // This exception should never occur.
		catch (UnsupportedEncodingException e) {
			result = s;
		}

		return result;
	}

	/**
	 * Encodes the passed String as UTF-8 using an algorithm that's compatible
	 * with JavaScript's <code>encodeURIComponent</code> function. Returns
	 * <code>null</code> if the String is <code>null</code>.
	 * 
	 * @param s
	 *            The String to be encoded
	 * @return the encoded String
	 */
	public static String encodeURIComponent(String s) {
		return encodeURIComponent(s, "UTF-8");
	}
	
	public static String concat(String src1, String src2) {
		return (isEmptyString(src1) ? "" : src1) + (isEmptyString(src2) ? "" : src2);
	}

	public static String trimTag(String source) {
		return (source == null ? source : source.replaceAll("\\<.*?\\>", ""));
	}

	public static String ltrim(String source) {
		try {
			StringBuffer output = new StringBuffer();
			Matcher matcher = FIRST_SPACE_PATTERN.matcher(source);
			while (matcher.find()) {
				matcher.appendReplacement(output, "");
			}
			matcher.appendTail(output);
			return output.toString();
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			return source;
		}
	}

	public static String rtrim(String source) {
		try {
			StringBuffer output = new StringBuffer();
			Matcher matcher = LAST_SPACE_PATTERN.matcher(source);
			while (matcher.find()) {
				matcher.appendReplacement(output, "");
			}
			matcher.appendTail(output);
			return output.toString();
		} catch (Exception ex) {
			return source;
		}
	}

	public static String trimAll(String source) {
		try {
			StringBuffer output = new StringBuffer();
			Matcher matcher = SPACE_PATTERN.matcher(source);
			while (matcher.find()) {
				matcher.appendReplacement(output, "");
			}
			matcher.appendTail(output);
			return output.toString();
		} catch (Exception ex) {
			return source;
		}
	}

	public static String trimMore(String source) {
		try {
			StringBuffer output = new StringBuffer();
			Matcher matcher = MORE_SPACE_PATTERN.matcher(source);
			while (matcher.find()) {
				matcher.appendReplacement(output, " ");
			}
			matcher.appendTail(output);
			return output.toString();
		} catch (Exception ex) {
			return source;
		}
	}

	public static String paddingLeft(String value, String padding, int length, int maxlength) {
		if (value != null && value.length() > maxlength) {
			value = value.substring(0, maxlength);
		}
		return paddingLeft(value, padding, length);
	}

	public static String paddingLeft(String value, String padding, int length) {
		if (value == null || "".equals(value.trim())) {
			return repeat(padding, length);
		}
		if (value.length() > length) {
			return value;
		}
		return repeat(padding, length - value.length()) + value;
	}

	public static String paddingRight(String value, String padding, int length, int maxlength) {
		if (value != null && value.length() > maxlength) {
			value = value.substring(0, maxlength);
		}
		return paddingRight(value, padding, length);
	}

	public static String paddingRight(String value, String padding, int length) {

        System.out.println("paddingRight.value : " + value);
        System.out.println("paddingRight.padding : " + padding);
        System.out.println("paddingRight.length : " + length);

		if (value == null || "".equals(value.trim())) {
			return repeat(padding, length);
		}
		if (value.length() > length) {
			return value;
		}

        System.out.println("paddingRight : " + value + repeat(padding, length - value.length()));

		return value + repeat(padding, length - value.length());
	}

	public static String repeat(String value, int length) {

        System.out.println("repeat.value : " + value);
        System.out.println("repeat.length : " + length);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(value);
		}
        System.out.println("repeat : " + sb.toString());
		return sb.toString();
	}

	public static String html2special(String source) {
		source = (source == null ? "" : source.trim());
		source = special2html(source);
		source = source.replaceAll("&", "&amp;");
		source = source.replaceAll("\"", "&quot;");
		source = source.replaceAll("<", "&lt;");
		source = source.replaceAll(">", "&gt;");
		return source;
	}

	public static String special2html(String source) {
		source = (source == null ? "" : source.trim());
		source = source.replaceAll("&gt;", ">");
		source = source.replaceAll("&lt;", "<");
		source = source.replaceAll("&quot;", "\"");
		source = source.replaceAll("&amp;", "&");
		return source;
	}

	public static String newline2br(String source) {
		source = (source == null ? "" : source.trim());
		source = source.replaceAll("\n", "<br/>\n");
		return source;
	}

	public static String newline2string(String source, String target) {
		source = (source == null ? "" : source.trim());
		source = source.replaceAll("\n", "\n" + target);
		return source;
	}

	public static String plain2html(String source) {
		source = (source == null ? "" : source.trim());
		source = html2special(source);
		source = newline2br(source);
		return source;
	}

	public static String activeXParameterString(String source) {
		source = (source == null ? "" : source.trim());
		source = source.replaceAll("\"", "&quot;");
		source = source.replaceAll("\\\\", "\\\\\\\\");
		source = source.replaceAll("&quot;", "\\\\\"");
		return source;
	}

	public static String jsString(String source) {
		if (source == null) {
			return "";
		}
		source = source.replaceAll("\\\\", "\\\\\\\\");
		source = source.replaceAll("\"", "\\\\\"");
		source = source.replaceAll("\r", "\\\\r");
		source = source.replaceAll("\n", "\\\\n");
		return source;
	}
	
	public static String escapeJson(Object value) {
		if (value == null) {
			return "{}";
		}
		
		try {
			String ret =  jsonMapper.writeValueAsString(value);
			ret = html2special(ret);
			ret = ret.replaceAll("\"", "&quot;");
			return ret;
		} catch (JsonProcessingException e) {
			return "{}";
		}
	}

	public static String replace(String source, String src, String dest) {
		if (source == null || src == null || dest == null) {
			return source;
		}
		int fromIndex = 0;
		while (source.indexOf(src, fromIndex) != -1) {
			String prefixstr = source.substring(0, source.indexOf(src, fromIndex));
			String surfixstr = source.substring(source.indexOf(src, fromIndex) + src.length(), source.length());
			source = prefixstr + dest + surfixstr;
			fromIndex = prefixstr.length() + dest.length();
		}
		return source;
	}

	public static String replaceChars(String source, String replacement) {
		if (source == null || source == null) {
			return source;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = source.length(); i < len; i++) {
			sb.append(replacement);
		}
		return sb.toString();
	}

	public static String removeTag(String source) {
		if (source == null) {
			return source;
		}
		return source.replaceAll("\\<.*?\\>", "");
	}

	public static boolean isNumeric(String value) {
		if (value == null) {
			return false;
		}
		return PATTERN_DIGIT.matcher(value).matches();
	}

	public static boolean isMacId(String macId) {
		return PATTERN_MACID_EXACT.matcher(macId).matches();
	}

	public static boolean isValidEmail(String email) {
		return PATTERN_EMAIL.matcher(email).matches();
	}

	public static boolean isValidZip(String zip) {
		return PATTERN_ZIP.matcher(zip).matches();
	}

	public static boolean isValidPhone(String phone) {
		return PATTERN_PHONE.matcher(phone).matches();
	}

	public static boolean isValidPhoneNo(String phone) {
		return PATTERN_PHONE_NO.matcher(phone).matches();
	}

	public static boolean isValidMobile(String mobile) {
		return PATTERN_KOREAN_MOBILE.matcher(mobile).matches();
	}

	public static boolean isValidAlphabet(String value) {
		return PATTERN_ALPHABET.matcher(value).matches();
	}

	public static boolean isValidLowerAlphabet(String value) {
		return PATTERN_LOWER_ALPHABET.matcher(value).matches();
	}

	public static boolean isValidUpperAlphabet(String value) {
		return PATTERN_UPPER_ALPHABET.matcher(value).matches();
	}

	public static boolean isValidAlphaDigit(String value) {
		return PATTERN_ALPHABET_DIGIT.matcher(value).matches();
	}

	public static boolean isValidLowerAlphaDigit(String value) {
		return PATTERN_LOWER_ALPHABET_DIGIT.matcher(value).matches();
	}

	public static boolean isValidUpperAlphaDigit(String value) {
		return PATTERN_UPPER_ALPHABET_DIGIT.matcher(value).matches();
	}

	public static boolean isValidAlphaDigitWithWhiteSpace(String value) {
		return PATTERN_ALPHABET_DIGIT_WITH_WHITESPACE.matcher(value).matches();
	}

	public static String ltrimDigits(String source) {
		try {
			StringBuffer output = new StringBuffer();
			Matcher matcher = PATTERN_TRIM_FIRST_DIGITS.matcher(source);
			while (matcher.find()) {
				matcher.appendReplacement(output, "");
			}
			matcher.appendTail(output);
			return output.toString();
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			return source;
		}
	}

	public static String join(String[] sources, String value) {
		if (sources == null || sources.length == 0) {
			return "";
		}

		if (sources.length == 0) {
			return sources[0];
		}

		StringBuilder sb = new StringBuilder();

		if (value == null) {
			value = "";
		}

		int index = 0;
		for (String source : sources) {
			sb.append(source == null ? "" : source);
			index++;
			if (index < sources.length) {
				sb.append(value);
			}
		}

		return sb.toString();
	}
	
	public static String removeScript(String source) {
		if (source == null) {
			return source;
		}
		source = source.replaceAll("</scr", "<&#47;&#115;&#99;&#114;");
		source = source.replaceAll("</Scr", "<&#47;&#83;&#99;&#114;");
		source = source.replaceAll("</sCr", "<&#47;&#115;&#67;&#114;");
		source = source.replaceAll("</scR", "<&#47;&#115;&#99;&#82;");
		source = source.replaceAll("</SCr", "<&#47;&#83;&#67;&#114;");
		source = source.replaceAll("</sCR", "<&#47;&#115;&#67;&#82;");
		source = source.replaceAll("</ScR", "<&#47;&#83;&#99;&#82;");
		source = source.replaceAll("</SCR", "<&#47;&#83;&#67;&#82;");

		source = source.replaceAll("scr", "&#115;&#99;&#114;");
		source = source.replaceAll("Scr", "&#83;&#99;&#114;");
		source = source.replaceAll("sCr", "&#115;&#67;&#114;");
		source = source.replaceAll("scR", "&#115;&#99;&#82;");
		source = source.replaceAll("SCr", "&#83;&#67;&#114;");
		source = source.replaceAll("sCR", "&#115;&#67;&#82;");
		source = source.replaceAll("ScR", "&#83;&#99;&#82;");
		source = source.replaceAll("SCR", "&#83;&#67;&#82;");
		return source;
	}
	
	public static boolean equals(String src, String desc) {
		if (src != null && desc != null) {
			return src.equals(desc);
		}
		return false;
	}
	
	public static boolean equalsIgnoreCase(String src, String desc) {
		if (src != null && desc != null) {
			return src.equalsIgnoreCase(desc);
		}
		return false;
	}
	
	public static String toObjectJson(Object obj) {
		try {
			return objectJsonMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return ToStringBuilder.reflectionToString(obj, ToStringStyle.DEFAULT_STYLE);
		}
	}
	
	public static String toJson(Object obj) {
		try {
			return jsonMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return ToStringBuilder.reflectionToString(obj, ToStringStyle.DEFAULT_STYLE);
		}
	}
	
	public static String toPrettyJson(Object obj) {
		try {
			return prettyJsonMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE);
		}
	}
	
	public static String getSha1(String data) {
		MessageDigest md = null;
		byte[] buf = data.getBytes();
		try {
			md = MessageDigest.getInstance("SHA1");
			md.update(buf, 0, buf.length);
			return HexUtil.toHex(md.digest());
		} catch (Exception ex) {
			return null;
		} finally {
			md = null;
		}
	}
}
