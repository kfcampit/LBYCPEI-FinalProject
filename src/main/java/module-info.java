module com.example.lbycpeifinalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires com.opencsv;

    opens com.example.lbycpeifinalproject to javafx.fxml;
    opens com.example.lbycpeifinalproject.seller to javafx.fxml;
    exports com.example.lbycpeifinalproject;
    exports com.example.lbycpeifinalproject.seller;
    exports com.example.lbycpeifinalproject.buyer;
}