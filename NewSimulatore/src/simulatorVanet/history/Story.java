package simulatorVanet.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Story implements Iterable<SpriteData>, Serializable{
	private static final long serialVersionUID = 235506483452183351L;

	private String idEntity;
	private double tempoNascita, tempoMorte;
	private ArrayList<SpriteData> data;
	
	public Story(String idEntity, double borningTime) {
		this.idEntity = idEntity;
		tempoNascita = borningTime;
	}

	
	// GETTERS ///////////////////////
	
	public String getIdEntity() {return idEntity;}
	public ArrayList<SpriteData> getData() {return data;}

	public double getTempoNascita() {return tempoNascita;}
	public double getTempoMorte() {return tempoMorte;}

	
	// METHODS ////////////////////
	
	public void dead(double deadTime) {tempoMorte = deadTime;}
	public void addData(SpriteData spriteData) {data.add(spriteData);}
	
	
	// OVERRIDES ////////////////////
	
	public Iterator<SpriteData> iterator(){return data.iterator();}
}
