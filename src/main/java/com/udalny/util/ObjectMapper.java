package com.udalny.util;

import com.udalny.documents.exceptions.FieldMapException;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ObjectMapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    static Logger logger = Logger.getLogger(ObjectMapper.class);

    private ObjectMapper() {
    }

    public static void mapStringValueToField(Object obj, String fieldName, String fieldValue)
            throws FieldMapException {

        Class<? extends Object> cl = obj.getClass();
        Field f;

        try {
            f = cl.getDeclaredField(fieldName);
        } catch (NoSuchFieldException ex) {
            throw new FieldMapException("No such field " + fieldName);
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
        f.setAccessible(true);

        try {
            if (f.getType() == String.class) {

                f.set(obj, fieldValue);

            } else if (f.getType() == Date.class) {

                f.set(obj, dateFormatter.parse(fieldValue));

            } else if (f.getType() == int.class) {

                f.setInt(obj, Integer.parseInt(fieldValue));

            } else if (f.getType() == BigDecimal.class) {

                f.set(obj, new BigDecimal(fieldValue));

            } else if (f.getType() == BigInteger.class) {

                f.set(obj, new BigInteger(fieldValue));
            }
        } catch (Exception ex) {
            throw new FieldMapException(f, fieldValue, ex);
        }

    }

    public static void map(Object obj, Map<String, Object> map) {

        Class<? extends Object> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {

            f.setAccessible(true);
            String fieldName = f.getName();

            if (map.containsKey(fieldName) && map.get(fieldName) instanceof String) {

                String val = (String) map.get(fieldName);

                try {
                    mapStringValueToField(obj, fieldName, val);
                } catch (FieldMapException ex) {
                    logger.error(ex);
                }
            }
        }

    }
}
