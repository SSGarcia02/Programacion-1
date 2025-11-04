module demo_proyectofinal_fx.demoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens demo_proyectofinal_fx.demoapp to javafx.fxml;
    opens demo_proyectofinal_fx.demoapp.controller;
    opens demo_proyectofinal_fx.demoapp.viewController;

    exports demo_proyectofinal_fx.demoapp;
    exports demo_proyectofinal_fx.demoapp.model;
    exports demo_proyectofinal_fx.demoapp.controller;
    exports demo_proyectofinal_fx.demoapp.factory;
    exports demo_proyectofinal_fx.demoapp.viewController;


    //opens demo_proyectofinal_fx.demoapp.model;
}