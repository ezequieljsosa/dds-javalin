package ar.edu.dds;

import io.javalin.Javalin;

public class WebApp {

	public static void main(String[] args) {
		RepoProducto repo = new RepoProducto();
		Integer port = Integer.parseInt( System.getProperty("port", "8080"));
		Javalin app = Javalin.create().start(port);
		 	app.get("/",ctx -> ctx.result("Hola Mundo"));
		 app.post("/productos", new AltaProductoController(repo));
		 app.get("/productos", 
				 new ListaProductoController(repo));
	}

}
