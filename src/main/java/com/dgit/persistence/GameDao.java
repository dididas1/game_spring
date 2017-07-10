package com.dgit.persistence;

import java.util.List;

import com.dgit.domein.Criteria;
import com.dgit.domein.GameVo;

public interface GameDao {
	public List<GameVo> gameSelectByAll() throws Exception;
	public GameVo gameSelectByNo(int gno) throws Exception;
	public void gameInsert(GameVo vo) throws Exception; 
	public void gameUpdate(GameVo vo) throws Exception;
	public List<GameVo> gameCalenderDataSelect() throws Exception;
	public int totalGameCount() throws Exception;
	public List<GameVo> listCriteria(Criteria criteria) throws Exception;
	public void addScreenShot(String sPath) throws Exception;
	public void modiScreenShot(int gno,String sPath) throws Exception;
	
	public List<String> selectImg(int gno) throws Exception;
}
