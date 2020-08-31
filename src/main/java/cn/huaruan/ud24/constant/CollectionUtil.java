package cn.huaruan.ud24.constant;

import java.util.*;

/**
 * 
 * ClassName: CollectionUtil <br/>  
 * Description: 集合工具类 <br/>  
 * date: 2020年3月4日 下午12:23:47 <br/>  
 *  
 * @author haiming.huang  
 *
 */
public class CollectionUtil {

	/**
	 * isEmpty <br/>  
	 * 是否为空
	 * @author haiming.huang  
	 * @param collection
	 * @return
	 */
	final static public boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * isNotEmpty <br/>  
	 * 是否不为空
	 * @author haiming.huang  
	 * @param collection
	 * @return
	 */
	final static public boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}

	/**
	 * isEmpty <br/>  
	 * map是否为空
	 * @author haiming.huang  
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	final static public boolean isEmpty(Map map) {
		return map == null || map.isEmpty();
	}

	/**
	 * isNotEmpty <br/>  
	 *  map是否不为空
	 * @author haiming.huang  
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	final static public boolean isNotEmpty(Map map) {
		return !isEmpty(map);
	}

	/**
	 * string2List <br/>  
	 * 将str转换为list, str中的元素以逗号分隔
	 * @author haiming.huang  
	 * @param str
	 * @return
	 */
	final static public List<String> string2List(String str) {
		return StringUtil.isEmpty(str) ? null : Arrays.asList(str.split(","));
	}

	/**
	 * convert2String <br/>  
	 * 集合转字符串，以symbol分隔
	 * @author haiming.huang  
	 * @param collection
	 * @param symbol
	 * @return
	 */
	final static public String convert2String(Collection<String> collection,
			String symbol) {
		if (isEmpty(collection))
			return "";
		StringBuilder result = new StringBuilder();
		for (String string : collection) {
			result.append(string).append(symbol);
		}
		return StringUtil.removeLast(result.toString());
	}

	/**
	 * convertToString <br/>  
	 * 将集合转成字符串，以，分割
	 * @author haiming.huang  
	 * @param list
	 * @return
	 */
	public static String convertToString(List<String> list) {
		if (CollectionUtil.isEmpty(list))
			return "";
		StringBuilder result = new StringBuilder();
		for (String item : list) {
			result.append("'").append(item).append("',");
		}
		return StringUtil.removeLast(result.toString());
	}

	/**
	 * convert2List <br/>  
	 * 转换成-LinkedList
	 * @author haiming.huang  
	 * @param collection
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	final static public List convert2List(Collection collection) {
		List result = new LinkedList();
		if (isEmpty(collection))
			return result;

		Iterator itr = collection.iterator();
		while (itr.hasNext()) {
			result.add(itr.next());
		}
		return result;
	}

	/**
	 * removeEmpty <br/>  
	 * 去集合中的null数据
	 * @author haiming.huang  
	 * @param collection
	 */
	final static public void removeEmpty(Collection<Object> collection) {
		Collection<Object> col = new LinkedList<Object>();
		if (isNotEmpty(collection)) {
			for (Object str : collection) {
				if (str == null)
					col.add(str);
			}
		}
		collection.removeAll(col);
	}

	public static void main(String[] args) {
		//TODO: 测试
	}
}
