package services.pessoa;

import entites.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicePessoa {

    Scanner sc = new Scanner(System.in);

    Utils utils = new Utils();

    public void cadastrarPessoa(ArrayList<Pessoa> pessoas, Pessoa pessoa) {
        Pessoa existe = buscarPessoa(pessoas, pessoa.getCodPessoa());

        if (existe != null) {
            System.out.println("Pessoa ja existe com esse codigo!");
        } else {
            pessoas.add(pessoa);
        }
    }

    public void listarPessoas(ArrayList<?> objects) {
        if (utils.arrayListIsEmpty(objects)) {
            System.out.println("Não existe nenhuma pessoa cadastrada!");
            return;
        }

        // Verifica o tipo do primeiro elemento
        Object firstElement = objects.get(0);
        if (firstElement instanceof Cliente) {
            System.out.println("Lista de Clientes:");
            for (Object obj : objects) {
                Cliente cliente = (Cliente) obj;
                System.out.println(cliente);
            }
        } else if (firstElement instanceof Atendente) {
            System.out.println("Lista de Atendentes:");
            for (Object obj : objects) {
                Atendente atendente = (Atendente) obj;
                System.out.println(atendente);
            }
        } else {
            System.out.println("Lista de Técnicos:");
            for (Object obj : objects) {
                Tecnico tecnico = (Tecnico) obj;
                System.out.println(tecnico);
            };
        }
    }

    public Pessoa buscarPessoa(ArrayList<Pessoa> pessoas, int codigo) {
        if (utils.arrayListIsEmpty(pessoas)) {
            System.out.println("Não existe nenhuma pessoa cadastrada!");
            return null;
        }

        List<Pessoa> pessoa = pessoas.stream()
                .filter(existePessoa -> utils.convertToString(codigo).equals(utils.convertToString(existePessoa.getCodPessoa())))
                .toList();

        return pessoa.get(0);
    }

    public void alterarPessoa(ArrayList<Pessoa> lista, int codigo) {
        Pessoa pessoa = buscarPessoa(lista, codigo);

        if (pessoa == null) {
            System.out.println("Pessoa não encontrada!");
            return;
        }

        // Verifica o tipo da instância e realiza as alterações específicas
        if (pessoa instanceof Cliente) {
            Cliente cliente = (Cliente) pessoa;


            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Endereco: ");
            String endereco = sc.nextLine();

            System.out.print("Telefone: ");
            String telefone = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            cliente.setNomeCompleto(nome);

            cliente.setEndereco(endereco);

            cliente.setTelefone(telefone);

            cliente.setEmail(email);

            System.out.println("Alterando dados do Cliente...");

            System.out.println("Cliente alterado com sucesso: " + cliente);
        } else if (pessoa instanceof Atendente) {
            Atendente atendente = (Atendente) pessoa;
            System.out.println("Alterando dados do Atendente...");
            // Exemplo de alteração específica para Atendente
            atendente.setNomeCompleto("Novo Nome Atendente");
            atendente.setTelefone("Novo Telefone Atendente");
            System.out.println("Atendente alterado com sucesso: " + atendente);
        } else if (pessoa instanceof Tecnico) {
            Tecnico tecnico = (Tecnico) pessoa;
            System.out.println("Alterando dados do Técnico...");
            // Exemplo de alteração específica para Técnico
            tecnico.setEmail("Novo Email Técnico");
            tecnico.setEndereco("Novo Endereço Técnico");
            System.out.println("Técnico alterado com sucesso: " + tecnico);
        } else {
            System.out.println("Tipo de pessoa desconhecido.");
        }
    }

    public void excluirPessoa(ArrayList<Pessoa> pessoas, int codigo) {
        Pessoa pessoa = buscarPessoa(pessoas, codigo);

        if (pessoa == null) {
            System.out.println("Pessoa não encontrada!");
            return;
        }

        pessoas.remove(pessoa);
    }
}
