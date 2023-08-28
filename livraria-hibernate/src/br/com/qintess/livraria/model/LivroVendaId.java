package br.com.qintess.livraria.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class LivroVendaId implements Serializable {
// id composta Livro - Venda
	
	private int livroId;
	
	private int vendaId;
	
	private LivroVendaId() {}
	
	public LivroVendaId(int livroId, int vendaId) {
		this.livroId = livroId;	
		this.vendaId = vendaId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
			
		if(obj == null || getClass() != obj.getClass())
			return false;
			
		LivroVendaId that = (LivroVendaId) obj;
		return Objects.equals(livroId, that.livroId) && 
			   Objects.equals(vendaId, that.vendaId);
		}
	
	@Override
	public int hashCode() {
		return Objects.hash(livroId, vendaId);
	}

	public int getLivroId() {
		return livroId;
	}

	public void setLivroId(int livroId) {
		this.livroId = livroId;
	}

	public int getVendaId() {
		return vendaId;
	}

	public void setVendaId(int vendaId) {
		this.vendaId = vendaId;
	}
	
}
