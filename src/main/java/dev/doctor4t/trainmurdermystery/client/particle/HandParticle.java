package dev.doctor4t.trainmurdermystery.client.particle;

import net.minecraft.util.Identifier;

public class HandParticle {
    public float x, y, z;
    public float vx, vy, vz;
    public float age;
    public final float maxAge;
    public float size;
    public final Identifier texture;
    public final int frames;
    public final boolean loop;
    public final float u0, v0, u1, v1;

    public HandParticle(float x, float y, float z,
                        float vx, float vy, float vz,
                        float size, float maxAge,
                        Identifier texture,
                        int frames, boolean loop
                        ) {
        this.x = x; this.y = y; this.z = z;
        this.vx = vx; this.vy = vy; this.vz = vz;
        this.size = size;
        this.maxAge = maxAge + 1f;
        this.texture = texture;
        this.frames = frames;
        this.loop = loop;
        this.u0 = 0f; this.v0 = 0f; this.u1 = 1f; this.v1 = 1f;
        this.age = 0f;
    }

    public boolean tick(float dt) {
        age += dt;
        if (age >= maxAge) return false;
        x += vx * dt;
        y += vy * dt;
        z += vz * dt;
        return true;
    }
}

