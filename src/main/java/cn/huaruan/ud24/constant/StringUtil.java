package cn.huaruan.ud24.constant;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 
 * ClassName: StringUtil <br/>  
 * Description: 字符串工具类 <br/>  
 * date: 2020年3月4日 下午12:24:04 <br/>  
 *  
 * @author haiming.huang  
 *
 */
public class StringUtil extends StringUtils {

	/**
	 * isNotEmpty <br/>  
	 * 判断字符串数组是否为空
	 * @author haiming.huang  
	 * @param strs
	 * @return
	 */
	final public static boolean isNotEmpty(String[] strs) {
		return strs != null && strs.length != 0;
	}
	
	/**
	 * 
	 * isNotEmpty <br/> 
	 * 判断字符串是否为空 
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	final public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * isEmpty <br/>  
	 * @author haiming.huang  
	 * @param strs
	 * @return
	 */
	final public static boolean isEmpty(String[] strs) {
		return !isNotEmpty(strs);
	}
	
	/**
	 * isEqual <br/>  
	 * 判断两个字符串是否相等
	 * @author haiming.huang  
	 * @param str1
	 * @param str2
	 * @return
	 */
	final public static boolean isEqual(String str1, String str2) {
		if (isEmpty(str1) && isEmpty(str2)) {
			return true;
		} else if (isEmpty(str1) || isEmpty(str2)) {
			return false;
		} else {
			return str1.trim().equals(str2.trim());
		}
	}

	/**
	 * isNotEqual <br/>  
	 * @author haiming.huang  
	 * @param str1
	 * @param str2
	 * @return
	 */
	final public static boolean isNotEqual(String str1, String str2) {
		return !isEqual(str1, str2);
	}
	

	/**
	 * isEqualIgnoreCase <br/>  
	 * 判断两个字符串是否相等, 不区分大小写
	 * @author haiming.huang  
	 * @param str1
	 * @param str2
	 * @return
	 */
	final public static boolean isEqualIgnoreCase(String str1, String str2) {
		if (isEmpty(str1) && isEmpty(str2)) {
			return true;
		} else if (isEmpty(str1) || isEmpty(str2)) {
			return false;
		} else {
			return str1.trim().equalsIgnoreCase(str2.trim());
		}
	}
	
	/**
	 * removeLast <br/>  
	 * 移除最后n个字符
	 * @author haiming.huang  
	 * @param str
	 * @param n
	 * @return
	 */
	final public static String removeLast(String str, int n) {
		if(isEmpty(str)) {
			return str;
		} else if(n >= str.length()) {
			return "";
		}
		return str.substring(0, str.length() - n);
	}
	
	/**
	 * removeLast <br/>  
	 * 移除最后一个字符
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	final public static String removeLast(String str) {
		if(isEmpty(str)) {
			return str;
		}
		return str.substring(0, str.length() - 1);
	}
	
	/**
	 * removeAllSpace <br/>  
	 * 去除所有空白,包括中间的
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	final public static String removeAllSpace(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str.replaceAll("\\s+", "");
	}
	
	/**
	 * field2Column <br/>  
	 * field字段转换为数据库column
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	final public static String field2Column(String str) {
		if(StringUtil.isEmpty(str)) {
			return "";
		}
		return str.replaceAll("[A-Z]", "_$0").toUpperCase();
	}
	

	/**
	 * hasSubString <br/>  
	 * 判断str是否包含subString (区分大小写)
	 * 
	 * @author haiming.huang  
	 * @param str
	 * @param subString
	 * @return
	 */
	final public static boolean hasSubString(String str, String subString) {
		if(isEmpty(str) || isEmpty(subString)) {
			return false;
		}
		return str.indexOf(subString) >= 0;
	}
	
	/**
	 * hasSubStringIgnoreCase <br/>  
	 * 判断str是否包含subString (不区分大小写)
	 * 
	 * @author haiming.huang  
	 * @param str
	 * @param subString
	 * @return
	 */
	final public static boolean hasSubStringIgnoreCase(String str, String subString) {
		if(isEmpty(str) || isEmpty(subString)) {
			return false;
		}
		str = str.toUpperCase();
		subString = subString.toUpperCase();
		return str.indexOf(subString) >= 0;
	}
	
	/**
	 * isNumeric <br/>  
	 * 是否为纯数字
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (isEmpty(str)) {
			return false;
		}
        return str.matches("\\d*");
	}
	
	/**
	 * isDouble <br/>  
	 * 是否为Double
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {
		if (isEmpty(str)) {
			return false;
		}
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * StringlistToArray <br/>  
	 * @author haiming.huang  
	 * @param emailList
	 * @return
	 */
	public static String[] listToArray(List<String> emailList) {
		String[] userEmails = new String[emailList.size()];
		int index = 0;
		for (String email : emailList) {
			userEmails[index++] = email;
		}
		return userEmails;
	}

	/**
	 * jsonCharFilter <br/>  
	 * 过滤json敏感字符串
	 * @author haiming.huang  
	 * @param jsonStr
	 * @return
	 */
	public static String jsonCharFilter(String jsonStr) {
		if(StringUtil.isEmpty(jsonStr) || jsonStr.length() ==0 ){
			return "";
		}
		if(jsonStr.indexOf("'")>0){
			jsonStr = jsonStr.replaceAll("'", "\\\\'");
		}
		if(jsonStr.indexOf("\r")>0 || jsonStr.indexOf("\n")>0){
			jsonStr = jsonStr.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		}
		return jsonStr;
	}
	
	/**
	 * toUperFirstChar <br/>  
	 * 将首字母变为大写
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	final public static String toUperFirstChar(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * toString <br/>  
	 * @author haiming.huang  
	 * @param obj
	 * @return
	 */
	final public static String toString(Object obj) {
		if(obj==null){
			return "";
		}
		
		return obj.toString();
	}
	
	/**
	 * replace2Blank <br/>  
	 * 去除目标中的指定字符
	 * 
	 * @author haiming.huang  
	 * @param target 目标字符串
	 * @param oldChars 被替换的目标值
	 * 
	 * @return 去空格
	 */
	final public static String replace2Blank(String target,String... oldChars) {
		if(StringUtil.isNotEmpty(oldChars)){
			for(String oldChar : oldChars ) {
				target = target.replace(oldChar, "");
			}
		}
		return target.trim();
	}
	
	
	public static void main(String[] args) {
		//TODO: 测试
	}

}
