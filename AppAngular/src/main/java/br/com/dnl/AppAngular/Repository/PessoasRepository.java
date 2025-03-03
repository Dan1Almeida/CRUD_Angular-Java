package br.com.dnl.AppAngular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dnl.AppAngular.Model.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
	

	
}