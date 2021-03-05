package br.dev.rvz.controleproduto.controllers;

import br.dev.rvz.controleproduto.models.Produto;
import br.dev.rvz.controleproduto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produto/")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(@RequestBody Produto produto) {
        return service.cadastrar(produto);
    }

    @GetMapping
    public List<Produto> mostrarProduto() {
        return service.listarProduto();
    }

    @GetMapping("{name}/")
    public Produto pesquisarProduto(@PathVariable String name) {
        try {
            return service.pesquisarProduto(name);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("{name}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProduto(@PathVariable String name) {
        try {
            service.excluirProduto(name);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
