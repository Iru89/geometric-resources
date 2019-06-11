# geometric-resources

Aquest es el servidor encarregat de guardar els recursos generats pels usuaris des de la SPA geometricApp. Es capaç de validar els tokens generats pel idProvider

## MongoDb
Per funcionar necesita una base de dades MongoDb corrent en el port 27017 i haver creat un usuari i una col·lecció amb els seguents comandos.

La base de dades ha de tenir el nom geometric_db. El usuari es te el nom root_geometric amb contrassenya secret_geometric i role root.

```bash
>use geometric_db
>db
>db.createUser(
	{
	user: "root_geometric",
	pwd: "secret_geometric",
	roles: [{role: "root",db: "admin"}]
	})
```
