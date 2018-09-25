package vanetStuff;

import simulator.Entity;
import simulator.EventHandler;
import simulatorVanet.VanetSimulation;
import vanetStuff.roadNetworks.Intersection;

public class VehicularFlow extends Entity<VanetSimulation>{
	private String id;
	private double tempoInizio, periodoGenerazioneVeicoli;
	private Intersection nodoInizio, nodoFine;
	private int numeroVeicoli;

	public VehicularFlow(VanetSimulation simulation, double startTime, double generationVehiclePeriod, Intersection startingPoint, Intersection targetPoint, int vehicleNumber) {
		super(simulation);
		this.tempoInizio = startTime;
		this.periodoGenerazioneVeicoli = generationVehiclePeriod;
		nodoInizio = startingPoint;
		nodoFine = targetPoint;
		numeroVeicoli = vehicleNumber;
		id = "("+startingPoint.getId()+")-("+targetPoint.getId()+")";
	}
	
	
	// GETTERS ///////////////////////////////
	
	public String getId() {return id;}
	public double getStartTime() {return tempoInizio;}
	public double getGenerationVehiclePeriod() {return periodoGenerazioneVeicoli;}
	public Intersection getStartingPoint() {return nodoInizio;}
	public Intersection getTargetPoint() {return nodoFine;}
	public int getVehicleNumber() {return numeroVeicoli;}
	
	// OVERRIDES /////////////////////////////
	
	public String toString() {return "FLOW{"+id+"}";}


	/* (non-Javadoc)
	 * @see simulator.Entity#getEventHandler()
	 */


	
}
