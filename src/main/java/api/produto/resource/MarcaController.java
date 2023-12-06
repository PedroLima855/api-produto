package api.produto.resource;

import api.produto.service.MarcaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PatchMapping("/{id}")
    public ResponseEntity<String> inativarMarca(@PathVariable Long id, @RequestBody Boolean param){
        try {
            marcaService.inativarMarca(id, param);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
