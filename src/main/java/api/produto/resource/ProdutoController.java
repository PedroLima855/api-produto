package api.produto.resource;

import api.produto.entity.Produto;
import api.produto.service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.save(produto);
        return ResponseEntity.created(URI.create("/produto/id")).body(produtoSalvo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProduto(){
        return produtoService.buscarTodosOsProdutos();
    }

    @GetMapping("/marca")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutoPorMarca(@RequestParam(value = "param") String marca){
        return produtoService.buscarProdutoPorMarca(marca);
    }

    @GetMapping("/categoria")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutoPorCategoria(@RequestParam(value = "param") String categoria){
        return produtoService.buscarProdutoPorCategoria(categoria);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> inativarProduto(@PathVariable Long id, @RequestBody Boolean param){
        try {
            produtoService.inativarProduto(id, param);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

}
