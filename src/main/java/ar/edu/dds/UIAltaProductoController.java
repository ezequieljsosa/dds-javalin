package ar.edu.dds;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class UIAltaProductoController implements Handler {

		private RepoProducto repo;

		public UIAltaProductoController(RepoProducto repo) {
			super();
			this.repo = repo;
		}
		
		@Override
		public void handle(Context ctx) throws Exception {
			Producto prod = new Producto(ctx.formParam("nombre"), 
					ctx.formParam("descripcion")) ;			
			this.repo.add(prod);
			ctx.redirect("/productos");
			
		}
	
}
