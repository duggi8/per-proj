package com.tj.core.reflection;

//This factory uses the EnemyShipFactory interface
//to create very specific UFO Enemy Ship

//This is where we define all of the parts the ship
//will use by defining the methods implemented
//being ESWeapon and ESEngine

//The returned object specifies a specific weapon & engine

public class KUFOEnemyShipFactory implements KEnemyShipFactory{

	// Defines the weapon object to associate with the ship
	
	public KESWeapon addESGun() {
		return new KESUFOGun(); // Specific to regular UFO
	}

	// Defines the engine object to associate with the ship
	
	public KESEngine addESEngine() {
		return new KESUFOEngine(); // Specific to regular UFO
	}
}