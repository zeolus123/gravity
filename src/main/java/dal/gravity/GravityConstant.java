package dal.gravity;

public class GravityConstant implements GravityModel{

	private double gravity;
	
	public GravityConstant(double g){
		this.gravity = g;
	}
	
	@Override
	public double getGravitationalField() {
		// TODO Auto-generated method stub
		return gravity;
	}

}
