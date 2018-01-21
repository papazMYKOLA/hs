package sample;

public enum PieceType{
    GREEN(1), YELLOW(2), ORANGE(3), BLUE(4), GREY(5), WHITE(6);

    final int moveDir;

    PieceType(int moveDir){
        this.moveDir = moveDir;
    }
}
