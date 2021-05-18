package util;

public enum UserType {
    VENDEDOR("Vendedor"), ADMINISTRADOR("Administrador"),  ORCAMENTISTA("Orçamentista");

    public String userType;

    UserType(String type) {
        userType = type;
    }
}
