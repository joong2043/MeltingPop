package com.example.meltingpop.controller;

import com.example.meltingpop.dto.BoardDto;
import com.example.meltingpop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(Model model){
        //postList 파람을 받아서 데이터베이스에 있는 내용
        List<BoardDto> boardDtoList = boardService.getBoardList();
        for(BoardDto boardDto1:boardDtoList){
            System.out.println(boardDto1);
        }

        return "static/index";
    }

    @GetMapping("/post")
    public String post(){
        return "static/index";
    }

    @PostMapping("/post")
    public String write(@RequestBody BoardDto boardDto){
        boardService.savePost(boardDto);
        return "static/index";
    }
}
