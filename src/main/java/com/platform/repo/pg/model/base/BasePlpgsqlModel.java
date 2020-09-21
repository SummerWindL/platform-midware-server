package com.platform.repo.pg.model.base;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.platform.common.util.JsonAdaptor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 所有PostgreSQL存储过程的返回结果模型
 */
@Data
@Entity
@IdClass(BasePlpgsqlModelPK.class)
public class BasePlpgsqlModel {

	/**
	 * 存储过程调用的返回值（retcode=0表示调用成功，负数表示调用失败）
	 */
	@Id
	private int retcode;
	
	/**
	 * 存储过程调用的返回结果（以JSON字符串形式表达）
	 */
	@Id
	private String retvalue;
	
	public <T> T getModel(Class<T> clz) throws JsonParseException, JsonMappingException, IOException {
		
		if (0 <= this.getRetcode()) {
			String jsonstr = this.getRetvalue();
			if (null != jsonstr) {
				JsonAdaptor jsonAdaptor = new JsonAdaptor();
				jsonAdaptor.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
				T t = jsonAdaptor.readValue(jsonstr, clz);
				return t;
			}
		}
		
		return null;
	}
}
