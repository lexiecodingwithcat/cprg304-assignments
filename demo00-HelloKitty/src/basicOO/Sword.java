package basicOO;

import exceptions.InvalidDamageValueException;

//the class can only inherit one class using "extends"
//but one class can inherit more interfaces using keyword "implements"
public class Sword implements Weapon
{

	private int damage;

	public Sword()
	{
		this.damage = 1;
	}
//the exception class name should be added
	public Sword( int damage ) throws InvalidDamageValueException
	{
		if( damage < 1 )
			throw new InvalidDamageValueException();
		this.damage = damage;
	}
// if the variable is private, we need public getter and setter
	public int getdamage()
	{
		return damage;
	}

	public void setdamage( int damage ) throws InvalidDamageValueException
	{
		if( damage < 1 )
			throw new InvalidDamageValueException();
		this.damage = damage;
	}

	@Override
	public void attack()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void drop()
	{
		// TODO Auto-generated method stub
	}

	//override the toString()in super class Object
	@Override
	public String toString()
	{
		return "This sword has a damage of " + this.damage + ".";
	}

}
