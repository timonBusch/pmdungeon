package de.pmdungeon.graphic;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import de.pmdungeon.interfaces.IHUDElement;
import de.pmdungeon.tools.Constants;

import java.util.ArrayList;
import java.util.List;


/**
 * Holds the HUD.
 */
public class HUD {
    private final SpriteBatch hudBatch;
    private final OrthographicCamera hudCamera;
    private final List<IHUDElement> hudElements;
    private boolean usePixelSystem = false;
    
    /**
     * Stage for Text
     */
    private TextStage textHUD;

    public HUD() {
        hudBatch = new SpriteBatch();
        hudCamera = new OrthographicCamera();
        hudCamera.position.set(0, 0, 0);
        hudCamera.update();
        hudElements = new ArrayList<>();
        
        this.textHUD = new TextStage(getHudBatch());
    }

    /**
     * Toogle between grid and pixel based system
     *
     * @param b activate or deactivate pixel system
     */
    public void usePixelSystem(boolean b) {
        this.usePixelSystem = b;
    }

    /**
     * Add an element to draw on the hud
     *
     * @param element element to add
     */
    public void addHudElement(IHUDElement element) {
        this.hudElements.add(element);
    }

    /**
     * Remove element
     *
     * @param element element to remove
     */
    public void removeHudElement(IHUDElement element) {
        if (hudElements.contains(element))
            this.hudElements.remove(element);
    }

    /**
     * Main loop of the hud.
     */
    public void draw() {
        if (!usePixelSystem) {
            hudCamera.update();
            hudBatch.setProjectionMatrix(hudCamera.combined);
        }
        drawElements();
        resize();
        textHUD.draw();

    }

    /**
     * Draws all the elements
     */
    private void drawElements() {
        for (IHUDElement element : hudElements) {
            Texture texture = element.getTexture();
            Sprite sprite = new Sprite(texture);
            //scaling
            sprite.setSize(element.getWidth(), element.getHeight() / texture.getWidth());
            sprite.setPosition(element.getPosition().x, element.getPosition().y);
            hudBatch.begin();
            sprite.draw(hudBatch);
            hudBatch.end();

        }
    }

    /**
     * Resizing the camera according to the size of the window.
     */
    public void resize() {
        if (usePixelSystem) return;
        hudCamera.setToOrtho(false, Constants.VIRTUALHEIGHT * Constants.WIDTH / (float) Constants.HEIGHT, Constants.VIRTUALHEIGHT);
        hudBatch.setProjectionMatrix(hudCamera.combined);
    }

    public SpriteBatch getHudBatch() {
        return this.hudBatch;
    }
    
    public Label drawText(String text, String fontPath, Color color, int size, int width, int height, int x, int y) {
		return textHUD.drawText(text, fontPath, color, size, width, height, x, y);
	}
}
