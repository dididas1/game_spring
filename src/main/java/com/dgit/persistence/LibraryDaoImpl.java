package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domein.LibraryVo;

@Repository
public class LibraryDaoImpl implements LibraryDao {
	
	@Autowired
	private SqlSession sqlSesstion;
	
	private static final String namespace="com.dgit.persistence.LibraryDao";

	@Override
	public List<LibraryVo> librarySelectByUserNo(String id) {
		return sqlSesstion.selectList(namespace+".librarySelectByUserNo",id);
	}

	@Override
	public void libraryInsert(LibraryVo vo) {
		sqlSesstion.insert(namespace+".libraryInsert",vo);
	}

	@Override
	public void libraryUpdateIsbuy(LibraryVo vo) {
		sqlSesstion.update(namespace+".libraryUpdateIsbuy",vo);
	}
}
