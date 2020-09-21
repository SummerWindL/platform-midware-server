package com.platform.repo.pg.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @Description	: request 层公共 基类，包含公共属性，createTime（对应mongo字段cts）
 * @ClassName		: CommonModel
 * @date 			: 2017年4月24日 下午4:08:33
 *
 */
@ToString
@Setter
@Getter
@MappedSuperclass
public abstract class CommonModel {

    /**
     * 创建时间
     */
    private Date createdtime = new Date();;

}
