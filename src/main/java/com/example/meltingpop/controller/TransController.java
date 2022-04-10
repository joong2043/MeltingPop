package com.example.meltingpop.controller;

import com.example.meltingpop.dto.SongDto;
import com.example.meltingpop.entity.Song_Info;
import com.example.meltingpop.papago.PapagoAPI;
import com.example.meltingpop.repository.TransRepository;
import com.example.meltingpop.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TransController {
    @Autowired
    private TransService transService;

    @Autowired
    private TransRepository transRepository;

    private PapagoAPI papagoAPI;

    public TransController(PapagoAPI papagoAPI){
        this.papagoAPI = papagoAPI;
    }

    public Object korean;

    @RequestMapping(value = "/trans", method = RequestMethod.GET)
    public String trans(){

        //System.out.println(song_infos);

        List<Song_Info> data = transRepository.findBySong("my universe");

        // String stayLyric = data.get(0).getLyric();

        // korean = papagoAPI.getKorean(stayLyric);

        // transRepository.setKoreanLyricData(korean,"my universe");

        // System.out.println("번역된 단어 : " + korean);
        return "static/index";
    }
}
