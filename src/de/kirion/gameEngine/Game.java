package de.kirion.gameEngine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

/**
 * The actual game window
 * 
 * @author Kirion1st
 *
 */
public class Game {

	private long window;
	
	private int width;
	private int height;
	private String windowName;
	
	/**
	 * Creates a game window.
	 * 
	 * @param width width of the game window
	 * @param height height of the game window
	 * @param windowName title tag of the game window
	 */
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

	/**
	 * necessary functions to create this game window.
	 * The While-Loop inside this method is run every tick and contains the main functions.
	 */
	public void run() {
		GLFWErrorCallback.createPrint(System.err).set();
		GLFW.glfwInit();
		window = GLFW.glfwCreateWindow(getWidth(), getHeight(), getWindowName(), 0, 0);
		GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, vidMode.width() / 2 - getWidth() / 2, vidMode.height() / 2 - getHeight() / 2);
		GLFW.glfwMakeContextCurrent(window);
		GLFW.glfwSwapInterval(1);
		
		GL.createCapabilities();
		GL11.glClearColor(0, 0, 1, 1);
		
		init();
		
		while (!GLFW.glfwWindowShouldClose(window)) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			render();
			
			GLFW.glfwSwapBuffers(window);
			
			GLFW.glfwPollEvents();
		}
		
		release();
		
		GLFW.glfwTerminate();
		GLFW.glfwSetErrorCallback(null).free();
	}
	
	/**
	 * The initial method of the game;
	 */
	public void init() {
		
	}
	
	/**
	 * Render is called every Frame.
	 */
	public void render() {
		
	}
	
	/**
	 * Is called at the end and releases all data.
	 */
	public void release() {
		
	}
}
