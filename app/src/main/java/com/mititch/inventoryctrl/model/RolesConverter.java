package com.mititch.inventoryctrl.model;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RolesConverter implements AttributeConverter<Roles, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Roles roles) {
        return roles.getCode();
    }

    @Override
    public Roles convertToEntityAttribute(Integer integer) {
        return Roles.findByCode(integer);
    }
}
