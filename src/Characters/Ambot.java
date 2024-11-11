package Characters;

import Characters.Stats.Health;
import Characters.Stats.Mana;
import Skills.Basic;
import Skills.Healing;
import Skills.Skill;
import Utils.ImageUtils;
import Utils.SpriteSheet;

import java.util.ArrayList;

public class Ambot extends Character {
    public Ambot() {
        // Pass all parameters, including playerSheet, to the superclass constructor
        super("Ambot", 1, new Health(100, 100), new Mana(100, 100), new ArrayList<>());

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
