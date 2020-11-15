package br.org.project.personal;

import org.junit.Test;

import br.org.project.personal.API;
import br.org.project.personal.ItemCrudResult;
import br.org.project.personal.LoginResult;
import br.org.project.personal.UserCrudResult;
import br.org.project.personal.models.Item;

import static org.junit.Assert.*;

import java.util.List;

public class TestCases {

    private API apiReference = new API();

    //CT01
    @Test
    public void testLoginSuccess() {
        LoginResult result = apiReference.doLogin("marivaldo", "123456");
        assertEquals(LoginResult.OK, result);
    }
    
    //CT05
    @Test
    public void testInvalidUser() {
        LoginResult result = apiReference.doLogin("marivado", "123456");
        assertEquals(LoginResult.INVALID_USER, result);
    }
    
    //CT06
    @Test
    public void testInvalidPassword() {
        LoginResult result = apiReference.doLogin("marivaldo", "12345");
        assertEquals(LoginResult.INVALID_PASSWORD, result);
    }
    
    //CT07
    @Test
    public void testAddUserOk() {
        UserCrudResult result = apiReference.createUser("novo", "123456", "Novo User");
        assertEquals(UserCrudResult.OK, result);
    }

    //CT09
    @Test
    public void testAddUserEmptyUsername() {
        UserCrudResult result = apiReference.createUser(null, "123456", null);
        assertEquals(UserCrudResult.ADD_EMPTY_USERNAME, result);
    }

    //CT10
    @Test
    public void testAddUserEmptyPassword() {
    	UserCrudResult result = apiReference.createUser("novo", null, "");
        assertEquals(UserCrudResult.ADD_EMPTY_PASSWORD, result);
    }

    //CT12
    @Test
    public void testGetUserItemsOk() {
        List<Item> items = apiReference.getUserItems("paulo", "c123456");
        assertFalse(items.size() == 0);
    }
    
    //CT14
    @Test
    public void testCreateItemForUserOk() {
        List<Item> items = apiReference.getUserItems("paulo", "c123456");
        assertTrue(items.size() == 0);

        ItemCrudResult result = apiReference.createItemForUser("Sapato", "Tamanho 44", 1, false, "paulo", "c123456");
        assertEquals(ItemCrudResult.OK, result);

        items = apiReference.getUserItems("paulo", "c123456");
        assertFalse(items.size() == 0);
    }

    
    //CT02    
    @Test
    public void testLoginBlankUserPassword() {
    	LoginResult result = apiReference.doLogin(null, null);
    	assertEquals(LoginResult.BLANK_USER_PASSWORD, result);
    	/*LoginResult result2 = apiReference.doLogin("", "");
    	assertEquals(LoginResult.BLANK_USER_PASSWORD, result2);*/
    }
    
    //CT03
    @Test
    public void testLoginBlankUser() {
    	LoginResult result = apiReference.doLogin(null, "123456");
    	assertEquals(LoginResult.BLANK_USER, result);
    }
    
    //CT04
    @Test
    public void testLoginBlankPassword() {
    	LoginResult result = apiReference.doLogin("marivaldo", null);
    	assertEquals(LoginResult.BLANK_PASSWORD, result);
    }
    
    //CT08
    @Test
    public void testAddUserOkBlankRealName() {
        UserCrudResult result = apiReference.createUser("novo2", "123456", "");
        assertEquals(UserCrudResult.OK, result);
    }
    
    //CT11
    @Test
    public void testAddUserNameDuplicated() {
    	UserCrudResult result = apiReference.createUser("marivaldo", "1234", "Novo User");
    	assertEquals(UserCrudResult.ADD_USER_NAME_DUPLICATED, result);
    }
    
    //CT13
    @Test
    public void testGetUserItemsInvalidLogin() {
        List<Item> items = apiReference.getUserItems("", "");
        assertNull(items);
    }
    
    //CT15
    @Test
    public void testCreateItemForUserOkBorrowedTrue() {
        List<Item> items = apiReference.getUserItems("farias", "654321");
        int aux = items.size();

        ItemCrudResult result = apiReference.createItemForUser("Garrafa", "", 1, true, "farias", "654321");
        assertEquals(ItemCrudResult.OK, result);

        items = apiReference.getUserItems("farias", "654321");
        assertTrue(items.size() == aux + 1);
    }
    
    //CT16
    @Test
    public void testCreateItemForUserAddEmptyItemName() {
    	List<Item> items = apiReference.getUserItems("novo", "123456");
        assertTrue(items.size() == 0);

        ItemCrudResult result = apiReference.createItemForUser(null, "", 1, false, "novo", "123456");
        assertEquals(ItemCrudResult.ADD_EMPTY_ITEM_NAME, result);

        items = apiReference.getUserItems("novo", "123456");
        assertTrue(items.size() == 0);
    }
    
    //CT17
    @Test
    public void testCreateItemForUserAddQuantityIsZeroOrLess() {
        List<Item> items = apiReference.getUserItems("paulo", "c123456");
        int aux = items.size();

        ItemCrudResult result = apiReference.createItemForUser("Sapato", "Tamanho 44", 0, false, "paulo", "c123456");
        assertEquals(ItemCrudResult.ADD_QUANTITY_IS_ZERO_OR_LESS, result);
        
        items = apiReference.getUserItems("paulo", "c123456");
        assertTrue(items.size() == aux);

    }
    
    //CT18  
    @Test
    public void testCreateItemForUserAddInvalidUser() {
        ItemCrudResult result = apiReference.createItemForUser("Presilha", "Vermelha", 1, false, "", "");
        assertEquals(ItemCrudResult.ADD_INVALID_USER, result);
    }
    
    //CT19
    @Test
    public void testCreateItemForUserAddItemNameDuplicated() {
        List<Item> items = apiReference.getUserItems("yasmim", "123abc");
        int aux = items.size();

        ItemCrudResult result = apiReference.createItemForUser("Copo", "de Cafe", 1, false, "yasmim", "123abc");
        assertEquals(ItemCrudResult.ADD_ITEM_NAME_DUPLICATED, result);

        items = apiReference.getUserItems("yasmim", "123abc");
        assertTrue(items.size() == aux);
    }

}
