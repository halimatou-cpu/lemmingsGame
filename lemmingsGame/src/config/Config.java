package config;

public class Config {
	public static final int LEMMINGS_NUMBER = 5;
	public static final int SCALE = 20;

	public static final int CASE_HEIGHT = 35;
	public static final int CASE_WIDTH = 50;

	public static final int MAIN_COMPONENT_HEIGHT = CASE_HEIGHT * SCALE;
	public static final int MAIN_COMPONENT_WIDTH = CASE_WIDTH * SCALE;
	public static final int MENU_WIDTH = 150;
	public static final int WINDOW_WIDTH = MAIN_COMPONENT_WIDTH + MENU_WIDTH;
	public static final int WINDOW_HEIGHT = CASE_HEIGHT * SCALE;
	public static final int MENU_HEIGHT = WINDOW_HEIGHT;

	public static final long GAME_REFRESH = 500; 
}
