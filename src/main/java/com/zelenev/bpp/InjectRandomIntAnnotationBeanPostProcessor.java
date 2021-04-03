package com.zelenev.bpp;

import com.zelenev.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private Random random;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt injectRandomIntAnnotation = field.getAnnotation(InjectRandomInt.class);
            if (injectRandomIntAnnotation != null) {
                int min = injectRandomIntAnnotation.minValue();
                int max = injectRandomIntAnnotation.maxValue();
                int randomValue = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomValue);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
