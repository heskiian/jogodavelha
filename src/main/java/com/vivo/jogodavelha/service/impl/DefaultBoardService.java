package com.vivo.jogodavelha.service.impl;

import com.vivo.jogodavelha.service.BoardService;
import org.springframework.stereotype.Service;

@Service
public class DefaultBoardService implements BoardService {

    @Override
    public void salvar(String teste){
        System.out.println("teste");
    }
}
