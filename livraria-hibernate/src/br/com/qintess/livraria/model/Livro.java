package br.com.qintess.livraria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false, length = 50)
	private String titulo;
	
	@Column(nullable=false)
	private double preco;
	
	@Column(nullable=false)
	private int estoque;
	
	@ManyToOne
	@JoinColumn(name="genero_id")
	private Genero genero;

	@ManyToMany
	@JoinTable(name="escreve")
	private List<Autor> autores;
	
	@OneToMany(mappedBy="livro", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<LivroVenda> vendas = new ArrayList<LivroVenda>();
//	key, composta, mapeamento bi lateral com LvroVenda
	
	public void alterarEstoque(int qtd) {
		this.setEstoque(this.getEstoque() - qtd);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<LivroVenda> getVendas() {
		return vendas;
	}

	public void setVendas(List<LivroVenda> vendas) {
		this.vendas = vendas;
	}
	
}
