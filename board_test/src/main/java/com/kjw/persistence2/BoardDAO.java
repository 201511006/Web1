package com.kjw.persistence2;

import java.util.List;

import com.kjw.domain2.BoardVO;
import com.kjw.domain2.Criteria;
import com.kjw.domain2.SearchCriteria;

public interface BoardDAO {

	public void create(BoardVO vo)throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listPage(int page)throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;
}
