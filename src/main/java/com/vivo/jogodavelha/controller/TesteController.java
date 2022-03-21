package com.vivo.jogodavelha.controller;


import com.vivo.jogodavelha.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/teste1")
    @ResponseBody
    public String newGame(){
        boardService.salvar("teste123");
        return "ok";
    }

}
