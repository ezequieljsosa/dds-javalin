package ar.edu.dds;

import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class UIListaProductosController implements Handler {

	private RepoProducto repo;

	public UIListaProductosController(RepoProducto repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void handle(Context ctx) throws Exception {
		Map<String, Object> model = new HashMap<>();

		model.put("productos", repo.all());
		ctx.render("productos.hbs", model);

	}

}
