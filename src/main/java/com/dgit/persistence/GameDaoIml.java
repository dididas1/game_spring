package com.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domein.Criteria;
import com.dgit.domein.GameVo;

@Repository
public class GameDaoIml implements GameDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace="com.dgit.persistence.GameDao";

	
	@Override
	public List<GameVo> gameSelectByAll() throws Exception {
		return sqlSession.selectList(namespace+".gameSelectByAll");
	}

	@Override
	public GameVo gameSelectByNo(int gno) throws Exception {
		return sqlSession.selectOne(namespace+".gameSelectByNo",gno);
	}

	@Override
	public void gameInsert(GameVo vo) throws Exception {
		sqlSession.insert(namespace+".gameInsert", vo);
	}

	@Override
	public void gameUpdate(GameVo vo) throws Exception {
		sqlSession.update(namespace+".gameUpdate", vo);
	}

	@Override
	public List<GameVo> gameCalenderDataSelect() throws Exception {
		return sqlSession.selectList(namespace+".gameCalenderDataSelect");
	}

	@Override
	public int totalGameCount() throws Exception {
		return sqlSession.selectOne(namespace+".totalGameCount");
	}

	@Override
	public List<GameVo> listCriteria(Criteria criteria) throws Exception {
		return sqlSession.selectList(namespace+".listCriteria",criteria);
	}

	@Override
	public void addScreenShot(String sPath) throws Exception {
		sqlSession.insert(namespace+".upLoadScreenShot",sPath);
	}

	@Override
	public List<String> selectImg(int gno) throws Exception {
		return sqlSession.selectList(namespace+".selectImg");
	}

	@Override
	public void modiScreenShot(int gno, String sPath) throws Exception {
		Map<String, Object> map= new HashMap<>();
		map.put("gno", gno);
		map.put("sPath", sPath);
		sqlSession.insert(namespace+".modiScreenShot",map);
	}
}