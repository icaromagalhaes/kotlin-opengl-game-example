package utils

import entities.Camera
import org.lwjgl.util.vector.Matrix4f
import org.lwjgl.util.vector.Vector3f

class Maths {
    companion object {
        fun createTransformationMatrix(translation: Vector3f, rx: Float, ry: Float, rz: Float, scale: Float): Matrix4f {
            val matrix = Matrix4f()
            matrix.setIdentity()
            Matrix4f.translate(translation, matrix, matrix)
            Matrix4f.rotate(Math.toRadians(rx.toDouble()).toFloat(), Vector3f(1F, 0F, 0F), matrix, matrix)
            Matrix4f.rotate(Math.toRadians(ry.toDouble()).toFloat(), Vector3f(0F, 1F, 0F), matrix, matrix)
            Matrix4f.rotate(Math.toRadians(rz.toDouble()).toFloat(), Vector3f(0F, 0F, 1F), matrix, matrix)
            Matrix4f.scale(Vector3f(scale, scale, scale), matrix, matrix)
            return matrix
        }

        fun createViewMatrix(camera: Camera): Matrix4f {
            val viewMatrix = Matrix4f()
            viewMatrix.setIdentity()
            Matrix4f.rotate(Math.toRadians(camera.pitch.toDouble()).toFloat(), Vector3f(1F, 0F, 0F), viewMatrix,
                    viewMatrix)
            Matrix4f.rotate(Math.toRadians(camera.yaw.toDouble()).toFloat(), Vector3f(0F, 1F, 0F), viewMatrix,
                    viewMatrix)
            val cameraPosition = camera.position
            val negativeCameraPos = Vector3f(-cameraPosition.x, -cameraPosition.y, -cameraPosition.z)
            Matrix4f.translate(negativeCameraPos, viewMatrix, viewMatrix);
            return viewMatrix
        }
    }


}