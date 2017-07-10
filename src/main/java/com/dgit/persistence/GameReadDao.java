package com.dgit.persistence;

import java.util.List;

import com.dgit.domein.GameVo;

public interface GameReadDao {
	public List<GameVo> gameReadSelectByAll();
	
	public GameVo gameReadSelectByNo(int gNo);
	
	public void gameReadInsert(GameVo vo);
	
	public void gameReadUpdate(GameVo vo);

}
