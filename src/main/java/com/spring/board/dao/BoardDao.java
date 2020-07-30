package com.spring.board.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.board.vo.BoardVo;


public interface BoardDao {

	List<BoardVo> getList();

}
