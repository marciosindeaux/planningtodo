package br.sindeaux.planningtod.planningtodo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ConverterUtils {

    private static final Logger logger = LoggerFactory.getLogger(ConverterUtils.class);

    public static <T> T convertTo(Object source, Class<T> target, String ... ignoreProperties) {
        if (source == null)
            return null;

        try {
            T result = target.getConstructor().newInstance();
            BeanUtils.copyProperties(source, result, ignoreProperties);
            return result;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("Não foi possivel realizar conversão de objeto");
        }
    }

    public static <T> T convertTo(Object source, Class<T> target) {
        return convertTo(source, target, "");
    }

}
