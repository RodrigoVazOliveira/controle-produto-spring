package br.dev.rvz.controleproduto.controllers;

import br.dev.rvz.controleproduto.models.Produto;
import br.dev.rvz.controleproduto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto/")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public void cadastrar(Produto produto) {
        service.cadastrar(produto);
    }

    public List<Produto> mostrarProduto() {
        return service.listarProduto();
    }

}
