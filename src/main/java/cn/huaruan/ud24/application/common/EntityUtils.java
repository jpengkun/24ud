package cn.huaruan.ud24.application.common;

import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.vo.UserWithRole;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 实体类工具
 * @author outas
 */
public class EntityUtils {

    private static String id = "Id";

    /**
     * 判断对象是否需要进行更新操作，并过滤空字符串
     *
     * @param t     需要判断的对象
     * @param clazz 需要判断的对象的类型
     * @param <T>
     * @return
     */
    public static <T> boolean needToUpdate(T t, Class clazz) {
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        AtomicBoolean flag = new AtomicBoolean(false);
        String className = clazz.getSimpleName();
        Class superclass = clazz.getSuperclass();
        // 如果该类不是基类
        if (superclass != Object.class) {
            className = superclass.getSimpleName();
            List<Field> superclassFields = new ArrayList<>(Arrays.asList(superclass.getDeclaredFields()));
            // 将其父类的字段拼接
            fields.addAll(superclassFields);
        }
        // 得到该对象获取主键的方法
        String pkId = className + id;
        fields.forEach(field -> {
            try {
                field.setAccessible(true);
                // 得到该字段的值
                Object value = field.get(t);
                // 将空字符串置空
                if ("".equals(value) &&
                        !(field.getName()).toLowerCase().contains("img") &&
                        !(field.getName()).toLowerCase().contains("image")) {
                    field.set(t, null);
                }

                if (!flag.get() &&
                        isBaseDataType(field.getType()) &&
                        !field.getName().equals(pkId) &&
                        value != null) {
                    //如果有一个字段不为id，且其值不为空时，则此对象需要更新
                    flag.set(true);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return flag.get();
    }

    /**
     * 将传入的参数升级为模糊查询参数
     *
     * @param t     需要升级的对象
     * @param clazz 需要升级的对象的类型
     * @param <T>
     * @return
     */
    public static <T> T upToContainsParam(T t, Class clazz) {
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        fields.forEach(field -> {
            try {
                field.setAccessible(true);
                Object value = field.get(t);
                if (value != null && field.getType() == String.class) {
                    if ("".equals(value)) {
                        field.set(t, null);
                    } else {
                        field.set(t, QueryUtils.likeContains(String.valueOf(value)));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return t;
    }

    private static boolean isBaseDataType(Class clazz) {
        return clazz.equals(String.class) ||
                clazz.equals(Integer.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(BigDecimal.class) ||
                clazz.equals(BigInteger.class) ||
                clazz.equals(Boolean.class) ||
                clazz.equals(Date.class) ||
                clazz.equals(DateTimeLiteralExpression.DateTime.class) ||
                clazz.isPrimitive();
    }

    public static void main(String[] args) {
    }
}
