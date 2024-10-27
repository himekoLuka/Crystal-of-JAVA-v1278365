package Characters;

import ImageStuff.ImageLoader;
import ImageStuff.SpriteSheet;
import Skills.*;

import java.util.ArrayList;

public class Kent extends Character {

    private String name = "Kent";
    private String description = "";
    private int level = 1;
    private int health = 100;
    private int mana = 100;
    private int baseHealth = 100;
    private ArrayList<Skill> skills = new ArrayList<>();

    public Kent() {
        // Pass all parameters, including playerSheet, to the superclass constructor
        super("Kent", 1, 100, 100, 100, new ArrayList<>());

        this.spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Player_Idle_Run_Death_Anim.png"));

        this.skills.add(new Basic());
        this.skills.add(new Healing());
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