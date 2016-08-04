/**
 * @author: chenlwh
 * @date: Jul 28, 2016 4:55:01 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 
 */
public class PartyDaoImpl extends SqlMapClientDaoSupport implements PartyDao{

	@SuppressWarnings("unchecked")
	public List<Object> getPartyUser(){
		return 	getSqlMapClientTemplate().queryForList("mainTableService.getTableCodeList");
	}
}
