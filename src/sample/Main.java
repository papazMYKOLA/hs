package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;

import static sample.Main.MoveType.None;
import static sample.Main.MoveType.Normal;

public class Main extends Application {

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();

    private Tile[][] board = new Tile[25][17];

    //how to read .properties file java
    public Parent createContent(int players){
        Pane root = new Pane();
        root.setPrefSize(600, 680);
        int[] x={0,0,1,1,2,2,2,2,3,3,3,3,4,4,4,4,4,5,5,5,5,6,6,6,6,6,7,7,7,7,8,8,8,8,8,9,9,9,9,9,9,10,10,10,10,10,10,10,11,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,
                24,24,23,23,22,22,22,22,21,21,21,21,20,20,20,20,20,19,19,19,19,18,18,18,18,18,17,17,17,17,16,16,16,16,16,15,15,15,15,15,15,14,14,14,14,14,14,14,13,13,13,13,13
                ,13,13,13};
        int[] y={4,12,5,11,4,6,10,12,5,7,9,11,4,6,8,10,12,5,7,9,11,4,6,8,10,12,5,7,9,11,4,6,8,10,12,3,5,7,9,11,13,2,4,6,8,10,12,14,1,3,5,7,9,11,13,15,0,2,4,6,8,10,12,14,16,
                4,12,5,11,4,6,10,12,5,7,9,11,4,6,8,10,12,5,7,9,11,4,6,8,10,12,5,7,9,11,4,6,8,10,12,3,5,7,9,11,13,2,4,6,8,10,12,14,1,3,5,7,9,11,13,15};
        for(int i=0; i<121; i++){
            Tile tile = new Tile(x[i],y[i]);
            tile.setTranslateX(x[i]*3);
            tile.setTranslateY(y[i]*20);
            board[x[i]][y[i]] = tile;
            Piece piece =null;
            if (players==6){
                if (y[i]<=3) {
                    piece = makePiece(PieceType.BLUE, x[i], y[i]);
                }
                if (y[i]>=13) {
                    piece = makePiece(PieceType.GREEN, x[i], y[i]);
                }
                if (y[i]+x[i]<=10) {
                    piece = makePiece(PieceType.ORANGE, x[i], y[i]);
                }
                if (y[i]-x[i]>=6) {
                    piece = makePiece(PieceType.YELLOW, x[i], y[i]);
                }
                if (y[i]-x[i]<=-14) {
                    piece = makePiece(PieceType.GREY, x[i], y[i]);
                }
                if (y[i]+x[i]>=30) {
                    piece = makePiece(PieceType.WHITE, x[i], y[i]);
                }
            }
            if (players==4){
                if (y[i]>=13) {
                    piece = makePiece(PieceType.GREEN, x[i], y[i]);
                }
                if (y[i]<=3) {
                    piece = makePiece(PieceType.BLUE, x[i], y[i]);
                }
                if (y[i]+x[i]<=10) {
                    piece = makePiece(PieceType.ORANGE, x[i], y[i]);
                }
                if (y[i]+x[i]>=30) {
                    piece = makePiece(PieceType.WHITE, x[i], y[i]);
                }
            }
            if (players==3){
                if (y[i]>=13) {
                    piece = makePiece(PieceType.GREEN, x[i], y[i]);
                }
                if (y[i]+x[i]<=10) {
                    piece = makePiece(PieceType.ORANGE, x[i], y[i]);
                }
                if (y[i]-x[i]<=-14) {
                    piece = makePiece(PieceType.GREY, x[i], y[i]);
                }
            }
            if (players==2){
                if (y[i]>=13) {
                    piece = makePiece(PieceType.GREEN, x[i], y[i]);
                }
                if (y[i]<=3) {
                    piece = makePiece(PieceType.BLUE, x[i], y[i]);
                }
            }

            if (piece!=null){
                tile.setPiece(piece);
                pieceGroup.getChildren().add(piece);
            }

            tileGroup.getChildren().add(tile);
        }


        root.getChildren().addAll(tileGroup,pieceGroup);

        return root;
    }

    private MoveResult tryMove(Piece piece, int newX, int newY){
        if (Arrays.asList(board[newX][newY]).contains(null)){
            return new MoveResult(sample.MoveType.None);
        }
        if (board[newX][newY].hasPiece()) {
            return new MoveResult(sample.MoveType.None);
        }

        int x0 = toBoard(piece.getOldX()*0.86);
        int y0 = toBoard(piece.getOldY()/2);

        if ((Math.abs(newX - x0)<=2.5) && (Math.abs(newY - y0)<2)){
            return new MoveResult(sample.MoveType.Normal);
        }
        if (Math.abs(newX - x0)<=4 && (Math.abs(newY - y0)<=3) && ((newX-x0)!=0) && (Math.abs(newY - y0)!=1)){
            double x1 =(newX+x0)/2;
            double y1 =(newY+y0)/2;
            if (board[(int)x1][(int)y1].hasPiece()){
                //System.out.println("YES"+x0+" "+ y0+ "     " + newX+ " "+newY+ "     "+ x1+" "+y1);
                return new MoveResult(sample.MoveType.Normal);
            }
        }
        return new MoveResult(sample.MoveType.None);
    }

    private int toBoard(double pixel){
        return (int)(pixel + 10)/20;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setScene(new Scene(root,600,449));
        primaryStage.show();

    }

    private Piece makePiece(PieceType type, int x, int y){
        Piece piece = new Piece(type, x, y);

        piece.setOnMouseReleased(e ->{
            int newX = toBoard(piece.getLayoutX()*0.86);
            int newY = toBoard(piece.getLayoutY()/2);

            MoveResult result = tryMove(piece, newX, newY);

            int x0 = toBoard(piece.getOldX()*0.86);
            int y0 = toBoard(piece.getOldY()/2);

            switch (result.getType()){
                case None:
                    piece.abortMove();
                    break;
                case Normal:
                    piece.move(newX, newY);
                    board[x0][y0].setPiece(null);
                    board[newX][newY].setPiece(piece);
                    break;

            }
        });

        return piece;
    }

    public enum MoveType{
        None, Normal, Jump;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
