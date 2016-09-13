import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Calendar.*;

class mathclock{

	public static void main(String args[]){

		Calendar getTime = Calendar.getInstance();

		int time;
		int hour;
		int minute;
		int second;

		double hourX;
		double hourY;
		double minuteX;
		double minuteY;
		double secondX;
		double secondY;

		double timeR;
		double minuteR;
		double secondR;

		second = getTime.get(13);
		minute = getTime.get(12);
		hour = getTime.get(10);

		System.out.println(hour +":"+ minute +":"+ second);

		minute *= 60;
		hour *= 3600;
		time = second + minute + hour;

		second = getTime.get(13);
		minute = getTime.get(12);

		secondR = (double)second/60.0;
		minuteR = (double)minute/60.0;
		timeR = (double)time/(12.0*60.0*60.0);

		System.out.println(timeR +":"+ minuteR +":"+ secondR);
		System.out.println(time);

		hourX = hourHandX(timeR);
		hourY = hourHandY(timeR);

		minuteX = minHandX(minuteR);
		minuteY = minHandY(minuteR);

		secondX = secHandX(secondR); 
		secondY = secHandY(secondR);

		System.out.println(hourX + "	:	" + hourY);
		System.out.println(minuteX + "	:	" + minuteY);
		System.out.println(secondX + "	:	" + secondY);

	}

// x and y must be switched so use sin for x val and cos for y val
///////////////////////////////////////////

	public static double hourHandX(double timeR){

		double x;
		double theta;

		theta = 2*Math.PI*timeR;
		x = Math.sin(theta);

		return x;

	}

	public static double hourHandY(double timeR){

		double y;
		double theta;

		theta = 2*Math.PI*timeR;
		y = Math.cos(theta);

		return y;

	}

///////////////////////////////////////////
		
	public static double minHandX(double minuteR){

		double x;
		double theta;

		theta = 2*Math.PI*minuteR;
		x = Math.sin(theta);

		return x;

	}

	public static double minHandY(double minuteR){

		double y;
		double theta;

		theta = 2*Math.PI*minuteR;
		y = Math.cos(theta);

		return y;

	}

///////////////////////////////////////////

	public static double secHandX(double secondR){

		double x;
		double theta;

		theta = 2*Math.PI*secondR;
		x = Math.sin(theta);

		return x;

	}

	public static double secHandY(double secondR){

		double y;
		double theta;

		theta = 2*Math.PI*secondR;
		y = Math.cos(theta);

		return y;

	}

}




