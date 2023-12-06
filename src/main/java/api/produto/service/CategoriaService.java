package api.produto.service;

import api.produto.entity.Categoria;
import api.produto.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void inativarCategoria(Long id, Boolean param){
        try {
            Categoria categoria = categoriaRepository.getReferenceById(id);
            categoria.setAtivo(param);
            categoriaRepository.save(categoria);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Não existe categoria com esse id: " + id);
        }
    }
}
