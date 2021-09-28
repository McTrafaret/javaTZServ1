package com.udalny.documents;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ObjectMapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private ObjectMapper() {
    }

    public static void map(Object obj, Map<String, Object> map) {

        Class<? extends Object> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);

        for (Field f : fields) {

            f.setAccessible(true);

            if (map.containsKey(f.getName())) {

                if (f.getType() == String.class) {

                    String val = (String) map.get(f.getName());
                    try {
                        f.set(obj, val);
                    } catch (IllegalAccessException ex) {
                    }

                } else if (f.getType() == Date.class) {

                    String val = (String) map.get(f.getName());

                    try {
                        f.set(obj, dateFormatter.parse(val));
                    } catch (ParseException ex) {
                    } catch (IllegalAccessException ex) {
                    }

                } else if (f.getType() == int.class) {

                    String val = (String) map.get(f.getName());

                    try {
                        f.setInt(obj, Integer.parseInt(val));
                    } catch (IllegalAccessException ex) {
                    }

                } else if (f.getType() == BigDecimal.class) {

                    String val = (String) map.get(f.getName());

                    try {
                        f.set(obj, new BigDecimal(val));
                    } catch (IllegalAccessException ex) {
                    }

                } else if (f.getType() == BigInteger.class) {
                    String val = (String) map.get(f.getName());

                    try {
                        f.set(obj, new BigInteger(val));
                    } catch (IllegalAccessException ex) {
                    }
                }
            }

            f.setAccessible(false);
        }
    }
}
