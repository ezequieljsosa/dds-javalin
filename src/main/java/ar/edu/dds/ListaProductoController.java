package ar.edu.dds;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class ListaProductoController implements Handler {

		private RepoProducto repo;

		public ListaProductoController(RepoProducto repo) {
			super();
			this.repo = repo;
		}
		
		@Override
		public void handle(Context ctx) throws Exception {
			ctx.json(repo.all());					
		}
	
}
