module com.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;
    requires java.naming;
    opens com.main to javafx.fxml;
    opens com.DAO to javafx.base;
    exports com.main;
}
