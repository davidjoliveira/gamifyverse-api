package com.gamifyverse.gamifyapi.attributes.model;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum AttributeTypeEnum {
	INT(1, "int"), STR(2, "str"), FLOAT(3, "float"),;

	private Integer code;
	private String name;

	private AttributeTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static AttributeTypeEnum fromCode(Integer code) {
		return Arrays.asList(values()).stream().filter(a -> a.getCode() == code).findFirst()
				.orElseThrow(() -> new RuntimeException("Atributo não encontrado para o código"));
	}

}
