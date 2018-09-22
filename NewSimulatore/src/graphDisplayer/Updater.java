package graphDisplayer;

import org.graphstream.ui.graphicGraph.stylesheet.StyleConstants.Units;
import org.graphstream.ui.spriteManager.Sprite;

import simulatorVanet.VanetParameter;
import simulatorVanet.history.SpriteData;
import simulatorVanet.history.SpriteData.SpriteDataCar;

public class Updater{
	private VanetParameter param;
	
	public void update(Sprite sprite, SpriteData spriteData) {
		SpriteDataCar spriteDataCar = (SpriteDataCar)spriteData;
		
		sprite.attachToEdge(spriteDataCar.getEdge());
		sprite.setPosition(Units.PX, spriteDataCar.getPosition(), param.distanceFromEdge, 0);
	}
	
	

}
