package org.first.first.util.constants;

public enum Privillages {
    RESET_ANY_USER_PASSWORD(1, "RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(2, "ACCESS_ADMIN_PANEL");

    private final Long id;
    private final String privillage;

    // Constructor
    private Privillages(long id, String privillage) {
            this.id = id;
        this.privillage = privillage;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getPrivillage() {
        return privillage;
    }
}
