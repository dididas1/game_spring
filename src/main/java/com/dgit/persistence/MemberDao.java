package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.dgit.domein.MemberVo;

public interface MemberDao {
	
	
	public List<MemberVo> MemberSelectByAll(); 
	
	public MemberVo MemberSelectById(String id);
	
	public MemberVo login(MemberVo vo);
	
	public void MemberJoin(MemberVo vo);
	
	public void MemberInfoModify(MemberVo vo);
	
	public void MemberDelete(String id);

}
