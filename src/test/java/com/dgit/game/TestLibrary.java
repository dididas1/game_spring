package com.dgit.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domein.LibraryVo;
import com.dgit.persistence.LibraryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestLibrary {
	
	@Autowired
	LibraryDao dao;
	
	@Test
	public void TestLibrarySelectByNo(){
		dao.librarySelectByUserNo("didids");
	}
	
	/*@Test*/
	public void TestLibraryInsert(){
		LibraryVo vo = new LibraryVo();
		vo.setBuy(true);
		vo.setgNo(2);
		vo.setId("dididas2");
		dao.libraryInsert(vo);
	}
	
	@Test
	public void TestLibraryUpdate(){
		LibraryVo vo = new LibraryVo();
		vo.setLibNo(1);
		vo.setBuy(true);
		dao.libraryUpdateIsbuy(vo);
	}

}
