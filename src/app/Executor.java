package app;

import entites.Atendente;
import entites.Cliente;
import entites.Pessoa;
import entites.Tecnico;
import services.pessoa.ServicePessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executor {
	public static final Scanner sc = new Scanner(System.in);

	private final ArrayList<Pessoa> lista = new ArrayList<>();
	private final ServicePessoa service = new ServicePessoa();

	public static void main(String[] args) {
		Executor executor = new Executor();
		while (true) {
			byte opcao = executor.menu();
			executor.verificarOpcao(opcao);
		}
	}

	public byte menu() {
		byte opcao;
		do {
			System.out.println("\nMENU PRINCIPAL:");
			System.out.println("1 - Manter Clientes");
			System.out.println("2 - Manter Atendentes");
			System.out.println("3 - Manter Técnicos");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = obterEntradaNumerica((byte) 1, (byte) 4);
		} while (opcao < 1 || opcao > 4);
		return opcao;
	}

	public byte submenu() {
		System.out.println("\nSUBMENU:");
		System.out.println("1 - Listar Todos");
		System.out.println("2 - Cadastrar");
		System.out.println("3 - Consultar");
		System.out.println("4 - Alterar");
		System.out.println("5 - Excluir");
		System.out.println("6 - Voltar ao Menu Principal");
		System.out.print("Escolha uma opção: ");
		return obterEntradaNumerica((byte) 1, (byte) 6);
	}

	public void verificarOpcao(byte opcao) {
		switch (opcao) {
			case 1 -> executarSubmenu(1); // Cliente
			case 2 -> executarSubmenu(2); // Atendente
			case 3 -> executarSubmenu(3); // Técnico
			case 4 -> {
				System.out.println("Encerrando o programa.");
				System.exit(0);
			}
			default -> System.out.println("Opção inválida!");
		}
	}

	public void executarSubmenu(int tipo) {
		byte opcaoSubmenu;
		do {
			opcaoSubmenu = submenu();
			switch (opcaoSubmenu) {
				case 1 -> service.listarPessoas(lista);
				case 2 -> cadastrarPessoa(tipo);
				case 3 -> service.buscarPessoa(lista, obterCodigoPessoa());
				case 4 -> service.alterarPessoa(lista, obterCodigoPessoa());
				case 5 -> service.excluirPessoa(lista, obterCodigoPessoa());
				case 6 -> System.out.println("Voltando ao Menu Principal...");
				default -> System.out.println("Opção inválida!");
			}
		} while (opcaoSubmenu != 6);
	}

	public void cadastrarPessoa(int tipo) {
		Pessoa pessoa = switch (tipo) {
			case 1 -> obterDadosCliente();
			case 2 -> obterDadosAtendente();
			case 3 -> obterDadosTecnico();
			default -> throw new IllegalArgumentException("Tipo inválido");
		};
		service.cadastrarPessoa(lista, pessoa);
	}

	public int obterCodigoPessoa() {
		System.out.print("Digite o código da Pessoa: ");
		return obterEntradaNumericaInt();
	}

	public List<String> obterDadosPessoa() {
		List<String> dados = new ArrayList<>();
		sc.nextLine(); // Limpa buffer
		System.out.print("Digite o nome completo da Pessoa: ");
		dados.add(sc.nextLine());
		System.out.print("Digite o endereço da Pessoa: ");
		dados.add(sc.nextLine());
		System.out.print("Digite o email da Pessoa: ");
		dados.add(sc.nextLine());
		System.out.print("Digite o telefone da Pessoa: ");
		dados.add(sc.nextLine());
		return dados;
	}

	public byte obterOpcao(String mensagem, int min, int max) {
		System.out.print(mensagem);
		return obterEntradaNumerica((byte) min, (byte) max);
	}

	public Cliente obterDadosCliente() {
		List<String> dadosPessoa = obterDadosPessoa();
		System.out.print("Como você conheceu a empresa: ");
		String comoConheceuEmpresa = sc.nextLine();
		byte planoAtendimento = obterOpcao("Digite o plano de atendimento (1-local, 2-virtual): ", 1, 2);
		return new Cliente(obterCodigoPessoa(), dadosPessoa.get(0), dadosPessoa.get(1), dadosPessoa.get(2), dadosPessoa.get(3), planoAtendimento, comoConheceuEmpresa);
	}

	public Atendente obterDadosAtendente() {
		List<String> dadosPessoa = obterDadosPessoa();
		System.out.print("Digite os serviços de atendimento ao cliente: ");
		String servAtendimento = sc.nextLine();
		byte areaAtendimento = obterOpcao("Digite a área de atendimento (1-hardware, 2-software, 3-ambos): ", 1, 3);
		return new Atendente(obterCodigoPessoa(), dadosPessoa.get(0), dadosPessoa.get(1), dadosPessoa.get(2), dadosPessoa.get(3), areaAtendimento, servAtendimento);
	}

	public Tecnico obterDadosTecnico() {
		List<String> dadosPessoa = obterDadosPessoa();
		System.out.print("Digite as certificações: ");
		String certificacoes = sc.nextLine();
		byte regimeContratacao = obterOpcao("Digite o regime de contratação (1-CLT, 2-PJ): ", 1, 2);
		return new Tecnico(obterCodigoPessoa(), dadosPessoa.get(0), dadosPessoa.get(1), dadosPessoa.get(2), dadosPessoa.get(3), regimeContratacao, certificacoes);
	}

	public byte obterEntradaNumerica(byte min, byte max) {
		byte entrada;
		while (true) {
			try {
				entrada = sc.nextByte();
				if (entrada >= min && entrada <= max) {
					return entrada;
				}
				System.out.println("Entrada fora do intervalo permitido! Tente novamente.");
			} catch (Exception e) {
				System.out.println("Entrada inválida! Por favor, insira um número.");
				sc.nextLine(); // Limpa o buffer
			}
		}
	}

	public int obterEntradaNumericaInt() {
		int entrada;
		while (true) {
			try {
				entrada = sc.nextInt();
				return entrada;
			} catch (Exception e) {
				System.out.println("Entrada inválida! Por favor, insira um número.");
				sc.nextLine(); // Limpa o buffer
			}
		}
	}
}
