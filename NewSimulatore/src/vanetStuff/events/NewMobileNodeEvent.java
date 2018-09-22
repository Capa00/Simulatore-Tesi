package vanetStuff.events;

import simulator.Event;
import vanetStuff.entities.MobileNode;

public class NewMobileNodeEvent extends Event{
	private MobileNode mobileNode;
	
	public NewMobileNodeEvent(double amongManyMillisec, MobileNode mobileNode) {
		super(Events.NEW_MOBILE_NODE, amongManyMillisec);
		this.mobileNode = mobileNode;
	}

	@Override
	public void action() {
		mobileNode.handle(this);

		//va aggiunto al grafo
	}

}
