import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Biblioteca {

    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {

        livros = Persistencia.carregarLivros();
        usuarios = Persistencia.carregarUsuarios();

    }

    // CADASTRAR LIVRO

    public void cadastrarLivro(Livro livro) {

        boolean existe = livros.stream()

                .anyMatch(l -> l.getTitulo()
                        .equalsIgnoreCase(livro.getTitulo()));

        if (existe) {

            System.out.println("Já existe um livro com esse título.");
            return;

        }

        livros.add(livro);

        Persistencia.salvarLivros(livros);

        System.out.println("Livro cadastrado com sucesso!");

    }

    // CADASTRAR USUÁRIO

    public void cadastrarUsuario(Usuario usuario) {

        boolean existe = usuarios.stream()

                .anyMatch(u -> u.getEmail()
                        .equalsIgnoreCase(usuario.getEmail()));

        if (existe) {

            System.out.println("Já existe um usuário com esse e-mail.");
            return;

        }

        usuarios.add(usuario);

        Persistencia.salvarUsuarios(usuarios);

        System.out.println("Usuário cadastrado com sucesso!");

    }

    // LISTAR LIVROS

    public void listarLivros() {

        if (livros.isEmpty()) {

            System.out.println("\nNenhum livro cadastrado.");
            return;

        }

        livros.forEach(livro -> {

            System.out.println("-------------------------");
            System.out.println(livro);

        });

    }

    // LISTAR USUÁRIOS

    public void listarUsuarios() {

        if (usuarios.isEmpty()) {

            System.out.println("\nNenhum usuário cadastrado.");
            return;

        }

        usuarios.forEach(usuario -> {

            System.out.println("-------------------------");
            System.out.println(usuario);

        });

    }

    // BUSCAR LIVRO

    public Optional<Livro> buscarLivro(String titulo) {

        return livros.stream()

                .filter(l -> l.getTitulo()
                        .equalsIgnoreCase(titulo))

                .findFirst();

    }

    // BUSCAR USUÁRIO

    public Optional<Usuario> buscarUsuario(String email) {

        return usuarios.stream()

                .filter(u -> u.getEmail()
                        .equalsIgnoreCase(email))

                .findFirst();

    }

    // MOSTRAR LIVRO

    public void mostrarLivro(String titulo) {

        Optional<Livro> livro = buscarLivro(titulo);

        if (livro.isPresent()) {

            System.out.println(livro.get());

        } else {

            System.out.println("Livro não encontrado.");

        }

    }

    // REMOVER LIVRO

    public void removerLivro(String titulo) {

        Optional<Livro> livro = buscarLivro(titulo);

        if (livro.isPresent()) {

            livros.remove(livro.get());

            Persistencia.salvarLivros(livros);

            System.out.println("Livro removido com sucesso!");

        } else {

            System.out.println("Livro não encontrado.");

        }

    }

    // MOSTRAR USUÁRIO

    public void mostrarUsuario(String email) {

        Optional<Usuario> usuario = buscarUsuario(email);

        if (usuario.isPresent()) {

            System.out.println(usuario.get());

        } else {

            System.out.println("Usuário não encontrado.");

        }

    }

    // EMPRÉSTIMO

    public void emprestarLivro(String titulo, String email)
            throws LivroIndisponivelException {

        Optional<Livro> livro = buscarLivro(titulo);
        Optional<Usuario> usuario = buscarUsuario(email);

        if (livro.isEmpty()) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (usuario.isEmpty()) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        if (livro.get().isEmprestado()) {
            throw new LivroIndisponivelException(
                    "O livro já está emprestado.");
        }

        livro.get().setEmprestado(true);

        Persistencia.salvarLivros(livros);

        System.out.println("\nLivro emprestado com sucesso!");
        System.out.println("Usuário: " + usuario.get().getNome());
        System.out.println("Livro: " + livro.get().getTitulo());

    }

    // DEVOLVER LIVRO

    public void devolverLivro(String titulo) {

        Optional<Livro> livro = buscarLivro(titulo);

        if (livro.isEmpty()) {

            System.out.println("Livro não encontrado.");
            return;

        }

        if (!livro.get().isEmprestado()) {

            System.out.println("Este livro já está disponível.");
            return;

        }

        livro.get().setEmprestado(false);

        Persistencia.salvarLivros(livros);

        System.out.println("Livro devolvido com sucesso!");

    }

    // ORDENAR POR TÍTULO

    public void ordenarPorTitulo() {

        List<Livro> copia = new ArrayList<>(livros);

        Collections.sort(copia);

        copia.forEach(System.out::println);

    }

    // ORDENAR POR ANO

    public void ordenarPorAno() {

        livros.stream()

                .sorted(Comparator.comparingInt(
                        Livro::getAnoPublicacao))

                .forEach(System.out::println);

    }

    // FILTRAR POR AUTOR

    public void listarPorAutor(String autor) {

        List<Livro> resultado = livros.stream()

                .filter(l -> l.getAutor()
                        .equalsIgnoreCase(autor))

                .collect(Collectors.toList());

        if (resultado.isEmpty()) {

            System.out.println("Nenhum livro encontrado.");

            return;

        }

        resultado.forEach(System.out::println);

    }

    // LIVROS DISPONÍVEIS

    public void listarDisponiveis() {

        livros.stream()

                .filter(l -> !l.isEmprestado())

                .forEach(System.out::println);

    }

    // LIVROS EMPRESTADOS

    public void listarEmprestados() {

        livros.stream()

                .filter(Livro::isEmprestado)

                .forEach(System.out::println);

    }

    // AGRUPAR POR AUTOR

    public void agruparPorAutor() {

        Map<String, List<Livro>> grupos =

                livros.stream()

                        .collect(Collectors.groupingBy(
                                Livro::getAutor));

        grupos.forEach((autor, lista) -> {

            System.out.println("\nAutor: " + autor);

            lista.forEach(System.out::println);

        });

    }

    // SALVAR DADOS

    public void salvarDados() {

        Persistencia.salvarLivros(livros);
        Persistencia.salvarUsuarios(usuarios);

    }
}