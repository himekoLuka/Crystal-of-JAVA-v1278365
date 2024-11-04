package Components;

import Game.Handler;
import Views.ViewManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class ComponentManager {
    private Handler handler;
    private final ArrayList<Component> components;

    public ComponentManager(ViewManager viewManager) {
        this.setHandler(viewManager.getHandler());
        components = new ArrayList<Component>();
    }

    public void tick() {
//        System.out.println("ComponentManager tick");
        for (Component o : components) {
            o.tick();
        }
    }

    public void render(Graphics g) {
        for (Component component : components) {
            component.render(g);
        }
    }

    public void onMouseMove(MouseEvent e) {
        for (Component o : components) {
            System.out.println(e.getX() + " " + e.getY());
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e) {
        for (Component o : components) {
            System.out.println(e.getX() + " " + e.getY());
            o.onMouseRelease(e);
        }
    }

    public void init(Component... componentsArray) {
        components.addAll(Arrays.asList(componentsArray));
    }

    public void removeObject(Component component) {
        components.remove(component);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}