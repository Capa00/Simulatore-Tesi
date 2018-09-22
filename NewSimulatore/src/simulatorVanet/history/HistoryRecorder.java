package simulatorVanet.history;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class HistoryRecorder {
	private double tempoInizioRecord, tempoFineRecord, periodo;
	
	private Semaphore mutex = new Semaphore(1);
	private HashMap<String, Story> entita; //<idEntity, history>
	private ArrayList<Story> storie;
	
	private String path;
	
	
	public HistoryRecorder(double period, String path) {
		entita = new HashMap<>();
		periodo = period;

		tempoInizioRecord = 0;
		tempoFineRecord = period;
		
		this.path = path;
		storie = new ArrayList<>();

	}
	
	public void entityDead(String idEntity, double deadTime) {
		try {
			
			mutex.acquire();
			Story entity = entita.get(idEntity);
			if( entity == null )throw new IllegalArgumentException("I can not receive a dead event if the entity "+idEntity+" is not born");
			
			entity.dead(deadTime);
			mutex.release();
			
		} catch (InterruptedException e) {e.printStackTrace();
		}
	}

	public void updatePosition(String idEntity, SpriteData spriteData) {
		try {

			mutex.acquire();
			if(spriteData.getTime() > tempoFineRecord) {
				store();
				restart();
			}
			
			Story entity = entita.get(idEntity);
			
			if(entity == null) {
				entity = new Story(idEntity, spriteData.getTime());
				storie.add(entity);
			}
			
			entity.addData(spriteData);
			mutex.release();
		
		} catch (InterruptedException e) {e.printStackTrace();
		}
		
	}
	
	private void store() {
		try {
			int index = (int)(tempoInizioRecord / periodo);
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path+File.separator+"histories"+index+".his"));
			o.writeObject(storie);
			o.flush();
			o.close();
		
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private void restart() {
		tempoInizioRecord = tempoFineRecord;
		tempoFineRecord += periodo;
		storie = new ArrayList<>();
		entita = new HashMap<>();
		
	}
}
