public class Planet{
    private static final double G = 6.67e-11;
    /** instance variables */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    /** constructors */
    public Planet(double xP, double yP, double xV,
		  double yV, double m, String img){
        xxPos = xP;  yyPos = yP;  xxVel = xV;
	yyVel = yV;  mass = m;  imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;  yyPos = p.yyPos;  xxVel = p.xxVel;
	yyVel = p.yyVel;  mass = p.mass;  imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet other){
        double dx = this.xxPos - other.xxPos;
	double dy = this.yyPos - other.yyPos;
	return Math.sqrt(dx * dx + dy * dy);
    }
    public double calcForceExertedBy(Planet other){
	double r = this.calcDistance(other);
        return G * this.mass * other.mass / (r * r);
    }
    public double calcForceExertedByX(Planet other){
        double dx = -this.xxPos + other.xxPos;
	double r = this.calcDistance(other);
	return G * this.mass * other.mass * dx / (r * r * r);
    }
    public double calcForceExertedByY(Planet other){
        double dy = -this.yyPos + other.yyPos;
	double r = this.calcDistance(other);
	return G * this.mass * other.mass * dy / (r * r * r);
    }
    public double calcNetForceExertedByX(Planet[] others){
        double fx = 0; 
	for (int i = 0; i < others.length; i++){
	    if (!this.equals(others[i])){
                fx += calcForceExertedByX(others[i]);
	    }
	}
	return fx;
    }
    public double calcNetForceExertedByY(Planet[] others){
        double fy = 0; 
	for (int i = 0; i < others.length; i++){
	    if (!this.equals(others[i])){
                fy += calcForceExertedByY(others[i]);
	    }
	}
	return fy;
    }
    public void update(double dt, double fx, double fy){
        double ax = fx / this.mass;
	double ay = fy / this.mass;
	this.xxVel += ax * dt;
	this.yyVel += ay * dt;
	this.xxPos += this.xxVel * dt;
	this.yyPos += this.yyVel * dt;
    }
    public void draw(){
	String filePath = "/images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, filePath);
    }
}
