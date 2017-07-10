package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domein.GameVo;

@Repository
public class GameReadDaoImpl implements GameReadDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace="com.dgit.persistence.GameReadDao";
	
	@Override
	public List<GameVo> gameReadSelectByAll() {
		return sqlSession.selectList(namespace+".gameReadSelectByAll");
	}

	@Override
	public GameVo gameReadSelectByNo(int gNo) {
		return sqlSession.selectOne(namespace+".gameReadSelectByNo",gNo);
	}

	@Override
	public void gameReadInsert(GameVo vo) {
		sqlSession.insert(namespace+".gameReadInsert",vo);

	}

	@Override
	public void gameReadUpdate(GameVo vo) {
		sqlSession.update(namespace+".gameReadUpdate",vo);
	}

}
