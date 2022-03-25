package com.example.meltingpop.controller;

import com.example.meltingpop.dto.LyricDto;
import com.example.meltingpop.papago.PapagoAPI;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransController {
    private PapagoAPI papagoAPI;

    public TransController(PapagoAPI papagoAPI){
        this.papagoAPI = papagoAPI;
    }

    @RequestMapping(value = "/trans", method = RequestMethod.GET)

    public String trans(@RequestBody LyricDto lyricDto){
        papagoAPI.getEnglish(lyricDto.getWord());
        return "static/index";
    }
}
