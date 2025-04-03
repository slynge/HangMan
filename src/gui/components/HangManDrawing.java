package gui.components;

import gui.utility.Emotion;
import gui.utility.Part;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import models.Game;

public class HangManDrawing extends Canvas {
    private final Game game;
    private final GraphicsContext gc;
    private final int lineWidth = 6;
    private final Runnable[] drawActions;

    public HangManDrawing(Game game, int width, int height) {
        super(width, height);
        this.game = game;
        gc = getGraphicsContext2D();
        gc.setLineWidth(lineWidth);
        this.drawActions = new Runnable[] {
                this::drawRope,
                () -> drawLeg(Part.RIGHT),
                () -> drawLeg(Part.LEFT),
                () -> drawArm(Part.RIGHT),
                () -> drawArm(Part.LEFT),
                this::drawBody,
                () -> drawSmile(Emotion.HAPPY),
                () -> drawEye(Part.RIGHT),
                () -> drawEye(Part.LEFT),
                this::drawHead,
        };
        drawGallow();
    }

    private void drawGallow() {
        gc.strokeLine(50, 195, 110, 195);
        gc.strokeLine(65, 195, 65, 45);
        gc.strokeLine(65, 45, 160, 45);
        gc.strokeLine(66, 75, 95, 46);
    }

    protected void draw() {
        int numberOfLives = game.getNumberOfLives();
        if(numberOfLives >= 0 && numberOfLives <= 9) {
            drawActions[numberOfLives].run();
        }
    }

    private void drawRope() {
        gc.strokeLine(160, 45, 160, 65);
    }

    private void drawHead() {
        gc.strokeOval(140, 65, 40, 40);
    }

    private void drawEye(Part part) {
        gc.setLineWidth(3);
        if(part == Part.LEFT) {
            gc.strokeOval(149, 75, 8, 8);
            gc.setLineWidth(1);
            gc.strokeText(".", 152, 80);
        }
        else {
            gc.strokeOval(163, 75, 8, 8);
            gc.setLineWidth(1);
            gc.strokeText(".", 166, 80);
        }
        gc.setLineWidth(lineWidth);
    }

    private void drawSmile(Emotion emotion) {
        gc.setLineWidth(3);
        if(emotion == Emotion.HAPPY) {
            gc.strokeArc(152.5, 82.5, 15, 15, 180, 180, ArcType.OPEN);
        }
        else {
            gc.strokeArc(152.5, 87.5, 15, 15, 0, 180, ArcType.OPEN);
        }
        gc.setLineWidth(lineWidth);

    }

    private void drawBody() {
        gc.strokeLine(160, 106, 160, 160);
    }

    private void drawArm(Part part) {
        if(part == Part.LEFT) {
            gc.strokeLine(160, 106, 140, 135);
        }
        else {
            gc.strokeLine(160, 106, 180, 135);
        }
    }

    private void drawLeg(Part part) {
        if(part == Part.LEFT) {
            gc.strokeLine(160, 160, 140, 189);
        }
        else {
            gc.strokeLine(160, 160, 180, 189);
        }
    }

    protected void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        drawGallow();
    }
}
