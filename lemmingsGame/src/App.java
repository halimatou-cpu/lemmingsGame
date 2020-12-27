import config.Config;
import controllers.GameController;
import views.Window;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("x = " + Config.MAP.length + " y =" + Config.MAP[0].length);
		Window window = new Window();
		GameController controller = new GameController(window);

		while (controller.alive()) {
			try {
				Thread.sleep(Config.GAME_REFRESH);
			} catch (Exception ignore) {
			}

//			controller.step();
		}

//         window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
		System.exit(0);

	}

}
