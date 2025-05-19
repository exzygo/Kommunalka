package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, idle,
            upHorizontalRight1, upHorizontalRight2, upHorizontalLeft1, upHorizontalLeft2,
            downHorizontalRight1, downHorizontalRight2, downHorizontalLeft1, downHorizontalLeft2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
