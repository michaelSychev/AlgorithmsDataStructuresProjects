package Misc;

public abstract class Player_Character
{
    public abstract void StandardAction(String Action);
}

class Evoker extends Wizard
{
    public void Magic_Misssile()
    {
        System.out.println("Evoker is casting magic missile at the darkness!!!");
    }

}

class Fighter extends Player_Character
{
    @Override
    public void StandardAction(String Action)
    {
        System.out.println("Fighter is doing" + Action);
    }
}

class Wizard extends Player_Character
{
    @Override
    public void StandardAction(String Action)
    {
        System.out.println("Wizaerd is doing" + Action);
    }
}

