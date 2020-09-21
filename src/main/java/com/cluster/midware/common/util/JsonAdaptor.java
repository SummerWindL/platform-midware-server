/**
 *文件名:JsonAdaptor.java
 *版权:ikinloop
 *描述:
 *修改人:rivers
 *修改时间:2017年6月8日
 *修改内容:
 *跟踪单号
 *修改单号
*/

package com.cluster.midware.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 *<一句话功能简述>
 *<功能详细描述>
 *@author rivers
 *@version 2.0
 *@see [相关类/方法]
 *@since [产品/模块版本]
 */
@Component
public class JsonAdaptor extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7827059945208682565L;

	public JsonAdaptor() {
		super();
		// 允许单引号
		this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		// 数字加双引号
		// this.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);
		// 允许不明字段
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.configure(Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
		// 空字符串转null
		this.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		// null转为""
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object obj, JsonGenerator gen, SerializerProvider provider)
					throws IOException, JsonProcessingException {
				// gen.writeString("");
				gen.writeNull();
			}
		});

	}

}
