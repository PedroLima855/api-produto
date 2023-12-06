package api.produto.service;

import api.produto.entity.Marca;
import api.produto.repository.MarcaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public void inativarMarca(Long id, Boolean param){

        try {
            Marca marca = marcaRepository.getReferenceById(id);
            marca.setAtivo(param);
            marcaRepository.save(marca);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Não existe marca com esse id: " + id);
        }
    }

}
