package sistemaproduto;

import java.util.Scanner;
	
public class Executavel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Operacao operacao = new Operacao();
		Produto p = new Produto();
		
		int op = 0;
		
		do {
			System.out.println("|>>>>>>>>>>>>>>>>>> SISTEMA DE CADASTRO <<<<<<<<<<<<<<<<<|");
			System.out.println("[1] PARA CADASTRAR PRODUTO");
			System.out.println("[2] PARA CADASTRAR CLIENTE");
			System.out.println("[3] PARA SAIR");
			op = sc.nextInt();
			switch(op) {
				case 1:
					do {
						System.out.println(" |>>>>>>>>>>>>>>>>> CADASTRO DE PRODUTO <<<<<<<<<<<<<<<<<|");
						System.out.println(" [1] PARA INSERIR PRODUTO");
						System.out.println(" [2] PARA PESQUISAR PRODUTO");
						System.out.println(" [3] PARA EXIBIR PRODUTO");
						System.out.println(" [4] PARA ATUALIZAR PRODUTO");
						System.out.println(" [5] PARA REMOVER PRODUTO");
						System.out.println(" [6] PARA VOLTAR AO MENU INICIAL");
						op = sc.nextInt();
						switch(op) {
							case 1:
								p.inserir();
								break;
							case 2:
								p.pesquisar();
								break;
							case 3:
								p.exibir();
								break;
							case 4:
								p.atualizar();
								break;
							case 5:
								p.remover();
								break;
						}
					}while(op < 6);
				break;
				case 2:
					do {
						System.out.println(" |>>>>>>>>>>>>>>>>> CADASTRO DE CLIENTE <<<<<<<<<<<<<<<<<|");
						System.out.println(" [1] PARA CADASTRAR CLIENTE");
						System.out.println(" [2] PARA PESQUISAR CLIENTE");
						System.out.println(" [3] PARA EXIBIR CLIENTE");
						System.out.println(" [4] PARA ATUALIZAR CLIENTE");
						System.out.println(" [5] PARA REMOVER CLIENTE");
						System.out.println(" [6] PARA VOLTAR AO MENU INICIAL");
						op = sc.nextInt();
						switch(op) {
							case 1:
								operacao.inserir();
								break;
							case 2:
								operacao.pesquisar();
								break;
							case 3:
								operacao.exibir();
								break;
							case 4:
								operacao.atualizar();
								break;
							case 5:
								operacao.remover();
								break;
						}
					}while(op < 6);
					break;
				case 3:
					System.out.println("OPERAÇÃO ENCERRADA...\n");
					break;
				default:
					System.out.println("Entre com um número válido entre 1 e 3!");
			}
		}while(op > 3);
		sc.close();
		
		if(!p.listaProdutos.isEmpty()) {
			p.novoPrecoProduto(p.getNomeMaiorPreco(), p.getMaiorPreco());
			operacao.novoPrecoProduto(p.getNomeMenorPreco(), p.getMenorPreco());
		}
		operacao.informacaoSistema("INFORMAÇÕES DO SISTEMA: ");
		operacao.informacaoSistema("HH:mm:ss", "dd/MM/yyyy");
		System.out.println("|>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<|");
	}
}
