package br.dev.rvz.controleproduto.controllers;

import br.dev.rvz.controleproduto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto/")
public class ProdutoController {

    @Autowired
    private ProdutoService service;



}