package simulator;

public class Parameter {
	private Long seed = null;
	private double tempoDiSimulazione;

	
	// COSTR /////////////////////////
	
	public Parameter() {}
	public Parameter(long seed, double tempoSimulazione) {
		this.seed = seed;
		tempoDiSimulazione = tempoSimulazione;
	}

	
	// GETTERS ///////////////////////
	
	public Long getSeed() {return seed;}
	public double getTempoDiSimulazione() {return tempoDiSimulazione;}


	// SETTERS //////////////////////
	
	public Parameter setSeed(long seed) {this.seed = seed; return this;}
	public Parameter setTempoDiSimulazione(double tempoDiSimulazione) {this.tempoDiSimulazione = tempoDiSimulazione; return this;}
	
}
