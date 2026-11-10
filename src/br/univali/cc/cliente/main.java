package br.univali.cc.cliente;
import br.univali.cc.dominio.Projeto;
import java.util.Scanner;

/**
 *
 * @author 8640033
 */
public class main {
private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SisCOAP - Orçamentos Aplicados a Projetos ===\n");

        Projeto projeto = solicitarDadosProjeto();

        boolean continuar;
        do {
            char tipo = lerOpcao("Tipo de despesa ('A' aquisição, 'M' mão de obra): ", "AM");
            if (tipo == 'A') {
                lerAquisicao(projeto);
            } else {
                lerMaoObra(projeto);
            }
            continuar = lerOpcao("Adicionar outra despesa? ('S' sim, 'N' não): ", "SN") == 'S';
        } while (continuar);

        System.out.printf("%nCusto do projeto:    R$ %,.2f%n", projeto.calcularCustoTotal());
        System.out.printf("Valor final cliente: R$ %,.2f%n", projeto.calcularPrecoFinal());
    }

    private static Projeto solicitarDadosProjeto() {
        System.out.print("Nome do projeto: ");
        String nome = teclado.nextLine();
        System.out.print("Data de início: ");
        String inicio = teclado.nextLine();
        System.out.print("Data de término: ");
        String fim = teclado.nextLine();
        double percentual = lerDouble("Percentual de lucro (ex.: 50 para 50%): ");
        return new Projeto(nome, inicio, fim, percentual / 100.0);
    }

    private static void lerAquisicao(Projeto projeto) {
        System.out.print("Descrição: ");
        String descricao = teclado.nextLine();
        double valor = lerDouble("Valor unitário: ");
        int qtde = lerInt("Quantidade de itens: ");
        projeto.adicionarDespesa(descricao, valor, qtde);
    }

    private static void lerMaoObra(Projeto projeto) {
        System.out.print("Descrição: ");
        String descricao = teclado.nextLine();
        char dificuldade = lerOpcao("Dificuldade ('F' fácil, 'M' médio, 'D' difícil): ", "FMD");
        int horas = lerInt("Horas de trabalho: ");
        projeto.adicionarDespesa(descricao, horas, dificuldade);
    }

    private static char lerOpcao(String mensagem, String validas) {
        while (true) {
            System.out.print(mensagem);
            String s = teclado.nextLine().trim().toUpperCase();
            if (s.length() == 1 && validas.indexOf(s.charAt(0)) >= 0) {
                return s.charAt(0);
            }
            System.out.println("Opção inválida.");
        }
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(teclado.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
            }
        }
    }
}
