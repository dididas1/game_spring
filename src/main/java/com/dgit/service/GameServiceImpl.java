package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dgit.domein.Criteria;
import com.dgit.domein.GameVo;
import com.dgit.persistence.GameDao;
import com.dgit.persistence.GameReadDao;

@Service
public class GameServiceImpl implements GameService {
	

	@Autowired
	private GameDao dao;
	
	@Autowired
	private GameReadDao rDao;

	@Transactional

	@Override
	public List<GameVo> saleListPage() throws Exception {
		return dao.gameSelectByAll();
	}
	


	@Override
	public int totalGameCount() throws Exception {
		return dao.totalGameCount();
	}

	@Override
	public List<GameVo> listCriteria(Criteria criteria) throws Exception {
		return dao.listCriteria(criteria);
	}

	@Transactional
	@Override
	public GameVo gameReadSelectByNo(int gno) throws Exception {
		GameVo vo= dao.gameSelectByNo(gno);
		GameVo rVo=rDao.gameReadSelectByNo(gno);
		rVo.setTitle(vo.getTitle());
		rVo.setSalePrice(vo.getSalePrice());
		rVo.setDiscount(vo.getDiscount());
		rVo.setPlatform(vo.getPlatform());
		rVo.setStart(vo.getStart());
		rVo.setTitleImg(vo.getTitleImg());
		return rVo;
	}

	@Transactional
	@Override
	public void gameCreate(GameVo vo) throws Exception{
		dao.gameInsert(vo);
		rDao.gameReadInsert(vo);
		
		 if(vo.getsPath() == null){//보호처리
	         return;
	      }
	      
	      for(String sPath : vo.getsPath()){
	         dao.addScreenShot(sPath);
	      }
		
	}


	@Transactional
	@Override
	public void gameModify(GameVo vo) throws Exception {
		dao.gameUpdate(vo);

		if (vo.getsPath() == null) {// 보호처리
			return;
		}

		for (String sPath : vo.getsPath()) {
			dao.modiScreenShot(vo.getgNo(),sPath);
		}
	}
}
