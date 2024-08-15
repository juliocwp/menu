package restaurante;

import dal.ConnectionModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static java.lang.System.exit;

public class Menu {
    private final Connection connection;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        this.connection = ConnectionModule.connection();
    }


    /**
     * INICIA O MENU
     *
     */
    public void iniciarMenu() {
        this.mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        int numeroMenu;
        do {
            printarMenuPrincipal();
            numeroMenu = chamaScanner(Integer.class);

            switch (numeroMenu) {
                // PRintar Alimento
                case 3:
                    this.printarProdutos(2);
                    break;
                // Printar Bebidas
                case 2:
                    //for each -> para cada
                    this.printarProdutos(1);
                    break;
                case 1:
                    chamaMenuAdmin();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    //encerrar programa
                    exit(0);
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
        System.out.println("3- Printar Alimentos");
        System.out.println("2- Printar Bebidas");
        System.out.println("1- Menu Admin");
        System.out.println("0- Sair");
        System.out.println("===========================");
        System.out.print("Digite um número: ");
    }

    private void chamaMenuAdmin() {
        int numeroMenuAdm;
        do {
            printarMenuAdm();

            numeroMenuAdm = chamaScanner(Integer.class);//scanner.nextInt();

            switch (numeroMenuAdm) {
                //cadastro de alimentos
                case 6:
                    // CRUD -> CREATE READ UPDATE E DELETE
                    // CREATE -> INSERT ( Inserir dados em uma tabela do banco )

                    System.out.println("informe o nome do produto: ");
                    String nomeProduto = scanner.next();
                    System.out.println("informe o preço do produto: ");
                    double precoProduto = scanner.nextDouble();

                    this.inserirProduto(nomeProduto, precoProduto, 2L);

                    break;
                //cadastro de bebidas
                case 5:
                    System.out.println("Nome da bebida: ");
                    String nomeBebida = scanner.next();
                    System.out.println("Preço da bebida: ");
                    double precoBebida = scanner.nextDouble();

                    this.inserirProduto(nomeBebida, precoBebida, 1L);
                    break;
                //alterar alimento por código

                case 4: // CRUD -> UPDATE
                    // Pedir o código do produto
                    System.out.println("Insira o código do produto que você deseja atualizar: ");
                    Long codigoProduto = scanner.nextLong();
                    try {
                        PreparedStatement pst = this.connection.prepareStatement("SELECT * from produto where prod_id = ?");
                        pst.setLong(1, codigoProduto);
                        ResultSet rs = pst.executeQuery();

                        int count = 0;

                        while(rs.next()) {
                            if(count > 0) {
                                break;
                            }
                            int id = rs.getInt("prod_id"); // Substitua 'id' pelos nomes das colunas da sua tabela
                            String nome = rs.getString("prod_desc");
                            double preco = rs.getDouble("prod_price");
                            long cat_id = rs.getLong("cat_id");
                            System.out.println("Informações atuais => ID: " + id + ", Nome: " + nome + ", Preço: " + preco + " categoria : " + cat_id);
                            count += 1;
                        }

                        if(count == 0){
                            System.out.println("O produto de id " + codigoProduto + " não existe na base de dados!");
                            break;
                        }

                        System.out.println("Insira o novo nome do produto: ");
                        String novoNomeProduto = scanner.next();
                        System.out.println("Insira o novo preço do produto: ");
                        double novoPrecoProduto = scanner.nextDouble();
                        System.out.println("Insira a nova categoria do produto: ");
                        Long novaCatProduto = scanner.nextLong();

                        PreparedStatement pstUpdate = this.connection.prepareStatement("UPDATE produto set prod_desc = ?, prod_price = ?, cat_id = ? WHERE prod_id = ?");
                        pstUpdate.setString(1,novoNomeProduto);
                        pstUpdate.setDouble(2,novoPrecoProduto);
                        pstUpdate.setLong(3, novaCatProduto);
                        pstUpdate.setLong(4, codigoProduto);
                        int resultado = pstUpdate.executeUpdate();
                        if(resultado == 1){
                            System.out.println("Produto atualizado com sucesso!");
                        } else {
                            System.out.println("Não foi possível atualizar o produto de ID: " + codigoProduto);
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                    // Consultar no banco se esse produto existe
                    //  CASO SIM : Mostrar as informações do produto
                    //  CASO NÃO : Dizer que o produto informado não existe e voltar pro menu admin
                    // Pedir os novos valores do produto
                    // Salvar as alterações do produto
                    break;
                // consulta de produtos
                case 2:
                    // consulta mais especifica
                    System.out.println("Informe algum valor para pesquisa (ID ou Descrição ou Preço ou Categoria do Produto ):");
                    String filter = scanner.next();
                    filter = "%"+filter+"%";

                    try {
                        PreparedStatement pst = this.connection.prepareStatement("SELECT * FROM PRODUTO WHERE CAST(prod_id AS CHAR) LIKE ? OR prod_desc LIKE ? OR CAST(prod_price AS CHAR) LIKE ? OR CAST(cat_id AS CHAR) LIKE ?");
                        pst.setString(1, filter);
                        pst.setString(2, filter);
                        pst.setString(3, filter);
                        pst.setString(4, filter);
                        ResultSet rs = pst.executeQuery();

                        while(rs.next()) {
                            int id = rs.getInt("prod_id");
                            String nome = rs.getString("prod_desc");
                            double preco = rs.getDouble("prod_price");
                            long cat_id = rs.getLong("cat_id");
                            System.out.println("ID: " + id + ", Nome: " + nome + ", Preço: " + preco + " categoria : " + cat_id);
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

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
        System.out.println("4- Alterar Produto por código");
        System.out.println("2- Consulta de Produtos");
        System.out.println("0- Voltar");
        System.out.println("============================");
    }

    private void inserirProduto(String prodDesc, double prodPrice, Long catId) {
        try {
            PreparedStatement pst = this.connection.prepareStatement("INSERT INTO PRODUTO(prod_desc, prod_price, cat_id) VALUES (?, ?, ?)");
            pst.setString(1, prodDesc);
            pst.setDouble(2, prodPrice);
            pst.setLong(3, catId);
            pst.execute();
        } catch (SQLException e) {

        }
    }

    private void printarProdutos(int tipoCategoria) {
        try {
            PreparedStatement pst = this.connection.prepareStatement("SELECT p.* FROM Produto p WHERE p.cat_id = ? ");
            pst.setString(1, String.valueOf(tipoCategoria));
            ResultSet rs = pst.executeQuery();

            // Iterar sobre o ResultSet e imprimir os resultados
            while (rs.next()) {
                int id = rs.getInt("prod_id"); // Substitua 'id' pelos nomes das colunas da sua tabela
                String nome = rs.getString("prod_desc");
                double preco = rs.getDouble("prod_price");
                long cat_id = rs.getLong("cat_id");

                // Adicione aqui as outras colunas que você deseja imprimir

                System.out.println("ID: " + id + ", Nome: " + nome + ", Preço: " + preco + " categoria : " + cat_id);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível consultar os alimentos do banco de dados!");
        }
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
