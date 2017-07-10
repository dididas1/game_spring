package com.dgit.persistence;

import java.util.List;

import com.dgit.domein.BoardVO;
import com.dgit.domein.Criteria;
import com.dgit.domein.SearchCriteria;

public interface BoardDAO {
	public void boardCreate(BoardVO vo) throws Exception;
	
	public BoardVO boardRead(int bno) throws Exception;
	
	public void boardUpdate(BoardVO vo) throws Exception;
	
	public void boardDelete(int bno) throws Exception;
	
	public List<BoardVO> boardListAll() throws Exception;
	
	
	public List<BoardVO> baordListPage(int page) throws Exception;
	public List<BoardVO> boardListCriteria(Criteria criteria) throws Exception;
	public int totalCount() throws Exception;
	
	/*public List<BoardVO> listSearch(SearchCriteria cri) throws Exception; 
	
	public int searchTotalCount(SearchCriteria cri) throws Exception;
	
	public void updateReplyCnt(int bno,int amount) throws Exception;
	
	public void addAttach(String fullname) throws Exception;
	
	public void ModiAttach	(String fullname,int bno) throws Exception;
	
	public List<String> selectImg(int bno) throws Exception;
	
	public void deleteImg(String filename) throws Exception;
	
	 public void deleteImgByNo(Integer bno) throws Exception;*/
}
