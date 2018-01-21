package sample;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Tile extends Circle{

    private Piece piece;

    public boolean hasPiece(){
        return piece != null;
    }

    public Piece getPiece(){
        return piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public Tile(int x,int y){
        setRadius(20);

        relocate(x * 20, y * 20);

        setFill(Color.BROWN);
    }

}
