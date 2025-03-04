package br.com.dnl.AppAngular.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dnl.AppAngular.Model.Pessoas;
import br.com.dnl.AppAngular.Repository.PessoasRepository;

@Service
public class PessoasService {

	@Autowired
	private PessoasRepository pessoaRepository;
	
	
	// ----- SALVAR -------------------------------------------------------------
		public Pessoas save(Pessoas pessoa) {
			return pessoaRepository.save(pessoa);
		}
		
	// ----- ENCONTRAR POR ID -------------------------------------------------------------
	public Optional<Pessoas> findById(Long id){
		return pessoaRepository.findById(id); 
	}
	
	// ----- LISTAGEM -------------------------------------------------------------
	public List<Pessoas> findAll() {
		return pessoaRepository.findAll();
	}
	
	// ----- ATUALIZAR -------------------------------------------------------------
	public Pessoas update(Long id, Pessoas pessoa) {
		Optional<Pessoas> findPessoa = pessoaRepository.findById(id);
		if (findPessoa.isPresent()) {
			Pessoas updPessoa = findPessoa.get();
			updPessoa.setNome(pessoa.getNome());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setLogradouro(pessoa.getLogradouro());
			updPessoa.setBairro(pessoa.getBairro());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updPessoa);
		}
		return null;
	}
		
		// ----- DELETAR -------------------------------------------------------------	
		public void delete(Long id) {
			pessoaRepository.deleteById(id);
		}
}
		
		
		
		
		
		

