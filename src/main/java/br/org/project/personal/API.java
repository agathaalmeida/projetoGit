package br.org.project.personal;

import java.util.HashMap;
import java.util.List;

import br.org.project.personal.models.Item;
import br.org.project.personal.models.User;
import br.org.project.personal.stage.Database;

public class API {

    private HashMap<String, User> usersDatabase = Database.getDataStoreUser();
    private HashMap<String, Item> itemDatabase = Database.getDataStoreItem();

    /**
     * Simula um método de Login
     * 
     * @param username Nome do usuário. Valores nulos ou vazios serão considerados inválidos.
     * @param password Senha do usuário. Valores nulos ou vazios serão considerados inválidos.
     * @return {@link LoginResult} Com o status da operação.
     */
    public LoginResult doLogin(String username, String password) {

        if ((username == null || username.trim().isEmpty()) && (password == null || password.trim().isEmpty())) {
            return LoginResult.BLANK_USER_PASSWORD;
        }

        if (username == null || username.trim().isEmpty()) {
            return LoginResult.BLANK_USER;
        }

        if (password == null || password.trim().isEmpty()) {
            return LoginResult.BLANK_PASSWORD;
        }

        if (!usersDatabase.containsKey(username)) {
            return LoginResult.INVALID_USER;
        } else {
            User user = usersDatabase.get(username);
            if (user.getPassword().equals(password)) {
                return LoginResult.OK;
            } else {
                return LoginResult.INVALID_PASSWORD;
            }
        }
    }

    /**
     * Simular a criação de um usuário novo na base de dados.
     * 
     * @param username Nome do usuário. Valores nulos ou vazios serão considerados inválidos. Valor deve ser único na
     *        database.
     * @param password Senha do usuário. Valores nulos ou vazios serão considerados inválidos.
     * @param realName Nome real. Valor opcional.
     * @return {@link UserCrudResult} Com o status da operação.
     */
    public UserCrudResult createUser(String username, String password, String realName) {
        if (username == null || username.trim().isEmpty()) {
            return UserCrudResult.ADD_EMPTY_USERNAME;
        }

        if (password == null || password.trim().isEmpty()) {
            return UserCrudResult.ADD_EMPTY_PASSWORD;
        }

        if (usersDatabase.containsKey(username)) {
            return UserCrudResult.ADD_USER_NAME_DUPLICATED;
        }

        User user = new User(username, password, realName);
        usersDatabase.put(user.getName(), user);

        return UserCrudResult.OK;
    }

    /**
     * 
     * @param username Nome do usuário. Valores nulos ou vazios serão considerados inválidos.
     * @param password Senha do usuário. Valores nulos ou vazios serão considerados inválidos.
     * @return Lista de {@link Item}. Retorna <code>null</code> em caso de login invalido, caso contrário conterá os
     *         itens do usuário de 0 a N.
     */
    public List<Item> getUserItems(String username, String password) {
        LoginResult result = doLogin(username, password);
        if (result != LoginResult.OK)
            return null;

        User user = usersDatabase.get(username);

        return user.getMyItems();
    }


    /**
     * 
     * @param itemName Nome do usuário. Valores nulos ou vazios serão considerados inválidos. Valor deve ser único na
     *        database.
     * @param itemDescription Descrição opcional do item.
     * @param itemQuantity Quantidade de itens. Valores iguais ou menores que 0 serão considerados inválidos.
     * @param itemIsBorrowed Indica se o item está emprestado ou não.
     * @param ownerUsername Nome do usuário dono do item. Valores nulos ou vazios serão considerados inválidos.
     * @param ownerPassword Senha do usuário dono do item. Valores nulos ou vazios serão considerados inválidos.
     * @return
     */
    public ItemCrudResult createItemForUser(String itemName, String itemDescription, int itemQuantity,
            boolean itemIsBorrowed, String ownerUsername, String ownerPassword) {
        if (itemName == null || itemName.trim().isEmpty()) {
            return ItemCrudResult.ADD_EMPTY_ITEM_NAME;
        }

        if (itemQuantity <= 0) {
            return ItemCrudResult.ADD_QUANTITY_IS_ZERO_OR_LESS;
        }

        LoginResult result = doLogin(ownerUsername, ownerPassword);
        if (result != LoginResult.OK) {
            return ItemCrudResult.ADD_INVALID_USER;
        }

        if (itemDatabase.containsKey(itemName)) {
            return ItemCrudResult.ADD_ITEM_NAME_DUPLICATED;
        }

        Item item = new Item(itemName, itemDescription, itemQuantity, itemIsBorrowed);
        User user = usersDatabase.get(ownerUsername);

        user.addItem(item);
        itemDatabase.put(item.getName(), item);

        return ItemCrudResult.OK;
    }


}
