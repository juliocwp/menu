package restaurante;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<Produto> listaDeProdutos = new ArrayList<>();
    private Categoria categoria1 = new Categoria(1L, "Alimento");
    private Categoria categoria2 = new Categoria(2L, "Bebida");
    private int numeroMenuAdm;
    private int numeroMenu;

    /*public static void main(String[] args) {

        Produto produto1 = new Produto(1L, "Feijão", 20.0, categoria1);
        //produto1.setProd_cat(categoria1);
        //produto1.setProd_id(1L);
        //produto1.setProd_desc("Feijão");
        //produto1.setProd_price(20.0);
        listaDeProdutos.add(produto1);
        Produto produto2 = new Produto(2L, "Coca", 10.0, categoria2);
        //Produto produto2 = new Produto();
        //produto2.setProd_id(2L);
        //produto2.setProd_desc("Arroz");
        //produto2.setProd_price(15.0);
        listaDeProdutos.add(produto2);


        do {
            System.out.println("===========================");
            System.out.println("=======MENU CARDAPIO=======");
            System.out.println("===========================");
            System.out.println("4- Salvar itens no TXT");
            System.out.println("3- Printar Alimentos");
            System.out.println("2- Printar Bebidas");
            System.out.println("1- Menu Admin");
            System.out.println("0- Sair");
            System.out.println("===========================");
            System.out.print("Digite um número: ");

            // tratamento de exceção
            try {
                numeroMenu = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                numeroMenu = -1;
            }

            switch (numeroMenu) {
                case 4:
                    String nomeArquivo = "C:\\Users\\julio\\IdeaProjects\\untitled\\src\\restaurante\\produtos.txt";

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
                        for (Produto produto : listaDeProdutos) {
                            writer.write(produto.toString());
                            writer.newLine();  // Adiciona uma nova linha após cada produto
                        }
                        System.out.println("Lista de produtos foi salva em " + nomeArquivo);
                    } catch (IOException e) {
                        System.err.println("Erro ao salvar arquivo: " + e.getMessage());
                    }
                    break;
                // PRintar Alimento
                case 3:
                    //for each -> para cada
                    for (Produto prod : listaDeProdutos) {
                        Categoria cat = prod.getProd_cat();
                        if (cat.getCat_id() == 1L) {
                            System.out.println(prod);
                        }
                    }
                    break;
                // Printar Bebidas
                case 2:
                    for (Produto prod : listaDeProdutos) {
                        Categoria cat = prod.getProd_cat();
                        if (cat.getCat_id() == 2L) {
                            System.out.println(prod);
                        }
                    }
                    break;
                case 1:
                    chamaMenuAdmin();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    //encerrar programa
                    System.exit(0);
                default:
                    System.out.println("Digite um número válido.");
                    break;
            }

        } while (numeroMenu != 0);
    }*/

    /**
     * INICIA O MENU
     *
     */
    public void iniciarMenu() {
        this.mostrarMenuPrincipal();
    }
    private void mostrarMenuPrincipal() {
        do {
            printarMenuPrincipal();
            // tratamento de exceção
//            try {
//                numeroMenu = scanner.nextInt();
//            } catch (Exception e) {
//                scanner = new Scanner(System.in);
//                numeroMenu = -1;
//            }
            numeroMenu = chamaScanner(Integer.class);

            switch (numeroMenu) {
                case 4:
                    String nomeArquivo = "C:\\Users\\julio\\IdeaProjects\\untitled\\src\\restaurante\\produtos.txt";

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
                        for (Produto produto : listaDeProdutos) {
                            writer.write(produto.toString());
                            writer.newLine();  // Adiciona uma nova linha após cada produto
                        }
                        System.out.println("Lista de produtos foi salva em " + nomeArquivo);
                    } catch (IOException e) {
                        System.err.println("Erro ao salvar arquivo: " + e.getMessage());
                    }
                    break;
                // PRintar Alimento
                case 3:
                    //for each -> para cada
                    for (Produto prod : listaDeProdutos) {
                        Categoria cat = prod.getProd_cat();
                        if (cat.getCat_id() == 1L) {
                            System.out.println(prod);
                        }
                    }
                    break;
                // Printar Bebidas
                case 2:
                    for (Produto prod : listaDeProdutos) {
                        Categoria cat = prod.getProd_cat();
                        if (cat.getCat_id() == 2L) {
                            System.out.println(prod);
                        }
                    }
                    break;
                case 1:
                    chamaMenuAdmin();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    //encerrar programa
                    System.exit(0);
                default:
                    System.out.println("Digite um número válido.");
                    break;
            }

        } while (numeroMenu != 0);
    }

    private void printarMenuPrincipal() {
        System.out.println("===========================");
        System.out.println("=======MENU CARDAPIO=======");
        System.out.println("===========================");
        System.out.println("4- Salvar itens no TXT");
        System.out.println("3- Printar Alimentos");
        System.out.println("2- Printar Bebidas");
        System.out.println("1- Menu Admin");
        System.out.println("0- Sair");
        System.out.println("===========================");
        System.out.print("Digite um número: ");
    }

    private void chamaMenuAdmin() {
        do {
            printarMenuAdm();

            numeroMenuAdm = chamaScanner(Integer.class);//scanner.nextInt();

            switch (numeroMenuAdm) {
                case 6:
                    //cadastro de alimentos
                    String descricaoProd = "";
                    Double priceProd = 0.0;
                    System.out.println("============================");
                    System.out.println("====CADASTRO DE ALIMENTOS=====");
                    System.out.println("============================");
                    System.out.println("descrição: ");
                    descricaoProd = chamaScanner(String.class);
                    System.out.println("============================");
                    // Pedir pro usuário digitar o preço, salvar numa variavel
                    System.out.println("preço:  ");
                    priceProd = chamaScanner(Double.class);
                    System.out.println("============================");
                    // size = 0 + 1 -> id = 1
                    // size = 1 + 1 -> id = 2
                    // size = 2 + 1 -> id = 3
                    Produto novoProd = new Produto();
                    novoProd.setProd_id((long) (listaDeProdutos.size() + 1));
                    novoProd.setProd_desc(descricaoProd);
                    novoProd.setProd_price(priceProd);
                    novoProd.setProd_cat(categoria1);

                    listaDeProdutos.add(novoProd);

                    break;
                case 5:
                    Produto novoProdBebida = new Produto();
                    String descBebida = "";
                    double priceBebida = 0.0;
                    System.out.println("============================");
                    System.out.println("====CADASTRO DE BEBIDAS=====");
                    System.out.println("============================");
                    System.out.println("descrição: ");
                    descBebida = chamaScanner(String.class);
                    System.out.println("============================");
                    // Pedir pro usuário digitar o preço, salvar numa variavel
                    System.out.println("preço:  ");
                    priceBebida = chamaScanner(Double.class);
                    System.out.println("============================");
                    // size = 0 + 1 -> id = 1
                    // size = 1 + 1 -> id = 2
                    // size = 2 + 1 -> id = 3
                    novoProdBebida.setProd_id((long) (listaDeProdutos.size() + 1));
                    novoProdBebida.setProd_desc(descBebida);
                    novoProdBebida.setProd_price(priceBebida);
                    novoProdBebida.setProd_cat(categoria2);

                    listaDeProdutos.add(novoProdBebida);
                    break;
                //cadastro de bebidas
                case 4:
                    break;
                //alterar alimento por código
                case 3:
                    break;
                //alterar bebida por código
                case 2:
                    //consultar por nome, ou id
                    //digitar um valor
                    // aveia grossa
                    // aveia fina
                    // aveia
                    break;
                // consulta de alimentos
                case 1:
                    break;
                // consulta de bebidas
                case 0:
                    break;
                // voltar
                default:
                    System.out.println("Digite um número válido");
                    break;
            }
        } while (numeroMenuAdm != 0);
    }

    private void printarMenuAdm() {
        System.out.println("===========================");
        System.out.println("=======ADMINISTRAÇÃO=======");
        System.out.println("===========================");
        System.out.println("6- Cadastro de Alimentos");
        System.out.println("5- Cadastro de Bebidas");
        System.out.println("3- Alterar Produto por código");
        System.out.println("2- Consulta de Alimentos");
        System.out.println("1- Consulta de Bebidas");
        System.out.println("0- Voltar");
        System.out.println("============================");
    }

    private <T> T chamaScanner(Class<T> clazz){
        try {
            if (clazz.equals(Integer.class)) {
                if (scanner.hasNextInt()) {
                    return clazz.cast(scanner.nextInt());
                } else {
                    throw new IllegalArgumentException("Input não é um inteiro válido.");
                }
            } else if (clazz.equals(String.class)) {
                if (scanner.hasNext()) {
                    return clazz.cast(scanner.next());
                } else {
                    throw new IllegalArgumentException("Input não é uma string válida.");
                }
            } else if (clazz.equals(Double.class)) {
                if (scanner.hasNextDouble()) {
                    return clazz.cast(scanner.nextDouble());
                } else {
                    throw new IllegalArgumentException("Input não é valor decimal válido.");
                }
            } else {
                throw new IllegalArgumentException("Tipo não suportado.");
            }
        } catch (Exception e) {
            // Aqui você pode tratar ou registrar a exceção conforme necessário
            scanner = new Scanner(System.in);
            if (clazz.equals(Integer.class)) {
                return clazz.cast(-1); // Retorna -1 em caso de exceção
            } else
            if(clazz.equals(String.class)) {
                return clazz.cast("");
            } else
            if(clazz.equals(Double.class)){
                return clazz.cast(0.0);
            } else {
                return clazz.cast(-1);
            }
        }
    }

}
