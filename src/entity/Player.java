package entity;

import main.Game;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {
    Game gp;
    KeyHandler keyH;

    public Player(Game gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
        direction = "idle";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcup.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcup2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcdown.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcdown2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcleft.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcleft2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcright.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcright2.png")));

            idle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcidle.png")));

            upHorizontalRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcuhr.png")));
            upHorizontalRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcuhr2.png")));
            upHorizontalLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcuhl.png")));
            upHorizontalLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcuhl2.png")));
            downHorizontalRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcdhr.png")));
            downHorizontalRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcdhr2.png")));
            downHorizontalLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcdhl.png")));
            downHorizontalLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Sprite-mcdhl2.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDefaultValues() {
        this.worldX = 100;
        this.worldY = 100;
        this.speed = 2;
    }

    public void update() {
        if (keyH.upPressed) {
            direction = "up";
            worldY -= speed;
            System.out.println("Player speed:" + speed);
        }
        if (keyH.downPressed) {
            direction = "down";
            worldY += speed;
            System.out.println("Player speed:" + speed);
        }
        if (keyH.leftPressed) {
            direction = "left";
            worldX -= speed;
            System.out.println("Player speed:" + speed);
        }
        if (keyH.rightPressed) {
            direction = "right";
            worldX += speed;
            System.out.println("Player speed:" + speed);
        }
        if (!keyH.anyKeyPressed) {
            direction = "idle";
        }

        // HORIZONTAL UP RIGHT
        if (keyH.upPressed && keyH.rightPressed) {
            speed = 2;
            direction = "hur";
            System.out.println("(W + D) Player speed [HORIZONTAL]:" + speed);
        }
        // HORIZONTAL UP LEFT
        if (keyH.upPressed && keyH.leftPressed) {
            direction = "hul";
            speed = 2;
            System.out.println("(W + A) - Player speed [HORIZONTAL]:" + speed);
        }
        // HORIZONTAL DOWN RIGHT
        if (keyH.downPressed && keyH.rightPressed) {
            direction = "hdr";
            speed = 2;
            System.out.println("(S + D) Player speed [HORIZONTAL]:" + speed);
        }
        // HORIZONTAL DOWN LEFT
        if (keyH.downPressed && keyH.leftPressed) {
            direction = "hdl";
            speed = 2;
            System.out.println("(S+ A) Player speed [HORIZONTAL]:" + speed);
        }

        spriteCounter++;

        if (spriteCounter >= 15) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            // ---------------------------------------------------------------------------
            // HORIZONTAL CASES
            // ---------------------------------------------------------------------------
            // Casos para movimentação inviesada (horizontal oblíqua) do personagem aonde segue-se:
            // - "hur": HORIZONTAL UP RIGHT,
            // - "hul": HORIZONTAL UP LEFT,
            // - "hdr": HORIZONTAL DOWN RIGHT,
            // - "hdl": HORIZONTAL DOWN LEFT.
            // ---------------------------------------------------------------------------
            case "hur":
                if (spriteNum == 1) {
                    image = upHorizontalRight1;
                }
                if (spriteNum == 2) {
                    image = upHorizontalRight2;
                }
                break;
            case "hul":
                if (spriteNum == 1) {
                    image = upHorizontalLeft1;
                }
                if (spriteNum == 2) {
                    image = upHorizontalLeft2;
                }
                break;
            case "hdr":
                if (spriteNum == 1) {
                    image = downHorizontalRight1;
                }
                if (spriteNum == 2) {
                    image = downHorizontalRight2;
                }
                break;
            case "hdl":
                if (spriteNum == 1) {
                    image = downHorizontalLeft1;
                }
                if (spriteNum == 2) {
                    image = downHorizontalLeft2;
                }
                break;
            case "idle":
                image = idle;
                break;
        }

        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}
