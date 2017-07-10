package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domein.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSesstion;
	
	private static final String namespace="com.dgit.persistence.LibraryDao";

	@Override
	public List<MemberVo> MemberSelectByAll() {
		return sqlSesstion.selectList(namespace+".MemberSelectByAll");
	}

	@Override
	public MemberVo MemberSelectById(String id) {
		return sqlSesstion.selectOne(namespace+".MemberSelectById",id);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return sqlSesstion.selectOne(namespace+".login",vo);
	}

	@Override
	public void MemberJoin(MemberVo vo) {
		sqlSesstion.insert(namespace+".JoinMember",vo);

	}

	@Override
	public void MemberInfoModify(MemberVo vo) {
		sqlSesstion.update(namespace+".MemberInfoModify",vo);
	}

	@Override
	public void MemberDelete(String id) {
		sqlSesstion.delete(namespace+".MemberDelete",id);
	}

}
