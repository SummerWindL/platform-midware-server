package com.platform.repo.pg.model.base;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BasePlpgsqlModelPK implements Serializable{

	private static final long serialVersionUID = 1227225159376390524L;

	private int retcode;

    private String retvalue;

}