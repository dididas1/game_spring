package com.dgit.persistence;

import java.util.List;

import com.dgit.domein.LibraryVo;

public interface LibraryDao {
	
	public List<LibraryVo> librarySelectByUserNo(String id);
	
	public void libraryInsert(LibraryVo vo);
	
	public void libraryUpdateIsbuy(LibraryVo vo);

}
