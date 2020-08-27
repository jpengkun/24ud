package cn.huaruan.ud24.application.query;

import org.springframework.beans.BeanUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class QueryUtils {

    private QueryUtils() {
    }

    /**
     * 获取最多只有一个元素的集合中的元素。
     */
    public static <E, C extends Collection<E>> E getMaxOne(C collection) {
        if (collection == null || collection.size() < 1) {
            return null;
        } else if (collection.size() == 1) {
            return collection.iterator().next();
        } else {
            throw new RuntimeException("Elements more than one.");
        }
    }

    /**
     * 获取集合中的第一个元素。
     */
    public static <E, C extends Collection<E>> E getFirstOne(C collection) {
        if (collection == null || collection.size() < 1) {
            return null;
        } else {
            return collection.iterator().next();
        }
    }

    /**
     * 获取集合中的最后一个元素。
     */
    public static <E, C extends Collection<E>> E getLastOne(C collection) {
        if (collection == null || collection.size() < 1) {
            return null;
        } else {
            Iterator<E> iterator = collection.iterator();
            E last = null;
            while (iterator.hasNext()){
                last = iterator.next();
            }
            return last;
        }
    }

    /**
     * 复制对象属性并返回目标对象。
     */
    public static <T> T copyProperties(Object source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 复制数组对象属性并返回新的数组
     * @return
     */
    public static <C, T> List<T> copyCollection(Collection<C> source, Class<T> clazz) {
        List<T> collect = null;
        if (!source.isEmpty()){
            collect = source.stream().map(c -> {
                T temp = BeanUtils.instantiateClass(clazz);
                BeanUtils.copyProperties(c, temp);
                return temp;
            }).collect(Collectors.toList());
        }
        return collect;
    }

    /**
     * 获取最多只有一个元素的集合中的元素，复制该元素的属性并返回目标对象。
     */
    public static <E, C extends Collection<E>, T> T getMaxOneAndCopy(C source, T target) {
        E one = getMaxOne(source);
        if (one == null || target == null) {
            return target;
        }
        return copyProperties(one, target);
    }

    /**
     * 获取集合中的第一个元素，复制该元素的属性并返回目标对象。
     */
    public static <E, C extends Collection<E>, T> T getFirstOneAndCopy(C source, T target) {
        E one = getFirstOne(source);
        if (one == null || target == null) {
            return target;
        }
        return copyProperties(one, target);
    }

    /**
     * 模糊查询包含转义后的输入字符串。
     */
    public static String likeContains(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        } else {
            return "%" + input.replace("%", "\\%")
                    .replace("_", "\\_") + "%";
        }
    }

    /**
     * 模糊查询以转义后的输入字符串开始。
     */
    public static String likeStartWith(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        } else {
            return input.replace("%", "\\%")
                    .replace("_", "\\_") + "%";
        }
    }

    /**
     * 模糊查询以转义后的输入字符串结束。
     */
    public static String likeEndWith(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        } else {
            return "%" + input.replace("%", "\\%")
                    .replace("_", "\\_");
        }
    }

}
