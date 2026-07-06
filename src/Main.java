import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao = -1;

        // Variáveis do sistema
        String titulo;
        String autor;
        String nome;
        String email;
        int ano;

        while (opcao != 0) {

            System.out.println("\n====================================");
            System.out.println("      BIBLIOTECA DIGITAL");
            System.out.println("====================================");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro");
            System.out.println("4 - Ordenar livros por título");
            System.out.println("5 - Ordenar livros por ano");
            System.out.println("6 - Listar livros por autor");
            System.out.println("7 - Cadastrar usuário");
            System.out.println("8 - Listar usuários");
            System.out.println("9 - Buscar usuário");
            System.out.println("10 - Emprestar livro");
            System.out.println("11 - Devolver livro");
            System.out.println("12 - Livros disponíveis");
            System.out.println("13 - Livros emprestados");
            System.out.println("14 - Agrupar livros por autor");
            System.out.println("15 - Salvar dados");
            System.out.println("16 - Remover livro");
            System.out.println("0 - Sair");

            System.out.print("\nEscolha uma opção: ");

            try {

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1:

                        System.out.print("Título: ");
                        titulo = scanner.nextLine();

                        System.out.print("Autor: ");
                        autor = scanner.nextLine();

                        System.out.print("Ano de publicação: ");
                        ano = scanner.nextInt();
                        scanner.nextLine();

                        biblioteca.cadastrarLivro(
                                new Livro(titulo, autor, ano));

                        break;

                    case 2:

                        biblioteca.listarLivros();

                        break;

                    case 3:

                        System.out.print("Título: ");
                        titulo = scanner.nextLine();

                        biblioteca.mostrarLivro(titulo);

                        break;

                    case 4:

                        biblioteca.ordenarPorTitulo();

                        break;

                    case 5:

                        biblioteca.ordenarPorAno();

                        break;

                    case 6:

                        System.out.print("Autor: ");
                        autor = scanner.nextLine();

                        biblioteca.listarPorAutor(autor);

                        break;

                    case 7:

                        System.out.print("Nome: ");
                        nome = scanner.nextLine();

                        System.out.print("E-mail: ");
                        email = scanner.nextLine();

                        biblioteca.cadastrarUsuario(
                                new Usuario(nome, email));

                        break;

                    case 8:

                        biblioteca.listarUsuarios();

                        break;

                    case 9:

                        System.out.print("E-mail: ");
                        email = scanner.nextLine();

                        biblioteca.mostrarUsuario(email);

                        break;

                    case 10:

                        System.out.print("Título do livro: ");
                        titulo = scanner.nextLine();

                        System.out.print("E-mail do usuário: ");
                        email = scanner.nextLine();

                        try {

                            biblioteca.emprestarLivro(titulo, email);

                        } catch (LivroIndisponivelException e) {

                            System.out.println(e.getMessage());

                        }

                        break;

                    case 11:

                        System.out.print("Título do livro: ");
                        titulo = scanner.nextLine();

                        biblioteca.devolverLivro(titulo);

                        break;

                    case 12:

                        biblioteca.listarDisponiveis();

                        break;

                    case 13:

                        biblioteca.listarEmprestados();

                        break;

                    case 14:

                        biblioteca.agruparPorAutor();

                        break;

                    case 15:

                        biblioteca.salvarDados();

                        System.out.println("Dados salvos com sucesso!");

                        break;

                    case 16:

                        System.out.print("Digite o título do livro: ");
                        titulo = scanner.nextLine();

                        biblioteca.removerLivro(titulo);

                        break;

                    case 0:

                        biblioteca.salvarDados();

                        System.out.println("\nSistema encerrado!");
                        break;

                    default:

                        System.out.println("Opção inválida!");

                }

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números.");

                scanner.nextLine();

            }

        }

        scanner.close();

    }

}