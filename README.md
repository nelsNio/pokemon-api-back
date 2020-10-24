# pokemon-api-back
##Despliegue en heroku

1)  Iniciar sesion en heroku usando cli
**heroku login**
```
heroku login
heroku: Press any key to open up the browser to login or q to exit: 
Opening browser to https://cli-auth.heroku.com/auth/cli/browser/7fa60fc5-db16-4427-b8b3-b9fbc490f605?requestor=SFMyNTY.g3QAAAACZAAEZGF0YW0AAAANMTg2LjEwMi45NC42OGQABnNpZ25lZG4GAPlz_lh1AQ.tfhwouQ5oZ46bA8y4IqCsOzRwSbPOIsi8eSnQ5Y222k
Logging in... done
Logged in as nels96@hotmail.es

```
2)  Inicializar repo de git ```git init```
```
git init
Initialized empty Git repository in /Users/andresnino/Documents/GitHub/JAVA/PokemonBack/.git/

```
3) Preparamos archivos del proyecto a subir,
hacemos el primer commit con los siguientes comandos
```
comado : git add .
comando: git commit -m "first commit"
resultado : [master (root-commit) 8342abd] first commit


```
4) Creamos la app en heroku 
``
heroku create nombre-proyecto
``
````
Creating app... done, ⬢ nombre-proyecto
````
5) Actualizamos repo de git en heroku `` git push heroku master``
````
Enumerating objects: 31, done.
Counting objects: 100% (31/31), done.
Delta compression using up to 4 threads
Compressing objects: 100% (21/21), done.
Writing objects: 100% (31/31), 54.40 KiB | 5.44 MiB/s, done.
Total 31 (delta 0), reused 0 (delta 0)

````
De salir todo bien, tenemos desplegada la API

## Consumo de servicios:
Heruko arroja una direccion de **API**,
en este caso es la siguiente : ``https://pokemon-api-back.herokuapp.com/`

### Endpoints 
1) Listar todos los pokemons :
Metodo: **GET**
````
https://pokemon-api-back.herokuapp.com/pokemons/
````
2) Traer pokemon por ID :
Metodo: **GET**
Parametro : **id** Ej:12
````
https://pokemon-api-back.herokuapp.com/pokemons/12/
````