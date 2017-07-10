package com.dgit.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domein.GradeVo;
import com.dgit.persistence.GradeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestGrade {
	
	@Autowired
	GradeDao dao;
	
	@Test
	public void TestSelectAllGrade(){
		dao.gradeSelectByALl();
	}
	
	@Test
	public void TestSelectByNoGrade(){
		dao.gradeSelectByNo(1);
	}
	
	@Test
	public void TestRate(){
		dao.gradeSelectByRate();
	}
	
	@Test
	public void TestInsertGood(){
		GradeVo vo= new GradeVo();
		vo.setgNo(1);
		vo.setId("dididas");
		dao.gradeInsertByGood(vo);
	}
	
	@Test
	public void TestInsertBad(){
		GradeVo vo= new GradeVo();
		vo.setgNo(1);
		vo.setId("dididas");
		dao.gradeInsertByBad(vo);
	}
	
	

}
