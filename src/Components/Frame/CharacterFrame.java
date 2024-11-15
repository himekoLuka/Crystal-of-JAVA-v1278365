package Components.Frame;

import Characters.Character;
import Components.Component;
import Components.Menu.MiniHealthBar;
import Components.Text.Text;
import Utils.ImageUtils;
import Utils.SpriteSheet;
import enums.Alignment;
import fonts.SuperPixelFont;

import java.awt.*;
import java.awt.image.BufferedImage;

import static enums.ComponentStateEnums.HOVERED;
import static enums.ComponentStateEnums.PRESSED;

public class CharacterFrame extends Frame {
    private final BufferedImage playerProfile;
//    private final Text tooltip;
    private final MiniHealthBar healthBar;
    private final Character player;

    public CharacterFrame(Character player) {
        super("Character Frame");
        hideText();
        sheet = new SpriteSheet(ImageUtils.loadImage("/ui/Battle_UI.png"));

        buttonSheet[0] = sheet.crop(106, 0, 1, 1); // default
        buttonSheet[1] = sheet.crop(106, 0, 1, 1); // hovered
        buttonSheet[2] = sheet.crop(106, 0, 28, 28);  // pressed

        setDimensions(28, 28);
        scale(3);

        this.player = player;
        this.playerProfile = player != null ? player.getProfile() : null;


        healthBar = (MiniHealthBar) new MiniHealthBar(player)
                .scale(3);
    }

    public void isActive(boolean isActive) {
        state = isActive ? PRESSED : state;
    }

    @Override
    public void tick() {
        super.tick();
        healthBar.tick();
    }

    @Override
    public void render(Graphics g) {
        BufferedImage buttonImage = switch (state) {
            case HOVERED -> buttonSheet[1];
            case PRESSED -> buttonSheet[2];
            default -> buttonSheet[0];
        };

        if (playerProfile != null) {
            g.drawImage(playerProfile, bounds.x - 4, bounds.y + 2, width + 12, height + 12, null);
        }

        g.drawImage(buttonImage, bounds.x, bounds.y, width, height, null);

        healthBar.setLocation(bounds.x + 10, bounds.y + 90);
        healthBar.render(g);

        if (showBounds) {
            g.setColor(Color.BLUE);
            g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }

    public Character getPlayer() {
        return player;
    }
}
