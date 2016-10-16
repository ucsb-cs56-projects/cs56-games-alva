package edu.ucsb.cs56.projects.game.alva.Util;

import java.awt.Rectangle;

import edu.ucsb.cs56.projects.game.alva.world.Tile;
import edu.ucsb.cs56.projects.game.alva.world.World;
import edu.ucsb.cs56.projects.game.alva.entity.Box;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;
import edu.ucsb.cs56.projects.game.alva.entity.Entity.State;

public class PhysicsEngine {

    public static final double gravity = 9;
    private World w;

    public void loadWorld(World w) {
        this.w = w;
    }

    public PhysicsEngine(World w) {
        this.w = w;
    }

    public void update(double dt) {
        for (Entity e : w.getEntities()) {
            yVelocity(e, dt);
        }
        handleCollision();
    }

    public void yVelocity(Entity e, double dt) {
        double dy = 0;
        if (e.getState() == edu.ucsb.cs56.projects.game.alva.entity.Entity.State.STATE_AIR) {
            dy = e.getVelocity().getY() + gravity * dt;
        } 
        e.getVelocity().setY(dy);
    }

    public void handleCollision() {
        for (Entity e : w.getEntities()) {
            boolean isStanding = false;
            Vector2 temp = e.getPosition().cpy().add(e.getVelocity());
            Rectangle r = (Rectangle) e.getBounds().clone();
            r.setLocation((int) temp.getX(), (int) temp.getY());
            for (int i = 0; i < w.getTiles().length; i++) {
                for (int j = 0; j < w.getTiles()[i].length; j++) {
                    Tile t = w.getTiles()[i][j];
                    int leftOfTile = i * 100;
                    int topOfTile = j * 100;
                    Rectangle tileBounds = new Rectangle(leftOfTile, topOfTile, 100, 100);
                    if(t == null || t.getTileType().isPassable()) continue;
                    if (r.intersects(tileBounds)) {
                        if (temp.getX() + e.getWidth() - 5 >= leftOfTile
                                && temp.getX() <= leftOfTile + 95) {
                            // handle collision from up top
                            if (e.getVelocity().getY() > 0
                                    && temp.getY() < topOfTile) {
                                e.setState(edu.ucsb.cs56.projects.game.alva.entity.Entity.State.STATE_GROUND);
                                e.getVelocity().setY(0);
                                isStanding = true;
                            } else if (e.getVelocity().getY() < 0
                                    && temp.getY() > topOfTile) {
                                e.getVelocity().setY(0);
                            }
                        }
                        //handle side to side collision
                        if (temp.getY() + e.getHeight() - 5 >= topOfTile
                                && temp.getY() <= topOfTile + 95) {
                            if (e.getVelocity().getX() > 0) {
                                e.getVelocity().setX(0);
                            } else if (e.getVelocity().getX() < 0) {
                                e.getVelocity().setX(0);
                            }
                        }
                    }
                }
            }
            for (Entity e2 : w.getEntities()) {
                if (e2.equals(e)) {
                    continue;
                }

                if (e2 instanceof Box) {
                    if (r.intersects(e2.getBounds())) {
                        if (temp.getX() + e.getWidth() - 10 >= e2.getPosition().getX()
                                && temp.getX() <= e2.getPosition().getX() + 90) {
                            // handle collision from up top
                            if (e.getVelocity().getY() > 0
                                    && temp.getY() < e2.getPosition().getY()) {
                                e.setState(edu.ucsb.cs56.projects.game.alva.entity.Entity.State.STATE_GROUND);
                                e.getVelocity().setY(0);
                                isStanding = true;
                            } else if (e.getVelocity().getY() < 0
                                    && temp.getY() > e2.getPosition().getY()) {
                                e.getVelocity().setY(0);
                            }
                        }
                        //handle side to side collision
                        if (temp.getY() + e.getHeight() - 10 >= e2.getPosition().getY()
                                && temp.getY() <= e2.getPosition().getY() + 90) {
                            if (e.getVelocity().getX() > 0) {
                                e.getVelocity().setX(0);
                            } else if (e.getVelocity().getX() < 0) {
                                e.getVelocity().setX(0);
                            }
                        }
                    }
                }
            }

            if (!isStanding) {
                e.setState(State.STATE_AIR);
            }
        }
    }
}
