import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    private static final String ARQUIVO_LIVROS = "livros.dat";
    private static final String ARQUIVO_USUARIOS = "usuarios.dat";

    // SALVAR LIVROS

    public static void salvarLivros(List<Livro> livros) {

        ObjectOutputStream out = null;

        try {

            out = new ObjectOutputStream(
                    new FileOutputStream(ARQUIVO_LIVROS));

            out.writeObject(livros);

        } catch (IOException e) {

            System.out.println("Erro ao salvar livros.");

        } finally {

            try {

                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {

                System.out.println("Erro ao fechar arquivo.");

            }

        }

    }

    // CARREGAR LIVROS

    @SuppressWarnings("unchecked")
    public static List<Livro> carregarLivros() {

        ObjectInputStream in = null;

        try {

            in = new ObjectInputStream(
                    new FileInputStream(ARQUIVO_LIVROS));

            return (List<Livro>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {

            return new ArrayList<>();

        } finally {

            try {

                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {

                System.out.println("Erro ao fechar arquivo.");

            }

        }

    }

    // SALVAR USUÁRIOS

    public static void salvarUsuarios(List<Usuario> usuarios) {

        ObjectOutputStream out = null;

        try {

            out = new ObjectOutputStream(
                    new FileOutputStream(ARQUIVO_USUARIOS));

            out.writeObject(usuarios);

        } catch (IOException e) {

            System.out.println("Erro ao salvar usuários.");

        } finally {

            try {

                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {

                System.out.println("Erro ao fechar arquivo.");

            }

        }

    }

    // CARREGAR USUÁRIOS

    @SuppressWarnings("unchecked")
    public static List<Usuario> carregarUsuarios() {

        ObjectInputStream in = null;

        try {

            in = new ObjectInputStream(
                    new FileInputStream(ARQUIVO_USUARIOS));

            return (List<Usuario>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {

            return new ArrayList<>();

        } finally {

            try {

                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {

                System.out.println("Erro ao fechar arquivo.");

            }

        }

    }
}