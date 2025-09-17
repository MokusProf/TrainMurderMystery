package dev.doctor4t.trainmurdermystery.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector4f;

public interface MatrixUtils {
    static Vec3d matrixToVec(MatrixStack matrixStack) {
        Matrix4f matrix = matrixStack.peek().getPositionMatrix();
        Camera camera = MinecraftClient.getInstance().gameRenderer.getCamera();

        Vector4f localPos = new Vector4f(0, 0, 0, 1);
        matrix.transform(localPos);

        Vec3d cameraPos = camera.getPos();
        return new Vec3d(
                cameraPos.x + localPos.x(),
                cameraPos.y + localPos.y(),
                cameraPos.z + localPos.z());
    }
}
