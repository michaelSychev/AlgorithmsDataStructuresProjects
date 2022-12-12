package Misc;

public class PlayDnD
{
    public static void doAction(Player_Character my_char, String action)
    {
        if(action == "Spell")
        {
            ((Evoker)my_char).Magic_Misssile();
            my_char.StandardAction(action);
        }
    }

    public static void main(String[] args)
    {
        doAction(new Fighter(), "Attack with sword");
        doAction(new Evoker(), "Magic");
        doAction(new Wizard(), "Spell");

    }
}