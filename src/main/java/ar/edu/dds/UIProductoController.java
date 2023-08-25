package ar.edu.dds;

import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class UIProductoController implements Handler {

	private RepoProducto repo;

	public UIProductoController(RepoProducto repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public void handle(Context ctx) throws Exception {
		 Map<String, Object> model = new HashMap<>();
		 Long prodID = Long.parseLong(ctx.pathParam("prodId"));
		 if (repo.exists(prodID)) {
				Producto prod = repo.findById(prodID);
				model.put("prod",prod);
				ctx.render("producto.hbs", model);
			} else {
				ctx.status(HttpStatus.NOT_FOUND);
				ctx.result("Producto no encontrado");
			}
		 
		 
         					
	}

	
}
