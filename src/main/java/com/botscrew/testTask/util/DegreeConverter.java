package com.botscrew.testTask.util;


import com.botscrew.testTask.entities.Degree;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import javax.management.relation.Role;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DegreeConverter implements AttributeConverter<Degree, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Degree degree) {
        if (degree == null) {
            return null;
        }
        return degree.getCode();
    }

    @Override
    public Degree convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Degree.values())
                .filter(c -> code.equals(c.getCode()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}