package com.dgit.persistence;

import java.util.List;

import com.dgit.domein.GradeVo;

public interface GradeDao {
	
	public List<GradeVo> gradeSelectByALl();
	
	public List<GradeVo> gradeSelectByNo(int gNo);
	
	public List<GradeVo> gradeSelectByRate();
	
	public void gradeInsertByGood(GradeVo vo);
	
	public void gradeInsertByBad(GradeVo vo);

}
