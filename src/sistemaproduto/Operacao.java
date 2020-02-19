package sistemaproduto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import interfaces.Protecao;

public final class Operacao extends Produto implements Protecao {
	Scanner sc = new Scanner(System.in);
	ArrayList<Operacao> listaClientes = new ArrayList<Operacao>();
	
	private String cpf, email, tel;
	
	public Operacao(String cpf, String email, String tel, int id, String nome) {
		super(id, nome);
		this.cpf = cpf;
		this.email = email;
		this.tel = tel;
	}
	
	public Operacao() {
		
	}

	@Override
	public void inserir() {
		String str = "";
		do {
			System.out.println("---------------------------------------------------------");

			Operacao op = new Operacao();
			
			System.out.print("ID do cliente: ");
			int id = sc.nextInt();
			sc.nextLine();
			op.setId(id);

			System.out.print("Nome do cliente: ");
			String nome = sc.nextLine();
			op.setNome(nome);

			System.out.print("CPF do cliente " + nome + ": ");
			String cpf = sc.next();
			sc.nextLine();
			op.setCpf(cpf);

			System.out.print("Email do cliente " + nome + ": ");
			String email = sc.nextLine();
			op.setEmail(email);

			System.out.print("Número para contato do cliente " + nome + ": ");
			String num = sc.nextLine();
			op.setTel(num);

			listaClientes.add(op);

			System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
			System.out.println("Deseja cadastrar outro cliente no sistema? [S/N]");
			str = sc.next();
		} while (str.equals("S"));
	}
	
	public void pesquisar() {
		if(listaClientes.isEmpty()) {
			System.out.println("PESQUISA INDISPONÍVEL. NENHUM CLIENTE CASDASTRADO!");
		}else {
			System.out.print("Digite o ID do cliente que deseja pesquisar: ");
			int id = sc.nextInt();
			Operacao op = new Operacao();
			
			for(Operacao opr: listaClientes) {
				if(opr.getId() == id) {
					op = opr;
					System.out.println("---------------------------------------------------------|");
					System.out.println("INFORMAÇÕES DO CLIENTE " + opr.getNome().toUpperCase());
					System.out.println("---------------------------------------------------------|");
					System.out.println("ID: " + opr.getId());
					System.out.println("Nome: " + opr.getNome());
					System.out.println("CPF: " + opr.getCpf());
					System.out.println("Email: " + opr.getEmail());
					System.out.println("Telefone: " + opr.getTel());
				}
			}
			if(op.getId() != id) {
				System.out.println("ID INVÁLIDO. DIGITE UM ID VÁLIDO PARA REALIZAR A PESQUISA!");
			}
		}
	}

	@Override
	public void exibir() {
		System.out.println("|       LISTA DE CLIENTES REGISTRADOS NO SISTEMA        |\n");

		if (listaClientes.isEmpty()) {
			System.out.println("VISUALIZAÇÂO INDISPONÍVEL. NENHUM CLIENTE CASDASTRADO!");
		}

		List<Operacao> lista = new ArrayList<Operacao>();
		lista = this.listaClientes;

		for (Operacao op : lista) {
			System.out.println("ID do cliente: " + op.getId());
			System.out.println("Nome no cliente: " + op.getNome());
			System.out.println("CPF do cliente: " + op.getCpf());
			System.out.println("Email do cliente: " + op.getEmail());
			System.out.println("Telefone do cliente: " + op.getTel());
			System.out.println("---------------------------------------------------------");
		}
		System.out.println("\n|                                                       |");
	}

	@Override
	public void atualizar() {
		if (listaClientes.isEmpty()) {
			System.out.println("ATUALIZAÇÂO INDISPONÍVEL. NENHUM CLIENTE CASDASTRADO!");
		} else {
			System.out.println(" Digite o ID do cliente que deseja alterar: ");
			System.out.println("---------------------------------------------------------");
			exibir();
			int idu = sc.nextInt();
			for (Operacao opr : listaClientes) {
				if (opr.getId() == idu) {
					System.out.println("---------------------------------------------------------");

					Operacao op = new Operacao();

					System.out.print("ID do novo cliente: ");
					int id = sc.nextInt();
					sc.nextLine();
					op.setId(id);

					System.out.print("Nome do novo cliente: ");
					String nome = sc.nextLine();
					op.setNome(nome);

					System.out.print("CPF do novo cliente: ");
					String cpf = sc.next();
					sc.nextLine();
					op.setCpf(cpf);

					System.out.print("Email do novo cliente: ");
					String email = sc.nextLine();
					op.setEmail(email);

					System.out.print("Número para contato do novo cliente: ");
					String num = sc.nextLine();
					op.setTel(num);

					for (int i = 0; i < listaClientes.size(); i++) {
						if (listaClientes.get(i).getId() == idu) {
							listaClientes.set(i, op);
						}
					}

					System.out.println("CLIENTE ATUALIZADO COM SUCESSO!");
				}
			}
		}
	}

	@Override
	public void remover() {
		if (listaClientes.isEmpty()) {
			System.out.println("REMOÇÃO DE PROTUDO INDISPONÍVEL. NENHUM CLIENTE CASDASTRADO!");
		} else {
			System.out.println(" [1] para remover todos os clientes da lista");
			System.out.println(" [2] para remover apenas um cliente da lista");
			System.out.println("---------------------------------------------------------");
			exibir();
			int op = sc.nextInt();

			if (op == 1) {
				listaClientes.clear();
				System.out.println("CLIENTES REMOVIDO COM SUCESSO!");
			} else if (op == 2) {
				System.out.println("Digite o ID do cliente que deseja remover da lista: ");
				System.out.println("---------------------------------------------------------");
				exibir();
				int id = sc.nextInt();

				Iterator<Operacao> itr = listaClientes.iterator();

				while (itr.hasNext()) {
					Operacao p = itr.next();
					if (p.getId() == id) {
						itr.remove();
					}
				}
				System.out.println("CLIENTE REMOVIDO COM SUCESSO!");
			}
		}
	}
	
	@Override
	public void novoPrecoProduto(String nome, float preco) {
		System.out.printf("Produto com menor preço: %s %s%.2f%s %s", nome, "[", preco, " R$]", "\n\n");
	}
	
	public void informacaoSistema(String info) {
		System.out.println(info);
	}
	
	public void informacaoSistema(String horario, String data) {
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat(horario);
		SimpleDateFormat sdf = new SimpleDateFormat(data);
		
		System.out.println("Data e Hora da operacao realizada: " + 
		sdf.format(Calendar.getInstance().getTime()) + " às "+ simpleDataFormat.format(Calendar.getInstance().getTime()));
	}
	
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}	
}
