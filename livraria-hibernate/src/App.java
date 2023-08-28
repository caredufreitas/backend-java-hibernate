import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.hibernate.config.HibernateConfig;
import br.com.qintess.livraria.dao.Dao;
import br.com.qintess.livraria.model.Autor;
import br.com.qintess.livraria.model.Cliente;
import br.com.qintess.livraria.model.Genero;
import br.com.qintess.livraria.model.Livro;
import br.com.qintess.livraria.model.Venda;

public class App {
	public static void main(String[] args) {
//		HibernateConfig.getSessionFactory().openSession();
		Dao dao = new Dao();
//		Cliente
		Cliente cliente = new Cliente();
		cliente.setNome("Carlos Freitas");
		cliente.setTelefone("196346-8159");
		
		dao.inserir(cliente);
//		Autor
		Autor autor = new Autor();
		autor.setNome("Ferraz Ferreita");
		autor.seteMail("FerrazFerreira@qintess.com.br");
//		inserir na lista dos livros
		List<Autor> autores = new ArrayList<Autor>();
		autores.add(autor);
		
		dao.inserir(autor);
//		Genero
		Genero genero = new Genero();
		genero.setDescricao("Horror");
		
		dao.inserir(genero);
//		testar por etapas nesta sequencia
//		Livro
//		temos autores e precisamos passar uma lista de autores
		Livro livro = new Livro();
		livro.setTitulo("IT A Coisa");
		livro.setPreco(12.90);
		livro.setEstoque(02);
//		genero
		livro.setGenero(genero);
//		lista de autores
		livro.setAutores(autores);
		
		dao.inserir(livro);
//		-------------------------//--------------------------------//
//		nesta sequencia ele tem que preencher a tabela escreve.
//		Autor JOIN Table com Livro e quem faz esta relacao Escreve.
		
//		Venda - ultima entidade a ser setada.
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setData(LocalDate.now());
		venda.adicionarLivro(livro, 10);
//		Livro e Qtd
		dao.inserir(venda);
	}
}
