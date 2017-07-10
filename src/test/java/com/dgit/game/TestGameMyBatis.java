package com.dgit.game;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domein.GameVo;
import com.dgit.persistence.GameDao;
import com.dgit.persistence.GameReadDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestGameMyBatis {
	
	@Autowired
	GameDao dao;
	
	@Autowired
	GameReadDao readDao;
	
	@Test
	public void gameSelectAllTest() throws Exception{
		dao.gameSelectByAll();
	}
	
	@Test
	public void gameSelectByNoTest() throws Exception{
		dao.gameSelectByNo(2);
	}
	
	@Test
	public void gameInsertTest() throws Exception{
		GameVo vo= new GameVo();
		vo.setTitle("글라디우스");
		vo.setSalePrice(15000);
		vo.setDiscount(0);
		vo.setSale(true);
		vo.setPlatform("패미콤");
		vo.setStart("2017-07-25");
		dao.gameInsert(vo);
	}
	
	/*@Test*/
	public void gameUpdateTest() throws Exception{
		GameVo vo= new GameVo();
		vo.setgNo(8);
		vo.setTitle("글라디우스2");
		vo.setSalePrice(13000);
		vo.setDiscount(10);
		vo.setSale(true);
		vo.setPlatform("슈퍼 패미콤");
		vo.setStart("2017-07-27");
		dao.gameUpdate(vo);
	}
	
	/*@Test*/
	public void gameCalenderDataSelectTest() throws Exception{
		dao.gameCalenderDataSelect();
	}
	
	@Test
	public void gameReadSelectAllTest() throws Exception{
		readDao.gameReadSelectByAll();
	}
	
	@Test
	public void gameReadSelectByNoTest() throws Exception{
		readDao.gameReadSelectByNo(1);
	}
	
	/*@Test*/
	public void gameReadInsertText() throws Exception{
		GameVo vo= new GameVo();
		vo.setgNo(8);
		vo.setCategory("슈팅");
		vo.setgContent("전나어려운슈팅임");
		vo.setgComp("타이토");
		vo.setSaleYear(0);
		readDao.gameReadInsert(vo);
	}
	
/*	@Test*/
	public void gameReadUpdate() throws Exception{
		GameVo vo= new GameVo();
		vo.setgNo(8);
		vo.setCategory("슈팅");
		vo.setgContent("전나어려운슈팅임 지옥임");
		vo.setgComp("타이토 망했음");
		vo.setSaleYear(18);
		readDao.gameReadUpdate(vo);
	}

}
