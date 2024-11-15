package Characters;

import Characters.Stats.AttackPower;
import Characters.Stats.Defense;
import Characters.Stats.Health;
import Characters.Stats.Mana;
import Skills.Warrior.PowerStrike;
import Skills.Warrior.ShieldBlock;
import Skills.Warrior.Taunt;
import Skills.Warrior.WarCry;
import Utils.SpriteSheet;
import Skills.*;
import Utils.ImageUtils;

import java.util.ArrayList;

public class Kent extends Character {

    public Kent() {
        // Pass all parameters, including playerSheet, to the superclass constructor
        super("Kent", 1, new Health(1200), new Mana(100), new AttackPower(150), new Defense(30), new ArrayList<>());



        this.addSkill(new PowerStrike());
        this.addSkill(new ShieldBlock());
        this.addSkill(new WarCry());
        this.addSkill(new Taunt());

        this.spriteSheet = new SpriteSheet(ImageUtils.loadImage("/textures/Player_Idle_Run_Death_Anim.png"));
    }

    @Override
    public void useSkill(int index) {
        if (index >= 0 && index < skills.size()) {
            Skill skill = skills.get(index);
            // Logic for using the skill can go here
        }
    }

    @Override
    public void useSkill(Skill skill) {
        // Logic for using a specific skill can go here
    }
}
