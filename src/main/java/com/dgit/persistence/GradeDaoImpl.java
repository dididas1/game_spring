package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domein.GradeVo;

@Repository
public class GradeDaoImpl implements GradeDao {
	
	@Autowired
	private SqlSession sqlssion;
	
	private static final String namespace="com.dgit.persistence.GradeDao";

	@Override
	public List<GradeVo> gradeSelectByALl() {
		return sqlssion.selectList(namespace+".gradeSelectByALl");
	}

	@Override
	public List<GradeVo> gradeSelectByNo(int gNo) {
		return sqlssion.selectList(namespace+".gradeSelectByNo",gNo);
	}

	@Override
	public List<GradeVo> gradeSelectByRate() {
		return sqlssion.selectList(namespace+".gradeSelectByRate");
	}

	@Override
	public void gradeInsertByGood(GradeVo vo) {
		sqlssion.insert(namespace+".gradeInsertByGood",vo);
	}

	@Override
	public void gradeInsertByBad(GradeVo vo) {
		sqlssion.update(namespace+".gradeInsertByBad",vo);
	}

}
