package br.org.project.personal.stage;

import java.util.HashMap;
import java.util.LinkedHashMap;

import br.org.project.personal.models.Item;
import br.org.project.personal.models.User;

public class Database {
    private static HashMap<String, User> dataStoreUser = new LinkedHashMap<String, User>();
    private static HashMap<String, Item> dataStoreItem = new LinkedHashMap<String, Item>();

    static {
        User user1 = new User("marivaldo", "123456", "Marivaldo Albuquerque");
        User user2 = new User("luciano", "abcdef", "Luciano Cavalcante");
        User user3 = new User("yasmim", "123abc", "Yasmim Souza");
        User user4 = new User("farias", "654321", "Leandro Farias");
        User user5 = new User("paulo", "c123456", "Paulo Mendonça");

        Item item1 = new Item("Celular", "iPhone 6 32 GB Branco", 1, false);//
        Item item2 = new Item("Bolsa", "Samsonite Note", 1, false);//
        Item item3 = new Item("Caderno", "Caderno da Escola", 2, false);//
        Item item4 = new Item("Caneta", "BIC Cristal Azul", 1, true);//
        Item item5 = new Item("Mouse", "Logitech prata", 1, true);//
        Item item6 = new Item("Copo", "Térmico Vermelho", 1, false);//
        Item item7 = new Item("Chocolate", "Sonho de valsa", 2, false);//
        Item item8 = new Item("Cadeira", "De escritório reclinável", 1, false);//
        Item item9 = new Item("Jacketa", "Verde de couro", 1, true);//
        Item item10 = new Item("PostIt", "Bloco de cor rosa", 2, false);//
        Item item11 = new Item("Monitor", "Dell", 1, false);//
        Item item12 = new Item("Cabo HDMI", "2 metros", 1, true);
        Item item13 = new Item("Carregador", "Novo de iPhone", 1, false);//
        Item item14 = new Item("Pincel", "Azul para quadro branco", 2, true);//


        user1.addItem(item1);
        user1.addItem(item3);
        user1.addItem(item9);

        user2.addItem(item14);
        user2.addItem(item6);
        user2.addItem(item8);

        user3.addItem(item13);
        user3.addItem(item2);
        user3.addItem(item10);
        user3.addItem(item11);
        user3.addItem(item12);

        user4.addItem(item4);
        user4.addItem(item5);
        user4.addItem(item7);

        dataStoreUser.put(user1.getName(), user1);
        dataStoreUser.put(user2.getName(), user2);
        dataStoreUser.put(user3.getName(), user3);
        dataStoreUser.put(user4.getName(), user4);
        dataStoreUser.put(user5.getName(), user5);

        dataStoreItem.put(item1.getName(), item1);
        dataStoreItem.put(item2.getName(), item2);
        dataStoreItem.put(item3.getName(), item3);
        dataStoreItem.put(item4.getName(), item4);
        dataStoreItem.put(item5.getName(), item5);
        dataStoreItem.put(item6.getName(), item6);
        dataStoreItem.put(item7.getName(), item7);
        dataStoreItem.put(item8.getName(), item8);
        dataStoreItem.put(item9.getName(), item9);
        dataStoreItem.put(item10.getName(), item10);
        dataStoreItem.put(item11.getName(), item11);
        dataStoreItem.put(item12.getName(), item12);
        dataStoreItem.put(item13.getName(), item13);
        dataStoreItem.put(item14.getName(), item14);

    }

    public static HashMap<String, User> getDataStoreUser() {
        return dataStoreUser;
    }

    public static HashMap<String, Item> getDataStoreItem() {
        return dataStoreItem;
    }

}
