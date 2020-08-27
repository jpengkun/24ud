package cn.huaruan.ud24.application.common;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class QuoteCalculateUtil<T> {

    /**
     * 使用java反射计算订单的分成信息
     *
     * @param amount
     * @return
     */
    public static <T> T calculate(T t, double amount) {
        Class clazz = t.getClass();
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        fields.forEach(field -> {
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Method setMethod = pd.getWriteMethod();
                double v = new BigDecimal(getMethod.invoke(t).toString()).multiply(new BigDecimal(amount)).setScale(2).doubleValue();
                setMethod.invoke(t, v);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return t;
    }
}
