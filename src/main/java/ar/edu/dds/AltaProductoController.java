package ar.edu.dds;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class AltaProductoController implements Handler {

		private RepoProducto repo;

		public AltaProductoController(RepoProducto repo) {
			super();
			this.repo = repo;
		}
		
		@Override
		public void handle(Context ctx) throws Exception {
			Producto prod = ctx.bodyAsClass(Producto.class);			
			this.repo.add(prod);
			ctx.status(HttpStatus.CREATED);
			ctx.result("Producto agregado correctamente");
		}
	
}
