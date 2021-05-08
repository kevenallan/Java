package dao;

import java.util.List;
import com.db4o.query.Query;
import modelo.Usuario;

public class DAOUsuario  extends DAO<Usuario>{

	public Usuario read (Object chave) {
		String email = (String) chave;
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("email").constrain(email);
		List<Usuario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Usuario> readVideo (Object chave) {
		String nomeVid = (String) chave;
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("visualizacoes").descend("video").descend("nome").constrain(nomeVid);
		List<Usuario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
}

