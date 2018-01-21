package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece extends StackPane {

    private PieceType type;

    private double mouseX, mouseY;
    private double oldX, oldY;

    public PieceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }


    public Piece(PieceType type, int x, int y) {
        this.type = type;

        move(x, y);

        Circle circle = new Circle(20 * 0.7);
        if (type == PieceType.GREEN) circle.setFill(Color.GREEN);
        if (type == PieceType.ORANGE) circle.setFill(Color.ORANGE);
        if (type == PieceType.WHITE) circle.setFill(Color.WHITE);
        if (type == PieceType.BLUE) circle.setFill(Color.BLUE);
        if (type == PieceType.YELLOW) circle.setFill(Color.YELLOW);
        if (type == PieceType.GREY) circle.setFill(Color.GREY);
        //circle.setStroke(Color.BLACK);
        //circle.setStrokeWidth(TILE_SIZE*0.03);
        circle.setTranslateX((20 - 20 * 0.7));
        circle.setTranslateY((20 - 20 * 0.7));
        getChildren().addAll(circle);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void move(int x, int y){
        oldX = x*23;
        oldY = y*40;
        relocate(oldX,oldY);
    }

    public void abortMove(){
        relocate(oldX, oldY);
    }

}
