package ar.edu.dds;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class BajaProductoController implements Handler {

		private RepoProducto repo;

		public BajaProductoController(RepoProducto repo) {
			super();
			this.repo = repo;
		}
		
		@Override
		public void handle(Context ctx) throws Exception {
			Long prodID = Long.parseLong(ctx.pathParam("prodId"));
			
			if (repo.equals(prodID)) {
				Producto prod = repo.findById(prodID);
				this.repo.remove(prod);
			} else {
				ctx.status(HttpStatus.NOT_FOUND);
				ctx.result("Producto no encontrado");
			}
						
			
		}
	
}
