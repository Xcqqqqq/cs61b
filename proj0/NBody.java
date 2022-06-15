public class NBody{
    public static double readRadius(String file){
	In in = new In(file);
        int num = in.readInt();
	return in.readDouble();
    }
    public static Planet[] readPlanets(String file){
        In in = new In(file);
	int planetNum = in.readInt();
	double radius = in.readDouble();
	Planet[] ret = new Planet[planetNum];
	for (int i = 0; i < planetNum; i++){
            ret[i] = new Planet(in.readDouble(), in.readDouble(),
			        in.readDouble(), in.readDouble(),
				in.readDouble(), in.readString()
				);
	}
	return ret;
    }
    public static void main(String[] args){
	/** getting data from file */
        double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	double radius = readRadius(filename);
	Planet[] planets = readPlanets(filename);
	int planetNum = planets.length;
	/** draw the background */
	StdDraw.setXscale(-radius, radius);
	StdDraw.setYscale(-radius, radius);
	StdDraw.picture(0,0,"/images/starfield.jpg");
        /** draw the planets */
	for (Planet p : planets){
            p.draw();
	}
	/** animation */
	StdDraw.enableDoubleBuffering();
	double time = 0;
	while(time <= T){
            double[] xForces = new double[planetNum];
            double[] yForces = new double[planetNum];
	    for (int i = 0; i < planetNum; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
	    }
	    for (int i = 0; i < planetNum; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
	    }
	    StdDraw.picture(0,0,"/images/starfield.jpg");
	    for (Planet p : planets){
                p.draw();
	    }
            StdDraw.show();
	    StdDraw.pause(10);
	    time += dt;
	}
    }
    StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < planets.length; i++) {
	        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			      planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
			      planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
    }
}
