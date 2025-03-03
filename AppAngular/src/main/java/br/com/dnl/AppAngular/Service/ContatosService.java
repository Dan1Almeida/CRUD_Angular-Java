package br.com.dnl.AppAngular.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dnl.AppAngular.Model.Contatos;
import br.com.dnl.AppAngular.Model.Pessoas;
import br.com.dnl.AppAngular.Repository.ContatosRepository;
import br.com.dnl.AppAngular.Repository.PessoasRepository;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository contatosRepository;
    
    @Autowired
    private PessoasRepository pessoasRepository;

    // ----- SALVAR -------------------------------------------------------------
    public Contatos cadastrarContato(Long pessoaId, Contatos contato) {
        Pessoas pessoa = pessoasRepository.findById(pessoaId)
            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

        contato.setPessoa(pessoa);
        return contatosRepository.save(contato); 
    }

    // ----- ENCONTRAR POR ID -------------------------------------------------------------
    public Optional<Contatos> findById(Long id) {
        return contatosRepository.findById(id);
    }

   
}
