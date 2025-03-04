package br.com.dnl.AppAngular.Model;

import jakarta.persistence.*;

@Entity
public class Contatos {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String celular;

    @Column(nullable = true)
    private String tipo;

    @Column(nullable = true)
    private String contato;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false) 
    private Pessoas pessoa;

    //---------------------------------
    public Contatos() {}

    public Contatos(Long id, String celular, String tipo, String contato, Pessoas pessoa) {
        this.id = id;
    	this.celular = celular;
        this.tipo = tipo;
        this.contato = contato;
        this.pessoa = pessoa;
    }

    //---------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }
}
