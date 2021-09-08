module com.example.lbycpeifinalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.lbycpeifinalproject to javafx.fxml;
    exports com.example.lbycpeifinalproject;
}