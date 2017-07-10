package com.dgit.service;

import java.util.List;

import com.dgit.domein.Criteria;
import com.dgit.domein.GameVo;

public interface GameService {
	
	public List<GameVo> saleListPage() throws Exception;
	
	public int totalGameCount() throws Exception;
	
	public List<GameVo> listCriteria(Criteria criteria) throws Exception;
	
	public GameVo gameReadSelectByNo(int gno) throws Exception;
	
	public void gameCreate(GameVo vo) throws Exception;
	
	public void gameModify(GameVo vo) throws Exception;
}
