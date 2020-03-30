package de.kirion.gameEngine.rendering;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * Contains the main information for mesh: vertices
 * 
 * @author Kirion1st
 * 
 */
public class Mesh {
	
	/**
	 * a vao (= Vertex Array Object) contains one or more vbos
	 */
	private int vao;
	/**
	 * a vbo (= Vertex Buffer Object) contains a data of a vertex
	 */
	private int[] vbos;
	private int vertexCount;
	
	/**
	 * Stores the vertexpositions in vbos.
	 * 
	 * @param positions contains the position of the vertices
	 */
	public Mesh(float[] positions) {
		vao = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vao);
		
		int positionVBO = addStaticAttribute(0, positions, 3);
		
		vbos = new int[] {positionVBO};
		vertexCount = positions.length / 3;
	}

	
	/**
	 * Renders the vao.
	 */
	public void render() {
		GL30.glBindVertexArray(vao);
		for (int i = 0; 1 < vbos.length; i++) {
			GL20.glEnableVertexAttribArray(i);
		}
		
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);
		for (int i = 0; 1 < vbos.length; i++) {
			GL20.glDisableVertexAttribArray(i);
		}
	}
	
	/**
	 * Deletes all vbos/vaos.
	 */
	public void release() {
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL30.glDeleteVertexArrays(vao);
		for (int id : vbos) {
			GL15.glDeleteBuffers(id);
		}
	}
	
	/**
	 * Adds a static attribute to a vbo.
	 * 
	 * @param index index of attribute
	 * @param data the actual data of the attribute
	 * @param dataSize the size of the datapack
	 * @return the vbo containing the attribute
	 */
	private int addStaticAttribute(int index, float[] data, int dataSize) {
		int vbo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(index, dataSize, GL11.GL_FLOAT, false, 0, 0);
		
		return vbo;
	}
}
