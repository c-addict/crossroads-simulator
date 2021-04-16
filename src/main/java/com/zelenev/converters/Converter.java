package com.zelenev.converters;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {

    private final Map<MappingKey, ObjectMapper<?, ?>> mapperMap;

    public Mapper(List<ObjectMapper<?,?>> mappers) {
        var tmpMappers = new HashMap<MappingKey, ObjectMapper<?,?>>();
        for (var mapper : mappers) {
            tmpMappers.put(new MappingKey(mapper.getInClass(), mapper.getOutClass()), mapper);
        }
        this.mapperMap = Collections.unmodifiableMap(tmpMappers);
    }

    @SuppressWarnings("unchecked")
    public <IN, OUT> OUT convert(IN obj, Class<OUT> destClass) {
        if (obj == null) {
            return null;
        }
        var mapper = (ObjectMapper<IN, OUT>)mapperMap.get(new MappingKey(obj.getClass(), destClass));
        if (mapper == null) {
            throw new RuntimeException("Unsupported mapper. " + obj.getClass() + " -> " + destClass);
        }
        return mapper.convert(obj);
    }

    @SuppressWarnings("unchecked")
    public <IN, OUT> List<OUT> convertList(List<IN> objList, Class<OUT> destClass) {
        if (objList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        var mapper = (ObjectMapper<IN, OUT>)mapperMap.get(new MappingKey(objList.get(0).getClass(), destClass));
        if (mapper == null) {
            throw new RuntimeException("Unsupported mapper. " + objList.getClass() + " -> " + destClass);
        }
        return mapper.convertList(objList);
    }
}
