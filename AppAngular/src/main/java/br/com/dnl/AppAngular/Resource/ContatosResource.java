package br.com.dnl.AppAngular.Resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.dnl.AppAngular.Model.Contatos;
import br.com.dnl.AppAngular.Service.ContatosService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/contatos")
@CrossOrigin(origins = "http://localhost:4200")
public class ContatosResource {

    @Autowired
    private ContatosService contatosService;

    // ----- SALVAR -------------------------------------------------------------
    @PostMapping("/{pessoaId}")
    public ResponseEntity<?> cadastrarContato(@PathVariable Long pessoaId, @RequestBody Contatos contato) {
        try {
            Contatos novoContato = contatosService.cadastrarContato(pessoaId, contato);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
   
}
