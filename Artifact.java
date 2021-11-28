public abstract class Artifact{
	
	protected final String creator;
	protected final int year;
	private final int index;
	private static int numberOfIndex=0;

	public Artifact(final String creator, final int year){
		this.creator=creator;
		this.year=year;
		numberOfIndex++;
		index=numberOfIndex;
		System.out.println("Creating an instance of class Artifact");
	}
	
	public void getInfo(){
		System.out.println("Creator is " + creator + " and Year is " + year);
	}
	
	public void getIndex(){
		System.out.println("Index: " + index);
	}
	
	public abstract boolean evaluate(MovementEnum m, ConditionEnum c);
	public abstract boolean evaluate(MovementEnum m);
}