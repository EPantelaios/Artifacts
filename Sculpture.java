public class Sculpture extends Masterpiece{
	
	private final double volume;
	private final MaterialEnum material;
	
	public Sculpture(final String creator, final int year, final MovementEnum movement, ConditionEnum condition,
			  										final double volume, final MaterialEnum material){
		
		super(creator, year, movement, condition);
		this.volume=volume;
		this.material=material;
		System.out.println("Creating an instance of class Sculpture");
		System.out.println();
	}
	
	public void getInfo() {
		super.getInfo();
		System.out.println("Volume is " + volume + " and material is " + material);
	}
	
	public boolean evaluate(MovementEnum m, ConditionEnum c) {
		
		if(m.equals(movement)) {
			
			if(c==ConditionEnum.bad)
				return true;
			else if(c==ConditionEnum.good && condition==ConditionEnum.good) 
				return true;
			else if(c==ConditionEnum.excellent && condition==ConditionEnum.excellent)
				return true;
			else 
				return false;
		}
		else 
			return false;
	}
	
	public boolean evaluate(MovementEnum m) {
		return(evaluate(m,ConditionEnum.excellent));
	}	
}