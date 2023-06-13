# tp-parcattraction

### Description
TP de M1 en spring boot sur les parcs d'attractions

### Initialiser docker
```
docker run --name monsql -p 3306:3306 -e MYSQL_DATABASE=parcattraction -e MYSQL_ROOT_PASSWORD=root mysql:5.5.54
```

### Initialiser phpmyadmin
```
docker pull phpmyadmin/phpmyadmin:latest

docker run --name my-own-phpmyadmin -d --link monsql:db -p 8081:80 phpmyadmin/phpmyadmin
```

### Plan de travail sur Git
Voir la branche sur laquelle je suis :
```
git branch
```
S'assurer d'avoir la dernière version quand je suis sur master (avant de créer ma branche) :
```
git pull
```
Créer sa branche et prévenir sur discord les changements apportés une fois push :
```
git checkout -b feat/nomFeature
```
Ajouter les changements sur la branche :
```
git add -A
```
| le -A ne le faite que si vous avez conscience de ce que vous pusher

Commit les changements sur la branche :
```
git commit -m "explication des modifications apportés
```
Push des changements :
```
git push
```

### Bug a l'installation
Une fois le git clone effectue, si le projet pas reconnu dans intellij, fermer intellij, supprimer le .idea et relancer intellij