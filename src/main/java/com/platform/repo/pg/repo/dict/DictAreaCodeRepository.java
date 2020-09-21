package com.platform.repo.pg.repo.dict;

import com.platform.repo.pg.model.base.BasePlpgsqlModel;
import com.platform.repo.pg.repo.base.CommonCustomRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @description:
 */
public interface DictAreaCodeRepository extends CommonCustomRepository<BasePlpgsqlModel, Integer> {
	
    /**
     * 查询指定区域编码的省份及其下级市区县，树状菜单列表
     * @param areacode
     * @return
     */
    @Query(value= "select * from f_dict_area_code_query (?1)", nativeQuery = true)
    BasePlpgsqlModel queryDictAreacode(String areacode);

    
    /**
     * 查询指定区域编码的省份及其下级市区县，含所辖医疗机构的树状菜单列表( 已经接入平台并开通的)
     * @param areacode
     * @return
     */
    @Query(value= "select * from f_tree_areacode_hosp_ha_query (?1)", nativeQuery = true)
    BasePlpgsqlModel queryAreacodeHosp(String areacode);

    /**
     * 查询指定区域编码的省份及其下级市区县，含所辖院科的树状菜单列表
     * @param areacode
     * @return
     */
    @Query(value= "select * from f_tree_areacode_hosp_dept_query (?1)", nativeQuery = true)
    BasePlpgsqlModel queryAreacodeHospDept(String areacode);

    /**
     * 查询指定区域编码的省份及其下级市区县，含所辖医疗机构字典的树状菜单列表(平台上配置的医疗机构字典表，未开通的医疗机构服务的)
     * @param areacode
     * @return
     */
    @Query(value= "select * from f_dict_areacode_hosp_tree_query (?1)", nativeQuery = true)
    BasePlpgsqlModel queryAreacodeHospTree(String areacode);
    
}
