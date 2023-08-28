package br.com.qintess.livraria.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="itens_das_vendas")
public class LivroVenda {
//	entidade customizada com chave composta LivroVendaId
	@EmbeddedId
	private LivroVendaId id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("livroId")
	private Livro livro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("vendaId")
	private Venda venda;
	
	@Column(nullable=false)
	private int qtd;
	
	@Column(nullable=false)
	private double subTotal;
	
	private LivroVenda() {}
	
	public LivroVenda(Livro livro, Venda venda, int qtd) {
		this.livro = livro;
		this.venda = venda;
		this.qtd = qtd;
		this.id = new LivroVendaId(livro.getId(), venda.getId());
	}

	public LivroVendaId getId() {
		return id;
	}

	public void setId(LivroVendaId id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
