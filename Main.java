import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void auction(Artifact[] artifacts, MovementEnum movement, ConditionEnum condition, int size) {
		
		for(int i=0; i<size;i++) {
			
			artifacts[i].getIndex();
			artifacts[i].getInfo();
			if(artifacts[i].evaluate(movement,condition)==true)
				System.out.println("The artifact above is suitable");
			else
				System.out.println("The artifact above is Not suitable");
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		MovementEnum movement = null;
		ConditionEnum condition = null;
		
		int N = Integer.parseInt(args[0]);
		String strMove = args[1];
		
		//Check input for all args 
		if(strMove.equals("impressionism"))
			movement = MovementEnum.impressionism;
		else if(strMove.equals("expressionism"))
			movement= MovementEnum.expressionism;
		else if(strMove.equals("naturalism"))
			movement = MovementEnum.naturalism;
		else{
			System.out.println("Write the movement correctly. (impressionism, expressionism, naturalism)");
			System.out.println(movement);
			System.exit(0); 
		}
		
		String strCondition = args[2];
		if(strCondition.equals("bad"))
			condition = ConditionEnum.bad;
		else if(strCondition.equals("good"))
			condition = ConditionEnum.good;
		else if(strCondition.equals("excellent"))
			condition = ConditionEnum.excellent;
		else{
			System.out.println("Write the condition correctly. (bad, good, excellent)");
			System.exit(0); 
		}
		
		Artifact[] artifacts = new Artifact[N];
		int cnt=0;
		for(int i=0;i<N;i++) {
			
			MovementEnum move;
			ConditionEnum cond;
			
			String name = "Creator" + (cnt+1);
			int year = ThreadLocalRandom.current().nextInt(1900, 1951);
			
			int randMovement = ThreadLocalRandom.current().nextInt(0,3);
			if(randMovement==0)
				move = MovementEnum.impressionism;
			else if(randMovement==1)
				move = MovementEnum.expressionism;
			else
				move = MovementEnum.naturalism;
			
			int randCondition = ThreadLocalRandom.current().nextInt(0,3);
			if(randCondition==0)
				cond = ConditionEnum.bad;
			else if(randCondition==1)
				cond = ConditionEnum.good;
			else 
				cond = ConditionEnum.excellent;
			
			int choiceArtifact = ThreadLocalRandom.current().nextInt(0,2);
			if(choiceArtifact==0) {
				
				double length = ThreadLocalRandom.current().nextDouble(10.0,60.0); //paragei enan dekadiko arithmo apo 10.0 ews 60.0
				double width = ThreadLocalRandom.current().nextDouble(10.0,60.0);
				TechniqueEnum technique;
				int randTechnique = ThreadLocalRandom.current().nextInt(0,3);
				if(randTechnique==0)
					technique = TechniqueEnum.oil;
				else if(randTechnique==1)
					technique = TechniqueEnum.aquarelle;
				else
					technique = TechniqueEnum.tempera;
				
				artifacts[cnt] = new Painting(name,year,move,cond,length,width,technique);
			}
			else{
				
				double volume = ThreadLocalRandom.current().nextDouble(10.0, 40.0);
				MaterialEnum material;
				int randMaterial = ThreadLocalRandom.current().nextInt(0,3);
				if(randMaterial==0)
					material = MaterialEnum.iron;
				else if(randMaterial==1)
					material = MaterialEnum.stone;
				else
					material = MaterialEnum.wood;
				
				artifacts[cnt] = new Sculpture(name,year,move,cond,volume,material);
			}
			cnt++;	
		}

		auction(artifacts,movement,condition,N);
	}
}