package com.example.meltingpop.service;

import com.example.meltingpop.dto.BoardDto;
import com.example.meltingpop.entity.Board;
import com.example.meltingpop.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    // Board 데이터에 있는 걸 찾아서 BoardDto에 넣자
    @Transactional
    public List<BoardDto> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board:boardList){
            BoardDto boardDto = BoardDto.builder()
                    .boardNum(board.getBoardNum())
                    .boardTitle(board.getTitle())
                    .boardWriter(board.getWriter())
                    .boardContent(board.getContent())
                    .boardCreatedDate(board.getCreatedDate())
                    .boardModifiedDate(board.getModifiedDate())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    @Transactional
    public void editPost(BoardDto boardDto){

    }

}
