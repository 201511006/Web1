package com.kjw.controller2;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.kjw.domain2.BoardVO;
import com.kjw.domain2.Criteria;
import com.kjw.persistence2.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	
	/*@Test
	public void testCreate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setTitle("안녕~!");
		board.setContent("new content~!");
		board.setWriter("userhello");
		dao.create(board);
	}*/


	@Test
	public void testRead() throws Exception{
		
		logger.info(dao.read(3).toString());
	}

	@Test
	public void testUpdate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setBno(9);
		board.setTitle("수정된 글이다~");
		board.setWriter("hello");
		board.setContent("수정 테스트~");
		dao.update(board);
	}

/*	@Test
	public void testDelete() throws Exception{
		
		dao.delete(5);
	}*/
	
	/*@Test
	public void testListPage() throws Exception{
		
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list){
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
	}*/
	
	@Test
	public void testListCriteria()throws Exception{
		
		
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO : list){
			logger.info(boardVO.getBno() + "-" + boardVO.getTitle());
		}
	}
	
	@Test
	public void testURI()throws Exception{
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.path("/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info("/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}


}





