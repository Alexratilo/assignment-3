package com.example.game;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class game extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        stage.setTitle("plane game!");
        BorderPane root=new BorderPane();
        Scene scene = new Scene(root, 800,600);
        scene.getStylesheets().add("style.css");


        ImageView plane = createShip(scene);
        ImageView cloud=createCloud(scene);

        ImageView lik=createLik(scene);
        ImageView molatsi=createMolatsi(scene);

        ImageView chen=createChen(scene);
        ImageView five=createFive(scene);
        root.getChildren().addAll(plane,cloud,lik,molatsi,five,chen);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    double x = plane.getX();
                    double y = plane.getY();

                    switch (event.getCode()) {
                        case LEFT -> plane.setX(x -10);
                        case RIGHT -> plane.setX(x +10);
                        case UP -> plane.setY(y - 10);
                        case DOWN -> plane.setY(y + 10);

                    }

                    if (plane.getBoundsInParent().intersects(cloud.getBoundsInParent())||plane.getBoundsInParent().intersects(lik.getBoundsInParent())||plane.getBoundsInParent().intersects(molatsi.getBoundsInParent())) {

                        ImageView crash = new ImageView(new Image("g.gif"));


                        scene.addEventFilter(KeyEvent.KEY_PRESSED, event1 -> {
                            double x1 = plane.getX();
                            double y1 = plane.getY();

                            switch (event.getCode()) {
                                case UP -> plane.setY(y - 0);
                                case DOWN -> plane.setY(y + 0);
                                case LEFT -> plane.setX(y -0);
                                case RIGHT -> plane.setX(y +0);

                            }
                        });

                    }
                });

        stage.setScene(scene);
        stage.show();
    }
    private ImageView createCloud(Scene scene){
        ImageView cloud = new ImageView(new Image("cloud3.png"));
        cloud.setFitWidth(100);
        cloud.setFitHeight(100);
        cloud.setY(100);
        cloud.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(12000),cloud);
        c.setByX(-2000);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return cloud;

    }

    private ImageView createLik(Scene scene){
        ImageView lik = new ImageView(new Image("lik.png"));
        lik.setFitWidth(100);
        lik.setFitHeight(100);
        lik.setY(300);
        lik.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(15000),lik);
        c.setByX(-2200);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return lik;
    }
    private ImageView createMolatsi(Scene scene){
        ImageView molatsi = new ImageView(new Image("molatsi.png"));
        molatsi.setFitWidth(100);
        molatsi.setFitHeight(100);
        molatsi.setY(300);
        molatsi.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(7000),molatsi);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return molatsi;
    }

    private ImageView createChen(Scene scene){
        ImageView chen = new ImageView(new Image("chen.png"));
        chen.setFitWidth(100);
        chen.setFitHeight(100);
        chen.setY(500);
        chen.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(6000),chen);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return chen;
    };
    private ImageView createFive(Scene scene){
        ImageView five = new ImageView(new Image("5.png"));
        five.setFitWidth(50);
        five.setFitHeight(50);
        five.setY(100);
        five.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(10000),five);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return five;
    }
    private ImageView createShip(Scene scene) {
        ImageView image = new ImageView(new Image("chopper.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(1300);
        image.setX(0);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }


    public static void main(String[] args) {
        launch();
    }
}