package game_package;

import java.awt.Graphics;
import java.awt.Graphics2D;
import Interfaces_game.IDrawable;
import Interfaces_game.IDead;
import Interfaces_game.IMovable;
import Interfaces_game.IShootable;

public class Container {

	public void draw(IDrawable d, Graphics g) {
		d.draw(g);
	}

	public void move(IMovable m, String direction) {
		m.movements(direction);
	}

	public void shoot(IShootable s) {
		s.shoot();
	}

	public void dead(IDead d) {
		d.die();
	}

}