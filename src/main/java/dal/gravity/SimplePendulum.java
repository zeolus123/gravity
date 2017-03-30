package dal.gravity;

/**
 * Represents pendulums exhibiting (approximately) simple harmonic motion
 */
public class SimplePendulum extends AbstractPendulum {

    private double angularFrequency, periodOfMotion;
    private GravityModel gravityModel;
    
    /**
     * Creates a new Pendulum instance using
     * inLength: the string length (>0)
     * inMass: the point mass (>0)
     * inTheta0: angular displacement at t=0 (0<=theta0<=pi/6)
     */
    public SimplePendulum (double inLength, double inMass, double inTheta0, GravityModel gravityModel) {
    super (inLength, inMass, inTheta0, gravityModel);
    this.gravityModel = gravityModel;
	angularFrequency = calculateAngularFrequency();
	periodOfMotion = 2 * Math.PI 
	    * Math.sqrt (this.getStringLength () / this.gravityModel.getGravitationalField ());
    }
    
    
    //calculate frequency
    public double calculateAngularFrequency(){
    	return Math.sqrt (this.gravityModel.getGravitationalField () / this.getStringLength ());
    }
    
    /**
     * provides this Pendulum's angular frequency
     */ 
    public double getAngularFrequency () { return angularFrequency; }

    /**
     * provides this Pendulum's period of motion
     */ 
    public double getPeriodOfMotion () { return periodOfMotion; }

    /**
     * provides the angular displacement of this Pendulum at time t
     */
    public double getTheta (double t) {
	return this.getMaxAngularDisplacement () * Math.cos (angularFrequency * t);
    }
    
    @Override
    public void setGravityModel(GravityModel gravityModel){
    	this.gravityModel = gravityModel;
    	angularFrequency = calculateAngularFrequency();
    }
}
