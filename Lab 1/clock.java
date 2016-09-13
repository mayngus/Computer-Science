import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Calendar.*;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.AnimationTimer;
import javafx.event.*;
import javafx.animation.*;




public class clock extends Application{

	public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage){

    	stage.setTitle("JavaFX Window");

    	double width = 700;
    	double height = 700;

    	Group rootNode = new Group();
    	Scene myScene = new Scene(rootNode, width, height);
		stage.setScene(myScene);
		Canvas myCanvas = new Canvas(width, height);
		GraphicsContext gc = myCanvas.getGraphicsContext2D();


		double radiusX = 250;
		double radiusY = 250;
		double centerX = width/2;
		double centerY = height/2;


		Ellipse clockTrim = new Ellipse(centerX, centerY, radiusX+5, radiusY+5);
		Ellipse clock = new Ellipse(centerX, centerY, radiusX, radiusY);
		Ellipse origin = new Ellipse(centerX, centerY, 7, 7);
		clockTrim.setFill(Color.BLACK);
		clock.setFill(Color.WHITE);
		origin.setFill(Color.BLACK);

		Line hourL = new Line();
		Line minuteL = new Line();
		Line secondL = new Line();

		hourL.setStrokeWidth(10);
		minuteL.setStrokeWidth(4);
		secondL.setStrokeWidth(2);
		secondL.setStroke(Color.RED);

		double hourLength = 0.4;
		double minuteLength = 0.9;
		double secondLength = 0.95;

		int i;
		int fatTickCount = 0;
		int tickCount = 0;
		double angle = 0.0;
		double angleR;
		
		Line[] arrayT = new Line[48];
		Line[] arrayFT = new Line[12];

		rootNode.getChildren().addAll(myCanvas, clockTrim, clock);
		
		for(i = 0 ; i < arrayFT.length ; i++){
			arrayFT[i] = new Line();
		}

		for(i = 0 ; i < arrayT.length ; i++){
			arrayT[i] = new Line();
		}


		for(i = 0; i < 60; i++){

			if(angle%30 == 0.0 || angle == 0){

				arrayFT[fatTickCount].setStrokeWidth(4);
				angleR = angle/360;

				arrayFT[fatTickCount].setStartX(radiusX*0.95*timeHandX(angleR)+width/2);
				arrayFT[fatTickCount].setStartY(-1*radiusY*0.95*timeHandY(angleR)+width/2);

				arrayFT[fatTickCount].setEndX(radiusX*timeHandX(angleR)+width/2);
				arrayFT[fatTickCount].setEndY(-1*radiusY*timeHandY(angleR)+width/2);

				angle += 6;
				rootNode.getChildren().add(arrayFT[fatTickCount]);
				fatTickCount++;
				
			}

			else{

				arrayT[tickCount].setStrokeWidth(2);
				angleR = angle/360;

				arrayT[tickCount].setStartX(radiusX*0.95*timeHandX(angleR)+width/2);
				arrayT[tickCount].setStartY(-1*radiusY*0.95*timeHandY(angleR)+width/2);

				arrayT[tickCount].setEndX(radiusX*timeHandX(angleR)+width/2);
				arrayT[tickCount].setEndY(-1*radiusY*timeHandY(angleR)+width/2);

				angle += 6;
				rootNode.getChildren().add(arrayT[tickCount]);
				tickCount++;

			}

		}

		//Here the clock is actually updated and created every second. 
		new AnimationTimer(){

			public void handle(long currentNanoTime){

				//if(currentNanoTime <= currentNanoTime + 100000){
					
					int time;
					int hour;
					int minute;
					int second;
					double timeR;
					double minuteR;
					double secondR;
					Calendar getTime;

					getTime = getTime();

					second = getTime.get(13);
					minute = getTime.get(12);
					hour = getTime.get(10);

					minute *= 60;
					hour *= 3600;
					time = second + minute + hour;

					second = getTime.get(13);
					minute = getTime.get(12);
					
					secondR = (double)second/60.0;
					minuteR = (double)minute/60.0;
					timeR = (double)time/(12.0*60.0*60.0);

					hourL.setStartX(width/2);
					hourL.setStartY(height/2);

					minuteL.setStartX(width/2);
					minuteL.setStartY(height/2);

					secondL.setStartX(width/2);
					secondL.setStartY(height/2);

					/////////////////////////////////////

					hourL.setEndX(radiusX*hourLength*timeHandX(timeR)+width/2);
					hourL.setEndY(-1*radiusX*hourLength*timeHandY(timeR)+height/2);

					minuteL.setEndX(radiusX*minuteLength*timeHandX(minuteR)+width/2);
					minuteL.setEndY(-1*radiusX*minuteLength*timeHandY(minuteR)+height/2);

					secondL.setEndX(radiusX*secondLength*timeHandX(secondR)+width/2);
					secondL.setEndY(-1*radiusX*secondLength*timeHandY(secondR)+height/2);

				//}

			}

		}.start();


		rootNode.getChildren().addAll(hourL, minuteL, secondL, origin);
		stage.show();

    }

    public static Calendar getTime(){
    	Calendar getTime = Calendar.getInstance();
    	return getTime;
    }

    public static double timeHandX(double timeR){

		double x;
		double theta;

		theta = 2*Math.PI*timeR;
		x = Math.sin(theta);

		return x;

	}

	public static double timeHandY(double timeR){

		double y;
		double theta;

		theta = 2*Math.PI*timeR;
		y = Math.cos(theta);

		return y;

	}

}