package com.example.meltingpop.controller;

import com.example.meltingpop.dto.BoardDto;
import com.example.meltingpop.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(){
        List<BoardDto> boardDtoList = boardService.getBoardList();
        return "static/index";
    }

    @GetMapping("/post")
    public String post(){
        return "static/index";
    }

    @GetMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "static/index";
    }
}
