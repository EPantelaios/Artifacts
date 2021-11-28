public class Painting extends Masterpiece{

	private final double length;
	private final double width;
	private final TechniqueEnum technique;
	
	public Painting(final String creator, final int year, final MovementEnum movement, ConditionEnum condition,
									final double length, final double width, final TechniqueEnum technique){
		
		super(creator, year, movement, condition);
		this.length=length;
		this.width=width;
		this.technique=technique;
		System.out.println("Creating an instance of class Painting");
		System.out.println();
	}
	
	public void getInfo(){
		super.getInfo();
		System.out.println("Length is " + length + ", Width is " + width + " and Technique is " + technique);
		System.out.println("Painting surface is " + length*width); 
	}
	
	public boolean evaluate(MovementEnum m, ConditionEnum c){
		
		if(m.equals(movement)) {
			
			if(c==ConditionEnum.bad)
				return true;
			else if(c==ConditionEnum.good && condition!=ConditionEnum.bad) 
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
		return(evaluate(m,ConditionEnum.good));
	}
}