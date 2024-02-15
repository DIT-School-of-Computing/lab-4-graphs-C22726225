package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};

	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	void randomize()
	{
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = random(400);
		}
	}

	public void settings()
	{
		size(500, 500);

		String[] m1 = months;
		// months[0] = "XXX";
		print(m1[0]);
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(HSB);
		background(0);
		randomize();
	}
	
	public void draw()
	{	

		background(0);
		stroke(0,0,1000);
		float leftOffset = width * 0.1f;
		float rightOffset = width - (width * 0.1f);
		float w = (rightOffset - leftOffset) / months.length;
		float h = height - (height * 0.1f);
		float barOffset = h;
		float monthOffset = barOffset + (height * 0.05f);
		int numMeasure = 0;
		line(map(0, 0, months.length, leftOffset - 1, rightOffset), h, map(0, 0, months.length, leftOffset - 1, rightOffset), height * 0.1f);
		noFill();
		fill (0, 0, 1000);
		text("Rainfall Bar Chart", (width/2.3f), height * 0.05f);
		
		for(int i = 0 ; i < months.length ;  i ++)
		{
			fill (0, 0, 1000);
			line(map(0, 0, months.length, leftOffset - 1, rightOffset), barOffset, leftOffset - 10, barOffset);
			
			text(numMeasure, map(0, 0, months.length, leftOffset - (width * 0.08f), rightOffset), barOffset);
			if (i < months.length - 4)
			{
				numMeasure += 20;
				barOffset -= height * 0.1f;
			}
			fill(map(i, 0, months.length, 0, 255), 255, 255);
			float x = map1(i, 0, months.length, leftOffset, rightOffset);
			rect(x, h, w, -rainfall[i]);
			fill (0, 0, 1000);
			text(months[i], x + (width * 0.02f), monthOffset);
		}
	}
}
