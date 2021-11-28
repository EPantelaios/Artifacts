public abstract class Masterpiece extends Artifact{
	protected final MovementEnum movement;
	protected ConditionEnum condition;
	
	public Masterpiece(final String creator, final int year, final MovementEnum movement, ConditionEnum condition) {
		super(creator, year);
		this.movement=movement;
		this.condition=condition;
		System.out.println("Creating an instance of class Masterpiece");
	}

	public void getInfo() {
		super.getInfo();
		System.out.println("Movemevent is " + movement + " and Condition is " + condition);
	}
	
	public abstract boolean evaluate(MovementEnum m, ConditionEnum c);
	public abstract boolean evaluate(MovementEnum m);
}