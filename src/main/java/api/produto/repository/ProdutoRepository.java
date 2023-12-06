package api.produto.repository;

import api.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "select p.id, p.nome, p.preco, p.ativo, p.categoria_id, p.marca_id from produto p join marca m on m.id = p.marca_id join categoria c on c.id = p.categoria_id" +
            " WHERE p.ativo = true and m.ativo = true and c.ativo = true", nativeQuery = true)
    List<Produto> buscarTodosOsProdutos();

    @Query(value = "select p.id, p.nome, p.preco, p.ativo, p.categoria_id, p.marca_id from produto p " +
            "join marca m on m.id = p.marca_id where p.ativo = true and m.ativo = true and LOWER(m.nome) LIKE LOWER(CONCAT('%', :marca, '%'))", nativeQuery = true)
    List<Produto> buscarProdutoPorMarca(String marca);

    @Query(value = "select p.id, p.nome, p.preco, p.ativo, p.categoria_id, p.marca_id from produto p " +
            "join categoria c on c.id = p.categoria_id where p.ativo = true and c.ativo = true and LOWER(c.nome) LIKE LOWER(CONCAT('%', :categoria, '%'))", nativeQuery = true)
    List<Produto> buscarProdutoPorCategoria(String categoria);

}
