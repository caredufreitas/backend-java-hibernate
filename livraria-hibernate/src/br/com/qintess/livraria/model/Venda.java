package br.com.qintess.livraria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@Column(nullable = false)
	private double total;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="venda", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<LivroVenda> livros = new ArrayList<LivroVenda>();
//	key, composta, mapeamento bi lateral com LvroVenda
	
//	metodo para alimentar itens_das_vendas, cada vez que adicionar um livro ele vai fazer este processo aqui.
	public void adicionarLivro(Livro livro, int qtd) {
		LivroVenda livroVenda = new LivroVenda(livro, this, qtd);
//		relacionamento bi lateral
		livros.add(livroVenda);
		livro.getVendas().add(livroVenda);
		
		double subTotal = qtd * livro.getPreco();
		livroVenda.setSubTotal(subTotal);
		
		this.total += subTotal;
		livro.alterarEstoque(qtd);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<LivroVenda> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroVenda> livros) {
		this.livros = livros;
	}
	
}
