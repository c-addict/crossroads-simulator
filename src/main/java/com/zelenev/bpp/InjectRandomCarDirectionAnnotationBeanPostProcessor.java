package com.zelenev.bpp;

import com.zelenev.annotations.InjectRandomCarDirection;
import com.zelenev.model.data.states.CarDirection;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

public class InjectRandomCarDirectionAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private List<CarDirection> directions;

    @Autowired
    private Random random;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getFields();
        for (Field field : fields) {
            InjectRandomCarDirection fieldAnnotation = field.getAnnotation(InjectRandomCarDirection.class);
            if (fieldAnnotation != null) {
                int randomDirectionIndex = random.nextInt(directions.size());
                CarDirection randomDirection = directions.get(randomDirectionIndex);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomDirection);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
