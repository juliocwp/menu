package restaurante;

import dal.ConnectionModule;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciarMenu();
    }
}
