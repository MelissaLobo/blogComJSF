package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String texto;

	public Comentario() {

	}

	public Comentario(String nome, String texto) {
		this.nome = nome;
		this.texto = texto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String comentario) {
		this.texto = comentario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Comentario outroComentario = (Comentario) obj;
		return this.id.equals(outroComentario.id);
	}

	public String toString() {
		return "  \n nome:" + nome + " \n texto:" + texto;
	}

}
