package com.example.meltingpop.service;

import com.example.meltingpop.dto.BoardDto;
import com.example.meltingpop.entity.Board;
import com.example.meltingpop.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public void savePost(BoardDto boardDto){
        boardRepository.save(boardDto.toEntity());
    }

    @Transactional
    public void editPost(BoardDto boardDto){

    }

}
