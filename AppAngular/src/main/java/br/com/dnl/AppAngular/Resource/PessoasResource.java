package br.com.dnl.AppAngular.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dnl.AppAngular.Model.Pessoas;
import br.com.dnl.AppAngular.Service.PessoasService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoasResource {


	@Autowired
	PessoasService pessoaService;
	
	
	// ----- SALVAR -------------------------------------------------------------
	
	@PostMapping
    public Pessoas cadastrarPessoa(@RequestBody Pessoas pessoa) {
        return pessoaService.save(pessoa);
    }


	// ----- ENCONTRAR POR ID -------------------------------------------------------------

	@GetMapping("/{id}") // GET http://localhost:8080/api/pessoas/{id}
	public ResponseEntity<Pessoas> findById(@PathVariable Long id) {
	    return pessoaService.findById(id)
	            .map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// ----- LISTAGEM -------------------------------------------------------------
	
		@GetMapping // GET http://localhost:8080/api/pessoas
		public ResponseEntity<List<Pessoas>> findAll() {
		    List<Pessoas> findpessoas = pessoaService.findAll();
		    return ResponseEntity.status(HttpStatus.OK).body(findpessoas);  
		}
		
		
	// ----- ATUALIZAR -------------------------------------------------------------
	
		@PutMapping("/{id}")
		public ResponseEntity<Pessoas> update(@PathVariable Long id, @RequestBody Pessoas pessoa) {
		    Pessoas updPessoa = pessoaService.update(id, pessoa);
		    return ResponseEntity.status(HttpStatus.OK).body(updPessoa);
		}
	
	// ----- DELETAR -------------------------------------------------------------
	
	@DeleteMapping("/{id}") //DELETE http://localhost:8080/api/pessoas/{id}
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}	
	
	
	