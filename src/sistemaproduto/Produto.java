package sistemaproduto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import interfaces.Protecao;

public class Produto extends PrecoProduto implements Protecao {
	Scanner sc = new Scanner(System.in);
	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	private int id;
	private String nome, codigoBarras, categoria;
	String str = "";
	
	public Produto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Produto() {
		
	}
	
	@Override
	public void inserir() {
		do {
			System.out.println("---------------------------------------------------------");

			Produto produto = new Produto();
			System.out.print("ID do produto: ");
			int id = sc.nextInt();
			sc.nextLine();
			produto.setId(id);

			System.out.print("Nome do produto: ");
			String nome = sc.nextLine();
			produto.setNome(nome);

			System.out.print("Código de barras do produto " + nome + ": ");
			String codigoBarras = sc.next();
			sc.nextLine();
			produto.setCodigoBarras(codigoBarras);

			System.out.print("Categoria do produto " + nome + ": ");
			String categoria = sc.nextLine();
			produto.setCategoria(categoria);

			System.out.print("Preço do produto " + nome + " R$: ");
			float preco = sc.nextFloat();
			produto.setPreco(preco);

			System.out.print("Unidade(s) do produto " + nome + ": ");
			int unidade = sc.nextInt();
			produto.setUnidade(unidade);

			listaProdutos.add(produto);

			if (produto.getPreco() > this.getMaiorPreco()) {
				this.setMaiorPreco(produto.getPreco());
				this.setNomeMaiorPreco(produto.getNome());
			}

			if (produto.getPreco() < this.getMenorPreco() || this.getMenorPreco() == 0) {
				this.setMenorPreco(produto.getPreco());
				this.setNomeMenorPreco(produto.getNome());
			}

			System.out.println("PRODUTO INSERIDO COM SUCESSO!");
			System.out.println("Deseja cadastrar outro produto no sistema? [S/N]");
			str = sc.next();
		} while (str.equals("S"));
	}
	
	public void pesquisar() {
		if(listaProdutos.isEmpty()) {
			System.out.println("PESQUISA INDISPONÍVEL. NENHUM PRODUTO CASDASTRADO!");
		}else {
			System.out.print("Digite o ID do produto que deseja pesquisar: ");
			int id = sc.nextInt();
			Produto pr = new Produto();
			
			for(Produto p: listaProdutos) {
				if(p.getId() == id) {
					pr = p;
					System.out.println("---------------------------------------------------------|");
					System.out.println("INFORMAÇÕES DO PRODUTO " + p.getNome().toUpperCase());
					System.out.println("---------------------------------------------------------|");
					System.out.println("ID: " + p.getId());
					System.out.println("Nome: " + p.getNome());
					System.out.println("Codigo de Barra: " + p.getCodigoBarras());
					System.out.println("Categoria: " + p.getCategoria());
					System.out.printf("Preço R$: %.2f", p.getPreco());
					System.out.println("\nUnidade: " + p.getUnidade());
				}
			}
			if(pr.getId() != id) {
				System.out.println("ID INVÁLIDO. DIGITE UM ID VÁLIDO PARA REALIZAR A PESQUISA!");
			}
		}
	}

	@Override
	public void exibir() {
		System.out.println("|       LISTA DE PRODUTOS REGISTRADOS NO SISTEMA        |\n");

		if (listaProdutos.isEmpty()) {
			System.out.println("VISUALIZAÇÂO INDISPONÍVEL. ESTOQUE DE PROTUDO VÁZIO!");
		}

		List<Produto> lista = new ArrayList<Produto>();
		lista = this.listaProdutos;

		for (Produto p : lista) {
			System.out.println("ID: " + p.getId());
			System.out.println("Nome: " + p.getNome());
			System.out.println("Código de Barras: " + p.getCodigoBarras());
			System.out.println("Categoria: " + p.getCategoria());
			System.out.printf("Preço R$: %.2f", p.getPreco());
			System.out.println("\nQuantidade: " + p.getUnidade());
			System.out.println("---------------------------------------------------------");
		}
		System.out.println("\n|                                                        |");
	}

	@Override
	public void atualizar() {
		if (listaProdutos.isEmpty()) {
			System.out.println("ATUALIZAÇÂO INDISPONÍVEL. ESTOQUE DE PROTUDO VÁZIO!");
		} else {
			System.out.println(" Digite o ID do produto que deseja alterar: ");
			System.out.println("---------------------------------------------------------");
			exibir();
			int idu = sc.nextInt();
			for (Produto p : listaProdutos) {
				if (p.getId() == idu) {
					System.out.println("---------------------------------------------------------");

					Produto produto = new Produto();

					System.out.print("ID do novo produto: ");
					int id = sc.nextInt();
					sc.nextLine();
					produto.setId(id);

					System.out.print("Nome do novo produto: ");
					String nome = sc.nextLine();
					produto.setNome(nome);

					System.out.print("Código de barras do novo produto: ");
					String codigoBarra = sc.next();
					sc.nextLine();
					produto.setCodigoBarras(codigoBarra);

					System.out.print("Categoria do novo produto: ");
					String categoria = sc.nextLine();
					produto.setCategoria(categoria);

					System.out.print("Preço do novo produto R$: ");
					float preco = sc.nextFloat();
					produto.setPreco(preco);

					System.out.print("Unidade do novo produto: ");
					int unidade = sc.nextInt();
					produto.setUnidade(unidade);

					for (int i = 0; i < listaProdutos.size(); i++) {
						if (listaProdutos.get(i).getId() == idu) {
							listaProdutos.set(i, produto);
						}
					}

					System.out.println("PRODUTO ATUALIZADO COM SUCESSO!");
				} 
			}
		}
	}

	@Override
	public void remover() {
		if (listaProdutos.isEmpty()) {
			System.out.println("REMOÇÃO DE PROTUDO INDISPONÍVEL. ESTOQUE DE PROTUDO VÁZIO!");
		} else {
			System.out.println(" [1] para remover todos os produtos da lista");
			System.out.println(" [2] para remover apenas um produto da lista");
			System.out.println("---------------------------------------------------------");
			exibir();
			int op = sc.nextInt();

			if (op == 1) {
				listaProdutos.clear();
				System.out.println("PRODUTOS REMOVIDO COM SUCESSO!");
			} else if (op == 2) {
				System.out.println("Digite o ID do produto que deseja remover da lista: ");
				System.out.println("---------------------------------------------------------");
				exibir();
				int id = sc.nextInt();

				Iterator<Produto> itr = listaProdutos.iterator();

				while (itr.hasNext()) {
					Produto p = itr.next();
					if (p.getId() == id) {
						itr.remove();
					}
				}
				System.out.println("PRODUTO REMOVIDO COM SUCESSO!");
			}
		}
	}
	
	@Override
	public void novoPrecoProduto(String nome, float preco) {
		System.out.printf("Produto com maior preço: %s %s%.2f%s %s", nome, "[", preco, " R$]", "\n");
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoBarras() {
		return this.codigoBarras;
	}

	public void setCodigoBarras(String codigoBarra) {
		this.codigoBarras = codigoBarra;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
