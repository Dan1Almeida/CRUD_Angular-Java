package br.com.dnl.AppAngular.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dnl.AppAngular.Model.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {

	
	// ----- BUSCAR PERSONALIZADA -----
	List<Contatos> findByPessoaId(Long idPessoa);
	
	boolean existsByPessoaIdAndContato(Long pessoaId, String contato);
}
