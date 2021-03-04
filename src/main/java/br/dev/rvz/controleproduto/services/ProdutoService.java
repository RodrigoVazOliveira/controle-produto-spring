package br.dev.rvz.controleproduto.services;

import br.dev.rvz.controleproduto.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Produto produto) {
        Produto produtoAjustar = verificarSeProdutoExiste(produto);
        if (produtoAjustar != null) {
            ajustarProduto(produtoAjustar, produto);
        } else {
            produtos.add(produto);
        }
    }

    private void ajustarProduto(Produto produto, Produto novoPoduto) {
        produto.setQuantidade(produto.getQuantidade() + novoPoduto.getQuantidade());
    }

    private Produto verificarSeProdutoExiste(Produto produto) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
                return p;
            }
        }
        return null;
    }

    public List<Produto> listarProduto() {
        return produtos;
    }

}
