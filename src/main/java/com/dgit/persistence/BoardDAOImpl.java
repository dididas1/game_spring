package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domein.BoardVO;
import com.dgit.domein.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace="com.dgit.persistence.BoardDao";

	@Override
	public void boardCreate(BoardVO vo) throws Exception {
		sqlSession.insert(namespace+".boardCreate",vo);
		
	}

	@Override
	public BoardVO boardRead(int bno) throws Exception {
		return sqlSession.selectOne(namespace+".boardRead",bno);
		
	}

	@Override
	public void boardUpdate(BoardVO vo) throws Exception {
		sqlSession.update(namespace+".boardUpdate",vo);
		
	}

	@Override
	public void boardDelete(int bno) throws Exception {
		sqlSession.delete(namespace+".boardDelete",bno);
	}

	@Override
	public List<BoardVO> boardListAll() throws Exception {
		return sqlSession.selectList(namespace+".boardListAll");
	}

	@Override
	public List<BoardVO> baordListPage(int page) throws Exception {
		return sqlSession.selectList(namespace+".baordListPage",page);
	}

	@Override
	public List<BoardVO> boardListCriteria(Criteria criteria) throws Exception {
		return sqlSession.selectList(namespace+".boardListCriteria",criteria);
	}

	@Override
	public int totalCount() throws Exception {
		return sqlSession.selectOne(namespace+".totalCount");
	}
	
}
