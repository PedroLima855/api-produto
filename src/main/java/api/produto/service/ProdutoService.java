package api.produto.service;

import api.produto.entity.Produto;
import api.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarTodosOsProdutos(){
        return produtoRepository.buscarTodosOsProdutos();
    }

    public List<Produto> buscarProdutoPorMarca(String marca){
        return produtoRepository.buscarProdutoPorMarca(marca);
    }

    public List<Produto> buscarProdutoPorCategoria(String categoria){
        return produtoRepository.buscarProdutoPorCategoria(categoria);
    }

    public void inativarProduto(Long id, Boolean param){

        try {
            Produto produto = produtoRepository.getReferenceById(id);
            produto.setAtivo(param);
            produtoRepository.save(produto);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Não existe produto com esse id: " + id);
        }
    }
}
