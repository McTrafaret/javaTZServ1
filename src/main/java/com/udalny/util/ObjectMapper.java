package com.udalny.util;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ObjectMapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    static Logger logger = Logger.getLogger(ObjectMapper.class);

    private ObjectMapper() {
    }

    public static void mapStringValueToField(Object obj, String fieldName, String fieldValue)
            throws NoSuchFieldException {

        Class<? extends Object> cl = obj.getClass();
        Field f;

        try {
            f = cl.getDeclaredField(fieldName);
        } catch (NoSuchFieldException ex) {
            logger.error(ex);
            throw ex;
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
        f.setAccessible(true);

        if (f.getType() == String.class) {

            try {
                f.set(obj, fieldValue);
            } catch (IllegalAccessException ex) {
            }

        } else if (f.getType() == Date.class) {

            try {
                f.set(obj, dateFormatter.parse(fieldValue));
            } catch (ParseException ex) {
            } catch (IllegalAccessException ex) {
            }

        } else if (f.getType() == int.class) {

            try {
                f.setInt(obj, Integer.parseInt(fieldValue));
            } catch (IllegalAccessException ex) {
            }

        } else if (f.getType() == BigDecimal.class) {

            try {
                f.set(obj, new BigDecimal(fieldValue));
            } catch (IllegalAccessException ex) {
            }

        } else if (f.getType() == BigInteger.class) {

            try {
                f.set(obj, new BigInteger(fieldValue));
            } catch (IllegalAccessException ex) {
            }
        }
    }

    public static void map(Object obj, Map<String, Object> map) {

        Class<? extends Object> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);

        for (Field f : fields) {

            f.setAccessible(true);

            if (map.containsKey(f.getName())) {

                if (map.get(f.getName()) instanceof String) {
                    String val = (String) map.get(f.getName());
                    try {
                        mapStringValueToField(obj, f.getName(), val);
                    } catch (Exception ex) {
                        /* this can't happen */
                    }
                }
            }

        }
    }
}
