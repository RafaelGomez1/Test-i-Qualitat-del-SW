package snake;
import java.awt.event.KeyEvent;

import java.awt.Component;


public class MockKey extends KeyEvent{
	
	public MockKey(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
		super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
	}
	

	
}
