package br.org.project.personal;

public enum ItemCrudResult {
    OK,
    ADD_EMPTY_ITEM_NAME,
    ADD_QUANTITY_IS_ZERO_OR_LESS,
    ADD_EMPTY_USER_NAME,
    ADD_INVALID_USER, 
    ADD_ITEM_NAME_DUPLICATED
}
