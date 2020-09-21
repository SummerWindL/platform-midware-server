package com.platform.repo.pg.model.base;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.util.Date;


@ToString
@Setter
@Getter
@MappedSuperclass
public abstract class CommonDateModel extends CommonModel {

    private Date modifiedtime = new Date();

}
