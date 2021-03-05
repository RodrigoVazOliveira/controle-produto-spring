package br.dev.rvz.controleproduto.services;

import br.dev.rvz.controleproduto.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public Produto cadastrar(Produto produto) {
        try {
            Produto produtoAjustar = verificarSeProdutoExiste(produto);
            ajustarProduto(produtoAjustar, produto);
            return produtoAjustar;
        } catch (RuntimeException erro) {
            produtos.add(produto);
            return produto;
        }
    }

    private void ajustarProduto(Produto produto, Produto novoPoduto) {
        produto.setQuantidade(produto.getQuantidade() + novoPoduto.getQuantidade());
    }

    private Produto verificarSeProdutoExiste(Produto produto) throws RuntimeException {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
                return p;
            }
        }
        throw new RuntimeException("Produto não localizado!");
    }

    public List<Produto> listarProduto() {
        return produtos;
    }

    public Produto pesquisarProduto(String nome) throws RuntimeException {
        Produto produto = new Produto();
        produto.setNome(nome);
        return pesquisarProduto(produto);
    }

    public Produto pesquisarProduto(Produto produto) throws RuntimeException {
        for (Produto obj : produtos) {
            if (obj.getNome().equalsIgnoreCase(produto.getNome())) {
                return obj;
            }
        }
        throw new RuntimeException("Produto não localizado!");
    }

    public void excluirProduto(String nome) throws RuntimeException{
        Produto produto = new Produto();
        produto.setNome(nome);
        excluirProduto(produto);
    }

    public void excluirProduto(Produto produto) {
        for (Produto obj : produtos) {
            if (obj.getNome().equalsIgnoreCase(produto.getNome())) {
                produtos.remove(obj);
            }
        }
        throw new RuntimeException("Produto não localizado!");
    }

}
