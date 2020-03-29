package de.kirion.gameEngine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;

/**
 * 
 * @author Kirion1st
 *
 */
public class Game {

	private long window;
	
	private int width;
	private int height;
	private String windowName;
	
	public Game(int width, int height, String windowName) {
		setWidth(width);
		setHeight(height);
		setWindowName(windowName);
	}
	
	public String getWindowName() {
		return windowName;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void run() {
		GLFWErrorCallback.createPrint(System.err).set();
		GLFW.glfwInit();
		window = GLFW.glfwCreateWindow(getWidth(), getHeight(), getWindowName(), 0, 0);
		GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, vidMode.width() / 2 - getWidth() / 2, vidMode.height() / 2 - getHeight() / 2);
		GLFW.glfwMakeContextCurrent(window);
		GLFW.glfwSwapInterval(1);
		
		while (!GLFW.glfwWindowShouldClose(window)) {
			GLFW.glfwSwapBuffers(window);
			
			GLFW.glfwPollEvents();
		}
		
		GLFW.glfwTerminate();
		GLFW.glfwSetErrorCallback(null).free();
	}
}
